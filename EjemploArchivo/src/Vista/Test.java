
package Vista;

import Datos.*;
import Modelo.Jugador;
import Negocio.GestionJugadores;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author jairo
 */
public class Test {
    public static void main(String[] args) {
        
        /*
        Jugador jugadorA = new Jugador("123", "Radamel", "Garcia", "Delantero", "Derecho", 1.70, 34, 40000);
        Jugador jugadorB = new Jugador("234", "James", "Rodriguez", "Volante", "Zurdo", 1.70, 28, 80000);
        Jugador jugadorC = new Jugador("345", "Juan", "Cuadrado", "Volante", "Derecho", 1.80, 32, 50000);
        Jugador jugadorD = new Jugador("456", "David", "Ospina", "Portero", "Zurdo", 1.80, 35, 10000);
        Jugador jugadorE = new Jugador("567", "Santiago", "Arias", "Defensa", "Derecho", 1.90, 30, 5000);
        */
       
        VentanaPrincipal principal = new VentanaPrincipal();
        /*
        
        GestionJugadores datos = new GestionJugadores();
        
        try{
            
           
           
           List<Jugador> lista;
           System.out.println("Consulta de todos los Jugadores");
           System.out.println("----------------------------------------");
           lista = datos.leerJugadores();
           imprimirListado(lista);
         
           System.out.println("\nBusqueda por cedula");
           System.out.println("----------------------------------------");
           Jugador jugador = datos.buscarJugador("345");
           if(jugador!=null) 
               System.out.println(jugador);
           else
               System.out.println("Jugador no registrado");
                      
           System.out.println("\nConsulta de Solo volantes");
           System.out.println("----------------------------------------");
           lista = datos.buscarJugadores("Volante");
           imprimirListado(lista);
           
           System.out.println("\nConsulta de Solo delanteros");
           System.out.println("----------------------------------------");
           lista = datos.buscarJugadores("Delantero");
           imprimirListado(lista);
           
           System.out.println("\nEliminar jugadores (Valor Menor a $150000)");
           System.out.println("----------------------------------------");
           int n = datos.eliminarJugadores(150000, 0);
           System.out.println("Eliminados: "+ n);
            
           System.out.println("\nLista Final de Jugadores");
           System.out.println("----------------------------------------");
           lista = datos.leerJugadores();
           imprimirListado(lista);
            
          
        }catch(IOException ioe){
            ioe.printStackTrace(System.out);
        } 
        catch(NullPointerException ne){
            ne.printStackTrace(System.out);
        }
       */
    }
    
    public static void imprimirListado(List<Jugador> lista){
        for(Jugador j : lista){
               System.out.println(j);
        }
        System.out.println(lista.size() + " Jugadores registrados");
    }
}
