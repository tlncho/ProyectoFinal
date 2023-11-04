
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
            Brigada brigada1 = new Brigada("1", "meter goles", true, cuartel1);
            // primero creo un modelo java(mejora, el metodo deberia de crear el modelo y mapearlo contra la BD automaticamente):
            // el constructor de bombero me pide un LocalDate, ojo que despues en el controlador, le manda un statement a la BD recuperandolo como si fuera un String al usar el metodo Date.of()
            LocalDate fechaNacBom1 = LocalDate.now();
            Bombero bombero1 = new Bombero(2, "44568754", "Leo Messi", "A-", fechaNacBom1, "2665000000", "no se mucho de messi, es zurdo", true, brigada1);
            
            
            bd.guardarBombero(bombero1);
            
            // buscar bombero con cod 2
            bd.buscarBombero(2);
            


            
            
            // para el siguiente metodo, MODIFICAR, voy a probar creando un bombero en la BD, y modificarlo con mi bombero1.
            // consejo, el codigo del bombero a modificar, deberia ser recuperado por vista, y pasado por metodo, para no dejarlo como un comodin en el prepare statement
            
            //bd.modificarBombero(bombero1,1);
            
            
            // creo un bombero en la bd directamente, y lo busco desde java:
            // problemas a la hora de llamar el metodo, ya que el prepare statement, toma valores que no setea correctamente, ademas que no esta claro que esta seteando, practicamente solo deberia de setear el codigo de bombero
            // System.out.print(bd.buscarBombero(1));
            System.out.print(bd.buscarBombero(2));
    }
    
}
