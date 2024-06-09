import 'package:flutter/material.dart';
import 'Compras.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class ProductoWindow extends StatefulWidget {
  final String imageUrl;
  final String valor;
  final List<String> medida = ['CH', 'MD', 'GD'];

  ProductoWindow({
    required this.imageUrl,
    required this.valor,
  });

  @override
  _ProductoWindowState createState() => _ProductoWindowState();
}

class _ProductoWindowState extends State<ProductoWindow> {
  final List<CarritoCompra> objetos = [];
  List<Map<String, dynamic>> dataProduct = [];
  String? pressedButton;
  String? textom; // Variable para guardar el texto del botón presionado
  bool objetoExistente = false;

  @override
  void initState() {
    super.initState();
    _fetchData();
  }

  Future<void> _fetchData() async {
    dataProduct.clear();
    try {
      String textoConCaracteres = widget.imageUrl;
      String textoSinCaracteres =
          textoConCaracteres.replaceAll('https://oscarestudiante2211.pythonanywhere.com/', '');
      print(textoSinCaracteres);
      final url = Uri.parse('https://cesarj.pythonanywhere.com/producto-info?imagen=${textoSinCaracteres}');
      final response = await http.get(url);
      if (response.statusCode == 200) {
        final jsonMap = json.decode(response.body) as Map<String, dynamic>;
        setState(() {
          print(jsonMap);

          dataProduct.add({
            'material': jsonMap['material'],
            'nameD': jsonMap['nameD'],
            'precio': jsonMap['precio'],
            'valor': jsonMap['valor'],
          });
          print(dataProduct);
        });
      } else {
        print('Error en la solicitud: ${response.statusCode}');
      }
    } catch (e) {
      print('Error: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 12, 12, 14),
        title: Text('Producto'),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Center(
              child: Container(
                width: 200,
                height: 200,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(20),
                  boxShadow: [
                    BoxShadow(
                      color: Colors.grey.withOpacity(0.5),
                      spreadRadius: 5,
                      blurRadius: 7,
                      offset: Offset(0, 3),
                    ),
                  ],
                ),
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(20),
                  child: Image.network(
                    widget.imageUrl,
                    fit: BoxFit.cover,
                  ),
                ),
              ),
            ),
            SizedBox(height: 25.0),
            Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Text(
                    'Diseño: ${widget.valor}',
                    style: TextStyle(
                      fontSize: 18.0,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  SizedBox(height: 8.0),
                  Text(
                    'Precio: ${dataProduct.isEmpty ? 'Cargando...' : dataProduct.isNotEmpty ? dataProduct[0]['precio'] : 'No disponible'}',
                    style: TextStyle(
                      fontSize: 18.0,
                    ),
                  ),
                  SizedBox(height: 8.0),
                  Text(
                    'Diseñador: ${dataProduct.isEmpty ? 'Cargando...' : dataProduct.isNotEmpty ? dataProduct[0]['nameD'] : 'No disponible'}',
                    style: TextStyle(
                      fontSize: 18.0,
                    ),
                  ),
                  SizedBox(height: 8.0),
                  Text(
                    'Materiales: ${dataProduct.isEmpty ? 'Cargando...' : dataProduct.isNotEmpty ? dataProduct[0]['material'] : 'No disponible'}',
                    style: TextStyle(
                      fontSize: 18.0,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 25.0),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: widget.medida.map((medida) {
                bool isPressed = pressedButton == medida;
                return ElevatedButton(
                  onPressed: () {
                    print('Presionaste el botón con texto: $medida');
                    setState(() {
                        pressedButton = medida;
                        textom = medida;
                    });
                  },
                  style: ElevatedButton.styleFrom(
                    primary: isPressed ? Colors.grey.withOpacity(0.5) : Color.fromARGB(255, 12, 12, 14), // Cambia el color del botón según su estado
                  ),
                  child: Text(medida),
                );
              }).toList(),
            ),
            SizedBox(height: 8.0),
            Center(
              child: ElevatedButton(
                onPressed: () {
                      objetoExistente = DataStore().objetos.contains(CarritoCompra(
                        imagen: widget.imageUrl,
                        medida: textom!, // Utilizar el valor actual de medida
                        precio: dataProduct.isNotEmpty ? dataProduct[0]['precio']?.toString() ?? 'Precio no disponible' : 'Precio no disponible',
                      ));
                  if (!objetoExistente) { // ¡Aquí está el cambio!
                    DataStore().objetos.add(CarritoCompra(
                          imagen: widget.imageUrl,
                          medida: textom!, // Utilizar el valor actual de textom
                          precio: dataProduct.isNotEmpty ? dataProduct[0]['precio']?.toString() ?? 'Precio no disponible' : 'Precio no disponible',
                        ));
                        print(DataStore().objetos);
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(
                             content: Text('El producto se ha añadido al carrito con éxito.',
                             style: TextStyle(
                              fontSize: 16,
                              ),
                              ),
                             duration: Duration(seconds: 2),
                             backgroundColor: Colors.green, 
                             ),
                             );
                   }else{
                    ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(
                             content: Text('Producto en tu carrito.',
                             style: TextStyle(
                              fontSize: 16,
                              ),
                              ),
                             duration: Duration(seconds: 2),
                             backgroundColor: Color.fromARGB(255, 247, 60, 14), // Duración del mensaje
                             ),
                             );
                   }
                },
                style: ElevatedButton.styleFrom(
                  primary: Color.fromARGB(255, 12, 12, 14),
                ),
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Icon(Icons.add),
                    SizedBox(width: 8.0),
                    Text(
                      'Añadir al carrito',
                      style: TextStyle(
                        fontSize: 18.0,
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
