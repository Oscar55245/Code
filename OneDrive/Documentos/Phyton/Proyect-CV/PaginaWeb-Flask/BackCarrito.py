import mysql.connector


def insert_car(usuario, domicilio, postal,total, pedido):
    try:
        conexion1=mysql.connector.connect(host="localhost",user="root",passwd="",database="playeras")
        cursor1=conexion1.cursor()
        print(usuario, domicilio, postal,total, pedido)
        sql="insert into pedidos(Usuario,Domicilio,Postal,Total,pedido,estatus) values (%s,%s,%s,%s,%s,%s)"
        datos=(usuario, domicilio, postal,total, pedido,"PENDIENTE")
        cursor1.execute(sql,datos)
        conexion1.commit()
        # Resto de tu código para insertar en la base de datos...
    except Exception as e:
        print(f"Error en insert_car: {e}")
 

