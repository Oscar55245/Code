from duckduckgo_search import DDGS
from googletrans import Translator

class Consulta :
    def searchDuckDuckgo(self,text):
        results = DDGS().text(text, max_results=5)
        translator = Translator()
        answer = ""
        cuerpo=""
        primer_titulo_agregado = False
        for result in results:
             if not primer_titulo_agregado:
                  answer += "\nTítulo: " + str(result['title']) + "\n"
                  primer_titulo_agregado = True
             else:
                  cuerpo += "" + str(result['body']) + "\n"
        answer+="\n"+cuerpo
        traduccion = translator.translate(answer, src='en', dest='es')
        print("Texto traducido al español:", traduccion.text)
        return  traduccion.text

