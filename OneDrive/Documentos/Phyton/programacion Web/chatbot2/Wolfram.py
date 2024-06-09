import wolframalpha

app_id = 'L4VRJK-6LXXVT4A6W'

client = wolframalpha.Client(app_id)



class wolfram:

    def question(self, question):
        res = client.query(question)
        for pod in res.pods:
            if pod.title=='Result':
                print(pod.title + ':')
                for sub in pod.subpods:
                    return sub.plaintext
