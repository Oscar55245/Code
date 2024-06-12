
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:provider/provider.dart';
import 'package:english_words/english_words.dart';
import 'datos.dart';
import 'Variables.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'Foto.dart' as Foto;
import 'dart:async';
import 'package:camera/camera.dart';


class PalabrasMyApp extends StatelessWidget  {
  const PalabrasMyApp({super.key});
  @override
  Widget build(BuildContext context) {
    
    return ChangeNotifierProvider(
    create: (context)=>MyAppState(),
    
    child:MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Color.fromARGB(255, 89, 117, 228)),
        useMaterial3: true,
      ),
      home:  MyHomePage(),
    ),
    );
  }
}
class MyAppState extends ChangeNotifier{
     var current = WordPair.random();
     var history = <WordPair>[];
     
     GlobalKey? historyListKey;
     void getNext(){
        history.insert(0, current);
        var animateList = historyListKey?.currentState as AnimatedListState?;
        animateList?.insertItem(0);
        current =  WordPair.random();
        notifyListeners();
     }
     var favorites =<WordPair>[];
     void togglerFavorites([WordPair? pair]){
      pair = pair ?? current;
      if(favorites.contains(pair)){
        favorites.remove(pair);
        }else{
          favorites.add(pair);
          }
          notifyListeners();
          }
          void removeFavorite(WordPair pair){
            favorites.remove(pair);
            notifyListeners();
          }
          }
class MyHomePage extends StatefulWidget {
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
   Map<String, dynamic> data = {};
   late CameraDescription _camera;
  @override
  void initState() {
    super.initState();
    fetchData(GlobalVariables.id);
    obtenerCamara();
  }
    Future<void> obtenerCamara() async {
    // Ensure that plugin services are initialized so that `availableCameras()`
    // can be called before `runApp()`
    WidgetsFlutterBinding.ensureInitialized();

    // Obtain a list of the available cameras on the device.
    final cameras = await availableCameras();

    // Guarda la cámara en la variable de estado
    setState(() {
      _camera = cameras.first;
    });
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
    var selectedIndex = 0;
     @override
     Widget build(BuildContext context){
      var colorScheme = Theme.of(context).colorScheme;
      Widget page;
      switch(selectedIndex) {
           case 0:
             page = GeneratorPage();
             break;
           case 1:
             page= FavoritesPage();
             break;
          case 2:
             page=DatosPage();
          case 3:
             
             page=Foto.TakePictureScreen(camera: _camera);
             break;
           default:
             throw UnimplementedError('No widget for $selectedIndex');
      }
      var mainArea =  ColoredBox(
        color: colorScheme.surfaceVariant,
        child: AnimatedSwitcher(
          duration: Duration(milliseconds: 200),
          child: page,
        ),
      
      );
      return Scaffold(
          body: LayoutBuilder(
          builder: (context, constraints){
            if (constraints.maxWidth < 450){
             return Column(
              children:[
                Expanded(child: mainArea,),
                  SafeArea(
                    child: BottomNavigationBar(
                    items: [
                      BottomNavigationBarItem(
                        icon: Icon(Icons.home),
                        label: 'Home',
                        backgroundColor: Colors.black,
                      ),
                      BottomNavigationBarItem(
                        icon: Icon(Icons.favorite),
                        label: 'Favoritos',
                        backgroundColor: Colors.black,
                        ),
                        BottomNavigationBarItem(
                        icon: Icon(Icons.supervised_user_circle_outlined),
                        label: 'Datos',
                        backgroundColor: Colors.black,
                        ),
                        BottomNavigationBarItem(
                        icon: Icon(Icons.camera),
                        label: 'Foto',
                        backgroundColor: Colors.black,
                        )
                    ],
                    currentIndex:  selectedIndex,
                    onTap: (value) {
                      setState(() {
                        selectedIndex=value;
                      });
                    },
                  ),
                  
             )
              ],
             );

            }else{
              return Row(
                children: [
                  SafeArea(
                    child: NavigationRail(
                      extended: constraints.maxWidth>=600,
                      destinations: [
                        NavigationRailDestination(icon: Icon(Icons.home), label: Text('Home')),
                        NavigationRailDestination(icon: Icon(Icons.favorite), label: Text('Favorites')),
                        NavigationRailDestination(icon: Icon(Icons.info), label: Text('Mis datos')),
                        NavigationRailDestination(icon: Icon(Icons.exit_to_app), label: Text('Salir'))
                      ],
                      selectedIndex: selectedIndex,
                      onDestinationSelected: (value) {
                        setState(() {
                          selectedIndex = value;
                        });
                      },
                    ),
                    ),
                    Expanded(child: mainArea)
                ],
              );
            }
          },
          ),
         );
     }   
}
class GeneratorPage extends StatelessWidget{
@override
  Widget build(BuildContext context) {
    var appState = context.watch<MyAppState>();
    var pair = appState.current;
    IconData icon;
    if(appState.favorites.contains(pair)){
       icon =  Icons.favorite;
    }else{
       icon = Icons.favorite_border;
    }
    return Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Expanded(
              flex: 3,
              child: HistoryListView(),
            ),
            SizedBox(height: 10,),
            BigCard(pair: pair),
            Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                ElevatedButton.icon(onPressed: (){
                appState.togglerFavorites();
                }
                ,
                 icon: Icon(icon), label: Text('Me gusta')),
                 SizedBox(width: 10,),
                 ElevatedButton(
                  onPressed:(){ appState.getNext();}
                  ,child: Text('Siguiente'),)

              ],
            ),
            Spacer(flex: 2,),
          ],
        ),
      );
  }
  }

 class BigCard extends StatelessWidget {
  const BigCard({
    super.key,
    required this.pair,
  });
  final WordPair pair;

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final style = theme.textTheme.displayMedium!.copyWith(
      color: theme.colorScheme.onPrimary,
    );
    return Card(
      color: theme.colorScheme.primary,
      child: Padding(
        padding: const EdgeInsets.all(20),
        child: AnimatedSize(
          duration: Duration(milliseconds: 200),
          child: MergeSemantics(
            child: Wrap(
              children: [
                Text(
                  pair.first,
                  style: style.copyWith(fontWeight: FontWeight.w200),
                ),
                Text(
                  pair.second,
                  style: style.copyWith(fontWeight: FontWeight.bold),
                )
              ],
            ),
          ),
        ),

      ),
    );
  }
}

 
class FavoritesPage extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    var theme = Theme.of(context);
    var appState = context.watch<MyAppState>();
    if(appState.favorites.isEmpty){
        return Center(
          child: Text("No hay favoritos"),
        );
    }
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Padding(
          padding: const EdgeInsets.all(30),
          child: Text("Tienes ${appState.favorites.length} favoritos : "),
          
          ),
          Expanded(
            child: GridView(
              gridDelegate: SliverGridDelegateWithMaxCrossAxisExtent(
                maxCrossAxisExtent: 400,
                childAspectRatio: 400/80,
              ),
              children: [
                 for(var pair in appState.favorites)
                  ListTile(
                    leading: IconButton(
                      icon: Icon(Icons.delete_outline,semanticLabel: 'Eliminar',),
                      color: theme.colorScheme.primary,
                      onPressed: (){
                        appState.removeFavorite(pair);
                      },
                    ),
                    title: Text(
                      pair.asLowerCase,
                      semanticsLabel: pair.asPascalCase,

                    ),
          )
              ],
            ) 
            )
          
      ],
    );
  }
}

