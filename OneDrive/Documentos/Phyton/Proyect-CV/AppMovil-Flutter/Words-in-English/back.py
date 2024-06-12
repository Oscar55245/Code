from flask import Flask, jsonify,request, send_from_directory
import mysql.connector

app = Flask(__name__)

conexion1 = mysql.connector.connect(
    host="localhost",
    user="root",
    passwd="",
    database="words"
)
cursor1 = conexion1.cursor()


@app.route('/tabla', methods=['GET'])
def tabla():
    sql = "SELECT * FROM usuario"
    cursor1.execute(sql)
    data = cursor1.fetchall()
    conexion1.commit()
    print(data)

    # Convierte la lista de tuplas a una lista de diccionarios
    column_names = [column[0] for column in cursor1.description]
    resultado = [dict(zip(column_names, row)) for row in data]

    # Convierte la lista de diccionarios a formato JSON
    return jsonify(resultado)

@app.route('/static/images/<path:image_name>')
def send_image(image_name):
    return send_from_directory('static/img', image_name)


@app.route('/obtener_datos', methods=['GET'])
def obtener_datos():
    access = False
    nombre = request.args.get("nombre")
    password = request.args.get("password")
    print(nombre, password)
    
    try:
        # Ejecutar la consulta con el cursor
        sql = "SELECT * FROM usuario WHERE User=%s AND Password=%s"
        cursor1.execute(sql, (nombre, password))
        
        # Obtener los resultados de la consulta
        data = cursor1.fetchall()
        print(data)

        id = 0
        nombre_usuario = ""
        
        for dat in data:
            id = dat[0]
            nombre_usuario = dat[2]

        if len(data) == 0:
            print("Usuario no encontrado")
        else:
            print("Usuario encontrado")
            access = True

    except mysql.connector.Error as err:
        print(f"Error de MySQL: {err}")
        # Manejar el error como mejor convenga a tu aplicación

    finally:
        # Asegurarse de cerrar el cursor y la conexión
        conexion1.commit()

    return jsonify({'datos': access, 'id': id, 'nombre': nombre_usuario})

    
@app.route('/usuario_datos', methods=['GET'])
def obtener_imagenes():
    id = request.args.get("id")
    sql="SELECT * FROM usuario WHERE ID='"+id+"'"
    cursor1.execute(sql)
    data = cursor1.fetchall()
    print(data)
    for dat in data :
        name=dat[1]
        user=dat[2]
        email=dat[3]
    if len(data)==0:
        print("Usuario no encontrado")
        return jsonify({' No encontrado'})
    else:
      print("Usuario encontrados")
      print(data)
      return jsonify({'name': name,'user': user,'email': email})

@app.route('/registrar_usuario', methods=['GET'])
def registrar():
   try:
        nombre = request.args.get("nombre")
        user = request.args.get("user")
        email = request.args.get("email")
        password = request.args.get("password")
        print(nombre,user,email,password)
        sql = "insert into usuario(User, Name, Email, Password) values (%s, %s, %s, %s)"
        datos = ( user,nombre, email, password)

        cursor1.execute(sql, datos)
        conexion1.commit()

        return jsonify({'mensaje': 'Datos insertados correctamente', 'success': True})
   except Exception as e:
        # Maneja la excepción y devuelve un mensaje de error
        return jsonify({'mensaje': f'Error al insertar datos: {str(e)}', 'success': False})
    

@app.route('/upload', methods=['POST'])
def upload_file():
    try:
        # Obtén el archivo de la solicitud multipart
        uploaded_file = request.files['image']
        uploaded_file.save('static/img/' + uploaded_file.filename)

        return 'Imagen subida exitosamente', 200
    except Exception as e:
        print(f'Error al subir la imagen: {e}')
        return 'Error al subir la imagen', 500
    

@app.route('/obtener_imagen', methods=['GET'])
def obtener():
    access=False
    file = request.args.get("file")
    print(file)
    sql="SELECT * FROM playeras WHERE URL='/static/"+file+"'"
    cursor1.execute(sql)
    data = cursor1.fetchall()
    conexion1.commit()
    conexion1.close()
    for dat in data :
        nombre=dat[1]
        precio=dat[7]
        diseñador=dat[3]
        material=dat[2]
    if len(data)==0:
        print("Usuario no encontrado")
        return jsonify({'nombre': access})
    else:
      print("Usuario encontrados")
      access=True
      print(data)
      return jsonify({'nombre': nombre,"precio":precio,"diseñador":diseñador,"material":material})
    

if __name__ == '__main__':
    # Cambia el host y el puerto para que tu aplicación sea accesible desde cualquier dispositivo en la red
    app.run(host='000.000.000.00', port=443, debug=True)
