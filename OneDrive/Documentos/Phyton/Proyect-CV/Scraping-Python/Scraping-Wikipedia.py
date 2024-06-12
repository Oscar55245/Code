from bs4 import BeautifulSoup
import requests


pagweb="https://es.wikipedia.org/wiki/Wikipedia:Portada"
respuesta=requests.get(pagweb)
contenido=respuesta.text
soup=BeautifulSoup(contenido,'lxml')
caja=soup.find('div',id='main-tfa',class_='main-box main-box-responsive-image')
texto=soup.find('div',id='main-tga',class_='main-box main-box-responsive-image')
titulo=caja.find('div',class_='mw-heading mw-heading2 ext-discussiontools-init-section').get_text()
titulo2=texto.find('div',class_='mw-heading mw-heading2 ext-discussiontools-init-section').get_text()
txt2=texto.find('p').get_text()
txt=caja.find('p').get_text()
chars ='Anexo:'
res = titulo2.translate(str.maketrans('', '', chars))
print(titulo)
print(txt)
print(titulo2)
print(txt2)
with open(f'{titulo}.txt','w') as file:
     file.write(txt)
with open(f'{res}.txt','w') as file:
     file.write(txt2)
