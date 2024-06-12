from flask import Flask,request, render_template, jsonify, session
import requests
import pandas as pd
import Estadistica as stat
import smtplib
import json
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from datetime import date
from reportlab.lib.pagesizes import letter
from reportlab.pdfgen import canvas
from reportlab.lib import colors
from email import encoders
from email.mime.base import MIMEBase
import math
tokens = {}
app = Flask(__name__)
app.secret_key = 'mi_clave_secreta'

@app.route("/buscar-pedido", methods=['GET'])
def BuscarPedido():
     if 'logged_in' in session:
        id_pedido = request.args.get('ID')
        url="https://cesarj.pythonanywhere.com/pedidos-buscar?ID="+id_pedido
        try:
            response = requests.get(url)
            if response.status_code == 200:
                message = response.json()
                usuario = [row[0] for row in message]
                domicilio = [row[1] for row in message]
                postal = [row[2] for row in message]
                total = [row[3] for row in message]
                pedido = [row[4] for row in message]
                estatus = [row[5] for row in message]
                ID = [row[6] for row in message]
                email = [row[7] for row in message]
                df = pd.DataFrame({'usuario': usuario,'domicilio':domicilio,'postal':postal,
                   'total':total,'pedido':pedido,'estatus':estatus,'ID':ID,'email':email})

                return render_template("TablaPedidos.html",tabla=df)
            else:
                return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
        except requests.exceptions.RequestException as e:
            return jsonify({'error': 'Error de conexión: {}'.format(e)})
     else:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})








@app.route("/Searchlike-shirt")
def search_like():
    try:
        imagen_url = request.args.get("imagen")
        idActual = request.args.get("ID")
        url = "https://cesarj.pythonanywhere.com/Searchlike-shirt?imagen="+imagen_url+" &ID="+idActual
        response = requests.get(url)

        if response.status_code == 200:
            # Procesar la respuesta obtenida
            data = response.json()
            return jsonify(data.get('valor'))
        else:
            # Si la solicitud no fue exitosa, devolver un mensaje de error
            return jsonify({'error': 'Error al hacer la solicitud: ' + str(response.status_code)}), response.status_code

    except Exception as e:
        # Manejar cualquier excepción que ocurra durante el proceso
        return jsonify({'error': 'Ocurrió un error al procesar la solicitud: ' + str(e)}), 500


@app.route("/deportiva")
def deportiva():
    try:
        url = "https://oscarestudiante2211.pythonanywhere.com/img-deportiva"
        response = requests.get(url)

        if response.status_code == 200:
            data = response.json()
            return jsonify(data)
        else:
            return jsonify({'error': 'Error al hacer la solicitud: ' + str(response.status_code)}), response.status_code

    except Exception as e:
        # Manejar cualquier excepción que ocurra durante el proceso
        return jsonify({'error': 'Ocurrió un error al procesar la solicitud: ' + str(e)}), 500



@app.route("/casuales")
def casual():
    try:
        url = "https://oscarestudiante2211.pythonanywhere.com/img-casual"
        response = requests.get(url)

        if response.status_code == 200:
            data = response.json()
            return jsonify(data)
        else:
            return jsonify({'error': 'Error al hacer la solicitud: ' + str(response.status_code)}), response.status_code

    except Exception as e:
        # Manejar cualquier excepción que ocurra durante el proceso
        return jsonify({'error': 'Ocurrió un error al procesar la solicitud: ' + str(e)}), 500



