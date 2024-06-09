import 'package:flutter/material.dart';
import 'dart:convert';
class CarritoDeComprasView extends StatefulWidget {
  final List<CarritoItem> items;

  CarritoDeComprasView({required this.items});

  @override
  _CarritoDeComprasViewState createState() => _CarritoDeComprasViewState();
}

class _CarritoDeComprasViewState extends State<CarritoDeComprasView> {
  late List<CarritoItem> _items;
  double _total = 0;

  @override
  void initState() {
    super.initState();
    _items = List.from(widget.items);
    _calculateTotal();
  }

  void _calculateTotal() {
    _total = _items.fold(0, (total, item) => total + item.producto.precio * item.cantidad);
  }

  void _incrementQuantity(int index) {
    setState(() {
      _items[index].cantidad++;
      _calculateTotal();
    });
  }

  void _decrementQuantity(int index) {
    setState(() {
      if (_items[index].cantidad > 1) {
        _items[index].cantidad--;
        _calculateTotal();
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 12, 12, 14),
        title: Text('Carrito de Compras'),
      ),
      body: ListView.builder(
        shrinkWrap: true,
        physics: const NeverScrollableScrollPhysics(),
        itemCount: _items.length,
        itemBuilder: (context, index) {
          var item = _items[index];
          return Dismissible(
            key: Key(item.producto.nombre),
            onDismissed: (direction) {
              setState(() {
                _total -= item.producto.precio * item.cantidad;
                _items.removeAt(index);
              });
            },
            background: Container(
              color: Colors.red,
              alignment: Alignment.centerRight,
              padding: EdgeInsets.only(right: 20.0),
              child: Icon(
                Icons.delete,
                color: Colors.white,
              ),
            ),
            child: ListTile(
              leading: Image.network(
                item.producto.imagenUrl,
                width: 50,
                height: 100,
                fit: BoxFit.cover,
              ),
              title: Text(item.producto.nombre),
              subtitle: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Row(
                    children: [
                      Text('\$${item.producto.precio.toString()}'),
                      SizedBox(width: 30),
                      Text('Cantidad: ${item.cantidad.toString()}'),
                      SizedBox(width: 40),
                      IconButton(
                        icon: Icon(Icons.add),
                        onPressed: () => _incrementQuantity(index),
                      ),
                      IconButton(
                        icon: Icon(Icons.remove),
                        onPressed: () => _decrementQuantity(index),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          );
        },
      ),
      bottomNavigationBar: BottomAppBar(
        color: Color.fromARGB(255, 53, 51, 51),
        child: Padding(
           
          padding: EdgeInsets.all(16.0),
          child: Row(
           
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              Text(
                'Total: \$${_total.toStringAsFixed(2)}',
                style: TextStyle(
                  color: Color.fromARGB(255, 240, 238, 238),
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                ),
              ),
              ElevatedButton(
                onPressed: () {
                  // Acción para finalizar la compra
                },
                  style: ElevatedButton.styleFrom(
                     primary: Color.fromARGB(255, 245, 244, 244), // Color rojo (RGB: 255, 0, 0)
                     ),
                child: Text('Comprar',
                style: TextStyle(
                  color: Color.fromARGB(255, 7, 7, 7),
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                ),),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class CarritoItem {
  final Producto producto;
  int cantidad;

  CarritoItem({required this.producto, this.cantidad = 1});
}

class Producto {
  final String nombre;
  final double precio;
  final String imagenUrl;

  Producto({required this.nombre, required this.precio, required this.imagenUrl});
}

void main() {
  // Ejemplo de datos
  List<CarritoItem> items = [
    CarritoItem(producto: Producto(nombre: 'Hola', precio: 10, imagenUrl: 'https://oscarestudiante2211.pythonanywhere.com/img10.jpg')),
    CarritoItem(producto: Producto(nombre: 'Producto 2', precio: 20, imagenUrl: 'https://oscarestudiante2211.pythonanywhere.com/img10.jpg')),
    CarritoItem(producto: Producto(nombre: 'Producto 3', precio: 30, imagenUrl: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png')),
  ];

  runApp(MaterialApp(
     debugShowCheckedModeBanner: false,
    home: CarritoDeComprasView(items: items),
  ));
}
