import numpy as np

# DataFrames/Procesamiento
import pandas as pd

# Gráficas
import matplotlib.pyplot as plt
data = pd.read_csv("diabetes.csv")
data.head()
print("Número original de datapoints\n", data.shape) # Filas x Columnas

# Elimina cualquier valor faltante y remplazarlos hacia la variable de los datos
data = data.dropna()
# Comprueba la nueva forma (shape)
print("Número actualizado de datapoints\n", data.shape) # Filas x Columnas
# Ajustar el tamaño de fuente.

"""plt.rcParams['font.size'] = 15 

# Crear una figura y ajusta su tamaño.f = plt.figure(figsize=(8,4))

# Crear un subplot o subtrama - al ser una sola figura es 1,1,1.
ax = f.add_subplot(1,1,1)

# Gráfica tus datos usando 'hist'. Pasa el objeto 'ax' a Pandas. Agrega un borde negro con un groso de 2.
data["Outcome"].hist(ax=ax, edgecolor='black', linewidth=2)

# Establece los límites en el eje x.
ax.set_xlim([-0.5, 1.5])

# Establece la frecuencia de tick. Tenemos 0 y 1 que corresponden a Sí y No respectivamente.
ax.set_xticks([0, 1])

# Etiquetar xtick labels.
ax.set_xticklabels(["N", "Y"])

# Crea el título.
ax.set_title("Diabetes Y/N?")

# Establece la etiqueta del eje X.
ax.set_xlabel("Answer")

# Establece la etiqueta del eje Y.
ax.set_ylabel("Count")

# Establece los límites superior/inferior del eje y.
ax.set_ylim([0, 510])

# Mace que las cosas sean bonitas, no es necesario, pero se ajusta al tamaño de la figura.
f.tight_layout()
"""
# Seleccionar las filas donde el valor es mayor a 0.
data = data[data["BloodPressure"] > 0]
print("Patients with blood pressure\n", data.shape) # Rows x Columns
diabetic = data[data["Outcome"] == 1]
notdiabetic = data[data["Outcome"] == 0]

plt.rcParams['font.size'] = 15 
f = plt.figure(figsize=(8,8))
ax = f.add_subplot(2,1,1)
ax.scatter(diabetic["BloodPressure"], diabetic["Age"], alpha=0.25, c='r')
ax.set_title("Diabetic: Age range of patients v. Blood Pressure")
ax.set_ylabel("Age")
ax.set_xlabel("Blood Pressure")

plt.rcParams['font.size'] = 15 
f = plt.figure(figsize=(8,8))
ax = f.add_subplot(2,1,1)
ax.scatter(notdiabetic["BloodPressure"], notdiabetic["Age"], alpha=0.25, c='r')
ax.set_title("notdiabetic: Age range of patients v. Blood Pressure")
ax.set_ylabel("Age")
ax.set_xlabel("Blood Pressure")

plt.show()