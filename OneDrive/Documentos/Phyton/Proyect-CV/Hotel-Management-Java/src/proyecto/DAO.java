package proyecto;

import java.util.ArrayList;
import java.util.List;

/*
 * @author dany9
 */

public interface DAO<E> {
    public ArrayList<E>list();
    public String Insertar (E e);
    public Integer id();
    public E get(Integer id);
    public String delete(Integer id);
    public String update (E e);
}
