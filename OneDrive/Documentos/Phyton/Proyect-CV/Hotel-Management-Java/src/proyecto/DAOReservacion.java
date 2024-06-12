package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import pBase.ConectaB;

public class DAOReservacion implements DAO<Reservacion> {

    public ConectaB db;

    public DAOReservacion() {
        db = new ConectaB();

    }

    @Override
    public ArrayList<Reservacion> list() {
        ArrayList<Reservacion> list = null;
        String sql = "select * from reservaciones";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Reservacion>();
            while (rs.next()) {
                Reservacion c = new Reservacion();
                c.setFolio(rs.getInt(1));
                c.setCliente(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setEstatus(rs.getString(4));
                c.setOcupantes(rs.getInt(5));
                c.setExtras(rs.getString(6));
                c.setFechaS(rs.getDate(7));
                c.setFechaE(rs.getDate(8));
                c.setHabitacion(rs.getString(9));
                c.setCosto(rs.getInt(10));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        return list;
    }

    @Override
    public String Insertar(Reservacion e) {
        String result = null;
        String sql = "INSERT INTO reservaciones(Cliente,Nombre,Estado,No_personas,Servicios_Ex,Fecha_Ingreso,Fecha_Salida,Habitacion,Costo)" + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getCliente());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getEstatus());
            ps.setInt(4, e.getOcupantes());
            ps.setString(5, e.getExtras());
            ps.setDate(6, (Date) e.getFechaE());
            ps.setDate(7, (Date) e.getFechaS());
            ps.setString(8, e.getHabitacion());
            ps.setInt(9, e.getCosto());
            ps.executeUpdate();
            ps.close();
            cn.close();
            result = "elemento insertado";
        } catch (SQLException a) {

            result = a.getMessage();
        }
        return result;
    }

    @Override
    public Integer id() {
        Integer id = 0;
        String sql = "select max(No_Folio) + 1 as codigo from reservaciones";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            ps.close();
            cn.close();
            System.out.println("" + id.getClass());
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
        return id;
    }
    @Override
    public Reservacion get(Integer id) {
        Reservacion e = null;
        String sql = "Select * from reservaciones where No_Folio=?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new Reservacion();
                e.setFolio(rs.getInt(1));
                e.setCliente(rs.getInt(2));
                e.setNombre(rs.getString(3));
                e.setEstatus(rs.getString(4));
                e.setOcupantes(rs.getInt(5));
                e.setExtras(rs.getString(6));
                e.setFechaE(rs.getDate(7));
                e.setFechaS(rs.getDate(8));
                e.setHabitacion(rs.getString(9));
                e.setCosto(rs.getInt(10));

            }
            cn.close();
            ps.close();
        } catch (SQLException a) {
            System.out.println("Error :" + a.getMessage());
        }
        return e;
    }
    @Override
    public String delete(Integer id) {
        String result = null;
        String sql = "Delete from reservaciones where No_Folio=?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            result = "Borrado";
        } catch (Exception a) {
            result = a.getMessage();
        }
        return result;
    }

    @Override
    public String update(Reservacion e) {
        String result = null;
        String sql = "UPDATE reservaciones SET Cliente=?,Nombre=?,Estado=?,No_personas=?,Servicios_Ex=?,Fecha_Ingreso=?,Fecha_Salida=?,Habitacion=?,Costo=? WHERE No_Folio=?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, e.getCliente());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getEstatus());
            ps.setInt(4, e.getOcupantes());
            ps.setString(5, e.getExtras());
            ps.setDate(6, (Date) e.getFechaE());
            ps.setDate(7, (Date) e.getFechaS());
            ps.setString(8, e.getHabitacion());
            ps.setInt(9, e.getCosto());
            ps.setInt(10, e.getFolio());
            ps.executeUpdate();
            cn.close();
            ps.close();
            result = "cambio";
        } catch (SQLException a) {
            result = a.getMessage();
        }
        return result;
    }

    public ArrayList<Reservacion> busquedapornombre(String busqueda) {
        ArrayList<Reservacion> list = null;
        String sql = "SELECT * FROM `reservaciones` WHERE Cliente LIKE \"%" + busqueda + "%\" OR Estado LIKE \"%" + busqueda + "%\" OR Nombre LIKE \"%" + busqueda + "%\"";
        System.out.println(sql);
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Reservacion>();
            while (rs.next()) {
                Reservacion c = new Reservacion();
                c.setFolio(rs.getInt(1));
                c.setCliente(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setEstatus(rs.getString(4));
                c.setOcupantes(rs.getInt(5));
                c.setExtras(rs.getString(6));
                c.setFechaS(rs.getDate(7));
                c.setFechaE(rs.getDate(8));
                c.setHabitacion(rs.getString(9));
                c.setCosto(rs.getInt(10));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        return list;
    }
public ArrayList<Reservacion> busquedaO(int habitacion, String reservacion) {
        ArrayList<Reservacion> list = null;
        String sql = "SELECT * FROM `reservaciones` WHERE Estado LIKE \"%" + reservacion+"%\"  AND Habitacion  LIKE \"%" + habitacion + "%\"";
        System.out.println(sql);
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Reservacion>();
            while (rs.next()) {
                Reservacion c = new Reservacion();
                c.setFolio(rs.getInt(1));
                c.setCliente(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setEstatus(rs.getString(4));
                c.setOcupantes(rs.getInt(5));
                c.setExtras(rs.getString(6));
                c.setFechaS(rs.getDate(7));
                c.setFechaE(rs.getDate(8));
                c.setHabitacion(rs.getString(9));
                c.setCosto(rs.getInt(10));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        return list;
    }
public ArrayList<Reservacion> busquedaR(int habitacion) {
        ArrayList<Reservacion> list = null;
        String sql = "SELECT * FROM `reservaciones` WHERE   Habitacion LIKE \"%" + habitacion +"%\"  AND (Estado  LIKE \"RESERVADO\"  OR Estado  LIKE \"ACTIVO\")";
        System.out.println(sql);
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Reservacion>();
            while (rs.next()) {
                Reservacion c = new Reservacion();
                c.setFolio(rs.getInt(1));
                c.setCliente(rs.getInt(2));
                c.setNombre(rs.getString(3));
                c.setEstatus(rs.getString(4));
                c.setOcupantes(rs.getInt(5));
                c.setExtras(rs.getString(6));
                c.setFechaS(rs.getDate(7));
                c.setFechaE(rs.getDate(8));
                c.setHabitacion(rs.getString(9));
                c.setCosto(rs.getInt(10));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }

        return list;
    }

public String Estado(Reservacion e) {
      String result = null ;
     String sql = "UPDATE reservaciones SET Estado=? Where No_Folio=?";
        try {
            PreparedStatement ps;
          try (Connection cn = db.getConnection()) {
              ps = cn.prepareStatement(sql);
              ps.setString(1, e.getEstatus());
              ps.setInt(2, e.getFolio());
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
