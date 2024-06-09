
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import matplotlib
matplotlib.use('Agg')
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
import pandas as pd
from io import BytesIO
import base64
class ImportacionesMaiz:
     def GenerarModelo(self):
         archivo=pd.read_csv('indicares.csv',  encoding='iso-8859-1')
         print(archivo)
         df = pd.DataFrame(archivo)
         df['Periodos'] = pd.to_datetime(df['Periodos']).dt.year
         x = df[["Periodos"]]
         y = df[["Importaciones Maiz"]]
         matriz = df.to_numpy()
         n = len(matriz)
         sumatoria_x = np.sum(matriz[:,0])
         sumatoria_y = np.sum(matriz[:,1])
         sumatoria_producto = np.sum(matriz[:,0] * matriz[:,1])
         sumatoria_cuadrado_x = np.sum(matriz[:,0] * matriz[:,0])
         print("n:", n)
         print("sumatoria x:", sumatoria_x)
         print("sumatoria y:", sumatoria_y)
         print("sumatoria xy:", sumatoria_producto)
         print("sumatoria x^2:", sumatoria_cuadrado_x)
         b1 = (n*sumatoria_producto - sumatoria_x*sumatoria_y) / (n*sumatoria_cuadrado_x - sumatoria_x*sumatoria_x)
         b0 = (sumatoria_y - b1*sumatoria_x) / n
         print("b1:", b1)
         print("b0:", b0)
         clf = LinearRegression()
         clf.fit(x,y)
         clf.coef_
         clf.intercept_
         clf.predict([[7]])
         clf.predict([[100]])
         predicciones = clf.predict(x)
         plt.plot(x, y)
         plt.plot(x, predicciones)
         plt.title("Regresion Lineal Simple")
         plt.xlabel("Fechas")
         plt.ylabel("Importaciones de Maiz")
         plt.legend(["y", "predicciones"])
         plt.grid()
         mean_squared_error(y, predicciones)
         img_buffer = BytesIO()
         plt.savefig(img_buffer, format='png')
         img_buffer.seek(0)
         img_base64 = base64.b64encode(img_buffer.read()).decode('utf-8')
         plt.close() 
         return img_base64