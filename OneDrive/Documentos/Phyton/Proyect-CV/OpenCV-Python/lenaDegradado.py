import cv2
import numpy as np

lena_img = cv2.imread('lena.jpg')

height, width, _ = lena_img.shape

degradation = np.linspace(0, 1, height).reshape(height, 1, 1)

mask = np.tile(degradation, (1, width, 3)) 

degraded_img = (lena_img * mask).astype(np.uint8)

cv2.imshow('Original', lena_img)
cv2.imshow('Degradada', degraded_img)
cv2.waitKey(0)
cv2.destroyAllWindows()
