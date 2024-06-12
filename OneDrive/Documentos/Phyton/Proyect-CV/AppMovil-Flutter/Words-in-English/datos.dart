import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'Variables.dart';

class DatosPage extends StatefulWidget {
  @override
  _DatosPageState createState() => _DatosPageState();
}

class _DatosPageState extends State<DatosPage> {
  Map<String, dynamic> data = {};

  @override
  void initState() {
    super.initState();
    fetchData(GlobalVariables.id);
  }

  Future<void> fetchData(int id) async {
    try {
      final response =
          await http.get(Uri.parse('http://000.000.000.00/usuario_datos?id=$id'));

      if (response.statusCode == 200) {
        setState(() {
          data = json.decode(response.body);
        });
        print(data);
      } else {
        throw Exception('Error al cargar datos desde el servidor');
      }
    } catch (error) {
      print('Error: $error');
    }
  }

  @override
  Widget build(BuildContext context) {
    var theme = Theme.of(context);

    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          if (data != null)
            ...[
               CircleAvatar(
            backgroundImage: NetworkImage('http://000.000.000.00/static/images/'+GlobalVariables.id.toString()+''+GlobalVariables.nombre+'.jpg'),
            radius: 50,
          ),
          SizedBox(height: 50),
              Text("Usuario:  ${data!['name'] ?? 'No disponible'}"),
              SizedBox(height: 50),
              Text("Nombre: ${data!['user'] ?? 'No disponible'}"),
              SizedBox(height: 50),
              Text("Correo: ${data!['email'] ?? 'No disponible'}"),
            ]
          else
            Text("No hay datos"),
        ],

      ),
    );
  }
}
