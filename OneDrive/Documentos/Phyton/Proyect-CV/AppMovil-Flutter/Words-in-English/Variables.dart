class GlobalVariables {
  static int id = 0;
  static String _nombre="";
  static set nombre(String value) {
    _nombre = value;
  }

  static String get nombre {
    return _nombre;
  }

}