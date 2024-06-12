package Controlador;

import static java.lang.Thread.sleep;
import model.Impresor;

public class Lapso extends Thread {

    public static int lapso;
    public static   int hor=0, min=0, seg=0,seg2=0;
    public static boolean finLapso;

   
    public void getLapso(int lapso) {
        this.lapso=lapso;
    }

    public void run() {
        while (true) {
            try {
                seg2++;
                System.out.println(lapso);
                if (seg2==60) {
                    seg2=0;
                    min++;
                }
                if (min==60) {
                    min=0;
                    hor++;
                }
                if (min==60) {
                    seg2=0;
                    min=0;
                }
                if (seg2==lapso) {
                    finLapso=true;
                    seg2=0;
                    min=0;
                    System.out.println(finLapso);
                    this.suspend();
                }
                System.out.println("Tiempo   = "+hor+" : "+min+" : "+seg2);
                Thread.sleep(999);
            } catch (InterruptedException e) {
                
            }
            
        }
    }
}
