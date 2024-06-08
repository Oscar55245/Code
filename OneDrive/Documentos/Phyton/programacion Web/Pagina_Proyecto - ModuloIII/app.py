##python -m flask run --reload
from flask import Flask,jsonify,redirect,url_for,render_template,session,send_from_directory
import requests
from flask import Response
import numpy as np
import cv2
from flask import current_app
from flask import Flask,request
import mysql.connector
import os
from flask_socketio import SocketIO, emit
from flask_caching import Cache
import distance_eucladiana
import Estadistica as stat
import pandas as pd
import mediapipe as mp
import Get_Puntos as getP
import BackCarrito as backCar
import time
import BackProduct 
import json
from flask import flash
from flask_mail import Mail, Message
video_active = True
conexion1=mysql.connector.connect(host="localhost",user="root",passwd="",database="playeras")
cursor1=conexion1.cursor()
numeroI=0
idActual=0
app=Flask(__name__)
app.secret_key='your_secret_key_here'
socketio=SocketIO(app)
cache = Cache(app, config={'CACHE_TYPE': 'simple'})
app.config['MAIL_SERVER'] = 'smtp.gmail.com'
app.config['MAIL_PORT'] = 465
app.config['MAIL_USE_SSL'] = True
app.config['MAIL_USERNAME'] = 'a12587@universidad-une.com'  # Tu dirección de Gmail
app.config['MAIL_PASSWORD'] = 'nwducguzwyznjhqb'  # Tu contraseña de Gmail
app.config['MAIL_DEFAULT_SENDER']= 'a12587@universidad-une.com'  

mail = Mail(app)
redireccionar=False
webCam=None



def get_database_connection():
    return mysql.connector.connect(host="localhost",user="root",passwd="",database="playeras")



@app.route("/")
def index ():
     
     return render_template("Login.html")

@app.route("/pedido")
def pedido ():
     estatus=None
     return render_template("Pedido.html",estatus=estatus)

@app.route("/carrito-points", methods=["POST"])
def actualizar_points():
    try:
        punto=request.form.get("puntos")
        punto=int(puntos) if puntos is not None and puntos.isdigit() else 0
        global idActual
        getP.actualizar_points(puntos, idActual)
        return jsonify({"success": True})
    except Exception as e:
        return jsonify({"error": str(e)}), 500
     

@app.route("/carrito")
@cache.cached(timeout=5) 
def carritoDeCompra ():
     global idActual
     print(idActual)
     lista = json.loads(request.args.get("lista"))
     puntos,nombre=getP.get_puntos(idActual)
     if lista is not None:
         precio=[]
         name=[]
         img=[]
         medida=[]
         for element in lista:
             print(element)
             sql="SELECT * FROM playeras WHERE Diseño='"+element['url']+"'"
             cursor1.execute(sql)
             data = cursor1.fetchall()
             for dat in data :
                 name.append(dat[1])
                 precio.append(dat[7])
                 img.append(dat[5])
                 medida.append(element['medida'])
         df = pd.DataFrame({'nombre': name,'precio':precio,'img':img,'medida':medida})
         print(df)
     else:
        lista = []
        df = pd.DataFrame({'nombre': [], 'precio': [], 'img': []})
     return render_template("CarritoCompra.html",tabla=df,puntos=puntos,nombre=nombre)


@app.route('/adminI',methods=["GET"])
def admin():
    nombre=request.args.get("name")
    email=request.args.get("email")
    usuario=request.args.get("usuario")
    password=request.args.get("password")
    puesto=request.args.get("puesto")
    print(nombre,email,usuario,puesto,password)
    insertar(nombre=nombre,email=email,usuario=usuario,puesto=puesto,password=password)
    return render_template('Admin.html')


