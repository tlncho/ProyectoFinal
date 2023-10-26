package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Development
 */
public class BrigadaData {

    private Connection con;

    public BrigadaData() {
        con = Conexion.getConexion();
    }

    public void cargarBrigada(Brigada brigada) {
        String cargarBrigada = "INSERT INTO brigada (nombre_br, especialidad, estado, nro_cuartel) VALUES (?, ?, ?, ?)";
        try {
            try (PreparedStatement ps = con.prepareStatement(cargarBrigada, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, brigada.getNombre());
                ps.setString(2, brigada.getEspecialidad());
                ps.setBoolean(3, brigada.isEstado());
                ps.setInt(4, brigada.getNroCuartel().getIdCuartel());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    brigada.setIdBrigada(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Brigada cargada correctamente");
                }
                rs.close();
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Ya existe una brigada con ese nombre");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar la brigada: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void modificarBrigada(Brigada brigada) {
        String actualizarBrigada = "UPDATE brigada SET nombre_br=?, especialidad=?, estado=?, nro_cuartel=? WHERE idBrigada=?";

        try {
            try (PreparedStatement ps = con.prepareStatement(actualizarBrigada)) {
                ps.setString(1, brigada.getNombre());
                ps.setString(2, brigada.getEspecialidad());
                ps.setBoolean(3, brigada.isEstado());
                ps.setInt(4, brigada.getNroCuartel().getIdCuartel());

                int filasActualizadas = ps.executeUpdate();

                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "Brigada modificada exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la brigada.");
                }
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar la brigada debido a una restricción de integridad.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la brigada: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Brigada buscarBrigada(int idBrigada) {
        Brigada br = null;

        String buscarBrigadaSQL = "SELECT idBrigada, nombre, especialidad, estado, nro_cuartel FROM brigada WHERE idBrigada=?";
        try (PreparedStatement ps = con.prepareStatement(buscarBrigadaSQL)) {
            ps.setInt(1, idBrigada);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                br.setIdBrigada(rs.getInt("idBrigada"));
                br.setNombre(rs.getString("nombre"));
                br.setEspecialidad(rs.getString("especialidad"));
                br.setEstado(rs.getBoolean("estado"));

                Cuartel cuartel = new Cuartel();
                cuartel.setIdCuartel(rs.getInt("nro_cuartel"));
                br.setNroCuartel(cuartel);
            } else {
                JOptionPane.showMessageDialog(null, "La brigada no existe con ese código");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la brigada: " + ex.getMessage());
            ex.printStackTrace();
        }
        return br;
    }

    public Brigada buscarBrigada(String nombre) {
        Brigada bri = null;
        String bb = "SELECT idBrigada, nombre, especialidad, estado, nro_cuartel FROM brigada WHERE nombre=?";
        try {
            try (PreparedStatement ps = con.prepareStatement(bb)) {
                ps.setString(1, nombre);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    bri = new Brigada();
                    bri.setIdBrigada(rs.getInt("idBrigada"));
                    bri.setNombre(rs.getString("nombre"));
                    bri.setEspecialidad(rs.getString("especialidad"));
                    bri.setEstado(rs.getBoolean("estado"));

                    Cuartel cuartel = new Cuartel();
                    cuartel.setIdCuartel(rs.getInt("nro_cuartel"));
                    bri.setNroCuartel(cuartel);
                } else {
                    JOptionPane.showMessageDialog(null, "La brigada no existe");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la brigada: " + ex.getMessage());
            ex.printStackTrace();
        }
        return bri;
    }

    public void eliminarBrigada(int id) {
        String eliminarBrigada = "DELETE FROM brigada WHERE idBrigada = ?";

        try {
            try (PreparedStatement ps = con.prepareStatement(eliminarBrigada)) {
                ps.setInt(1, id);
                int filasEliminadas = ps.executeUpdate();

                if (filasEliminadas > 0) {
                    JOptionPane.showMessageDialog(null, "Brigada eliminada correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la brigada con ese ID");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar la brigada: " + ex.getMessage());
        }
    }

    public List<Brigada> listarBrigadas() {
        ArrayList<Brigada> listaBrig = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT idMateria, nombre, año, estado FROM materia WHERE estado = 1")) {;
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Brigada br = new Brigada();
                    br.setIdBrigada(rs.getInt("idBrigada"));
                    br.setNombre(rs.getString("nombre"));
                    br.setEspecialidad(rs.getString("especialidad"));
                    br.setEstado(rs.getBoolean("estado"));

                    Cuartel cuartel = new Cuartel();
                    cuartel.setIdCuartel(rs.getInt("nro_cuartel"));
                    br.setNroCuartel(cuartel);
                    listaBrig.add(br);
                }
                ps.close();
            } catch (SQLException ex) {

            }
        } catch (SQLException ex) {

        }
        return listaBrig;
    }

}
