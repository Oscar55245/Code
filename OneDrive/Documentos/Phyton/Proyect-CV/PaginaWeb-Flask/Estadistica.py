import pandas as pd
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
from io import BytesIO
import base64


def generate_statistics(id, numero):
    df = pd.DataFrame({'Playera': id, 'Numero': numero})
    df_agrupado = df.groupby('Playera').sum().reset_index()
    print(df_agrupado)
    df_agrupado_ordenado = df_agrupado.sort_values(by='Numero', ascending=False)
    grupos_mas_grandes = df_agrupado_ordenado.head(3)
    print(grupos_mas_grandes)
    df_playera=grupos_mas_grandes['Playera'].tolist()
    df_numero=grupos_mas_grandes['Numero'].tolist()
    plt.bar(df_agrupado['Playera'], df_agrupado['Numero'], color='GREEN')
    plt.title('Histograma de Popularidad')
    plt.xlabel('Nombres de los diseños')
    plt.ylabel('Usuarios')
    plt.xticks(rotation=45)
    img_buffer = BytesIO()
    plt.savefig(img_buffer, format='png')
    plt.close()  # Cierra el gráfico

    img_buffer.seek(0)
    img_base64 = base64.b64encode(img_buffer.read()).decode('utf-8')

    return img_base64,df_playera,df_numero
    
    """# Renderizamos en la plantilla directamente
    img_data = img_buffer.read()
    img_base64 = base64.b64encode(img_data).decode('utf-8')

    return img_base64"""
    
