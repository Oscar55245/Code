
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error
import requests
from bs4 import BeautifulSoup
import pandas as pd
headers = {
    "user-agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/71.0.3578.80 Chrome/71.0.3578.80 Safari/537.36"
}
url = 'https://www.inegi.org.mx/app/indicadores/?tm=0&ind=111776#D111776_1100037000760250'
pag = requests.get(url, headers=headers)
soup=BeautifulSoup(pag.content,"html.parser")
print(soup)