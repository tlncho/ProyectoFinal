package AccesoADatos;

import Entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class BrigadaData {

    private Connection con;

    public BrigadaData() {
        con = Conexion.getConexion();
    }

    //se cargo cun alias que ya no exista y ese es el identificador unico para el usuario
    public void cargarBrigada(Brigada brigada) {
        String cargarBrigada = "INSERT INTO brigada (aliasBrigada, especialidad, estado, codCuartel) VALUES (?, ?, ?, ?)";
        try {
            try (PreparedStatement ps = con.prepareStatement(cargarBrigada, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, brigada.getAliasBrigada());
                ps.setString(2, brigada.getEspecialidad());
                ps.setBoolean(3, brigada.isEstado());
                ps.setInt(4, brigada.getCodCuartel().getIdCuartel());

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
        String actualizarBrigada = "UPDATE brigada SET aliasBrigada=?, especialidad=?, estado=?, codCuartel=? WHERE codBrigada=?";

        try {
            try (PreparedStatement ps = con.prepareStatement(actualizarBrigada)) {
                ps.setString(1, brigada.getAliasBrigada());
                ps.setString(2, brigada.getEspecialidad());
                ps.setBoolean(3, brigada.isEstado());
                ps.setInt(4, brigada.getCodCuartel().getIdCuartel());

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

    //se busca por alias que es identificador unico para el usuario
    public Brigada buscarBrigada(String aliasBrigada) {
        Brigada br = null;

        String buscarBrigadaSQL = "SELECT aliasBrigada, especialidad, estado, codCuartel FROM brigada WHERE aliasBrigada=?";
        try (PreparedStatement ps = con.prepareStatement(buscarBrigadaSQL)) {
            ps.setString(1, aliasBrigada);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                br = new Brigada(); 
                br.setAliasBrigada(rs.getString("aliasBrigada"));
                br.setEspecialidad(rs.getString("especialidad"));
                br.setEstado(rs.getBoolean("estado"));

                Cuartel cuartel = new Cuartel();
                cuartel.setCodCuartel(rs.getInt("codCuartel"));
                br.setCodCuartel(cuartel);
            } else {
                JOptionPane.showMessageDialog(null, "La brigada no existe con ese alias");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la brigada: " + ex.getMessage());
            ex.printStackTrace();
        }
        return br;
    }

//   este lo dejo pero no ocuparemos borrados fisicos
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
        try (PreparedStatement ps = con.prepareStatement("SELECT aliasBrigada, especialidad,"
                + " estado FROM brigada WHERE aliasBrigada ")) {;
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Brigada bri = new Brigada();
                    bri.setAliasBrigada(rs.getString("aliasBrigada"));
                    bri.setEspecialidad(rs.getString("especialidad"));
                    bri.setEstado(rs.getBoolean("estado"));

                    Cuartel cuartel = new Cuartel();
                    cuartel.setCodCuartel(rs.getInt("codCuartel"));
                    bri.setCodCuartel(cuartel);
                    listaBrig.add(bri);
                }
                ps.close();
            } catch (SQLException ex) {

            }
        } catch (SQLException ex) {

        }
        return listaBrig;
    }

}
