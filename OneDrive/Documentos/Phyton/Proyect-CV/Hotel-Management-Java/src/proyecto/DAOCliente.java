package proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import proyecto.ConectaBD;
import proyecto.DAO;

// @author Danny
public class DAOCliente implements DAO<Cliente> {

    public ConectaBD db;
    Cliente g;

    public DAOCliente() {
        db = new ConectaBD();
    }

//   @Override
    public ArrayList<Cliente> list() {
        ArrayList<Cliente> list = null;
        String sql = "select * from cliente";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente v = new Cliente();
                v.setID_Cliente(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setPaterno(rs.getString(3));
                v.setMaterno(rs.getString(4));
                v.setTelefono(rs.getString(5));
                v.setEmail(rs.getString(6));
                v.setOpcEmail(rs.getString(7));
                v.setNacimiento(rs.getDate(8));
                list.add(v);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }

    //@Override
    public Integer id() {
        Integer id = 0;
        String sql = " select max(ID_Clientecliente) + 1 as codigo from cliente "; ///
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
            System.out.println(" Error : " + e.getMessage());
        }
        return id;

    }

    //@Override
    public Cliente get(Integer id) {
        Cliente cliente = null;
        String sql = " select * from cliente where ID_Cliente=? ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            cliente = new Cliente();
            if (rs.next()) {
                cliente.setID_Cliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setPaterno(rs.getString(3));
                cliente.setMaterno(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setEmail(rs.getString(6));
                cliente.setOpcEmail(rs.getString(7));
                cliente.setNacimiento(rs.getDate(8));
            }
            cn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return cliente;
    }

    //@Override
    public String delete(Integer id) {
        String result = null;
        String sql = " delete from cliente where ID_Cliente =? ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            result = "Eliminado";
        } catch (SQLException e) {
            result = e.getMessage();
        }
        return result;

    }

    //@Override
    public String update(Cliente e) {
        String result = null;
        String sql = " UPDATE cliente"
                + " SET Nombre =?, Paterno =?, Materno =?, Telefono =?, Email =?, opcemail =?, Nacimiento =? "
                + "WHERE ID_Cliente = ?";
        try {

            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPaterno());
            ps.setString(3, e.getMaterno());
            ps.setString(4, e.getTelefono());
            ps.setString(5, e.getEmail());
            ps.setString(6, e.getOpcEmail());
            ps.setDate(7, (Date) e.getNacimiento());
            ps.setInt(8, e.getID_Cliente());
            ps.executeUpdate();
            cn.close();
            ps.close();
            result = "Actualizado";
        } catch (SQLException i) {
            result = i.getMessage();
        }
        return result;

    }

    public ArrayList<Cliente> busquedapornombre(String busqueda) {
        ArrayList<Cliente> list = null;
        String sql = "SELECT * FROM `cliente` WHERE ID_Cliente LIKE \"%" + busqueda + "%\" OR Nombre LIKE \"%" + busqueda + "%\" OR Telefono LIKE \"%" + busqueda + "%\"";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente v = new Cliente();
                v.setID_Cliente(rs.getInt(1));
                v.setNombre(rs.getString(2));
                v.setPaterno(rs.getString(3));
                v.setMaterno(rs.getString(4));
                v.setTelefono(rs.getString(5));
                v.setEmail(rs.getString(6));
                v.setOpcEmail(rs.getString(7));
                v.setNacimiento(rs.getDate(8));
                list.add(v);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }

    @Override
    public String Insertar(Cliente e) {
        String result = null;
        String sql = " INSERT INTO cliente (ID_Cliente,Nombre,Paterno,Materno,"
                + "Telefono,Email,opcemail, Nacimiento) "
                + " VALUES (?,?,?,?,?,?,?,?) ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, e.getID_Cliente());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getPaterno());
            ps.setString(4, e.getMaterno());
            ps.setString(5, e.getTelefono());
            ps.setString(6, e.getEmail());
            ps.setString(7, e.getOpcEmail());
            ps.setDate(8, (Date) e.getNacimiento());
            ps.executeUpdate();
            ps.close();
            cn.close();
            result = "Agregado";
        } catch (SQLException i) {
            result = i.getMessage();
        }
        return result;
    }
}
