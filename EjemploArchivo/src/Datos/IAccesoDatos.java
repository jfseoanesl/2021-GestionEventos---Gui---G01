
package Datos;

import Modelo.Jugador;
import java.io.IOException;
import java.util.List;


public interface IAccesoDatos {
    
    void registrarJugador(Jugador jugador) throws IOException;
    List<Jugador> leerJugadores() throws IOException;
    Jugador buscarJugador(String cedula)throws IOException;
    List<Jugador> buscarJugadores(String posicion) throws IOException;
    int eliminarJugadores(double valor, int modo) throws IOException;
    void eliminarJugador(String cedula) throws IOException;
    
}
