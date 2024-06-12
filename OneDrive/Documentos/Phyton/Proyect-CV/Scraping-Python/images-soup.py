import requests
from bs4 import BeautifulSoup
import cfscrape
import os
import urllib.request
import csv
import pandas as pd

scrapper = cfscrape.create_scraper()
r = scrapper.get("https://hidralistico.com.mx/categoria-producto/juegos-de-cartas/yu-gi-oh/carta-suelta/zombie-horde/")

image_folder = 'imagenes'
os.makedirs(image_folder, exist_ok=True)

soup = BeautifulSoup(r.content, "html.parser")
fichaProductos = soup.find_all('div', class_="inner img-effect",limit=12)
name_img = soup.find_all('h2', class_="woocommerce-loop-product__title", limit=12)
pre=soup.find_all('span',class_='woocommerce-Price-amount amount',limit=12)
precios = []
name=[]
for precio in pre:
    chars ='xa'
    bdi = precio.find('bdi')
    if bdi:
        precios.append(bdi.get_text().translate(str.maketrans('', '', chars)))

for index, element in enumerate(fichaProductos):
    img_url = element.find("img")['data-lazy-src']
    try:
        with urllib.request.urlopen(img_url) as web_file:
            data = web_file.read()
            product_name = name_img[index].get_text().strip()
            name.append(f"{product_name}")
            image_path = os.path.join(image_folder, f"{product_name}.jpg")

            with open(image_path, mode='wb') as local_file:
                local_file.write(data)
            print(f"Imagen guardada: {image_path}")
    except urllib.error.URLError as e:
        print(f"Error en la iteración {index}: {e}")
    except urllib.error.URLError as e:
        print(e)

df = pd.DataFrame({'Titulo': name, 'Precios': precios})
print(df)

archivo_csv = 'mi_archivo.csv'
df.to_csv(archivo_csv, index=False)



