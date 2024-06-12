
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
import requests
from bs4 import BeautifulSoup
import pandas as pd
headers = {
    "user-agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/71.0.3578.80 Chrome/71.0.3578.80 Safari/537.36"
}
url = 'https://www.espn.com.mx/futbol/posiciones/_/liga/esp.1'
pag = requests.get(url, headers=headers)
soup=BeautifulSoup(pag.content,"html.parser")
Tabla = soup.find("table", class_="Table Table--align-right")
columns = [Tabla.select("thead th")[1].text.strip(), Tabla.select("thead th")[7].text.strip()]
data_rows = []
for row in Tabla.select("tbody tr"):
    data_row = [td.text.strip() for td in row.select("td")[1]]+[td.text.strip() for td in row.select("td")[7]]
    data_rows.append(data_row)
df = pd.DataFrame(data_rows, columns=columns[:2]).astype(int)
x = df[["G"]]
y = df[["PTS"]]
print(x)
matriz = df.to_numpy()
matriz = matriz.astype(int)
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
plt.xlabel("Partidos ganados")
plt.ylabel("Puntos ganados")
plt.legend(["y", "predicciones"])
plt.grid()
plt.show()
mean_squared_error(y, predicciones)