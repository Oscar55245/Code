
package cenafilosofos;

import modelo.Mesa;
import Controlador.Filosofo;

public class CenaFilosofos {
    public static int MAX_TENEDORES=5;
    public static int MAX_FILOSOFOS= 5;
    public static void main(String[] args) throws InterruptedException {
        Mesa mesa  =  new Mesa();
        mesa.CrearTenedores(MAX_TENEDORES);
        crearFilosofos(MAX_FILOSOFOS, mesa);
        iniciarCena(crearFilosofos(MAX_FILOSOFOS, mesa));
    }   
    private static Filosofo[] crearFilosofos(int numeroFilosofos , Mesa mesa) throws InterruptedException{
        String[] NombreFilosofos =  {"Empedocles","Tales","Pitagoras","Democrito","Damo"};
        Filosofo filosofos[]= new Filosofo[numeroFilosofos];
        for (int i = 0; i < numeroFilosofos; i++) {
            filosofos[i]= new Filosofo(NombreFilosofos[i],i,mesa);
        }
        return filosofos;
    }
    public static void iniciarCena(Thread[] threads){
        for (Thread t : threads) {
            t.start();
        }
    }
}
