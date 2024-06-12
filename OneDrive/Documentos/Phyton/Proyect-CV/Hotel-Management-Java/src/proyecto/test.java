package proyecto;

// @author Danny

public class test {
    
    public static void main(String[] args) {
        ConectaBD bd= new ConectaBD();
        System.out.println(bd.getConnection().toString());
    }
}