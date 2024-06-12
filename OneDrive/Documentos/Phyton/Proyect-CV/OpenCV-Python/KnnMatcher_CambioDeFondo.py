import cv2
import numpy as np
import Ejemplo 
stdShape = (275,440)

webCam = cv2.VideoCapture(1)
imgTarget = cv2.imread("TargetImage.jpeg")
imgTarget = cv2.resize(imgTarget,stdShape)
displayVid = cv2.VideoCapture("infinito.mp4")
_,cam=webCam.read()

detection=False
frameCounter = 0

ORB = cv2.ORB_create(nfeatures=1000)

keyPoint1, descriptor1 = ORB.detectAndCompute(imgTarget,None)

imgTarget=cv2.drawKeypoints(imgTarget, keyPoint1,None) 
cv2.imshow("keypoints",imgTarget)

while webCam.isOpened():
    _ , imgWebcam = webCam.read()  
    keyPoint2, descriptor2 = ORB.detectAndCompute(imgWebcam,None) 
    
    if detection ==False:
        displayVid.set(cv2.CAP_PROP_POS_FRAMES,0)
        frameCounter=0
    else:
        if frameCounter==displayVid.get(cv2.CAP_PROP_FRAME_COUNT):
            displayVid.set(cv2.CAP_PROP_POS_FRAMES,0)
            frameCounter=0
        _,imgVideo=displayVid.read()


    imgAR  = imgWebcam.copy()


    
    _ , imgVideo = displayVid.read()
    imgVideo = cv2.resize(imgVideo, stdShape)
    bruteForce = cv2.BFMatcher()
    matches = bruteForce.knnMatch(descriptor2,descriptor1,k=2)
    goodMatches = []
    for m,n in matches:
        if m.distance < 0.75 * n.distance:
            goodMatches.append(m)
    if len(goodMatches) > 15:
             print("Hola")
             Ejemplo.filtro(webCam)
    if cv2.waitKey(1) & 0xFF == ord('q'):
          break

    

webCam.release()