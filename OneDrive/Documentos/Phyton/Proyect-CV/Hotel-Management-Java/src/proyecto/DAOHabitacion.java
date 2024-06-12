package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import proyecto.ConectaBD;
import proyecto.ConectaBD;
import proyecto.DAO;
import proyecto.DAO;
import proyecto.No_Habi;
import proyecto.No_Habi;


public class DAOHabitacion implements DAO <Habitacion> {
   public ConectaBD db;
    
    public DAOHabitacion (){
        db = new ConectaBD();
    }

    @Override
    public ArrayList<Habitacion> list() {
        ArrayList<Habitacion> list=null;
     String sql = "select * from habitaciones";
        try {
           Connection cn= db.getConnection();
         PreparedStatement st = cn.prepareStatement(sql);
         ResultSet rs= st.executeQuery(sql);
         list = new ArrayList <Habitacion> ();
         while(rs.next()){
         Habitacion c = new Habitacion();
         c.setNoH(rs.getInt(1));
         c.setTipo(rs.getString(2));
         c.setCapacidad(rs.getInt(3));
         c.setEstatus(rs.getString(4));
         c.setCosto(rs.getInt(5));
         c.setPISO(rs.getString(6));
         c.setCUARTOS(rs.getString(7));
        c.setFoto(rs.getString(8));
        c.setCAMAS(rs.getString(9));
        c.setBAÑOS(rs.getString(10));
        c.setAC(rs.getString(11));
        c.setTV(rs.getString(12));
         list.add(c);
         }
         cn.close();
        } catch (SQLException e) {
           System.out.println("Error"+e.getMessage());
           }
    
        return list;
    }

    @Override
    public String Insertar(Habitacion e) {
      String result = null;
       String sql = "INSERT INTO habitaciones(Tipo_Ha,Capacidad,Estatus,Costo,PISO,CUARTOS,Foto,CAMAS,BAÑOS,AC,TV)"+"VALUES(?,?,?,?,?,?,?,?,?,?,?)";
       try {
       Connection cn = db.getConnection();
       PreparedStatement ps = cn.prepareStatement(sql);
       ps.setString(1, e.getTipo());
       ps.setInt(2, e.getCapacidad());
       ps.setString(3, e.getEstatus());
       ps.setInt(4, e.getCosto());
       ps.setString(5, e.getPISO());
       ps.setString(6, e.getCUARTOS());
       ps.setString(7, e.getFoto());
       ps.setString(8, e.getCAMAS());
       ps.setString(9, e.getBAÑOS());
       ps.setString(10, e.getAC());
       ps.setString(11, e.getTV());
       ps.executeUpdate();
       ps.close();
       cn.close();
       result="elemento insertado";
       }catch(SQLException a){
       
       result=a.getMessage();
       }
       return result;
    }

