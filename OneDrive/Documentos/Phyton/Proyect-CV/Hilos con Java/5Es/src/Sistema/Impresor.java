
package Sistema;

/**
 * @author CesarJ
 */
public interface Impresor {
    
    void inicio(String inicio);void ejecucion(String archivo);
    void listo(String archivo);
     void bloqueo(String archivo);
    void terminado(String archivo);
    
}
