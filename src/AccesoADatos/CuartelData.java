package AccesoADatos;

import Entidades.Cuartel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Development
 */
public class CuartelData {

    private Connection con;

    public CuartelData() {
        con = Conexion.getConexion();
    }

    //nuevo cuartel
    public void cargarCuartel(Cuartel cuartel) {
        String cargarCuartel = "INSERT INTO cuartel (codCuartel, nombre, domicilio, coord_X, coord_Y, telefono, correo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement ps = con.prepareStatement(cargarCuartel, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, cuartel.getCodCuartel());
                ps.setString(2, cuartel.getNombre());
                ps.setString(3, cuartel.getDomicilio());
                ps.setInt(4, cuartel.getCoordenadaX());
                ps.setInt(5, cuartel.getCoordenadaY());
                ps.setString(6, cuartel.getTelefono());
                ps.setString(7, cuartel.getCorreo());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    cuartel.setCodCuartel(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Cuartel cargado correctamente");
                }
                rs.close();
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Ya existe un cuartel con ese nombre");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar cuartel: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //metodo hacer modificaciones en un cuartel
    public void modificarCuartel(Cuartel cuartel) {
        String modificarCuartel = "UPDATE cuartel SET codCuartel=?, nombre=?, domicilio=?, codCuartel=? WHERE codBrigada=?";

        try {
            try (PreparedStatement ps = con.prepareStatement(modificarCuartel)) {
                ps.setInt(1, cuartel.getCodCuartel());
                ps.setString(2, cuartel.getNombre());
                ps.setString(3, cuartel.getDomicilio());
                ps.setInt(4, cuartel.getCoordenadaX());
                ps.setInt(5, cuartel.getCoordenadaY());
                ps.setString(6, cuartel.getTelefono());
                ps.setString(7, cuartel.getCorreo());

                int filasActualizadas = ps.executeUpdate();

                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "Cuartel modificado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar el cuartel.");
                }
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el cuartel debido a una restricción de integridad.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar cuartel: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //metodo para buscar un cuartel
    public Cuartel buscar(int codCuartel) {
        Cuartel xx = null;

        String buscarBrigadaSQL = "SELECT codCuartel, nombre, domicilio, coord_X, coord_Y, telefono, correo"
                + " FROM cuartel WHERE codCuartel=?";
        try (PreparedStatement ps = con.prepareStatement(buscarBrigadaSQL)) {
            ps.setInt(1, codCuartel);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                xx = new Cuartel();
                xx.setCodCuartel(rs.getInt("codCuartel"));
                xx.setDomicilio(rs.getString("nombre"));
                xx.setDomicilio(rs.getString("domicilio"));
                xx.setCoordenadaX(rs.getInt("coord_X"));
                xx.setCoordenadaY(rs.getInt("coord_Y"));
                xx.setTelefono(rs.getString("telefono"));
                xx.setCorreo(rs.getString("correo"));

            } else {
                JOptionPane.showMessageDialog(null, "La brigada no existe con ese alias");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la brigada: " + ex.getMessage());
            ex.printStackTrace();
        }
        return xx;
    }

    //metodo para obtener todos los cuarteles
    public List<Cuartel> listarCuarteles() {
        ArrayList<Cuartel> lista = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT codCuartel, nombre, domicilio, "
                + "coord_X, coord_Y, telefono, correo FROM cuartel WHERE codCuartel")) {;
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Cuartel xx = new Cuartel();
                    xx.setCodCuartel(rs.getInt("codCuartel"));
                    xx.setDomicilio(rs.getString("nombre"));
                    xx.setDomicilio(rs.getString("domicilio"));
                    xx.setCoordenadaX(rs.getInt("coord_X"));
                    xx.setCoordenadaY(rs.getInt("coord_Y"));
                    xx.setTelefono(rs.getString("telefono"));
                    xx.setCorreo(rs.getString("correo"));
                    lista.add(xx);
                }
                ps.close();
            } catch (SQLException ex) {

            }
        } catch (SQLException ex) {

        }
        return lista;
    }
}
