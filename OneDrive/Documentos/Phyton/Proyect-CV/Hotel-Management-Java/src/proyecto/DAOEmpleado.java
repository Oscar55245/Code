package proyecto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * @author dany9
 */

public class DAOEmpleado implements DAO <Empleado> {
        
    public ConectaBD db;
    
    public DAOEmpleado (){
        db = new ConectaBD();
    }

    @Override
    public ArrayList<Empleado> list() {
        ArrayList<Empleado> list = null;
        String sql = "select * from empleado";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Empleado>();
            while (rs.next()) {
                Empleado c = new Empleado();
                c.setID(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setPaterno(rs.getString(3));
                c.setMaterno(rs.getString(4));
                c.setCurp(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setSexo(rs.getString(8));
                c.setPuesto(rs.getString(10));
                c.setIngreso(rs.getDate(11));
                c.setEmail(rs.getString(12));
                c.setOpcEmail(rs.getString(13));
                c.setStatus(rs.getString(14));
                c.setFoto(rs.getString(15));
                c.setPass(rs.getString(16));
                c.setRepass(rs.getString(17));
                c.setUsuario(rs.getString(18));
                list.add(c);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }

    @Override
    public String Insertar(Empleado e) {
        String result = null;
        String sql = " INSERT INTO empleado (nombre,paterno,materno,curp,direccion,telefono,sexo,nacimiento,puesto,ingreso,email,opcemail,status,foto,password,repassword,usuario) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPaterno());
            ps.setString(3, e.getMaterno());
            ps.setString(4, e.getCurp());
            ps.setString(5, e.getDireccion());
            ps.setString(6, e.getTelefono());
            ps.setString(7, e.getSexo());
            ps.setString(9, e.getPuesto());
            ps.setDate(10, (Date) e.getIngreso());
            ps.setString(11, e.getEmail());
            ps.setString(12, e.getOpcEmail());
            ps.setString(13, e.getStatus());
            ps.setString(14, e.getFoto());
            ps.setString(15, e.getPass());
            ps.setString(16, e.getRepass());
            ps.setString(17, e.getUsuario());
            ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (SQLException e2) {
            result = e2.getMessage();
        }
        return result;
    }

    @Override
    public Integer id() {
        Integer id = 0;
        String sql = " select max(ID) + 1 as codigo from empleado ";
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
            System.out.println("Error : " + e.getMessage());
        }
        return id;
    }

    @Override
    public Empleado get(Integer id) {
        Empleado empleado = null;
        String sql = " select * from empleado where ID_Empleado=? ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            empleado = new Empleado();
            if (rs.next()) {
                empleado.setID(rs.getInt(1));
                empleado.setNombre(rs.getString(2));
                empleado.setPaterno(rs.getString(3));
                empleado.setMaterno(rs.getString(4));
                empleado.setCurp(rs.getString(5));
                empleado.setDireccion(rs.getString(6));
                empleado.setTelefono(rs.getString(7));
                empleado.setSexo(rs.getString(8));
                empleado.setPuesto(rs.getString(10));
                empleado.setIngreso(rs.getDate(11));
                empleado.setEmail(rs.getString(12));
                empleado.setOpcEmail(rs.getString(13));
                empleado.setStatus(rs.getString(14));
                empleado.setFoto(rs.getString(15));
                empleado.setPass(rs.getString(16));
                empleado.setRepass(rs.getString(17));
                empleado.setUsuario(rs.getString(18));
            }
            cn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return empleado;
    }

    @Override
    public String delete(Integer id) {
        String result = null;
        String sql = "delete from empleado where ID_Empleado =?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Empleado e) {
        String result = null;
        String sql = " UPDATE empleado "
                + " SET nombre =?,paterno =?,materno =?,curp =?,direccion =?,telefono =?,sexo =?,nacimiento =?,puesto =?,ingreso =?,email =?,opcemail =?,status =?,foto =?,password =?,repassword =?,usuario =? "
                + " WHERE ID_Empleado = ? ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPaterno());
            ps.setString(3, e.getMaterno());
            ps.setString(4, e.getCurp());
            ps.setString(5, e.getDireccion());
            ps.setString(6, e.getTelefono());
            ps.setString(7, e.getSexo());
            ps.setString(9, e.getPuesto());
            ps.setDate(10, (Date) e.getIngreso());
            ps.setString(11, e.getEmail());
            ps.setString(12, e.getOpcEmail());
            ps.setString(13, e.getStatus());
            ps.setString(14, e.getFoto());
            ps.setString(15, e.getPass());
            ps.setString(16, e.getRepass());
            ps.setString(17, e.getUsuario());
            ps.setInt(18, e.getID());
            ps.executeUpdate();
            cn.close();
            ps.close();
        } catch (SQLException e2) {
            result = e2.getMessage();
        }
        return result;
    }
    
     public ArrayList<Empleado> busquedapornombre(String busqueda) {
        ArrayList<Empleado> list = null;
        String sql = "SELECT * FROM `empleado` WHERE paterno LIKE \"%"+busqueda+"%\" OR materno LIKE \"%"+busqueda+"%\" OR nombre LIKE \"%"+busqueda+"%\"";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Empleado>();
            while (rs.next()) {
                Empleado c = new Empleado();
                c.setID(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setPaterno(rs.getString(3));
                c.setMaterno(rs.getString(4));
                c.setCurp(rs.getString(5));
                c.setDireccion(rs.getString(6));
                c.setTelefono(rs.getString(7));
                c.setSexo(rs.getString(8));
                c.setPuesto(rs.getString(10));
                c.setIngreso(rs.getDate(11));
                c.setEmail(rs.getString(12));
                c.setOpcEmail(rs.getString(13));
                c.setStatus(rs.getString(14));
                c.setFoto(rs.getString(15));
                c.setPass(rs.getString(16));
                c.setRepass(rs.getString(17));
                c.setUsuario(rs.getString(18));
                list.add(c);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }
     
     public Empleado login(String usuario, String password){
        Empleado empleado = null;
        String sql = " select * from empleado where usuario =? and password =? ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setID(rs.getInt(1));
                empleado.setNombre(rs.getString(2));
                empleado.setPaterno(rs.getString(3));
                empleado.setMaterno(rs.getString(4));
                empleado.setCurp(rs.getString(5));
                empleado.setDireccion(rs.getString(6));
                empleado.setTelefono(rs.getString(7));
                empleado.setSexo(rs.getString(8));
                empleado.setNacimiento(rs.getString(9));
                empleado.setPuesto(rs.getString(10));
                empleado.setEmail(rs.getString(12));
                empleado.setOpcEmail(rs.getString(13));
                empleado.setStatus(rs.getString(14));
                empleado.setFoto(rs.getString(15));
                empleado.setPass(rs.getString(16));
                empleado.setRepass(rs.getString(17));
                empleado.setUsuario(rs.getString(18));
                System.out.println(empleado);
            }
            cn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return empleado;
    }
     
}
