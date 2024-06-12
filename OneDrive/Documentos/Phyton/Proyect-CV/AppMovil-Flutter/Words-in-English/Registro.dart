import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:flutter/material.dart';
import 'main.dart';
import 'dart:async';
import 'package:camera/camera.dart';

class RegistroApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        backgroundColor: Color.fromARGB(255, 63, 63, 63),
        appBar: AppBar(
          title: Text(
            'Words',
            style: TextStyle(
              color: Colors.white,
            ),
          ),
          backgroundColor: Color.fromARGB(255, 63, 63, 63),
          actions: [
            IconButton(
              icon: Icon(Icons.exit_to_app),
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => MyApp()),
                );
              },
            ),
          ],
        ),
        body: MyForm(),
      ),
    );
  }
}

class MyForm extends StatefulWidget {
  @override
  _MyFormState createState() => _MyFormState();
}

void showDial(BuildContext context, String mensaje) {
  showDialog(
    context: context,
    builder: (BuildContext context) {
      return AlertDialog(
        title: Text(
          'Datos',
          style: TextStyle(
            color: Colors.white,
          ),
        ),
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
  final _formKey = GlobalKey<FormState>();

  List<Map<String, String>> datos = [];
  String nombre = '';
  String user = '';
  String email = '';
  String password = '';
  TextEditingController nombreController = TextEditingController();
  TextEditingController userController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  Future<bool?> fetchData(String nombre, String user, String email, String password) async {
    final response = await http.get(Uri.parse(
        'http://000.000.000.00/registrar_usuario?nombre=$nombre&user=$user&email=$email&password=$password'));
    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      bool datos = data['success'];
      return datos;
    } else {
      throw Exception('Error al cargar datos desde el servidor');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: SingleChildScrollView(
        child: Form(
          key: _formKey,
          autovalidateMode: AutovalidateMode.onUserInteraction,
          child: Column(
            children: [
              SizedBox(height: 100),
              Align(
                alignment: Alignment.center,
                child: Container(
                  width: 200,
                  child: TextFormField(
                    controller: nombreController,
                    decoration: InputDecoration(
                      labelText: 'Nombre',
                      hintText: 'Ingrese su nombre',
                      hintStyle: TextStyle(color: Colors.white),
                      labelStyle: TextStyle(color: Colors.white),
                    ),
                    onChanged: (value) {
                      setState(() {
                        nombre = value;
                      });
                    },
                    style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.bold,
                      color: Color.fromARGB(255, 236, 236, 238),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Por favor, ingrese un nombre.';
                      } else if (value.length < 6) {
                        return 'El nombre debe tener al menos 6 caracteres.';
                      } else if (!RegExp(r'^[a-zA-Z]+$').hasMatch(value)) {
                        return 'Solo se permiten letras en el nombre.';
                      }
                      return null;
                    },
                  ),
                ),
              ),
              SizedBox(height: 20),
              Align(
                alignment: Alignment.center,
                child:Container(
                width: 200,
                child: TextFormField(
                  controller: userController,
                  decoration: InputDecoration(
                    labelText: 'Usuario',
                    hintText: 'Ingrese su Usuario',
                    hintStyle: TextStyle(color: Colors.white),
                    labelStyle: TextStyle(color: Colors.white),
                  ),
                  onChanged: (value) {
                    setState(() {
                      user = value;
                    });
                  },
                  style: TextStyle(
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                    color: Color.fromARGB(255, 236, 236, 238),
                  ),
                  validator: (value) {
  if (value == null || value.isEmpty) {
    return 'Por favor, ingrese un usuario.';
  } else if (value.length < 7 || value.length > 15) {
    return 'El usuario debe tener entre 7 y 15 caracteres.';
  } 
  return null;
},

                ),
              ),
              ),
              SizedBox(height: 20),
              Align(
  alignment: Alignment.center,
  child: Container(
    width: 200,
    child: TextFormField(
      controller: emailController,
      decoration: InputDecoration(
        labelText: 'Email',
        hintText: 'Ingrese su email',
        hintStyle: TextStyle(color: Colors.white),
        labelStyle: TextStyle(color: Colors.white),
      ),
      onChanged: (value) {
        setState(() {
          email = value;
        });
      },
      style: TextStyle(
        fontSize: 18,
        fontWeight: FontWeight.bold,
        color: Color.fromARGB(255, 236, 236, 238),
      ),
      validator: (value) {
        if (value == null || value.isEmpty) {
          return 'Por favor, ingrese un email válido.';
        }
        return null;
      },
    ),
  ),
),

SizedBox(height: 20),

Align(
  alignment: Alignment.center,
  child: Container(
    width: 200,
    child: TextFormField(
      obscureText: true,
      controller: passwordController,
      decoration: InputDecoration(
        labelText: 'Password',
        hintText: 'Ingrese su Password',
        hintStyle: TextStyle(color: Colors.white),
        labelStyle: TextStyle(color: Colors.white),
      ),
      onChanged: (value) {
        setState(() {
          password = value;
        });
      },
      style: TextStyle(
        fontSize: 18,
        fontWeight: FontWeight.bold,
        color: Color.fromARGB(255, 246, 246, 248),
      ),
      validator: (value) {
        // Aquí puedes agregar la validación necesaria para el campo de password
        if (value == null || value.isEmpty) {
          return 'Por favor, ingrese una contraseña válida.';
        }
        return null;
      },
    ),
  ),
),
              SizedBox(height: 5),
              Align(
                alignment: Alignment.center,
                child: Container(
                  width: 250,
                  height: 100,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                    children: [
                      ElevatedButton.icon(
                        onPressed: () async {
                          if (_formKey.currentState?.validate() ?? false) {
                            try {
                              if (!(await fetchData(nombre, user, email, password))!) {
                                String mensaje = "Usuario no registrado";
                                showDial(context, mensaje);
                              } else {
                                String mensaje = "Usuario registrado con éxito!";
                                showDial(context, mensaje);
                                nombreController.clear();
                                userController.clear();
                                emailController.clear();
                                passwordController.clear();
                              }
                              setState(() {});
                            } catch (error) {
                              print('Error en el botón: $error');
                            }
                          }
                        },
                        icon: Icon(Icons.add),
                        label: Text('Registrar'),
                        style: ButtonStyle(
                          backgroundColor: MaterialStateProperty.all<Color>(Color.fromARGB(255, 49, 43, 73)),
                          foregroundColor: MaterialStateProperty.all<Color>(Color.fromARGB(218, 218, 92, 235)),
                          elevation: MaterialStateProperty.all<double>(20.0),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
