from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.edge.service import Service
service = Service(executable_path=r"C:\driverEdge\msedgedriver.exe")#control del navegador
driver = webdriver.Edge(service=service)
driver.get("https://www.youtube.com/channel/UCcT6IFddIod7xURc7a7q3Bg?view_as=subscriber")
driver.get_screenshot_as_file("C:\\Users\\rockr\\Pictures\\Screenshots\\mi_canal.png")