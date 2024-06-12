import cv2 as cv
import numpy as np
import matplotlib.pyplot as plt

# Intenta cargar la imagen
a3 = cv.imread('cameraman.tif', cv.IMREAD_GRAYSCALE)

# Verifica si la carga de la imagen fue exitosa
if a3 is not None:
    plt.imshow(a3, cmap='gray')
    plt.title('Imagen original')
    plt.show()
    print(type(a3))
    print(a3.shape)

    # Convierte la imagen a float32
    a4 = a3.astype(np.float32)
    a5 = a4.astype(np.uint8)

    # Guarda la imagen
    cv.imwrite('cameraman_modificado.tif', a5)

    # Crea una copia de la imagen
    a = np.copy(a4)
    ojo_de_Lena = a[65:170, 170:269]

    # Muestra la imagen original y la región de interés
    plt.figure()
    plt.subplot(121)
    plt.imshow(a, cmap='gray', interpolation='nearest')
    plt.title('Cameraman'), plt.axis('off')
    plt.subplot(122)
    plt.imshow(ojo_de_Lena, cmap='gray', interpolation='nearest')
    plt.title('Cabeza del cameraman'), plt.axis('off')
    plt.show()
else:
    print("No se pudo cargar la imagen 'cameraman.tif'. Verifica la ruta del archivo.")
