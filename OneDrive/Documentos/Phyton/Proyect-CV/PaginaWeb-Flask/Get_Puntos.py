import mysql.connector


def get_puntos(idActual):
    conexion1=mysql.connector.connect(host="localhost",user="root",passwd="",database="playeras")
    cursor1=conexion1.cursor()
    puntos=0
    nombre=""
    cursor1.execute("SELECT * FROM  usuarios WHERE ID="+str(idActual))
    puntosUser = cursor1.fetchall()
    for dat in puntosUser :
         puntos=dat[3]
         nombre=dat[4]
    conexion1.commit()
    return puntos,nombre

def actualizar_points(point,id):
    conexion1=mysql.connector.connect(host="localhost",user="root",passwd="",database="playeras")
    cursor1=conexion1.cursor()
    update_query = "UPDATE usuarios SET Points = %s WHERE ID = %s"
    values = (point, id)
    cursor1.execute(update_query, values)
    conexion1.commit()


