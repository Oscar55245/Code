import cv2
import numpy as np
cap  =  cv2.VideoCapture(3)
imgTarget = cv2.imread('TargetImage.jpeg')
myVid = cv2.VideoCapture('infinito.mp4')

success, imgVideo = myVid.read()
hT,wT,cT=imgVideo.shape
imgTarget=cv2.resize(imgTarget,(wT,hT))
orb =  cv2.ORB_create(nfeatures=1000)
kp1,des1=orb.detectAndCompute(imgTarget,None)
imgTarget=cv2.drawKeypoints(imgTarget,kp1,None)
while True :
	  success, imgWebCam = cap.read()
	  imgAR  = imgWebCam.copy()
	  imgWebCam=cv2.resize(imgWebCam,(wT,hT))
	  kp2,des2=orb.detectAndCompute(imgWebCam,None)
	  imgWebCam=cv2.drawKeypoints(imgWebCam,kp2,None)
	  bf =  cv2.BFMatcher()
	  matches = bf.knnMatch(des2,des1,k=2)
	  good=[]
	  for m,n in matches:
	  	if m.distance < 0.75 *n.distance:
	  		good.append(m)
	  print(len(good))
	  imgFeatures = cv2.drawMatches(imgWebCam,kp2,imgTarget,kp1,good,None,flags=2)
	  if len(good)>11:
	  	 srcPts=np.float32([kp2[m.queryIdx].pt for m in good]).reshape(-1,1,2)
	  	 dstPts=np.float32([kp1[m.trainIdx].pt for m in good]).reshape(-1,1,2)
	  	 matrix,mask = cv2.findHomography(dstPts,srcPts,cv2.RANSAC,3.0)
	  	 print(matrix)
	  	 pts = np.float32([[0,0],[0,440],[275,440],[275,0]]).reshape(-1,1,2)
	  	 dst = cv2.perspectiveTransform(pts,matrix)
	  	 cv2.polylines(imgWebCam,[np.int32(dst)],True,(0,0,255),3)
	  	 imgWarp = cv2.warpPerspective(imgVideo,matrix,(imgWebCam.shape[1],imgWebCam.shape[0]))
	  	 newmask = np.zeros((imgWebCam.shape[0],imgWebCam.shape[1]),np.uint8)
	  	 cv2.fillPoly(newmask,[np.int32(dst)],(255,255,255))
	  	 invMask = cv2.bitwise_not(newmask)
	  	 imgAR = cv2.bitwise_and(imgAR,imgAR,mask=invMask)
	  	 imgAR = cv2.bitwise_or(imgAR,imgWarp)
	  	 cv2.imshow("imgAR",imgAR)
	  	 cv2.imshow("img",imgWarp)
	  if cv2.waitKey(1) & 0xFF == ord('q'):
                      break


	  cv2.imshow('imgFeatures',imgFeatures)
	  cv2.imshow('imgTarget',imgTarget)
	  cv2.imshow('myVid',imgVideo)
	  cv2.imshow('Cam',imgWebCam)

	  cv2.waitKey(1)