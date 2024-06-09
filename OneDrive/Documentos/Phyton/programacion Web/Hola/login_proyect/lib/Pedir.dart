import 'package:flutter/material.dart';

class PaymentScreen extends StatefulWidget {
  @override
  _PaymentScreenState createState() => _PaymentScreenState();
}

class _PaymentScreenState extends State<PaymentScreen> {
  final TextEditingController nombre = TextEditingController();
  final TextEditingController email = TextEditingController();
  final TextEditingController domicilio = TextEditingController();
  final TextEditingController municipio = TextEditingController();
  final TextEditingController codigopost = TextEditingController();
  final TextEditingController total = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Payment'),
        backgroundColor: Color.fromARGB(255, 12, 12, 14),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            TextFormField(
              controller: nombre,
              decoration: InputDecoration(labelText: 'Nombre'),
            ),
            SizedBox(height: 16.0),
            TextFormField(
              controller: email,
              decoration: InputDecoration(labelText: 'Email'),
            ),
            SizedBox(height: 16.0),
            TextFormField(
              controller: domicilio,
              decoration: InputDecoration(labelText: 'Domicilio'),
            ),
            SizedBox(height: 16.0),
            TextFormField(
              controller: municipio,
              decoration: InputDecoration(labelText: 'Municipio'),
            ),
            SizedBox(height: 16.0),
            TextFormField(
              controller: codigopost,
              decoration: InputDecoration(labelText: 'Codifo postal'),
            ),
            SizedBox(height: 16.0),
            TextFormField(
              controller: total,
              decoration: InputDecoration(labelText: 'Total'),
            ),
            SizedBox(height: 32.0),
            Center(
              child: ElevatedButton(
                onPressed: () {
                  // Aquí puedes implementar la lógica para procesar el pago
                  // Puedes usar los valores ingresados en los campos de texto
                  // que están controlados por los controladores.
                  print('Payment processed!');
                },
                
                child: Text('Hacer pedido',
                style: TextStyle(
                  color: Color.fromARGB(255, 7, 7, 7),
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                ),),
                
              ),
            ),
          ],
        ),
      ),
    );
  }
}
