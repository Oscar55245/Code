import requests

class Consulta:
  def buscar_articulo_wikipedia(self,termino):
    url = "https://es.wikipedia.org/w/api.php"
    parametros = {
        "action": "query",
        "format": "json",
        "prop": "extracts",
        "titles": termino,
        "exintro": True,
        "explaintext": True
    }
    answer = ""
    respuesta = requests.get(url, params=parametros)
    datos = respuesta.json()
    paginas = datos["query"]["pages"]
    for pagina_id, informacion_pagina in paginas.items():
        titulo = informacion_pagina["title"]
        extracto = informacion_pagina["extract"]
        indice_punto = extracto.find(".")
        if indice_punto != -1:
            extracto = extracto[:indice_punto + 1] 
        
        answer +=f"Título: {titulo}\n"
        answer +=f"Respuesta: {extracto}"
    return answer