@app.route('/buscar',methods=["GET"])
def buscar():
   global idActual
   nombre=request.args.get("usuario")
   password=request.args.get("password")
   print(nombre,password)
   sql="SELECT * FROM usuarios WHERE User='"+nombre+"' AND Password='"+password+"'"
   cursor1.execute(sql)
   data = cursor1.fetchall()
   for dat in data :
        puntos=dat[3]
        name=dat[4]
   if len(data)==0:
         sql="SELECT * FROM empleados WHERE usuario='"+nombre+"' AND password='"+password+"'"
         cursor1.execute(sql)
         data = cursor1.fetchall()
         for dat in data :
             valor=dat[4]
         if len(data)==0:
             return render_template("Login.html")
         else:
             return redirect(url_for('empleado'))
   else:
        for dat in data : 
            session['ID_cliente'] = dat[0]
        id_cliente = session['ID_cliente']
        idActual=id_cliente
        print(idActual)
        print(id_cliente)
        listImages=[]
        listImages=distance_eucladiana.DevolverRecomendacion(id_cliente)
        if not listImages:
             listImages=['img10.jpg','img12.jpg','img13.jpg','img14.jpg','img15.jpg']
        return render_template("camara.html", imagen_urls=listImages,puntos=puntos,nombre=name)



@app.route("/actualizar-pedido", methods=['POST'])
def UpdatePedido():
    id_pedido = request.form.get('ID')
    name = request.form.get('name')
    email = request.form.get('email')
    codigo = request.form.get('codigo')
    print(id_pedido, name, email, codigo)

    update_query = "UPDATE pedidos SET estatus = 'ENVIADO' WHERE ID = %s"
    values = (id_pedido,)
    cursor1.execute(update_query, values)
    
    cursor1.execute("SELECT Usuario,Domicilio,Postal,Total,pedido,email,estatus,ID FROM pedidos")
    pedido = cursor1.fetchall()
    conexion1.commit()

    column_names = ['usuario', 'domicilio', 'postal', 'total', 'pedido', 'email', 'estatus', 'ID']
    df = pd.DataFrame(pedido, columns=column_names)
    df_pendiente = df[df['estatus'] == 'PENDIENTE']
    df_enviado = df[df['estatus'] == 'ENVIADO']
    df_complet = df[df['estatus'] == 'COMPLETADO']
    df_final = pd.concat([df_pendiente, df_enviado,df_complet], ignore_index=True)

    return jsonify(df_final.to_dict(orient="records"))




###obtener imagenes
@app.route('/static/images/<path:image_name>')
def send_image(image_name):
    return send_from_directory('static/img', image_name)


@app.route("/producto")
def producto ():
     imagen_url = request.args.get("imagen")
     data=BackProduct.Producto(imagen_url)
     valor=None
     precio=None
     for dat in data : 
                    valor=dat[1]
                    precio=dat[7]
     return jsonify({'valor': valor,'precio':precio})



@app.route("/pedido_cliente")
def pedido_cliente():
    try:
        global idActual
        print(idActual)
        id_pedido = request.args.get('ID')
        cursor1.execute("SELECT ID_user, Domicilio, Postal, Total, pedido, estatus, ID FROM pedidos WHERE ID = %s AND ID_user = %s ", (id_pedido,idActual))
        pedido = cursor1.fetchall()
        conexion1.commit()
        nombres = []
        precios = []
        cantidades = []
        estatus = []
        for dat in pedido:
            
            pedidos = dat[4].split('|')
            estatus.append(dat[5])
            for pedido in pedidos:
                datos = pedido.split(',')
                nombres.append(datos[0])
                precios.append(datos[1])
                cantidades.append(datos[2])
                
        df = pd.DataFrame({'playera': nombres, 'precio': precios, 'cantidad': cantidades})
        return render_template("Pedido.html", tabla=df, estatus=estatus)

    except Exception as e:
        print("Error:", e)
        return render_template("Pedido.html", tabla=pd.DataFrame(),estatus=None)




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

@app.route("/like-shirt")
def like_shirt ():
    global idActual
    imagen_url = request.args.get("imagen")
    nueva_cadena = imagen_url.replace("https://oscarestudiante2211.pythonanywhere.com//", "")
    nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/deportiva", "")
    nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/casual", "")
    try:
         conexion1 = get_database_connection()
         cursor1 = conexion1.cursor()
         sql="insert into historialproductosfavoritos(IDUsuario,producto) values (%s,%s)"
         datos=(idActual, nueva_cadena)
         cursor1.execute(sql,datos)
         conexion1.commit()
         print('id ACTUAL',idActual,nueva_cadena)
         return jsonify({'valor': idActual,'precio':nueva_cadena})
    except Exception as e:
        # Manejar la excepción
        print("Error:", e)
        return jsonify({'error': 'Ocurrió un error al procesar la solicitud'}), 500


