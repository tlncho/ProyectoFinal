
package AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conexion;

    public Conexion() {
    }
    public static Connection conectarDriver(){
        if(conexion==null){
            String cargarDriver="org.mariadb.jdbc.Driver";
            String URL="jdbc:mariadb://localhost:3306/proyectofinalgrupo7";
            String USUARIO="root";
            String CONTRASEÑA="";
            try {
                Class.forName(cargarDriver);
                System.out.println("Driver cargado");
                try {
                    conexion=DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
                    System.out.println("Conectado a la base de datos");
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos");
                }
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver");
            }
        }
        return conexion;
    
    }
}
