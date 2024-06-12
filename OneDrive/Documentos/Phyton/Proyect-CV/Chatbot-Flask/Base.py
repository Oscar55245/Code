from pyswip import Prolog
import os
class Consultas:
    

    def queryProlog(self, question):
        prolog = Prolog()
        route_file_pl = os.path.join("", 'Arbolgenealogico.pl')
        prolog.consult(route_file_pl)
        consulta = self.convertir_a_consulta(question)  # Llamar a convertir_a_consulta usando self
        for solucion in prolog.query(consulta):
            return solucion["Texto"]

    def convertir_a_consulta(self, question):  # Asegúrate de que convertir_a_consulta sea un método de instancia
        question = question.lower()
        relaciones = {'madre': 'madre_de', 'padre': 'padre_de'}
        relacion = None
        for palabra in relaciones:
            if palabra in question:
                print(palabra)
                print(question)
                relacion = relaciones[palabra]
                break
        if relacion is None:
            return None
        nombre = question.split(' de ')[1].rstrip('?')
        # Construir la consulta Prologs
        consulta = f"{relacion}(X, {nombre}, Texto)."
        return consulta

