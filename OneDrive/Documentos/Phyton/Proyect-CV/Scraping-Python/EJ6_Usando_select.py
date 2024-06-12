import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.keys import Keys
import time
class usando_unittest(unittest.TestCase):

	def setUp(self):
		service = Service(executable_path=r"C:\driverEdge\msedgedriver.exe")
		self.driver = webdriver.Edge(service=service)
	def test_usando_select(self):
		driver = self.driver
		driver.get("https://www.w3schools.com/howto/howto_custom_select.asp")
		time.sleep(3)
		select = driver.find_element(By.XPATH,"/html/body/div[5]/div[1]/div[1]/div[3]/div[1]/select")
		opcion = select.find_elements(By.TAG_NAME,"option")
		time.sleep(3) 
		for option in opcion:
			print("Value is: %s" % option.get_attribute("value"))
			option.click()
			time.sleep(1)
		seleccionar = Select(driver.find_element(By.XPATH,"/html/body/div[5]/div[1]/div[1]/div[3]/div[1]/select"))
		seleccionar.select_by_value("10")
		time.sleep(3)


if __name__ == '__main__':
	unittest.main()