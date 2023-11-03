
package Main;

import AccesoADatos.BomberoData;
import Entidades.Bombero;
import Entidades.Brigada;
import Entidades.Cuartel;
import Vistas.Escritorio;
import java.time.LocalDate;
import java.time.Month;

public class Principal {

   
    public static void main(String[] args) {
        
            Escritorio esc = new Escritorio();
            esc.setVisible(true);
          
            // probando controladores para los crud de bomberos
            BomberoData bd = new BomberoData();
            
            // Probando el guardado de bombero:
            // creo cuartel, mismo caso que en brigada, las asignaciones deberian ser despues
            Cuartel cuartel1 = new Cuartel(1, "cuartel 1", "calle siempre viva", 1, 1, "2665000001", "cuartel1@gmail.com");
            // creo la brigada a la que la voy a asignar, que pasa si no quiero asignarlo a una brigada hasta despues?
            Brigada brigada1 = new Brigada("PSG", "meter goles", true, cuartel1);
            // primero creo un modelo java(mejora, el metodo deberia de crear el modelo y mapearlo contra la BD automaticamente):
            // el constructor de bombero me pide un LocalDate, ojo que despues en el controlador, le manda un statement a la BD recuperandolo como si fuera un String al usar el metodo Date.of()
            Bombero bombero1 = new Bombero(1, "44568754", "Leo Messi", "A+", LocalDate.of(1995, Month.MARCH, 13), "2665000000", "no se mucho de messi, es zurdo", true, brigada1);
            
            
            
            
            // buscar bombero con cod 1
            bd.buscarBombero(1);
            
            // vamos a ver si guarda el bombero creado previamente, tener en cuenta que muy posiblemente rompa por lo del date, y lo de las FK, que no se si estan contempladas en la BD(deberia insertar el bombero
//            y despues mapear y modelar las otras clases en un metodo de asignar bombero a cuartel y brigada).

            bd.guardarBombero(bombero1);
    }
    
}