@app.route("/Unlike-shirt")
def Unlike():
    global idActual
    imagen_url = request.args.get("imagen")
    nueva_cadena = imagen_url.replace("https://oscarestudiante2211.pythonanywhere.com/casual", "")
    nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com//", "")
    nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/deportiva", "")
    print(nueva_cadena)
    try:
         conexion1 = get_database_connection()
         cursor1 = conexion1.cursor()
         sql="DELETE FROM historialproductosfavoritos WHERE IDUsuario='"+str(idActual)+"' AND producto='"+nueva_cadena+"'"
         cursor1.execute(sql)
         conexion1.commit()
         print('id ACTUAL',idActual,nueva_cadena)
         return jsonify({'valor': idActual,'precio':nueva_cadena})
    except Exception as e:
        # Manejar la excepción
        print("Error:", e)
        return jsonify({'error': 'Ocurrió un error al procesar la solicitud'}), 500

@app.route("/like-shirt-page")
def like_page():
    global idActual
    print(idActual)
    imageNames=[]
    try:
         conexion1 = get_database_connection()
         cursor1 = conexion1.cursor()
         cursor1.execute("SELECT producto FROM historialproductosfavoritos WHERE IDUsuario="+str(idActual))
         likeshirt= cursor1.fetchall()
         conexion1.commit()
         for lik in likeshirt:
              imageNames.append(lik)
         return render_template("camara.html",imagen_urls=imageNames)
    except Exception as e:
        print("Error:", e)
        return jsonify({'error': 'Ocurrió un error al procesar la solicitud'}), 500

@app.route("/Searchlike-shirt")
def Searchlike():
    global idActual
    try:
        conexion1 = get_database_connection()
        cursor1 = conexion1.cursor()
        imagen_url = request.args.get("imagen")
        nueva_cadena = imagen_url.replace("https://oscarestudiante2211.pythonanywhere.com//", "")
        nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/deportiva", "")
        nueva_cadena = nueva_cadena.replace("https://oscarestudiante2211.pythonanywhere.com/casual", "")
        print(nueva_cadena)
        
        sql = "SELECT producto FROM historialproductosfavoritos WHERE IDUsuario=%s AND producto=%s"
        cursor1.execute(sql, (str(idActual), nueva_cadena))
        
        resultado = cursor1.fetchone()
        conexion1.commit()
        
        like = False
        if resultado:
            print("La consulta encontró resultados")
            like = True
        else:
            print("La consulta no encontró resultados")
            like = False

        return jsonify({'valor': like})
    
    except Exception as e:
        # Manejar la excepción
        print("Error:", e)
        return jsonify({'error': 'Ocurrió un error al procesar la solicitud'}), 500



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
    print(medida)
    cantidades = form_dict.get('cantidades', [])
    df = pd.DataFrame({'Playera': nombres,'Medida':medida,'Precio':precios,'Cantidad':cantidades})
    df.loc[len(df)] = ['Total', '', total, '']  # Agregar una fila 'Total' al DataFrame
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
            return render_template("CarritoCompra.html", ID=ID)
        else:
            return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
    except requests.exceptions.RequestException as e:
        return jsonify({'error': 'Error de conexión: {}'.format(e)})



def insertar(nombre, email, usuario,puesto, password):
 sql="insert into empleados(nombre,email,usuario,puesto,password) values (%s,%s,%s,%s,%s)"
 datos=(nombre, email, usuario,puesto, password)
 cursor1.execute(sql,datos)
 conexion1.commit()


##### Insertar playeras detectadas
def insertDetection(ID_cliente, playera):
  print("playera",playera)
  playera=""+playera
  sql="insert into detectada(ID_Cliente,Playera) values (%s,%s)"
  datos=(ID_cliente, playera)
  cursor1.execute(sql,datos)
  conexion1.commit()


@app.route("/camara")
@cache.cached(timeout=5) 
def camara():
    global idActual
    puntos,nombre=getP.get_puntos(idActual)
    print("Puntos y id acutal",idActual, puntos,nombre)
    imageNames=['img10.jpg','img12.jpg','img13.jpg','img14.jpg','img15.jpg']
    return render_template("camara.html", imagen_urls=imageNames,puntos=puntos,nombre=nombre)