@app.route('/buscar', methods=['POST'])
def sendB():
    nombre = request.form.get('usuario')
    password = request.form.get('password')


    def get_empleados_data():
        url = f"https://cesarj.pythonanywhere.com/login-empleados?user={nombre}&pass={password}"
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        return None

    def get_compras_data():
        url = "https://cesarj.pythonanywhere.com/compras"
        response = requests.get(url)
        if response.status_code == 200:
            return response.json()
        return None

    url_buscar = f"https://cesarj.pythonanywhere.com/buscar?user={nombre}&pass={password}"
    response_buscar = requests.get(url_buscar)

    if response_buscar.status_code == 200:
        message = response_buscar.json()
        name = message.get('nombre')
        puntos = message.get('puntos')
        id_customer = message.get('ID')
        if name is None or puntos is None or id_customer is None:
            return render_template("Login.html")
        else:
            session['user_type'] = 'cliente'
            session['logged_in'] = True
            session['ID'] = id_customer
            listImages=[]
            url = f"https://euclidiana.pythonanywhere.com/recomendacion?ID={id_customer}"
            response = requests.get(url)
            if response.status_code == 200:
                data = response.json()
                listImages = data.get("listImages", [])
            if not listImages:
                listImages=['img10.jpg','img12.jpg','img13.jpg','img14.jpg','img15.jpg']
            return render_template("camara.html", imagen_urls=listImages, puntos=puntos, nombre=name, ID=id_customer)
    else:
        empleados_data = get_empleados_data()
        if empleados_data:
            compras_data = get_compras_data()
            if compras_data:
                playera = compras_data.get('Playera')
                cantidad = compras_data.get('cantidad')
                listName = []
                lista_playera, lista_numero = stat.generate_statistics(playera,cantidad)
                for num in lista_playera:
                     url2 = "https://cesarj.pythonanywhere.com/info?ID=" + str(num)
                     try:
                        response = requests.get(url2)
                        if response.status_code == 200:
                            message = response.json()
                            listName.append(message.get('valor'))
                        else:
                            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
                     except requests.exceptions.RequestException as e:
                        print("Error en la solicitud:", e)
                session['user_type'] = 'empleado'
                session['logged_in'] = True
                return render_template("Empleados.html",lista_playera=lista_playera, lista_numero=lista_numero,listName=listName)
            else:
                return jsonify({'error': 'La solicitud de compras no fue exitosa. Código de estado: {}'.format(response.status_code)})
        else:
            return render_template("Login.html")




@app.route("/like-shirt")
def like_shirt ():
  if 'logged_in' in session:
     imagen_url = request.args.get("imagen")
     ID = request.args.get("ID")
     nueva_cadena = imagen_url.replace("https://oscarestudiante2211.pythonanywhere.com//", "")
     nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/deportiva", "")
     nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/casual", "")
     try:
         url=f"https://cesarj.pythonanywhere.com/like-shirt?ID={ID}&imagen={nueva_cadena}"
         response = requests.get(url)
         if response.status_code == 200:
             message = response.json()
             return render_template("camara.html",imagen_urls=message,ID=ID)
         else:
             return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
     except requests.exceptions.RequestException as e:
         return jsonify({'error': 'Error de conexión: {}'.format(e)})
  else:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})

@app.route("/Unlike-shirt")
def Unlike():
 if 'logged_in' in session:
    imagen_url = request.args.get("imagen")
    ID = request.args.get("ID")
    nueva_cadena = imagen_url.replace("https://oscarestudiante2211.pythonanywhere.com/casual", "")
    nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com//", "")
    nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/deportiva", "")
    try:
        url=f"https://cesarj.pythonanywhere.com/Unlike-shirt?ID={ID}&imagen={nueva_cadena}"
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            return jsonify({'valor': ID,'precio':nueva_cadena})
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})




@app.route("/like-shirt-page")
def like_page():
 ID = request.args.get('ID')
 if 'logged_in' in session and session.get('user_type') == 'cliente'and session.get('ID')== int(ID):
     url=f"https://cesarj.pythonanywhere.com/like-shirt-page?ID={ID}"
     try:
         response = requests.get(url)
         if response.status_code == 200:
             message = response.json()
             return render_template("camara.html",imagen_urls=message,ID=ID)
         else:
             return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
     except requests.exceptions.RequestException as e:
         return jsonify({'error': 'Error de conexión: {}'.format(e)})
 else:
     return jsonify({'error': ID})


@app.route("/")
def index ():
     session.pop('logged_in', None)
     session.pop('user_type', None)
     session.pop('ID', None)
     return render_template("Login.html")


@app.route('/home')
def send_image():
    ID = request.args.get('ID')
    if 'logged_in' in session and session.get('user_type') == 'cliente'and session.get('ID')== int(ID):
            listImages=[]
            url = f"https://euclidiana.pythonanywhere.com/recomendacion?ID={ID}"
            response = requests.get(url)
            if response.status_code == 200:
                data = response.json()
                listImages = data.get("listImages", [])
            if not listImages:
                listImages=['img10.jpg','img12.jpg','img13.jpg','img14.jpg','img15.jpg']
            return render_template("camara.html", imagen_urls=listImages,ID=ID)
    else:
        ID = request.args.get('ID')
        imageNames=['img10.jpg','img12.jpg','img13.jpg','img14.jpg','img15.jpg']
        return render_template("camara.html", imagen_urls=imageNames)


