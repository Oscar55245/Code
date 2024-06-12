import mysql.connector


def Producto(imagen_url):
     try: 
          conexion1=mysql.connector.connect(host="localhost",user="root",passwd="",database="playeras")
          cursor1=conexion1.cursor()
          sql="SELECT * FROM playeras WHERE URL='"+imagen_url+"'"
          cursor1.execute(sql)
          data = cursor1.fetchall()
          cursor1.close()
          conexion1.commit()
          return data
     except Exception as e:
        print(f"Error en insert_car: {e}")