    @Override
    public Integer id() {
        Integer id=0;
        String sql = "select max(No_Habitacion) + 1 as codigo from habitaciones";
        try{
        Connection cn = db.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);    
            }
            ps.close();
            cn.close();
        }catch(SQLException e){
            System.out.println("Error"+e.getMessage());
        }
        return id;
    }

    @Override
    public Habitacion get(Integer id) {
         Habitacion e= null;
        String sql="Select * from habitaciones where No_Habitacion=?";
        try{
        Connection cn = db.getConnection();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs =  ps.executeQuery();
            if (rs.next()){
                e = new Habitacion();
                e.setNoH(rs.getInt(1));
                e.setTipo(rs.getString(2));
                e.setCapacidad(rs.getInt(3));
                e.setEstatus(rs.getString(4));
                e.setCosto(rs.getInt(5));
                e.setPISO(rs.getString(6));
                e.setCUARTOS(rs.getString(7));
                e.setFoto(rs.getString(8));
                e.setCAMAS(rs.getString(9));
                e.setBAÑOS(rs.getString(10));
                e.setAC(rs.getString(11));
                e.setTV(rs.getString(12));
            }
            cn.close();
            ps.close();
                }catch(SQLException a){
            System.out.println("Error :"+a.getMessage());
        }
        return e;
    }

    @Override
    public String delete(Integer id) {
       String result = null;
       String sql = "Delete from habitaciones where No_Habitacion=?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            result="Borrado";
        } catch (Exception a) {
            result =  a.getMessage();
        }
        return result;
    }

    @Override
    public String update(Habitacion e) {
      String result = null ;
     String sql = "UPDATE habitaciones SET Tipo_Ha=?,Capacidad=?,Estatus=?, Costo = ?, PISO=?,CUARTOS=?,foto=?,CAMAS=?,BAÑOS=?,AC=?,TV=? Where No_Habitacion=?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, e.getTipo());
            ps.setInt(2, e.getCapacidad());
            ps.setString(3, e.getEstatus());
            ps.setInt(4,  e.getCosto());
            ps.setString(5, e.getPISO());
            ps.setString(6,e.getCUARTOS());
            ps.setString(7, e.getFoto());
            ps.setString(8, e.getCAMAS());
            ps.setString(9, e.getBAÑOS());
            ps.setString(10, e.getAC());
            ps.setString(11, e.getTV());
            ps.setInt(12, e.getNoH());
            ps.executeUpdate();
            result="Cambio";
            cn.close();
            ps.close();
        } catch (Exception a) {
            result = a.getMessage();
        }
        return result;
    }
    
    public ArrayList<Habitacion> busquedapornombre(String busqueda) {
        ArrayList<Habitacion> list = null;
        String sql = "SELECT * FROM `habitaciones` WHERE Estatus LIKE \"%"+busqueda+"%\" OR No_Habitacion LIKE \"%"+busqueda+"%\" OR Capacidad LIKE \"%"+busqueda+"%\"";
        try {
            Connection cn = db.getConnection();
            try (PreparedStatement st = cn.prepareStatement(sql); ResultSet rs = st.executeQuery(sql)) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Habitacion c = new Habitacion();
                    c.setNoH(rs.getInt(1));
                    c.setTipo(rs.getString(2));
                    c.setCapacidad(rs.getInt(3));
                    c.setEstatus(rs.getString(4));
                    c.setCosto(rs.getInt(5));
                    c.setPISO(rs.getString(6));
                    c.setCUARTOS(rs.getString(7));
                    c.setFoto(rs.getString(8));
                    c.setCAMAS(rs.getString(9));
                    c.setBAÑOS(rs.getString(10));
                    c.setAC(rs.getString(11));
                    c.setTV(rs.getString(12));
                    list.add(c);
                }
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }
   @SuppressWarnings("empty-statement")
   
     public ArrayList<No_Habi> No_habitacion() {
        ArrayList<No_Habi> list=null;
     String sql = "SELECT No_Habitacion , Costo FROM habitaciones WHERE Estatus=\"ACTIVO\";";
        try {
           Connection cn= db.getConnection();
         PreparedStatement st = cn.prepareStatement(sql);
         ResultSet rs= st.executeQuery(sql);
         list = new ArrayList <> ();
         while(rs.next()){
         No_Habi c = new No_Habi();
         c.setHabitacionNO(rs.getInt(1));
         c.setCosto(rs.getInt(2));
         list.add(c);
         }
         cn.close();
        } catch (SQLException e) {
           System.out.println("Error"+e.getMessage());
           }
    
        return list;
     }
     
    public String Estado(Habitacion e) {
      String result = null ;
     String sql = "UPDATE habitaciones SET Estatus=? Where No_Habitacion=?";
        try {
            PreparedStatement ps;
          try (Connection cn = db.getConnection()) {
              ps = cn.prepareStatement(sql);
              ps.setString(1, e.getEstatus());
              ps.setInt(2, e.getNoH());
              ps.executeUpdate();
              result="Cambio";
          }
            ps.close();
        } catch (SQLException a) {
            result = a.getMessage();
        }
        return result;
    }
    
}
