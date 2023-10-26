package AccesoADatos;

import Entidades.*;
import AccesoADatos.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Development
 */
public class BomberoData {

    private final Connection con;

    public BomberoData() {
        con = Conexion.getConexion();
    }

    public void guardarBombero(Bombero bom) {
        String sql = "INSERT INTO bombero (dni, nombre_ape, fecha_nac, celular, codBrigada) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, bom.getDni());
            ps.setString(2, bom.getNombreCompleto());
            ps.setDate(3, Date.valueOf(bom.getFechaNacimiento()));
            ps.setString(4, bom.getCelular());

            int idBrigada = bom.getIdBrigada().getIdBrigada();
            ps.setInt(5, idBrigada);

            int filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        bom.setIdBombero(rs.getInt(1));
                    }
                }
                JOptionPane.showMessageDialog(null, "Se cargó el bombero correctamente!!");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cargar el bombero.");
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Ya existe ese DNI");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar el bombero: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void modificarBombero(Bombero bom) {
        String sql = "UPDATE bombero SET dni=?, nombre_ape=?, fecha_nac=?, celular=?, codBrigada=? WHERE idBombero=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, bom.getDni());
            ps.setString(2, bom.getNombreCompleto());
            ps.setDate(3, Date.valueOf(bom.getFechaNacimiento()));
            ps.setString(4, bom.getCelular());

            int idBrigada = bom.getIdBrigada().getIdBrigada();
            ps.setInt(5, idBrigada);

            ps.setInt(6, bom.getIdBombero());

            int filasModificadas = ps.executeUpdate();

            if (filasModificadas > 0) {
                JOptionPane.showMessageDialog(null, "Bombero modificado correctamente!!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Bombero buscarBombero(int idBombero) {
        Bombero bom = null;
        String buscarBombero = "SELECT dni, nombre_ape, fecha_nac, celular FROM bombero WHERE idBombero=?";
        try (PreparedStatement ps = con.prepareStatement(buscarBombero)) {
            ps.setInt(1, idBombero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bom = new Bombero();
                bom.setIdBombero(idBombero);
                ps.setInt(1, bom.getDni());
                ps.setString(2, bom.getNombreCompleto());
                ps.setDate(3, Date.valueOf(bom.getFechaNacimiento()));
                ps.setString(4, bom.getCelular());
            } else {
                JOptionPane.showMessageDialog(null, "El bombero no existe");
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar el alumno: " + ex.getMessage());
        }
        return bom;
    }

    public Bombero buscarBomberoPorDni(int dni) {
        Bombero bom = null;
        String buscarDni = "SELECT idBombero, dni, nombre_ape, fecha_nac, celular, codBrigada FROM bombero WHERE dni=?";
        try (PreparedStatement ps = con.prepareStatement(buscarDni)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bom = new Bombero();
                bom.setIdBombero(rs.getInt("idBombero"));
                bom.setDni(rs.getInt("dni"));
                bom.setNombreCompleto(rs.getString("nombre_ape"));
                bom.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());

                int idBrigada = rs.getInt("idBrigada");

                bom.setIdBrigada(idBrigada);

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un bombero con ese número de DNI");
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar el bombero por DNI: " + ex.getMessage());
        }
        return bom;
    }

    public List<Bombero> obtenerBomberos() {
        ArrayList<Bombero> lista = new ArrayList<>();
        String consulta = "SELECT idBombero, dni, nomabre_ape, fechaNac, celular, idBrigada FROM bombero ";

        try (PreparedStatement ps = con.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Bombero bom = new Bombero();
                bom.setIdBombero(rs.getInt("idBombero"));
                bom.setDni(rs.getInt("dni"));
                bom.setNombreCompleto(rs.getString("nombre_ape"));
                bom.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                bom.setIdBrigada(rs.getInt("idBrigada"));
                lista.add(bom);
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de bomberos: " + ex.getMessage());
        }

        return lista;
    }

    public void eliminarBombero(int dni) {
        Bombero bom = buscarBombero(dni);
        if (bom != null) {
            String eliminarBombero = "DELETE FROM bombero WHERE dni = ?";
            try {
                try (PreparedStatement ps = con.prepareStatement(eliminarBombero)) {
                    ps.setInt(1, dni);
                    int filasAfectadas = ps.executeUpdate();
                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "Se elimino al bombero");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se eliminar al bombero");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar al bombero: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El bombero no existe");
        }
    }

    public List<Bombero> obtenerListaBomberos(int orden) {
        ArrayList<Bombero> lista = new ArrayList<>();
        String sql = formarSQL(orden);
        try {
            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bombero bom = new Bombero();

                    bom.setIdBombero(rs.getInt("idBombero"));
                    bom.setDni(rs.getInt("dni"));
                    bom.setNombreCompleto(rs.getString("nombre_ape"));
                    bom.setFechaNacimiento(rs.getDate("fechaNac").toLocalDate());
                    bom.setIdBrigada(rs.getInt("idBrigada"));
                    lista.add(bom);
                }
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de alumnos: " + ex.getMessage());
        }
        return lista;
    }

    private String formarSQL(int orden) {
        StringBuilder sql = new StringBuilder("SELECT idBombero, dni, nombre_ape, fechaNac, celular, idBrigada FROM bombero");

        switch (orden) {
            case 1:
                sql.append(" ORDER BY dni");
                break;
            case 2:
                sql.append(" ORDER BY nombre_ape");
                break;
            case 3:
                sql.append(" ORDER BY fechaNac");
                break;
            case 4:
                sql.append(" ORDER BY celular");
                break;
            case 5:
                sql.append(" ORDER BY idBrigada");
            default:
                sql.append(" ORDER BY idBombero");
                break;
        }

        return sql.toString();
    }

}
