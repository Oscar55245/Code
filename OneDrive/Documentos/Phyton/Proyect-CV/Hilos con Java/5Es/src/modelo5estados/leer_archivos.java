
package modelo5estados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author CesarJ
 */
public class leer_archivos {
    Instruccion instruccion;
    public static int conteo,lugarBloqueo;
    public static boolean razonBloqueo=false;
    public ArrayList<Instruccion> leer(String leer_archivo) throws FileNotFoundException{
        conteo=lugarBloqueo=0;
        razonBloqueo=false;
        ArrayList<Instruccion> lista = new ArrayList<Instruccion>();
        InputStream file = new FileInputStream("src\\archivos\\"+leer_archivo);
        Scanner obj = new Scanner(file);
        while (obj.hasNextLine()) {
            conteo=conteo+1;
        instruccion = new Instruccion();
        String in = obj.nextLine();
        StringTokenizer tokens = new StringTokenizer(in, "|"); while (tokens.hasMoreTokens()) {
        String token = tokens.nextToken();
        if (isDigit(token)) {
            System.out.println("Número: " + token);
            instruccion.setEjecucion(Integer.parseInt(token));
        } else if (isLetter(token)) {
            instruccion.setIntruccion(token);
            System.out.println("Letra: " + token);
            if ("write".equals(token)) {
                lugarBloqueo=conteo;
                razonBloqueo=true;
                System.out.println("Lugar bloqueo"+conteo);
            }
        } else {
            System.out.println("Otro tipo de token: " + token);
        }
    }
        lista.add(instruccion);
}
            return lista;
    }
     private static boolean isDigit(String token) {
        for (char c : token.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
     private static boolean isLetter(String token) {
    for (char c : token.toCharArray()) {
        if (!Character.isLetter(c)) {
            return false;
        }
    }
    return true;
}
}
