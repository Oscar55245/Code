
class CarritoCompra {
  final String imagen;
  final String medida;
  final String precio; 

  CarritoCompra({required this.imagen, required this.medida, required this.precio});
  @override

  String toString() {
    return 'imagen: $imagen, medida: $medida, precio: $precio';
  }
    @override
  bool operator ==(Object other) {
    if (identical(this, other)) return true;
    return other is CarritoCompra &&
        other.imagen == imagen &&
        other.medida == medida &&
        other.precio == precio;
  }

  @override
  int get hashCode => imagen.hashCode ^ medida.hashCode ^ precio.hashCode;
}
class DataStore {
  static final DataStore _instance = DataStore._internal();
  factory DataStore() => _instance;
  
  DataStore._internal();

  // Lista de objetos CarritoCompra compartidos
  List<CarritoCompra> objetos = [];

    void eliminarElemento(String imagen,String medida) {
    objetos.removeWhere((element) => element.imagen == imagen &&element.medida == medida);
  }
}