class HistoryListView extends StatefulWidget{
  const HistoryListView({Key? key}) : super(key: key);
  @override
  State<HistoryListView> createState() => _HistoryListState();
}
class _HistoryListState extends State<HistoryListView>{
  final _key = GlobalKey();
  static const Gradient _maskingGradiet = LinearGradient(
    colors: [Colors.transparent, Colors.black],
    stops: [0.0,0.5],
    begin: Alignment.topCenter,
    end: Alignment.bottomCenter,
    );
    @override
    Widget build(BuildContext context){
      final appState = context.watch<MyAppState>();
      appState.historyListKey = _key;
      return ShaderMask(
        shaderCallback:(bounds) => _maskingGradiet.createShader(bounds),
        blendMode: BlendMode.dstIn,
        child: AnimatedList(
          key: _key,
          reverse: true,
          padding: EdgeInsets.only(top: 100),
          initialItemCount: appState.history.length,
          itemBuilder: (context,index,animation){
            final pair = appState.history[index];
             return SizeTransition(
              sizeFactor: animation,
              child: Center(
               child: TextButton.icon(onPressed: (){appState.togglerFavorites(pair);},
                icon: appState.favorites.contains(pair)
                ? Icon(Icons.favorite, size: 12,)
                : SizedBox(),
                 label: Text(
                   pair.asLowerCase,
                   semanticsLabel: pair.asPascalCase,
                 ),
                 ),
              ),
              );
          }
        ), 
        );
    }

}
