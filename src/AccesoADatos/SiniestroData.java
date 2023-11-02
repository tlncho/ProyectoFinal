package AccesoADatos;

import Entidades.Brigada;
import Entidades.Cuartel;
import Entidades.Siniestro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SiniestroData {

    private Connection con;

    public SiniestroData() {
        con = Conexion.getConexion();
    }

    //nuevo cuartel
    public void cargarSiniestro(Siniestro siniestro) {
        String cargarSiniestro = "INSERT INTO siniestro (tipoSiniestro, fechaSiniestro, coordenadaX, coordenadaY, detalles, fechaResolucion, calificacion, idBrigada) "
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement ps = con.prepareStatement(cargarSiniestro, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, siniestro.getTipoSiniestro());
                ps.setDate(2, siniestro.getFechaSiniestro());
                ps.setInt(3, siniestro.getCoordenadaX());
                ps.setInt(4, siniestro.getCoordenadaY());
                ps.setString(5, siniestro.getDetalles());
                ps.setDate(6, siniestro.getFechaResolucion());
                ps.setInt(7, siniestro.getCalificacion());
                ps.setInt(8, siniestro.getIdBrigada());

                JOptionPane.showMessageDialog(null, "Siniestro cargado correctamente");
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El siniestro ya fue cargado anteriormente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar siniestro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //metodo hacer modificaciones en un cuartel
    public void modificarSiniestro(Siniestro siniestro) {
        //revisar el where si quedaria asi
        String modificarSiniestro = "UPDATE siniestro SET tipoSiniestro=?, fechaSiniestro=?, coordenadaX=?, coordenadaY=?, detalles=?, fechaResolucion=?, calificacion=?, idBrigada=?";

        try {
            try (PreparedStatement ps = con.prepareStatement(modificarSiniestro)) {
                ps.setString(1, siniestro.getTipoSiniestro());
                ps.setDate(2, siniestro.getFechaSiniestro());
                ps.setInt(3, siniestro.getCoordenadaX());
                ps.setInt(4, siniestro.getCoordenadaY());
                ps.setString(5, siniestro.getDetalles());
                ps.setDate(6, siniestro.getFechaResolucion());
                ps.setInt(7, siniestro.getCalificacion());
                ps.setInt(8, siniestro.getIdBrigada());

                int filasActualizadas = ps.executeUpdate();

                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, "Siniestro modificado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar el siniestro.");
                }
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el siniestro debido a una restricción de integridad.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar siniestro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    //metodo para buscar un cuartel
    public Siniestro buscar(int idSiniestro) {
        Siniestro xx = null;
        String buscarSiniestroSQL = "SELECT (tipoSiniestro, fechaSiniestro, coordenadaX, coordenadaY, detalles, fechaResolucion, calificacion, idBrigada)"
                + " FROM siniestro WHERE idSiniestro=?";
        try (PreparedStatement ps = con.prepareStatement(buscarSiniestroSQL)) {
            ps.setInt(1, idSiniestro);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                xx = new Siniestro();
                xx.setTipoSiniestro(rs.getString("tipoSiniestro"));
                xx.setFechaSiniestro(rs.getDate("fechaSiniestro"));
                xx.setCoordenadaX(rs.getInt("coordenadaX"));
                xx.setCoordenadaY(rs.getInt("coordenadaY"));
                xx.setDetalles(rs.getString("detalles"));
                xx.setFechaResolucion(rs.getDate("fechaResolucion"));
                xx.setCalificacion(rs.getInt("calificacion"));
                xx.setCalificacion(rs.getInt("calificacion"));
                xx.setIdBrigada(rs.getInt("idBrigada"));

            } else {
                JOptionPane.showMessageDialog(null, "La brigada no existe con ese alias");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la brigada: " + ex.getMessage());
            ex.printStackTrace();
        }
        return xx;
    }

    //metodo para obtener todos los siniestros
    public List<Siniestro> listarSiniestros() {
        ArrayList<Siniestro> lista = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("SELECT tipoSiniestro, fechaSiniestro, coordenadaX, coordenadaY, detalles, fechaResolucion, calificacion, idBrigada)")) {;
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Siniestro xx = new Siniestro();
                    xx.setTipoSiniestro(rs.getString("tipoSiniestro"));
                    xx.setFechaSiniestro(rs.getDate("fechaSiniestro"));
                    xx.setCoordenadaX(rs.getInt("coordenadaX"));
                    xx.setCoordenadaY(rs.getInt("coordenadaY"));
                    xx.setDetalles(rs.getString("detalles"));
                    xx.setFechaResolucion(rs.getDate("fechaResolucion"));
                    xx.setCalificacion(rs.getInt("calificacion"));
                    xx.setCalificacion(rs.getInt("calificacion"));
                    xx.setIdBrigada(rs.getInt("idBrigada"));
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