@app.route("/producto-info")
def producto_info ():
    imagen_url = request.args.get("imagen")
    ID = request.args.get("ID")
    caracteres_a_quitar = ["https://oscarestudiante2211.pythonanywhere.com//", "https://oscarestudiante2211.pythonanywhere.com/deportiva", "https://oscarestudiante2211.pythonanywhere.com/casual"]
    resultado = imagen_url
    for caracteres in caracteres_a_quitar:
        resultado = resultado.replace(caracteres, "")
    url="https://cesarj.pythonanywhere.com/producto-info?imagen="+resultado
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            valor = message.get('valor')
            precio = message.get('precio')
            material=message.get('material')
            dise=message.get('nameD')
            return render_template("producto.html",imagen_url=imagen_url,material=material,valor=valor,dise=dise,precio=precio,ID=ID)
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})


@app.route("/producto")
def producto ():
    imagen_url = request.args.get("imagen")
    caracteres_a_quitar = ["https://oscarestudiante2211.pythonanywhere.com//", "https://oscarestudiante2211.pythonanywhere.com/deportiva", "https://oscarestudiante2211.pythonanywhere.com/casual"]
    resultado = imagen_url
    for caracteres in caracteres_a_quitar:
        resultado = resultado.replace(caracteres, "")
    url="https://cesarj.pythonanywhere.com/producto-info?imagen="+resultado
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            valor = message.get('valor')
            precio = message.get('precio')
            return jsonify({'valor': valor,'precio':precio,'url':imagen_url})
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})



@app.route("/New_Shirt")
def New_Shirt():
    url = "https://cesarj.pythonanywhere.com/New-shirt"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            valor = message.get('valor')
            if valor:
                return jsonify({'valor': valor})
            else:
                return jsonify({'error': 'No se encontró la clave "valor" en el JSON'})
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})

@app.route("/carrito")
def carritoDeCompra():
 ID = request.args.get("ID")
 if 'logged_in' in session and session.get('ID')== int(ID):
     lista_parametro = request.args.get("lista")
     if lista_parametro:
         lista = json.loads(lista_parametro)
         precio = []
         name = []
         img = []
         medida=[]
         df = pd.DataFrame({'nombre': [], 'precio': [], 'img': [],'medida':[]})  # Inicializar df fuera del bucle
         for element in lista:
             url = "https://cesarj.pythonanywhere.com//carrito-info?element=" + element['url']
             try:
                 response = requests.get(url)
                 response.raise_for_status()  # Raise an exception for bad response status
                 message = response.json()
                 name.append(message.get('valor'))
                 precio.append(message.get('precio'))
                 img.append(message.get('imagen'))
                 medida.append(element['medida'])
             except requests.exceptions.RequestException as e:
                 df = pd.DataFrame({'nombre': name, 'precio': precio, 'img': img,'medida':medida})
                 return render_template("CarritoCompra.html", tabla=df,ID=ID)
         df = pd.DataFrame({'nombre': name, 'precio': precio, 'img': img,'medida':medida})  # Actualizar df con los datos recolectados
         return render_template("CarritoCompra.html", tabla=df,ID=ID)
     else:
         lista = []
         df = pd.DataFrame({'nombre': [], 'precio': [], 'img': []})
         return render_template("CarritoCompra.html", tabla=df,ID=ID)
 else :
         lista = []
         df = pd.DataFrame({'nombre': [], 'precio': [], 'img': []})
         return render_template("CarritoCompra.html", tabla=df,ID=ID)



@app.route("/registrar-clientes")
def registrar_cliente():
    return render_template("Registro.html")


@app.route("/insertar-cliente")
def insertar_cliente():
    usuario=request.args.get("usuario")
    nombre=request.args.get("nombre")
    correo=request.args.get("correo")
    password=request.args.get("password")
    error=False
    print(usuario,password, nombre, correo)
    if not usuario or not nombre or not correo or not password :
        return "Todos los campos son obligatorios"
    else:
        url="https://cesarj.pythonanywhere.com/insertar-cliente?usuario="+usuario+"&nombre="+nombre+"&correo="+correo+"&password="+password
        try:
            response = requests.get(url)
            if response.status_code == 200:
                message = response.json()
                error=message.get('usuario_existente')
                return render_template("Registro.html",usuario_existente=error)
            else:
                return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
        except requests.exceptions.RequestException as e:
            return jsonify({'error': 'Error de conexión: {}'.format(e)})



    return render_template("Registro.html",usuario_existente=error)