@app.route("/Admin")
def Admin ():
     return render_template("Admin.html")


@app.route('/puntos_playeraEspecial')
def puntosEspecial():
    global idActual
    puntos(idActual,5)
    return redirect(url_for('camara'))


def insertarPlayera(nameDiseño, materiales, diseñador,localidad,url, precio):
    sql="insert into playeras(Diseño,Materiales,Diseñador,Localidad,URL,precio,estatus) values (%s,%s,%s,%s,%s,%s,%s)"
    datos=(nameDiseño, materiales, diseñador,localidad,url, precio,"DISPONIBLE")
    cursor1.execute(sql,datos)
    conexion1.commit()




@app.route("/empleado")
def empleado ():
     sql="SELECT * FROM compra"
     cursor1.execute(sql)
     data = cursor1.fetchall()
     playera=[]
     numero=[]
     listName=[]
     for dat in data :
             playera.append(dat[2])
             numero.append(dat[3])
             
     file_path,lista_playera, lista_numero = stat.generate_statistics(playera,numero)
     for num in lista_playera:
        url2 = "https://cesarj.pythonanywhere.com/info?ID=" + str(num)
        try:
            response = requests.get(url2)
            if response.status_code == 200:
                message = response.json()
                listName.append(message.get('valor'))
                print(listName)
            else:
                return jsonify({'error': 'La solicitud no fue exitosa. Código de estado: {}'.format(response.status_code)})
        except requests.exceptions.RequestException as e:
                        print("Error en la solicitud:", e)
     return render_template("Empleados.html", file_path=file_path)


@app.route("/login")
def login ():
     return render_template("login2.html")

@app.route("/Ingresar_playeras")
def Ingresar_Playeras ():
     return render_template("Playeras_E.html")


@app.route('/subir_imagen', methods=['POST'])
def subir_imagen():
    try:
        corte = request.form['corte']
        diseño = request.form['diseño']
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
                distance_eucladiana.InsertarNuevasCaracteristicas(nombre_imagen,diseño,material,tipo,corte)
                try:
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





@app.route("/Tabla")
def Tabla():
    cursor1.execute("SELECT id,nombre,email,usuario,puesto FROM empleados")
    empleados = cursor1.fetchall()
    print(empleados)
    return render_template("empleadosTabla.html", empleados=empleados)



@app.route("/Tabla-Pedidos")
def TablaPedidos():
    cursor1.execute("SELECT ID_user,Domicilio,Postal,Total,pedido,email,estatus,ID FROM pedidos")
    pedido= cursor1.fetchall()
    conexion1.commit()
    print(pedido)
    usuario=[]
    domicilio=[]
    postal=[]
    total=[]
    ped=[]
    estatus=[]
    email=[]
    ID=[]
    for dat in pedido :
                 usuario.append(dat[0])
                 domicilio.append(dat[1])
                 postal.append(dat[2])
                 total.append(dat[3])
                 ped.append(dat[4])
                 email.append(dat[5])
                 estatus.append(dat[6])
                 ID.append(dat[7])
    df = pd.DataFrame({'usuario': usuario,'domicilio':domicilio,'postal':postal,
                       'total':total,'pedido':ped,'email':email,'estatus':estatus,'ID':ID})
    df_pendiente = df[df['estatus'] == 'PENDIENTE']
    df_enviado = df[df['estatus'] == 'ENVIADO']
    df_complet = df[df['estatus'] == 'COMPLETADO']
    df_final = pd.concat([df_pendiente, df_enviado,df_complet], ignore_index=True)
    return render_template("TablaPedidos.html",tabla=df_final)


