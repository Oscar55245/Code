import requests
from bs4 import BeautifulSoup
import pandas as pd
import matplotlib.pyplot as plt
headers = {
    "user-agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/71.0.3578.80 Chrome/71.0.3578.80 Safari/537.36"
}
url = 'https://pokemondb.net/pokedex/all'
pag = requests.get(url, headers=headers)
soup=BeautifulSoup(pag.content,"html.parser")
Tabla = soup.find("table", class_="data-table sticky-header block-wide")
fila=Tabla.find_all("tr")
fila=Tabla.find("tbody").find_all("tr")
#print(Tabla)
vida=[]
attack=[]
Defense=[]
nombre=[]
for x in fila:
  vida.append(x.find_all("td")[4].get_text())
  attack.append(x.find_all("td")[5].get_text())
  Defense.append(x.find_all("td")[6].get_text())
  nombre.append(x.find_all("td")[1].get_text())

df = pd.DataFrame({'nombre': nombre,'Vida':vida,'Defense':Defense, 'Ataque': attack})

archivo_csv = 'pokemon.csv'
df.to_csv(archivo_csv, index=False)

# Selecciona la columna que deseas incluir en el histograma
data_column = 'Vida'
data_columnD ='Defense'
data_columnA ='Ataque'
nombre='nombre'


##plt.figure(figsize=(8, 6))
# Crea el histograma
##plt.hist(df[data_column], bins=10, color='skyblue', edgecolor='black')
##plt.title(f'Histograma de {df[data_column]}')
##plt.xlabel(data_column)

plt.figure(figsize=(8, 6))
plt.bar(df[nombre],df[data_columnD], color='GREEN')
plt.title(f'Histograma de {df[data_columnD]}')
plt.xlabel('Nombres de los pokemons')  # Etiqueta del eje x
plt.ylabel('Defense')  # Etiqueta del eje y
plt.title('Histograma de pokemons Defensa')  # Título del gráfico
plt.xticks(rotation=45)

plt.figure(figsize=(8, 6))
plt.bar(df[nombre],df[data_columnA],color='RED')
plt.title(f'Histograma de {df[data_columnA]}')
plt.xlabel('Nombres de los pokemons Ataque')  # Etiqueta del eje x
plt.ylabel('Ataque')  # Etiqueta del eje y
plt.xticks(rotation=45)

plt.figure(figsize=(10, 6))  # Tamaño de la figura
plt.bar(df[nombre],df[data_column], color='skyblue')  # Crear el gráfico de barras
plt.xlabel('Nombres de los pokemons  Vida')  # Etiqueta del eje x
plt.ylabel('vida')  # Etiqueta del eje y
plt.title('Histograma de pokemons')  # Título del gráfico
plt.xticks(rotation=45)

# Muestra el histograma
plt.tight_layout()
plt.show()



print(df)