@app.route("/actualizar-status", methods=['POST'])
def UpdateStatus():
    status = request.form.get('status')
    dise = request.form.get('dise')
    print(status,dise)
    url =f"https://cesarj.pythonanywhere.com/actualizar-estado?diseno={dise}&estado={status}"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
        return jsonify({'exito': 'exito'})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})


@app.route("/actualizar-precio", methods=['POST'])
def UpdatePrecio():
    precio = request.form.get('precio')
    dise = request.form.get('dise')
    url =f"https://cesarj.pythonanywhere.com/actualizar-precio?diseno={dise}&precio={precio}"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
        return jsonify({'exito': 'exito'})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})




@app.route("/Tabla-Playeras")
def TablaPlayeras():
    url = "https://cesarj.pythonanywhere.com/shirt-info"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            shirts = message.get('camisetas')
            dise=[]
            precio=[]
            url=[]
            namedise=[]
            estado=[]
            for shirt in shirts:
                 dise.append(shirt["valor"])
                 url.append(shirt["url"])
                 precio.append(shirt["precio"])
                 namedise.append(shirt["namedise"])
                 estado.append(shirt["estado"])

            df = pd.DataFrame({'dise': dise, 'precio': precio, 'url': url, 'namedise': namedise,'estado':estado})
            return render_template("TablaPlayeras.html",tabla=df)
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})






@app.route('/insertar-compra', methods=['POST'])
def insertar_compra():
    usuario = request.form.get('usuario', '')
    domicilio = request.form.get('domicilio', '')
    email = request.form.get('email', '')
    postal = request.form.get('postal', '')
    total = request.form.get('total', '')
    ID = request.form.get('ID', '')
    form_dict = request.form.to_dict(flat=False)
    nombres = form_dict.get('nombres', [])
    precios = form_dict.get('precios', [])
    medida = form_dict.get('medida', [])
    cantidades = form_dict.get('cantidades', [])
    df = pd.DataFrame({'Playera': nombres,'Medida':medida,'Precio':precios,'Cantidad':cantidades})
    df.loc[len(df)] = ['Total', '', total, '']
    fecha_hoy = date.today()
    for nombre, precio, cantidad,medida in zip(nombres, precios, cantidades,medida):
        datos_concatenados = "|".join([f"{nombre},{precio},{cantidad},{medida}" for nombre, precio, cantidad,medida in zip(nombres, precios, cantidades,medida)])
    datos = {
    'nombres': nombres,
    'cantidades': cantidades,
    'ID': ID
    }
    url = 'https://cesarj.pythonanywhere.com/insertar-compra'
    respuesta = requests.post(url, json=datos)
    if respuesta.status_code == 200:
        print("Datos enviados exitosamente.")
    else:
            print(f"Error al enviar los datos. Código de estado: {respuesta.status_code}")

    url = f"https://cesarj.pythonanywhere.com/insert_car?usuario={usuario}&domicilio={domicilio}&postal={postal}&total={total}&pedido={datos_concatenados}&email={email}&ID={ID}"

    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            id_pedido=message.get('idProduct')
            pdf_file_name = "Confirmacion_pedido.pdf"
            c = canvas.Canvas(pdf_file_name, pagesize=letter)
            barra_x = 50
            barra_y = 690
            barra_ancho = 500
            barra_alto = 1600
            contenido_y = 600
            titulo = "Confirmación de Pedido"
            c.setFillColorRGB(0.2, 0.4, 0.6)

            c.rect(barra_x, barra_y, barra_ancho, barra_alto, fill=1)
            c.setFillColorRGB(1, 1, 1)
            c.setFont("Helvetica-Bold", 16)
            c.drawString(barra_x + 10, barra_y + 20, titulo)
            c.drawImage("/home/oscar4323/mysite/shiva.png", 350, 695, width=90, height=90)
            contenido_pedido = [
                f"¡Hola! {usuario}",
                f"Este es tu pedido realizado el día: {fecha_hoy}",
                f"Con este código puedes ver el estado de tu pedido en nuestra página: {id_pedido}",
                ]
            contenido_y = 600
            for linea in contenido_pedido:
                c.setFont("Helvetica", 12)
                c.setFillColorRGB(0, 0, 0)
                c.drawString(100, contenido_y, linea)
                contenido_y -= 20
            tabla_x = 100
            tabla_y = 400
            ancho_celda = 100
            alto_celda = 30
            c.setStrokeColorRGB(0, 0, 0)
            c.setLineWidth(1)
            c.setFont("Helvetica-Bold", 12)
            for i, texto in enumerate(["Playera", "Precio", "Cantidad", "Medida"]):
                    c.drawString(tabla_x + i * ancho_celda + 10, tabla_y - 10, texto)
                    c.line(tabla_x + i * ancho_celda, tabla_y, tabla_x + i * ancho_celda, tabla_y - (len(df) + 1) * alto_celda)
            c.line(tabla_x, tabla_y, tabla_x + 4 * ancho_celda, tabla_y)
            for i in range(len(df) + 1):
                    c.line(tabla_x, tabla_y - i * alto_celda, tabla_x + 4 * ancho_celda, tabla_y - i * alto_celda)
            c.setFont("Helvetica", 12)
            for i, (_, row) in enumerate(df.iterrows(), start=1):
                    c.drawString(tabla_x + 10, tabla_y - i * alto_celda, str(row['Playera']))
                    c.drawString(tabla_x + 110, tabla_y - i * alto_celda, str(row['Precio']))
                    c.drawString(tabla_x + 210, tabla_y - i * alto_celda, str(row['Cantidad']))
                    c.drawString(tabla_x + 310, tabla_y - i * alto_celda, str(row['Medida']))
            c.save()
            EnviarPDF(pdf_file_name,email)
            return render_template("CarritoCompra.html", ID=ID)
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})





