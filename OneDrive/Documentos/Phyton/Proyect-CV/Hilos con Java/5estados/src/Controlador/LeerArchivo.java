package Controlador;

import Vista.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeerArchivo {

    public static int N = 0, id = 0;
    private final ArrayList nombre = new ArrayList<String>();
    public static String proceso = "", conteo = "", bloqueo = "", instruccion = "";
    public static Boolean block = false;
    public static ArrayList<Instruccion> I_final;

    public proceso LeerArchivo(String txt) throws FileNotFoundException, IOException {
        try {
            I_final = new ArrayList<>();
            InputStream file = new FileInputStream("src\\" + txt);
            Scanner obj = new Scanner(file);
            while (obj.hasNextLine()) {
                proceso = obj.nextLine();
                nombre.add(proceso);
            }

            for (int i = 0; i < nombre.size(); i++) {
                Pattern patron = Pattern.compile(Tipos.BLOQUEO.patron);
                Matcher matcher = patron.matcher(nombre.get(i).toString());
                if (matcher.matches()) {
                    bloqueo = nombre.get(i).toString();
                    System.out.println(bloqueo);
                    if (bloqueo.equals("")) {
                        block = false;
                    } else {
                        block = true;
                    }
                } else {
                    Instruccion tk = new Instruccion();
                    StringTokenizer tokens = new StringTokenizer(nombre.get(i).toString(), "|");
                    while (tokens.hasMoreTokens()) {
                        instruccion = tokens.nextToken();
                        Pattern patro = Pattern.compile(Tipos.NUMERO.patron);
                        Matcher matche = patro.matcher(instruccion);
                        if (matche.matches()) {
                            tk.setNumero(instruccion);
                        } else {
                            tk.setImpresion(instruccion);
                        }
                    }
                    I_final.add(tk);
                }
            }
            ////////////////////////////////////////////////////Establecer proceso//////////////////////////////////////////////////////////////
            id = id + 1;

        } catch (Exception e) {
            System.out.println("Lista vacia");
        }
        proceso pro = new proceso();
        pro.setlapsoEjecucion(Integer.parseInt(View.txtLapsoEjecucion.getText()));
        pro.settiempoBloqueo(Integer.parseInt(View.txtTiempoBloqueo.getText()));
        pro.settiempoEjecucion(Integer.parseInt(View.txtTiempoEjecucion.getText()));
        pro.settiempoInicio(Integer.parseInt(View.txtTiempoInicio.getText()));
        pro.setid(id);
        pro.setnombre(txt);
        pro.setI_final(I_final);
        pro.setBloqueo(block);
        return pro;
    }

    enum Tipos {
        NUMERO("[0-9]+"),
        BLOQUEO("(write|read|break)*");
        public final String patron;

        Tipos(String s) {
            this.patron = s;
        }
    }
}
