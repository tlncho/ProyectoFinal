package AccesoADatos;

import Entidades.*;
import AccesoADatos.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class BomberoData {

    private final Connection con;

    public BomberoData() {
        con = Conexion.getConexion();
    }

    //listo guardar por codigo de bombero(es unico), no por id
    public void guardarBombero(Bombero bom) {
        String sql = "INSERT INTO bombero (codBombero, dni, nombreCompleto, grupoSang, "
                + "fechaNac, celular, observaciones, aliasBrigada) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, bom.getCodBombero());
            ps.setString(2, bom.getDni());
            ps.setString(3, bom.getNombreCompleto());
            ps.setString(4, bom.getGrupoSang());
            ps.setDate(5, Date.valueOf(bom.getFechaNac()));
            ps.setString(6, bom.getCelular());

            String aliasBrigada = bom.getAliasBrigada().getAliasBrigada();
            ps.setString(7, aliasBrigada);

            int filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        bom.setCodBombero(rs.getInt(1));
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

    //listo modificar por codigo no pir id
    public void modificarBombero(Bombero bom, int codBom) {
        String sql = "UPDATE bombero SET codBombero=?, dni=?, nombreCompleto=?, grupoSang=?, "
                + "fechaNac=?, celular=?, obsrevaciones=?, estado=?, aliasBrigada=? WHERE codBombero=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, bom.getCodBombero());
            ps.setString(2, bom.getDni());
            ps.setString(3, bom.getNombreCompleto());
            ps.setString(4, bom.getGrupoSang());
            ps.setDate(5, Date.valueOf(bom.getFechaNac()));
            ps.setString(6, bom.getCelular());
            ps.setString(7, bom.getObservaciones());
            ps.setBoolean(8, true);

            String aliasBrigada = bom.getAliasBrigada().getAliasBrigada();
            ps.setString(9, aliasBrigada);
            
            ps.setInt(10, codBom);

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

    //listo busqueda por cod de bombero
    public Bombero buscarBombero(int codBombero) {
        Bombero bom = new Bombero();
        BrigadaData bd = new BrigadaData();
        
        
        String query = "SELECT codBombero, dni, nombreCompleto, grupoSang, fechaNac,"
                + " celular, observaciones, estado, aliasBrigada FROM bombero WHERE codBombero=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, codBombero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                
                bom.setDni(rs.getString("dni"));
                bom.setNombreCompleto(rs.getString("nombreCompleto"));
                bom.setGrupoSang(rs.getString("grupoSang"));
                bom.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                bom.setCelular(rs.getString("celular"));
                bom.setObservaciones(rs.getString("observaciones"));
                
                // en orden de poder recuperar el alias correctamente necesito llamar al controlador de brigada
                String aliasBrigada = rs.getString("aliasBrigada");
                Brigada brigadaAsociadaEnBD = bd.buscarBrigada(aliasBrigada);
                
                // y termino finalmente de crear mi modelo de bombero:
                
                bom.setAliasBrigada(brigadaAsociadaEnBD);
                
                
            } else {
                JOptionPane.showMessageDialog(null, "El bombero no existe");
            }
            // importante tmb cerrar la conexion, sino esto no se ejecuta
            ps.close();
            
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al buscar el bombero: " + ex.getMessage());
        }
        return bom;
    }

    //listo
    public List<Bombero> obtenerBomberos() {
        ArrayList<Bombero> lista = new ArrayList<>();
        String consulta = "SELECT b.codBombero, b.dni, b.nombreCompleto, b.grupoSang, b.fechaNac, b.celular, b.observaciones, b.estado, br.idBrigada, br.nombreBrigada, br.especialidad, br.nroCuartel, br.estado AS estadoBrigada, br.aliasBrigada\n"
                + "FROM bombero b\n"
                + "LEFT JOIN brigada br ON b.idBrigada = br.idBrigada;";

        try (PreparedStatement ps = con.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Bombero bom = new Bombero();
                bom.setCodBombero(rs.getInt("codBombero"));
                bom.setDni(rs.getString("dni"));
                bom.setNombreCompleto(rs.getString("nombreCompleto"));
                bom.setGrupoSang(rs.getString("grupoSang"));
                bom.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                bom.setCelular(rs.getString("celular"));
                bom.setObservaciones(rs.getString("observaciones"));
                bom.setEstado(rs.getBoolean("estado"));

                // traemos la brigada para obtener el alias
                Brigada brigada = new Brigada();
                brigada.setAliasBrigada(rs.getString("aliasBrigada"));

                bom.setAliasBrigada(brigada);

                lista.add(bom);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de bomberos: " + ex.getMessage());
        }

        return lista;
    }

    //baja logica del bombero, se maneja con el codigo del bombero
    public void eliminarBombero(int codBombero) {
        Bombero bom = buscarBombero(codBombero);
        if (bom != null) {
            if (bom.isEstado() == false) {
                JOptionPane.showMessageDialog(null, "El bombero ya se encuentra dado de baja");
            } else {
                String darDeBaja = "UPDATE bombero SET estado = 0 WHERE codBombero = ?";
                try {
                    try (PreparedStatement ps = con.prepareStatement(darDeBaja)) {
                        ps.setInt(1, codBombero);
                        int filasAfectadas = ps.executeUpdate();
                        if (filasAfectadas > 0) {
                            JOptionPane.showMessageDialog(null, "Se dio de baja al bombero");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo dar de baja al bombero");
                        }
                    }
                } catch (SQLException ex) {

                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al dar de baja al bombero: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El alumno no existe");
        }
    }
    //listo
    public List<Bombero> obtenerListaBomberos(int orden) {
        ArrayList<Bombero> lista = new ArrayList<>();
        String sql = formarSQL(orden);
        try {
            try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Bombero bom = new Bombero();
                    bom.setCodBombero(rs.getInt("codBombero"));
                    bom.setDni(rs.getString("dni"));
                    bom.setNombreCompleto(rs.getString("nombreCompleto"));
                    bom.setGrupoSang(rs.getString("grupoSang"));
                    bom.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                    bom.setCelular(rs.getString("celular"));
                    bom.setObservaciones(rs.getString("observaciones"));
                    bom.setEstado(rs.getBoolean("estado"));

                    // traemos la brigada para obtener el alias
                    Brigada brigada = new Brigada();
                    brigada.setAliasBrigada(rs.getString("aliasBrigada"));

                    bom.setAliasBrigada(brigada);
                    lista.add(bom);
                }
            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de bomberos: " + ex.getMessage());
        }
        return lista;
    }

    private String formarSQL(int orden) {
        StringBuilder sql = new StringBuilder("SELECT codBombero, dni, nombreCompleto, grupoSang,"
                + " fechaNac, celular, observaciones, estado, aliasBrigada FROM bombero");

        switch (orden) {
            case 1:
                sql.append(" ORDER BY codBombero");
                break;
            case 2:
                sql.append(" ORDER BY dni");
                break;
            case 3:
                sql.append(" ORDER BY nombreCompleto");
                break;
            case 4:
                sql.append(" ORDER BY grupoSang");
                break;
            case 5:
                sql.append(" ORDER BY fechaNac");
            case 6:
                sql.append(" ORDER BY celular");    
            case 7:
                sql.append(" ORDER BY observaciones");  
            case 8:
                sql.append(" ORDER BY estado");   
            case 9:
                sql.append(" ORDER BY aliasBrigada");    
            default:
                sql.append(" ORDER BY idBombero");
                break;
        }

        return sql.toString();
    }

}