def sendEmail(html,asunto,destinatario):
    smtp_host = 'smtp.gmail.com'
    smtp_port = 465
    email_usuario = ''
    email_password = ''
    remitente = ''
    msg = MIMEMultipart()
    msg['From'] = remitente
    msg['To'] = destinatario
    msg['Subject'] = asunto

    msg.attach(MIMEText(html, 'html'))
    server = smtplib.SMTP_SSL(smtp_host, smtp_port)
    server.login(email_usuario, email_password)
    server.sendmail(remitente, destinatario, msg.as_string())
    server.quit()

def agregar_url_a_json(url):
    try:
        with open('/home/oscar4323/mysite/urls.json', 'r') as file:
            data = json.load(file)
    except FileNotFoundError:
        data = {}

    data[url] = True  # Puedes poner cualquier valor aquí para marcar que la URL está presente

    with open('/home/oscar4323/mysite/urls.json', 'w') as file:
        json.dump(data, file)



@app.route('/subir_imagen', methods=['POST'])
def subir_imagen():
    try:
        corte = request.form['corte']
        diseno = request.form['diseno']
        material = request.form['material']
        tipo= request.form['tipo']
        nombre_imagen = request.form['nombreImagen']
        produccion = request.form['produccion']
        nameD = request.form['nameD']
        precio = request.form['precio']
        locacion = request.form['locacion']
        url = nombre_imagen + ".jpg"
        if 'imagen' in request.files:
            imagen = request.files['imagen']

            if imagen.filename != '':
                files = {'image': imagen}
                data = {'nombre': url}
                try:
                    url_insertar = f"https://euclidiana.pythonanywhere.com/insertar-caracteristicas?playera={nombre_imagen}&disenador={diseno}&material={material}&ocasion={tipo}&URL={url}&tipoCorte={corte}"
                    response = requests.get(url_insertar)
                    if response.status_code == 200:
                        print('Los datos se insertaron correctamente.')
                    else:
                        print('Error al insertar los datos. Código de estado:', response.status_code)
                    response_post = requests.post('https://oscarestudiante2211.pythonanywhere.com/upload', files=files, data=data)
                    response_post.raise_for_status()
                except requests.exceptions.RequestException as e:
                    return f"Error al enviar la imagen: {str(e)}"
                try:
                    url_insertar = f"https://cesarj.pythonanywhere.com/insert-playera?Diseno={nombre_imagen}&Materiales={produccion}&Disenador={nameD}&Localidad={locacion}&URL={url}&precio={precio}"
                    response_get = requests.get(url_insertar)
                    response_get.raise_for_status()
                except requests.exceptions.RequestException as e:
                    return f"Error al enviar los datos a /insertarPlayera por método GET: {str(e)}"

                return render_template("Playeras_E.html")

        return render_template("Playeras_E.html")
    except Exception as e:
        return f"Error: {str(e)}"




