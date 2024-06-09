
class chatbot:
    Questions = ['Cual es tu nombre? ','Cual es tu edad?','Donde vives? ','Que clase es esta?', 'Cuantos compañeros hay?'
             ,'Te gusta el helado ?', 'Te gusta la pizza?','Cual es la capital  ?','Que musica te gusta? ',
             'Hoy hace frio? ', 'Hoy hace calor? ', 'Nombre de tu escuela?','Te vas a titular? ',
             'Mañana que dia es ?','20.-Salir']
    
    Answers = ['Oscar','24','Guadalajara','Inteligencia Artificial','9','Si me gusta el helado','Me gusta gusta la pizza','Ciudad de mexico'
           ,'Toda la musica','No hace frio','Si hace calor','UNE','Si a la titulacion','Miercoles']
    
    def match(self, question):
        for p, a in zip(self.Questions, self.Answers):
            if p.strip().lower() == question.strip().lower():
                return a
        return "Lo siento, no entiendo esa pregunta."





