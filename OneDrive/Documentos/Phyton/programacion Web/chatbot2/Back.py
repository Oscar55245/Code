from flask import Flask, request, render_template, jsonify,send_file
import os
import Base 
from multiprocessing import Process,Queue
import ModeloEconomico
import matplotlib
import Chatbotmini
import Wolfram
import Duck
import Wikipedia
import re
import ArbolDecisionDiabetes 
matplotlib.use('Agg')
app = Flask(__name__)
app.secret_key = 'tu_clave_secreta_aqui'
global secondResponse
secondResponse=False
@app.route('/pregunta')
def send_image():
    global secondResponse
    print(secondResponse)
    guia=""
    question=request.args.get('chatbot')
    direcciones=['arbol','modelo','diabetes']
    question = question.lower()
    relaciones = {'madre': 'arbol', 'padre': 'arbol','modelo':'modelo','diabetes':'diabetes'}
    direccion = None
    for palabra in relaciones:
            if palabra in question:
                 print(palabra)
                 direccion=relaciones[palabra]
                 break
    if direccion==direcciones[0]:
         queue = Queue()
         process = Process(target=consultar_prolog, args=(question, queue))
         respuesta =processQuestion(process,queue)
         return jsonify(respuesta=respuesta)
    elif direccion == direcciones[1]:
         modelo = ModeloEconomico.ImportacionesMaiz()
         img_base64 = modelo.GenerarModelo()
         return jsonify(img_base64=img_base64)
    elif direccion == direcciones[2] or secondResponse==True:
         question = question.lower()
         if "tengo" in question and "diabetes" in question:
              print(question)
              secondResponse=True
              res='Puedo ayuarte a saber la probabilidad si tienes diabetes si me dices tu edad y tu presion sanguinea'
         
         elif ("años" in question and "sanguinea" in question) or ("edad" in question and "sanguinea" in question) :
              print(question)
              tree=ArbolDecisionDiabetes.TreeOutcome()
              numeros = re.findall(r'\d+', question)
              numeros_enteros = [int(numero) for numero in numeros]
              print(numeros_enteros)
              paciente=tree.treeOutcome(numeros_enteros)
              print('Paciente : ',paciente[0])
              if paciente[0]==1:
                   res='Te vas a morir compa'
              elif paciente[0]==0:
                   res='Todavia vas a vivir '
         else:
              res='Vuelve a inentar preguntarme si tienes diabetes'
         print(question)
         
         return jsonify(respuesta=res)
    else:
         chatbot=Chatbotmini.chatbot()
         respuesta=chatbot.match(question)
         if (respuesta=='Lo siento, no entiendo esa pregunta.'):
              wol=Wolfram.wolfram()
              res=wol.question(question)
              if (res is None):
                   queue = Queue()
                   process = Process(target=consultarDuck, args=(question, queue))
                   res=processQuestion(process,queue)
                   if (res is None):
                        wiki=Wikipedia.Consulta()
                        res=wiki.buscar_articulo_wikipedia(question)
                        if (res is None):
                             res='Lo siento, no entiendo esa pregunta.'
              return jsonify(respuesta=res)
         else:
              return jsonify(respuesta=respuesta)

@app.route('/')
def index():
    return render_template('index.html')

def processQuestion(process,queue):
     process.start()
     process.join()
     res = queue.get()
     return res 


def consultarDuck(pregunta,queue):
     duck=Duck.Consulta()
     respuesta=duck.searchDuckDuckgo(pregunta)
     queue.put(respuesta)

def consultar_prolog(pregunta, queue):
    prolog = Base.Consultas()
    respuesta=prolog.queryProlog(pregunta)
    queue.put(respuesta)

if __name__ == '__main__':
    app.run(debug=True)