@app.route('/buscar-empleado')
def buscar_empleado():
    nombre = request.args.get("usuario")
    password = request.args.get("password")
    url = "https://cesarj.pythonanywhere.com/login-empleados?user=" + nombre + "&pass=" + password
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            if message:
                url = "https://cesarj.pythonanywhere.com/compras"
                response = requests.get(url)
                if response.status_code == 200:
                    message = response.json()
                    playera = message.get('Playera')
                    cantidad = message.get('cantidad')
                    lista_playera, lista_numero = stat.generate_statistics(playera,cantidad)
                    return render_template("Empleados.html", lista_playera=lista_playera, lista_numero=lista_numero)
                else:
                    return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
            else:
                return render_template("Login_Empleado.html")
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})


@app.route('/Login-Empleado-Tienda-de-Playeras')
def login_empleado():
    return render_template("Login_Empleado.html")

@app.route('/empleados')
def Home_empleado():
 if 'logged_in' in session and session.get('user_type') == 'empleado':
    url="https://cesarj.pythonanywhere.com/compras"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            playera = message.get('Playera')
            cantidad = message.get('cantidad')
            listName=[]
            lista_playera, lista_numero = stat.generate_statistics(playera,cantidad)
            for num in lista_playera:
                    url2 = "https://cesarj.pythonanywhere.com/info?ID=" +str(num)
                    try:
                        response = requests.get(url2)
                        if response.status_code == 200:
                            message = response.json()
                            listName.append(message.get('valor'))
                        else:
                            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
                    except requests.exceptions.RequestException as e:
                        print("Error en la solicitud:", e)
            return render_template("Empleados.html",lista_playera=lista_playera, lista_numero=lista_numero,listName=listName)
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})
 else:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})


@app.route("/pedido")
def pedido ():
     ID = request.args.get("ID")
     estatus=None
     return render_template("Pedido.html",estatus=estatus,ID=ID)





@app.route("/pedido_cliente")
def pedido_cliente():
 ID = request.args.get('ID')
 if 'logged_in' in session and session.get('ID')== int(ID):
    try:
        id_pedido = request.args.get('id_pedido')

        url = "https://cesarj.pythonanywhere.com/pedido_cliente?ID=" + ID + "&id_pedido=" + id_pedido
        response = requests.get(url)
        nombres = []
        precios = []
        cantidades = []
        estatus = []
        if response.status_code == 200:
            message = response.json()
            for dat in message:
                pedidos = dat[4].split('|')
                estatus.append(dat[5])
            for pedido in pedidos:
                datos = pedido.split(',')
                nombres.append(datos[0])
                precios.append(datos[1])
                cantidades.append(datos[2])

            df = pd.DataFrame({'playera': nombres, 'precio': precios, 'cantidad': cantidades})
            return render_template("Pedido.html", tabla=df, estatus=estatus,ID=ID)

        else:
            estatus=None
            return render_template("Pedido.html",estatus=estatus,ID=ID)
    except Exception as e:
        estatus=None
        return render_template("Pedido.html",estatus=estatus,ID=ID)
 else:
     estatus=None
     return render_template("Pedido.html",estatus=estatus,ID=ID)



@app.route("/Tabla-Pedidos")
def TablaPedidos():
  if 'logged_in' in session and session.get('user_type') == 'empleado':
    url="https://cesarj.pythonanywhere.com/pedidos"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            usuario = [row[0] for row in message]
            domicilio = [row[1] for row in message]
            postal = [row[2] for row in message]
            total = [row[3] for row in message]
            pedido = [row[4] for row in message]
            estatus = [row[5] for row in message]
            ID = [row[6] for row in message]
            email = [row[7] for row in message]
            df = pd.DataFrame({'usuario': usuario,'domicilio':domicilio,'postal':postal,
                   'total':total,'pedido':pedido,'estatus':estatus,'ID':ID,'email':email})
            df_pendiente = df[df['estatus'] == 'PENDIENTE']
            df_enviado = df[df['estatus'] == 'ENVIADO']
            df_complet = df[df['estatus'] == 'COMPLETADO']
            df_final = pd.concat([df_pendiente, df_enviado,df_complet], ignore_index=True)
            return render_template("TablaPedidos.html",tabla=df_final)
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})
  else:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})


