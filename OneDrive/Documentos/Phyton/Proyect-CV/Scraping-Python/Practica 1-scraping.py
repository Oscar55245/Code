import requests
from bs4 import BeautifulSoup
import pandas as pd
headers = {
    "user-agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/71.0.3578.80 Chrome/71.0.3578.80 Safari/537.36"
}
url = 'https://www.espn.com.mx/futbol/posiciones/_/liga/esp.1'
pag = requests.get(url, headers=headers)
soup=BeautifulSoup(pag.content,"html.parser")
Tabla = soup.find("table", class_="Table Table--align-right")
columns = [th.text.strip() for th in Tabla.select("thead th")[:4]]
print(columns)
data_rows = []
for row in Tabla.select("tbody tr"):
    data_row = [td.text.strip() for td in row.select("td")[:4]]
    data_rows.append(data_row[1:])
df = pd.DataFrame(data_rows, columns=columns[1:])
print(df)