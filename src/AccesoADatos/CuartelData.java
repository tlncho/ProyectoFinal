
package AccesoADatos;

import java.sql.Connection;

/**
 
 * @author Julian Development
 */
public class CuartelData {
    
     private Connection con;

    public CuartelData() {
        con = Conexion.getConexion();
    }

}
