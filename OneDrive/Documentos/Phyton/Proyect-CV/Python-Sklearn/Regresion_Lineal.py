import numpy as np
import pandas as pd
import math
from matplotlib import pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error

archivo=pd.read_csv('movies.csv',  encoding='iso-8859-1')
df = pd.DataFrame(archivo)
df.fillna(0, inplace=True)
df = df[['presupuesto', 'popularidad', 'duracion', 'puntuacion', 'n_votos', 'ventas']]
df = df.dropna()

pct_entrenamiento = 0.8
df_training = df.sample(frac=pct_entrenamiento)
df_test = df[~df.index.isin(df_training.index)]

variables_independientes = ['presupuesto', 'popularidad', 'duracion', 'puntuacion', 'n_votos']
variable_dependiente = 'ventas'

fig, axes = plt.subplots(nrows=2, ncols=3, figsize=(18, 12))
fig.suptitle("Regresión Lineal para Variables Independientes")
df_test['ventas_pred'] = np.nan
for i, ax in enumerate(axes.flatten()):
    if i < len(variables_independientes):
        var = variables_independientes[i]
        
        X_train = df_training[var]
        y_train = df_training[variable_dependiente]
        X_test = df_test[var]
        y_test = df_test[variable_dependiente]

        X_train = np.column_stack((np.ones_like(X_train), X_train))
        X_test = np.column_stack((np.ones_like(X_test), X_test))

        theta = np.linalg.inv(X_train.T @ X_train) @ X_train.T @ y_train

        y_pred = X_test @ theta

        mse_test = np.mean((y_test - y_pred)**2)

        df_test['ventas_pred'] += X_test @ theta

        ax.scatter(X_test[:, 1], y_test, alpha=0.5, label="Real")
        ax.scatter(X_test[:, 1], y_pred, c="black", linewidth=3, label="Predicción")
        ax.set_title(f"{var.capitalize()} vs Ventas\nMSE: {mse_test:.2f}")
        ax.set_xlabel(var.capitalize())
        ax.set_ylabel("Ventas")
        ax.legend()

df_test['ventas_pred'] /= len(variables_independientes)

print(df_test["ventas_pred"])


plt.tight_layout(rect=[0, 0, 1, 0.96])
plt.show()