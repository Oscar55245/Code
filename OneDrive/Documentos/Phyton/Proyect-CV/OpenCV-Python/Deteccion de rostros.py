import cv2
import numpy as np
#cv2.data.haarcascades + se usa por si los archivos no estan en la carpeta actual, sino en alguna carpeta
#del modulo cv2 y se debe usar la ruta completa para cargarlos
faceClassif = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

image = cv2.imread('Oficina.jpg')
gray=cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

faces =  faceClassif.detectMultiScale(gray,
scaleFactor=1.09,
minNeighbors=5,
minSize=(30,30),
maxSize=(200,200))

for (x,y,w,h) in faces:
	cv2.rectangle(image,(x,y),(x+w,y+h),(0,255,0),2)

cv2.imshow('image',image)
cv2.waitKey(0)
cv2.destroyAllWindows()
