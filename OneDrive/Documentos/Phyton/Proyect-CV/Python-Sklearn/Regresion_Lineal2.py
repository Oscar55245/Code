import pandas  as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression

votos_primarias_us = pd.read_csv('primary_results.csv')
df = votos_primarias_us
df2 = df.set_index("state")
print(df2)
df_sorted = df.sort_values(by="votes", ascending=False)
print(df_sorted.head())
print(df.groupby(["state", "party"]))
print(df.groupby(["state", "party"]).sum())

df_democrat = votos_primarias_us[votos_primarias_us['party'] == 'Democrat']
df_democrat = df_democrat[['votes', 'fraction_votes']]
votes_array = np.array(df_democrat['votes']).reshape(-1, 1)
fraction_votes_array = np.array(df_democrat['fraction_votes'])

# Crea un modelo de regresión lineal
model = LinearRegression()

# Entrena el modelo
model.fit(votes_array, fraction_votes_array)

# Predice los valores
fraction_votes_pred = model.predict(votes_array)
plt.scatter(votes_array, fraction_votes_array, color='blue', label='Datos reales')
plt.plot(votes_array, fraction_votes_pred, color='red', linewidth=2, label='Regresión Lineal')
plt.xlabel('Votos')
plt.ylabel('Fracción de Votos')
plt.title('Regresión Lineal de Votos por Candidato (Demócratas)')
plt.legend()
plt.show()