@app.route("/actualizar-pedido", methods=['POST'])
def UpdatePedido():
    id_pedido = request.form.get('ID')
    status = request.form.get('status')

    if status=='ENVIADO':
        email = request.form.get('email')
        codigo = request.form.get('codigo')
        fecha_hoy = date.today()
        pdf_file_name = "pedido.pdf"
        fecha_llegada = "24 de abril de 2024"
        c = canvas.Canvas(pdf_file_name, pagesize=letter)
        barra_x = 50
        barra_y = 690
        barra_ancho = 500
        barra_alto = 1600
        titulo = "Información del Pedido"
        c.setFillColorRGB(0.2, 0.4, 0.6)
        c.rect(barra_x, barra_y, barra_ancho, barra_alto, fill=1)
        c.setFillColorRGB(1, 1, 1)  # Color del texto (blanco)
        c.setFont("Helvetica-Bold", 16)  # Fuente y tamaño del texto
        c.drawString(barra_x + 10, barra_y + 20, titulo)  # Posicionar y agregar el título
        c.drawImage("/home/oscar4323/mysite/shiva.png", 350, 695, width=90, height=90)
        info_pedido = f"Código del pedido: {codigo}"
        c.setFont("Helvetica", 12)  # Cambiar a una fuente más pequeña
        c.setFillColorRGB(0, 0, 0)  # Color de la barra (en este caso, negro)
        c.drawString(100, 600, info_pedido)  # Posicionar y agregar la información del pedido
        c.setFont("Helvetica", 12)
        c.setFillColorRGB(0, 0, 0)
        c.drawString(100, 580, f"Tu pedido fue enviado el día {fecha_hoy}")
        c.setFont("Helvetica", 12)
        c.setFillColorRGB(0, 0, 0)
        c.drawString(100, 560, f"Llegada aproximada de tu pedido {fecha_llegada}")
        c.save()
        EnviarPDF(pdf_file_name,email)

    url=f"https://cesarj.pythonanywhere.com/actualizar-pedido?ID={id_pedido}&status={status}"
    try:
        response = requests.get(url)
        if response.status_code == 200:
                message = response.json()
                return jsonify({'response': True})
        else:
                return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
            return jsonify({'error': 'Error de conexión: {}'.format(e)})




def EnviarPDF(filename,email):
    smtp_host = 'smtp.gmail.com'
    smtp_port = 465
    email_usuario = ''
    email_password = ''
    remitente = ''
    subject = ''
    body = ''
    msg = MIMEMultipart()
    msg['From'] = remitente
    msg['To'] = email
    msg['Subject'] = subject

    # Agregar el cuerpo del mensaje
    msg.attach(MIMEText(body, 'plain'))

    attachment = open(filename, 'rb')

    part = MIMEBase('application', 'octet-stream')
    part.set_payload((attachment).read())
    encoders.encode_base64(part)
    part.add_header('Content-Disposition', "attachment; filename= " + filename)

    msg.attach(part)
    server = smtplib.SMTP_SSL(smtp_host, smtp_port)
    server.login(email_usuario, email_password)
    server.sendmail(remitente, email, msg.as_string())
    server.quit()



@app.route("/Tabla-Status")
def TablaStatus():
    status = request.args.get('status')
    url="https://cesarj.pythonanywhere.com/pedidos"
    try:
        response = requests.get(url)
        if response.status_code == 200:
            message = response.json()
            usuario = [row[0] for row in message]
            domicilio = [row[1] for row in message]
            postal = [row[2] for row in message]
            total = [row[3] for row in message]
            pedido = [row[4] for row in message]
            estatus = [row[5] for row in message]
            ID = [row[6] for row in message]
            email = [row[7] for row in message]
            df = pd.DataFrame({'usuario': usuario,'domicilio':domicilio,'postal':postal,
                   'total':total,'pedido':pedido,'estatus':estatus,'ID':ID,'email':email})
            df_enviado = df[df['estatus'] == status]
            df_final = pd.concat([df_enviado], ignore_index=True)
            return render_template("TablaPedidos.html",tabla=df_final)
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})

@app.route("/Ingresar_playeras")
def Ingresar_playeras():
  if 'logged_in' in session and session.get('user_type') == 'empleado':
    return render_template("Playeras_E.html")
  else:
      return jsonify({'error': 'Error de conexión: {}'.format(e)})









