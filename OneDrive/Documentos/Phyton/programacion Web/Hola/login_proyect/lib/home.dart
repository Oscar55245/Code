import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'producto.dart';
import 'Compras.dart';
import 'carrito.dart';
import 'IdGoblal.dart';

class ImageList extends StatefulWidget {
  @override
  _ImageListState createState() => _ImageListState();
}

class _ImageListState extends State<ImageList> {
  List<Map<String, dynamic>> dataProduct = [];
  List<String> imageNames = [];


  @override
  void initState() {
    super.initState();
    _initializeImageNames();
    
    print(GlobalVariables.id);
    
  }
  Future<void> _initializeImageNames() async {
    try {
      // Llama a la función recomenda para obtener la lista de imágenes
      List<String> recomendaImages = await recomenda(GlobalVariables.id);
      setState(() {
        // Asigna la lista obtenida a imageNames
        imageNames = recomendaImages;
      });
      _fetchData();
    } catch (e) {
      print('Error al inicializar imageNames: $e');
    }
  }
Future<void> dataLike(int id) async {
  try {
    final url = Uri.parse('https://cesarj.pythonanywhere.com/like-shirt-page?ID=$id');
    final response = await http.get(url);
    if (response.statusCode == 200) {
      final jsonResponse = json.decode(response.body);
      setState(() {
        imageNames.clear(); // Eliminar elementos existentes
        for (var item in jsonResponse) {
          // Verifica que cada elemento sea una lista y que tenga al menos un elemento
          if (item is List && item.isNotEmpty) {
            // Imprime cada nombre de archivo de imagen
            imageNames.add(item[0]);
          }
        }
      });
      dataProduct.clear();
       _fetchData();
    } else {
      print('Error en la solicitud: ${response.statusCode}');
    }
  } catch (e) {
    print('Error: $e');
  }
}
Future<List<String>> recomenda(int id) async {
  try {
    final url = Uri.parse('https://euclidiana.pythonanywhere.com/recomendacion?ID=$id');
    final response = await http.get(url);
    if (response.statusCode == 200) {
      final jsonResponse = json.decode(response.body) as Map<String, dynamic>;
      final listIm = jsonResponse['listImages'] as List<dynamic>;
      return List<String>.from(listIm);
    } else {
      print('Error en la solicitud: ${response.statusCode}');
      return []; // En caso de error, retornar una lista vacía
    }
  } catch (e) {
    print('Error: $e');
    return []; // En caso de excepción, retornar una lista vacía
  }
}

Future<List<String>> deportivas() async {
  try {
    final url = Uri.parse('https://oscarestudiante2211.pythonanywhere.com/img-deportiva');
    final response = await http.get(url);
    if (response.statusCode == 200) {
       final jsonResponse = json.decode(response.body) as List<dynamic>;
      return List<String>.from(jsonResponse);
    } else {
      print('Error en la solicitud: ${response.statusCode}');
      return []; // En caso de error, retornar una lista vacía
    }
  } catch (e) {
    print('Error: $e');
    return []; // En caso de excepción, retornar una lista vacía
  }
}
Future<List<String>> casuales() async {
  try {
    final url = Uri.parse('https://oscarestudiante2211.pythonanywhere.com/img-casual');
    final response = await http.get(url);
    if (response.statusCode == 200) {
       final jsonResponse = json.decode(response.body) as List<dynamic>;
      return List<String>.from(jsonResponse);
    } else {
      print('Error en la solicitud: ${response.statusCode}');
      return []; // En caso de error, retornar una lista vacía
    }
  } catch (e) {
    print('Error: $e');
    return []; // En caso de excepción, retornar una lista vacía
  }
}
  Future<void> _fetchData() async {
    dataProduct.clear();
    for (var name in imageNames) {
      try {
        final url = Uri.parse('https://cesarj.pythonanywhere.com/producto-info?imagen=$name');
        final response = await http.get(url);
        if (response.statusCode == 200) {
          final jsonMap = json.decode(response.body) as Map<String, dynamic>;
          setState(() {
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
  }

  @override
  Widget build(BuildContext context) {
    print(imageNames);
    List<String> imageUrls=[];
    imageUrls=imageNames.map((name) => 'https://oscarestudiante2211.pythonanywhere.com/$name'.trim()).toList();
    print("Listas finales");
    print(imageUrls);
    print(imageNames);
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 12, 12, 14),
        title: Text('Home'),
        actions: [
          Row(
        children: [
          IconButton(
            icon: Icon(Icons.shopping_cart),
            onPressed: () {
                List<CarritoItem> items = [];
                for (var objeto in DataStore().objetos) {
                  print("Imagen: ${objeto.imagen}, Medida: ${objeto.medida}");
                  String precioSinSigno = objeto.precio.replaceAll('\$', '');
                  items.add( CarritoItem(producto: Producto(nombre: objeto.medida, precio:  int.parse(precioSinSigno), imagenUrl: objeto.imagen)));
                }
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => CarritoDeComprasView(items:items)),
                );
            },
          ),
          IconButton(
            icon: Icon(Icons.favorite),
            onPressed: () {
              print(GlobalVariables.id);
              int id = GlobalVariables.id;
              dataLike(id);

            },
          ),
        ],
      ),
        ],
      ),
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: <Widget>[
            DrawerHeader(
              decoration: BoxDecoration(
                color: Color.fromARGB(255, 12, 12, 14),
                ),
                child:       Align(
                  alignment: Alignment.center,
                  child: ClipOval(
                    child: Container(
                      width: 70,
                      height: 70,
                      color: Colors.transparent,
                      child: GestureDetector(
                        onTap: () async {
                          imageNames.clear();
                          dataProduct.clear();
                          imageNames = await recomenda(GlobalVariables.id);
                          print(imageNames);
                          _fetchData();
                          print('La imagen ha sido tocada.');
                          },

                          child: Image.network(
                            'https://oscarestudiante2211.pythonanywhere.com/shiva.PNG',
                            fit: BoxFit.cover,
                            ),
                            ),
                            ),
                            ),
                            ),
                            ),
            ListTile(
              title: Text('Deportivas'),
              onTap: ()async { 
                
                imageNames.clear();
                dataProduct.clear();
                imageNames= await deportivas();
                _fetchData();
              },
            ),
            ListTile(
              title: Text('Casuales'),
              onTap: ()async { 
                imageNames.clear();
                dataProduct.clear();
                imageNames= await casuales();
                _fetchData();
              },
            ),
          ],
        ),
      ),
      body: GridView.builder(
        gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 2,
          crossAxisSpacing: 8.0,
          mainAxisSpacing: 8.0,
        ),
        itemCount: dataProduct.length,
        itemBuilder: (context, index) {
          return Padding(
  padding: const EdgeInsets.all(8.0),
  child: GestureDetector(
  onTap: () {
    print('Contenedor presionado');
     Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => ProductoWindow(
                  imageUrl: imageUrls[index],
                  valor:'${dataProduct[index]['valor']}',
                ),
              ),
            );
    // Aquí puedes agregar cualquier lógica que desees ejecutar cuando se presione el contenedor
  },
  child: Container(
    padding: EdgeInsets.all(8.0), // Ajusta el espaciado interior según sea necesario
    decoration: BoxDecoration(
      border: Border.all(color: Colors.grey), // Agrega un borde al contenedor
    ),
    child: Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Expanded(
          child: Image.network(
            imageUrls[index],
            width: 150, // Ancho deseado de la imagen
            height: 250, // Alto deseado de la imagen
            fit: BoxFit.cover, // Ajustar la imagen dentro del tamaño especificado
          ),
        ),
        SizedBox(height: 8.0),
        Text(
          '${dataProduct[index]['valor']}',
          style: TextStyle(
            fontSize: 16.0, // Tamaño de fuente para el valor
            fontWeight: FontWeight.bold, // Negrita para el valor
          ),
        ),
        Text(
          '\$ ${dataProduct[index]['precio']}',
          style: TextStyle(
            fontSize: 16.0, // Tamaño de fuente para el precio
             color: Color.fromARGB(255, 245, 229, 7),
          ),
        ),
        SizedBox(height: 8.0),
        TextButton.icon(
          onPressed: () {
            // Aquí puedes agregar la lógica para manejar el "me gusta"
          },
          icon: Icon(
            Icons.favorite,
            size: 18,
            color: Colors.red, // Color del icono de "me gusta"
          ),
          label: Text(
            'Me gusta', // Texto del botón de "me gusta"
            style: TextStyle(
              fontSize: 14,
              color: Colors.red, // Color del texto del botón de "me gusta"
            ),
          ),
        ),
      ],
    ),
  ),

),

);

        },
      ),
    );
  }
}
