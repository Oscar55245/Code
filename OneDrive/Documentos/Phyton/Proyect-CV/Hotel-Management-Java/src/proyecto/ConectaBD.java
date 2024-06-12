package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaBD {
    static Connection getConnection(){
        Connection cn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoi", "root","");
      // cn = DriverManager.getConnection("jdbc:mysql://b85jdqaxy9gy77ajdez1-mysql.services.clever-cloud.com:3306/b85jdqaxy9gy77ajdez1","u92fvrqvmtpuhysi","VJLFYOq99TqW0MH6cNpM");
            System.out.println("Conexion establecida");
        } catch (SQLException | ClassNotFoundException e2){
            JOptionPane.showMessageDialog(null, e2);
            System.exit(0);
        }
        return cn;
    }
}
