import requests   
import pandas as pd
import math

playera_A =[]

df1 = pd.read_csv('Cac.csv')

df1 = df1.iloc[:, 0:]
print(df1)
def distancia_euclidiana(p1, p2):
    suma_cuadrados = sum((float(x) - float(y))**2 for x, y in zip(p1, p2))
    return math.sqrt(suma_cuadrados)

def InsertarNuevasCaracteristicas(playera, diseñador, material, ocasion, tipoCorte):
    global df1
    nueva_fila = {'Playera':"static\\img\\detection\\"+playera+".jpg",'Diseñador':diseñador,'Material':material,'Ocasion':ocasion,'Corte':tipoCorte}
    df1 = df1.append(nueva_fila, ignore_index=True)
    df1.to_csv('Caracteristicas.csv', index=False)

def RecomendacionPlayera(indice_a_buscar,listaprincipal):
    print('Índice de distancia:', indice_a_buscar)
    indice_a_buscar = indice_a_buscar
    imagenes = []
    playera_A = df1.loc[df1['Playera'] == indice_a_buscar].values.tolist()
    playera_A = playera_A[0][1:]
    print(playera_A)
    distancias = []
    for index, row in df1.iterrows():
        playera_actual = row["Playera"]
        if not playera_actual.startswith('static\\img\\detection\\'):
            valores_numericos = row.values[1:].tolist()
            distancia = distancia_euclidiana(playera_A, valores_numericos)
            if distancia < 1.5:
                distancias.append((playera_actual, distancia))
    distancias.sort(key=lambda x: x[1])
    for img, dist in distancias[:3]:
        if img not in listaprincipal:
            imagenes.append(img)
    return imagenes



def ObtenerLista(id):

    url=f"https://cesarj.pythonanywhere.com/total-comprado?ID={id}"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            return message[:3]
        else:
              print('error')
    except requests.exceptions.RequestException as e:
        print(e)



def DevolverRecomendacion(id):
    listaprincipal=ObtenerLista(id)
    imagenes_sin_duplicados = set()
    for lista in listaprincipal:
        recomendaciones = RecomendacionPlayera(lista,listaprincipal)
        imagenes_sin_duplicados.update(recomendaciones)
    imagenes_sin_duplicados = list(imagenes_sin_duplicados)
    if len(imagenes_sin_duplicados) > 8:
        imagenes_sin_duplicados = imagenes_sin_duplicados[:8]
    return imagenes_sin_duplicados

