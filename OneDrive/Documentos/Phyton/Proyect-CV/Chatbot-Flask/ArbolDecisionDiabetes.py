import pandas as pd
from sklearn.tree import DecisionTreeClassifier, plot_tree
import matplotlib.pyplot as plt
from scipy.stats import entropy
from math import log
from sklearn.model_selection import train_test_split
from sklearn import tree


class TreeOutcome:
  def treeOutcome(self,numer):
    data = pd.read_csv("diabetes.csv")
    age = pd.Series([40, 30, 20, 50])
    bloodPressure = pd.Series([100, 110, 100, 110])
    diabetic = data[data["Outcome"] == 1]
    notdiabetic = data[data["Outcome"]==0]
    datos_entrena, datos_prueba, clase_entrena, clase_prueba = train_test_split(
    data[["Age", "BloodPressure"]],
    data["Outcome"], 
    test_size=0.30)
    arbol_decision = tree.DecisionTreeClassifier(criterion="entropy")
    arbol = arbol_decision.fit(datos_entrena, clase_entrena)
    accuracy = arbol_decision.score(datos_prueba, clase_prueba)
    print(numer)
    print("Nuevo paciente", arbol_decision.predict([numer]))
    return arbol_decision.predict([numer])



