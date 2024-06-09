import 'dart:io';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'carrito.dart';
String filtro="";
List<dynamic> mixedList = [];
class ImageData {
  List<File> imageList;
  List<String> nameList;
  List<int> precioList;
  ImageData(this.imageList, this.nameList,this.precioList);
}
List<File> carritoCompra=[];
class Filtro extends StatefulWidget {
  @override
  String filtro;
  Filtro({required this.filtro});
  _HomePageState createState() => _HomePageState(filtro: filtro);
}
String  modificarCadena(String cadena,String filtro){
          String caracterAQuitar ="C:/Users/aylem/OneDrive/Documentos/Phyton/programacion Web/Hola/login_proyect/lib/img/$filtro";
          String cadenaModificada = cadena.replaceAll(caracterAQuitar, "");
          cadenaModificada = cadenaModificada.replaceAll(r'\', r'/');
          return cadenaModificada;
}

class _HomePageState extends State<Filtro> {
  final String filtro;
  _HomePageState({required this.filtro});
 
  Future<ImageData> getImages() async {
    Directory directory = Directory('C:/Users/aylem/OneDrive/Documentos/Phyton/programacion Web/Hola/login_proyect/lib/img/$filtro');
    List<File> imageList = [];
    List<String> nameList = [];
    List<int> precioList=[]; 
    if (directory.existsSync()) {
      List<FileSystemEntity> files = directory.listSync();
      for (FileSystemEntity file in files) {
        if (file is File) {
          String cadenaOriginal = file.path;
          String cadenaModificada=modificarCadena(cadenaOriginal,filtro);
          final response = await http.get(Uri.parse('http://127.0.0.1:5000/obtener?file=img$cadenaModificada'));
          if (response.statusCode == 200) {
            final data = json.decode(response.body);
            String name = data['nombre'];
            int precio = data['precio'];
            nameList.add(name);
            precioList.add(precio);
          } else {
            throw Exception('Error al cargar datos desde el servidor');
          }
          imageList.add(file);
        }
      }
    }

    return ImageData(imageList, nameList,precioList);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color.fromARGB(255, 222, 225, 233),
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 12, 12, 14),
        title: Text('Home'),
        actions: [
          PopupMenuButton(
            itemBuilder: (context) => [
              PopupMenuItem(
                child: Text('Deportes'),
                value: 'deportivo',
              ),
              PopupMenuItem(
                child: Text('Casual'),
                value: 'casuales',
              ),
            ],
            icon: Icon(Icons.more_vert),
            onSelected: (value) {
              Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => Filtro(filtro: value)),
                );
            },
          ),
        ],
        leading: Stack(
          alignment: Alignment.center,
          children: [
            IconButton(
              icon: Icon(Icons.shopping_cart),
              onPressed: () {
              },
            ),
            Positioned(
              top: 40, // Ajusta la posición vertical del texto según tu preferencia
              child: Text("Carrito", style: TextStyle(fontSize: 12),), // Agrega un texto debajo del icono
            ),
          ],
        ),
      ),
      body: FutureBuilder<ImageData>(
        future: getImages(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error al cargar las imágenes'));
          } else if (snapshot.data == null || snapshot.data!.imageList.isEmpty) {
            return Center(child: Text('No se encontraron imágenes'));
          } else {
            return GridView.builder(
              gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                crossAxisCount: 3,
                crossAxisSpacing: 26.0,
                mainAxisSpacing: 36.0,
              ),
              itemCount: snapshot.data!.imageList.length,
              itemBuilder: (context, index) {
                return _buildCard(context, snapshot.data!.imageList[index], snapshot.data!.nameList[index],snapshot.data!.precioList[index]);
              },
            );
          }
        },
      ),
    );
  }
  Widget _buildCard(BuildContext context, File imageFile, String nameList, int precio) {
    return GestureDetector(
      onTap: () {
        _showSelectedImages(context, imageFile);
      },
      child: Card(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10.0),
        ),
        elevation: 5.0,
        margin: EdgeInsets.all(4.0),
        child: Container(
          width: 150.0, // Ajusta el ancho del Card
          height: 250.0, // Ajusta la altura del Card
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Image.file(
                imageFile,
                width: 150.0, // Ajusta el ancho de la imagen
                height: 150.0, // Ajusta la altura de la imagen
              ),
              SizedBox(height: 45.0),
              Container(
                padding: EdgeInsets.symmetric(horizontal: 45.0),
                child: Text(nameList),
              ),
             Column(
                children: [
                  Text("Precio: "),
                  Text('$precio'),
                  ],
                  ),
                   ],
          ),
        ),
      ),
    );
  }

  void _showSelectedImages(BuildContext context, File imageFile) async {
    String cadenaOriginal = imageFile.path;
    String material="";
    String name_dis="";
    String medida="";
    String playera=modificarCadena(cadenaOriginal,filtro);
    final response = await http.get(Uri.parse('http://127.0.0.1:5000/obtener?file=img$playera'));
          if (response.statusCode == 200) {
            final data = json.decode(response.body);
             material= data['material'];
             name_dis= data['diseñador'];
            print(material);
          } else {
            throw Exception('Error al cargar datos desde el servidor');
          }
          showDialog(
            context: context,
            builder: (BuildContext context) {
              return AlertDialog(
                title: Text('Ver playera'),
                content: Container(
                  width: 300.0, 
                  height: 400.0,
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.center,
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Container(
                        width: 100.0,
                        height: 140.0,
                         child: Image.file(
                          imageFile,
                          fit: BoxFit.cover, 
                  ),
                ),
                SizedBox(height: 20.0),
                Text(material),
                SizedBox(height: 20.0),
                Text(name_dis),
                SizedBox(height: 20.0),
                Row(
  mainAxisAlignment: MainAxisAlignment.center,
  children: [
    ElevatedButton(
      onPressed: () {
        medida="EG";
        print(medida);
      },
      style: ElevatedButton.styleFrom(
        primary: Color.fromARGB(255, 63, 63, 63),
        minimumSize: Size(10, 10),
      ),
      child: Text('EG', style: TextStyle(color: Colors.white)),
    ),
    SizedBox(width: 10.0), // Espacio entre botones
    ElevatedButton(
      onPressed: () {
        medida="M";
        print(medida);
      },
      style: ElevatedButton.styleFrom(
        primary: Color.fromARGB(255, 63, 63, 63),
        minimumSize: Size(10, 10),
      ),
      child: Text('M', style: TextStyle(color: Colors.white)),
    ),
    SizedBox(width: 10.0), // Espacio entre botones
    ElevatedButton(
      onPressed: () {
       medida="CH";
       print(medida);
      },
      style: ElevatedButton.styleFrom(
        primary: Color.fromARGB(255, 63, 63, 63),
        minimumSize: Size(10, 10),
        ),
      child: Text('CH', style: TextStyle(color: Color.fromARGB(255, 235, 232, 232))),
    ),
  ],
),
SizedBox(height: 20.0),
               ElevatedButton(
                onPressed: () {
                   mixedList.add(imageFile);
                   mixedList.add(medida);
                   for (var item in mixedList) {
                    if (item is File) {
                      File fileItem = item;
                      print(fileItem);
                      } else if (item is String) {
                        String stringItem = item;
                          print(stringItem);
                        }
                          }
                    _addToCart(imageFile);
                    final snackBar = SnackBar(
                    content: Text('Producto agregado con éxito'),
                    backgroundColor: Colors.green, // Puedes personalizar el color
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
                  },
                  style: ElevatedButton.styleFrom(
                    primary: Color.fromARGB(255, 63, 63, 63),
                    minimumSize: Size(10, 10),
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Icon(
                        Icons.add,
                        color: Color.fromARGB(255, 255, 255, 255),
                      ),
                      SizedBox(width: 5.0),
                      Text(
                        'Agregar',
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 16.0, // Ajusta el tamaño del texto
                        ),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop(); // Cerrar el diálogo
              },
              child: Text('Cerrar'),
            ),
          ],
        );
      },
    );
  }

  void _addToCart(File imageFile) {
    carritoCompra.add(imageFile);
    print(carritoCompra);
  }
}
