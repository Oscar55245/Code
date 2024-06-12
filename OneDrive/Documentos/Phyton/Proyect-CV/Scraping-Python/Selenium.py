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
        self.driver.maximize_window()
    def test_buscar(self):
        self.driver.get("https://forms.office.com/Pages/ResponsePage.aspx?id=_eeS24nuHUm_P6918HPgz8kGucio5uRAucnQjmvXLKJUNURCSlVMNDg4RTBQRk9JNkhYMEFSUFJMOS4u")
        ##self.assertIn("Google", self.driver.title)
        elemento = self.driver.find_element(By.CSS_SELECTOR, '[aria-labelledby="QuestionId_rb286768a44aa4f0fbe30e70ad341a7a4 QuestionInfo_rb286768a44aa4f0fbe30e70ad341a7a4"]').send_keys("Oscar Sartana")
        elemento2=self.driver.find_element(By.CSS_SELECTOR, '[aria-labelledby="QuestionId_r2256f714dcd64017a39a024187ddbc92 QuestionInfo_r2256f714dcd64017a39a024187ddbc92"]').send_keys("Velazquez Juarez")
        elemento3 = self.driver.find_element(By.CSS_SELECTOR, '[aria-labelledby="QuestionId_r6476d7fbddd94cf0aa768ea4a67aef55 QuestionInfo_r6476d7fbddd94cf0aa768ea4a67aef55"]').send_keys("Ingenieria en Computacion")
        elemento4=self.driver.find_element(By.CSS_SELECTOR, '[aria-labelledby="QuestionId_rae0d3384aeda48fb804ca12e2204e5a8 QuestionInfo_rae0d3384aeda48fb804ca12e2204e5a8"]').send_keys("Centro")
        button = self.driver.find_element(By.CSS_SELECTOR, '[data-automation-id="submitButton"]').click()
        time.sleep(5)
        assert "No se ha encontrado resultado" not in self.driver.page_source
    def tearDown(self):
        self.driver.quit()
if __name__ == "__main__":
    unittest.main()