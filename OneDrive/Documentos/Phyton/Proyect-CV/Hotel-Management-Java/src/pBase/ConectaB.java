package pBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectaB {
    
     public Connection getConnection (){
       Connection cn = null;
       try {
          Class.forName("com.mysql.jdbc.Driver");
         cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoi", "root","");
            
           System.out.println("Conexion Establecida ");
       } catch (SQLException e2) {
           System.out.println("Error : " + e2.getMessage());
       }catch(ClassNotFoundException e){
           System.out.println("Error: " + e.getMessage());
       }
       return  cn;
   }
    
}
