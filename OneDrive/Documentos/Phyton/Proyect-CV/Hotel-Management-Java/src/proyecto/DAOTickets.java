package proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import proyecto.ConectaBD;
import proyecto.ConectaBD;
import proyecto.ConectaBD;
import proyecto.DAO;
import proyecto.DAO;
import proyecto.DAO;
import proyecto.Tickets;
import proyecto.Tickets;
public class DAOTickets implements DAO<Tickets> {

    public ConectaBD db;
    Tickets g;

    public DAOTickets() {
        db = new ConectaBD();
    }

//   @Override
    public ArrayList<Tickets> list() {
        ArrayList<Tickets> list = null;
        String sql = "select * from mantenimiento";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Tickets>();
            while (rs.next()) {
                Tickets t = new Tickets();
                t.setNo_Folio(rs.getInt(1));
                t.setTipo(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setEmision(rs.getDate(4));
                t.setHabitacion(rs.getString(5));
                t.setEmpleado(rs.getString(6));
                t.setStatus(rs.getString(7));
                t.setResolucion(rs.getDate(8));
                list.add(t);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }

    //  @Override
    

    //@Override
    public Integer id() {
        Integer id = 0;
        String sql = " select max(No_Folio) + 1 as codigo from mantenimiento "; ///
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
    public Tickets get(Integer id) {
        Tickets tiket = null;   // (tiket ==> ticket_mantenimiento)
        String sql = " select * from mantenimiento where No_Folio=? ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            tiket = new Tickets();
            if (rs.next()) {
                tiket.setNo_Folio(rs.getInt(1));
                tiket.setTipo(rs.getString(2));
                tiket.setDescripcion(rs.getString(3));
                tiket.setEmision(rs.getDate(4));
                tiket.setHabitacion(rs.getString(5));
                tiket.setEmpleado(rs.getString(6));
                tiket.setStatus(rs.getString(7));
                tiket.setResolucion(rs.getDate(8));
            }
            cn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return tiket;
    }

    //@Override
    public String delete(Integer id) {
        String result = null;
        String sql = " delete from mantenimiento where No_Folio =? ";
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
    public String update(Tickets e) {
        String result = null;
        String sql = " UPDATE mantenimiento"
                + " SET Tipo =?, Descripcion =?, Emision =?,Habitacion =?, Empleado =?, Status =?, Resolucion =? "
                + "WHERE No_Folio = ?";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, e.getTipo());
            ps.setString(2, e.getDescripcion());
            ps.setDate(3, (Date) e.getEmision());
            ps.setString(4, e.getHabitacion());
            ps.setString(5, e.getEmpleado());
            ps.setString(6, e.getStatus());
            ps.setDate(7,(Date) e.getResolucion());
            ps.setInt(8, e.getNo_Folio());
            System.out.println(ps);
            ps.executeUpdate();
            cn.close();
            ps.close();
            result="Actualizado";
        } catch (SQLException i) {
            result = i.getMessage();
        }
        return result;

    }

    public ArrayList<Tickets> busquedapornombre (String busqueda) {
        ArrayList<Tickets> list = null;
        String sql = "SELECT * FROM `mantenimiento` WHERE No_Folio LIKE \"%" + busqueda + "%\" OR Empleado LIKE \"%" + busqueda + "%\" OR Habitacion LIKE \"%" + busqueda + "%\"";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Tickets>();
            while (rs.next()) {
                Tickets v = new Tickets();
                v.setNo_Folio(rs.getInt(1));
                v.setTipo(rs.getString(2));
                v.setDescripcion(rs.getString(3));
                v.setEmision(rs.getDate(4));
                v.setHabitacion(rs.getString(5));
                v.setEmpleado(rs.getString(6));
                v.setStatus(rs.getString(7));
                v.setResolucion(rs.getDate(8));
                list.add(v);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
    }

    @Override
    public String Insertar(Tickets e) {
        String result = null;
        String sql = " INSERT INTO mantenimiento (Tipo,Descripcion,Emision,"
                + "Habitacion,Empleado, Status,Resolucion) "
                + " VALUES (?,?,?,?,?,?,?) ";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, e.getTipo());
            ps.setString(2, e.getDescripcion());
            ps.setDate(3, (Date) e.getEmision());
            ps.setString(4, e.getHabitacion());
            ps.setString(5, e.getEmpleado());
            ps.setString(6, e.getStatus());
            ps.setDate(7,(Date) e.getResolucion());
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
