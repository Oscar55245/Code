import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:flutter/material.dart';
import 'home.dart';
import 'IdGoblal.dart';
void main() {
  runApp(MyApp());
}
class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        backgroundColor:  Color.fromARGB(255, 63, 63, 63),

        body: MyForm(),
      ),
    );
  }
}
class MyForm extends StatefulWidget {
  @override
  _MyFormState createState() => _MyFormState();
}
void showDial(BuildContext context, String mensaje){
         showDialog(
                    context: context,
                    builder: (BuildContext context) {
                      return AlertDialog(
                        title: Text('Datos',style: TextStyle(
      color: Colors.white, // Cambia el color del texto a blanco
           ),),
                        content: Column(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            ListTile(
                              title: Text('$mensaje'),
                            ),
                          ],
                        ),
                        actions: [
                          ElevatedButton(
                            onPressed: () {
                              Navigator.of(context).pop();
                            },
                            child: Text('Cerrar'),
                          ),
                        ],
                      );
                    },
                  );
  }

class _MyFormState extends State<MyForm> {
  List<Map<String, String>> datos = [];
  String usuario = '';
  String password = '';
  @override
  Widget build(BuildContext context) {
    Future<bool?> fetchData(String nombre,String password) async {
    final response = await http.get(Uri.parse('https://cesarj.pythonanywhere.com/obtener_datos?nombre=$nombre&password=$password'));
    print(response);
    if (response.statusCode==200) {
      final jsonResponse=json.decode(response.body);
      final data=json.decode(response.body);
      bool datos=data['datos'];
      int idUser=jsonResponse['ID'];
      GlobalVariables.id =idUser;
      print(idUser);
      return datos;
    } else {
      throw Exception('Error al cargar datos desde el servidor');
    }
  }
return Center(
  child: Column(
    children: [
      SizedBox(height: 100),
      Align(
        alignment: Alignment.center,
        child: ClipOval(
          child: Container(
            width: 100,
            height: 100,
            color: Colors.transparent,
            child: Image.network(
              'https://oscarestudiante2211.pythonanywhere.com/shiva.PNG',
              fit: BoxFit.cover,
            ),
          ),
        ),
      ),
      SizedBox(height: 100),
        Align(
          alignment: Alignment.center,
          
          child: Container(
            width: 200,
            child: TextField(
              decoration: InputDecoration(
                labelText: 'Usuario',
                hintText: 'Ingrese su Usuario',
                hintStyle: TextStyle(color: Colors.white), 
                labelStyle: TextStyle(color: Colors.white),
              ),
              onChanged: (value) {
                setState(() {
                  usuario = value;
                });
              },
              style: TextStyle(
                fontSize: 18, // Tamaño de fuente deseado
                fontWeight: FontWeight.bold, // Grosor de fuente deseado
                color: Color.fromARGB(255, 236, 236, 238),
               ),
            ),
          ),
        ),SizedBox(height: 50),
        Align(
          alignment: Alignment.center,
          child: Container(
            width: 200, // Establece el ancho deseado
            child: TextField(
              obscureText: true,
              decoration: InputDecoration(
                labelText: 'Password',
                hintText: 'Ingrese su Password',
                hintStyle: TextStyle(color: Colors.white), // Cambia el color del texto del hint (opcional)
                labelStyle: TextStyle(color: Colors.white),
                
              ),
              onChanged: (value) {
                setState(() {
                  password = value;
                });
              },
              style: TextStyle(
                fontSize: 18, // Tamaño de fuente deseado
                fontWeight: FontWeight.bold, // Grosor de fuente deseado
                color: Color.fromARGB(255, 246, 246, 248),
               ),
            ),
          ),
        ),SizedBox(height: 50),
        Align(
          alignment: Alignment.center,
          child: Container(
            width: 150,
            height: 50, // Establece el ancho deseado
            child: ElevatedButton.icon(
              onPressed: () async {
                try {
                  if ((await fetchData(usuario, password))==false) {
                            String mensaje=("Usuario no encontrado");
                            showDial(context,mensaje);
                            }else{
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => ImageList()),
                              );
                            }
                  setState(() {});
                } catch (error) {
                  print('Error en el botón: $error');
                }
              },
              icon: Icon(Icons.add), // Icono
              label: Text('Iniciar'),
              style: ButtonStyle(
                  backgroundColor: MaterialStateProperty.all<Color>(Color.fromARGB(255, 169, 155, 223)),
                  foregroundColor: MaterialStateProperty.all<Color>(Color.fromARGB(218, 12, 9, 12)),
                  elevation: MaterialStateProperty.all<double>(20.0),
                  
              ), 
            ),
          ),
        ),
      ],
    ),
  );
}

}
