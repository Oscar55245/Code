from bs4 import BeautifulSoup
import requests


pagweb="https://subslikescript.com/movie/Titanic-120338"
respuesta=requests.get(pagweb)
##print(respuesta)
contenido=respuesta.text
soup=BeautifulSoup(contenido,'lxml')
##print(soup.prettify())   ############ acomoda el html en arbol
caja=soup.find('article',class_='main-article')#### Busca la etiqueta por medio de el tipo de etiqueta y su clase
titulo=caja.find('h1').get_text()
texto=caja.find('div',class_='full-script').get_text()
##print(texto)
with open(f'{titulo}.txt','w') as file:
    file.write(texto)
