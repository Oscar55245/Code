
package pBase;


public class desencript {
 
        public  String desencrip(String crip){
        char ch []=new char[crip.length()];
        int cr []=new int[crip.length()];
        for (int i = 0; i < crip.length(); i++) {
            ch[i]=crip.charAt(i);
            int ascii = ch[i];
            cr[i] += (int) ch[i]-3;
        }
        crip="";
        for (int i = 0; i < cr.length; i++) {
            crip+=cr[i]+"-";
        }
        String cri  =  crip;
        String[] c = cri.split("-");
        int []   asciiValue = new int [cri.length()];
        char[] convertedChar = new char [cri.length()];
        cri="";
        for (int i = 0; i < c.length; i++) {
            asciiValue[i] = Integer.parseInt(c[i]);
            convertedChar[i] = (char)asciiValue[i];
            cri+=convertedChar[i];
        }
        return cri;
    }
         public static void main(String[] args) {
        desencript encrip = new desencript();
        String respuesta = encrip.desencrip("jskdjahd"); 
        System.out.println(respuesta); 
    }   
}