@app.route("/buscar-pedido", methods=['GET'])
def BuscarPedido():
    
    try:
         id_pedido = request.args.get('ID')
         print(id_pedido)
         cursor1.execute("SELECT ID_user,Domicilio,Postal,Total,pedido,email,estatus,ID FROM pedidos WHERE ID="+str(id_pedido))
         pedido= cursor1.fetchall()
         conexion1.commit()
         usuario=[]
         domicilio=[]
         postal=[]
         total=[]
         ped=[]
         estatus=[]
         email=[]
         ID=[]
         for dat in pedido :
                 usuario.append(dat[0])
                 domicilio.append(dat[1])
                 postal.append(dat[2])
                 total.append(dat[3])
                 ped.append(dat[4])
                 email.append(dat[5])
                 estatus.append(dat[6])
                 ID.append(dat[6])
         df = pd.DataFrame({'usuario': usuario,'domicilio':domicilio,'postal':postal,
                       'total':total,'pedido':ped,'estatus':estatus,'ID':ID})
         return render_template("TablaPedidos.html",tabla=df)
    except Exception as e:
         usuario=[]
         domicilio=[]
         postal=[]
         total=[]
         ped=[]
         estatus=[]
         ID=[]
         df = pd.DataFrame({'usuario': usuario,'domicilio':domicilio,'postal':postal,
                       'total':total,'pedido':ped,'estatus':estatus,'ID':ID})
         return render_template("TablaPedidos.html",tabla=df)




@app.route("/Tabla-Playeras")
def TablaPlayeras():
    
    df =getTablaPlayeras()
    print(df)
    return render_template("TablaPlayeras.html",tabla=df)


@app.route("/actualizar-status", methods=['POST'])
def UpdateStatus():
    status = request.form.get('status') 
    dise = request.form.get('dise')
    print(status,dise)
    update_query = "UPDATE playerasd SET estatus = %s WHERE Diseño = %s"
    values = (status, dise)
    cursor1.execute(update_query, values)
    conexion1.commit()
    df=getTablaPlayeras()
    print(df)
    return render_template("TablaPlayeras.html",tabla=df)




def getTablaPlayeras():
    cursor1.execute("SELECT Diseño,URL,Precio,estatus FROM playerasd")
    pedido= cursor1.fetchall()
    conexion1.commit()
    print(pedido)
    dise=[]
    precio=[]
    url=[]
    status=[]
    for dat in pedido :
                 dise.append(dat[0])
                 url.append(dat[1])
                 precio.append(dat[2])
                 status.append(dat[3])
    df = pd.DataFrame({'dise': dise,'precio':precio,'url':url,'status':status})             
    return df
     

@app.route("/socket.io/")
def socketio_endpoint():
    return ""


def background_task():
    while True:
        socketio.sleep(0.1)  
        valor,material,diseñador,promocion,imagenes,firtDetection,locacion = get_valor()
        socketio.emit('update_valor', {'valor': valor,'material':material,'diseñador':diseñador,'promocion':promocion,'imagenes':imagenes,'locacion':locacion,'firtDetection':firtDetection}, namespace='/')


@app.route("/mostrar_valor")
def mostrar_valor():
    return render_template("camara.html")

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

    cursor1.execute("SELECT * FROM usuarios WHERE User = %s OR correo = %s", (usuario, correo))
    usuario_existente = cursor1.fetchone()

    if usuario_existente:
        error=True
        return render_template("Registro.html",usuario_existente=error)

    sql="insert into usuarios(User,Password,nombre,correo) values (%s,%s,%s,%s)"
    datos=(usuario,password, nombre, correo)
    cursor1.execute(sql,datos)
    conexion1.commit()
    error=False
    return render_template("Registro.html",usuario_existente=error)


def puntos(index,puntos):
    valor=0
    cursor1.execute("SELECT * FROM  usuarios WHERE ID="+str(index))
    playeraDetectada = cursor1.fetchall()
    conexion1.commit()
    print(playeraDetectada,str(index))
    for dat in playeraDetectada :
         valor=dat[3]
    print(valor)
    puntos=valor+puntos
    update_query = "UPDATE usuarios SET Points = %s WHERE ID = %s"
    values = (puntos, index)
    cursor1.execute(update_query, values)
    conexion1.commit()


def get_valor():
    global valor
    global material
    global diseñador
    global promocion
    global imagenes
    global firtDetection
    global locacion
    return (valor,material,diseñador,promocion,imagenes,firtDetection,locacion)




if __name__ == '__main__':
    # Cambia el host y el puerto para que tu aplicación sea accesible desde cualquier dispositivo en la red
    app.run(host='192.168.100.13', port=443, debug=True)

