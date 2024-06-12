from flask import Flask, render_template
import mysql.connector

app = Flask(__name__)

@app.route("/")
def index():
    db = mysql.connector.connect(
        host="localhost",
        user="root",
        password="",
        database="playeras"
    )
    cursor = db.cursor()
    cursor.execute("SELECT id,nombre,email,usuario,puesto FROM empleados")
    empleados = cursor.fetchall()
    print(empleados)
    db.close()
    return render_template("TablaEmpleado.html", empleados=empleados)

if __name__=='__main__':
    app.run()