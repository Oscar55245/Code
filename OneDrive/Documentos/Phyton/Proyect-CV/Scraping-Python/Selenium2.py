from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.edge.service import Service
service = Service(executable_path=r"C:\driverEdge\msedgedriver.exe")
driver = webdriver.Edge(service=service)
busqueda = input("¿Que es lo que deseas buscar?")
driver.get("http://www.google.com")
elemento = driver.find_element(By.NAME, "q")
elemento.send_keys(busqueda)
elemento.send_keys(Keys.RETURN)
driver.get_screenshot_as_file("C:\\Users\\aylem\\OneDrive\\Documentos\\Phyton\\img\\mi_canal.png")
