package Negocio;

import Datos.ArchivoObjeto;
import Datos.IAccesoDatos;
import Modelo.Jugador;
import java.io.IOException;
import java.util.List;

public class GestionJugadores {

    private IAccesoDatos datos;

    public GestionJugadores() {
        //this.datos = new ArchivoTexto();
        this.datos = new ArchivoObjeto();
        //this.datos = new ListJugadores();
    }
    
    public void registrarJugador(Jugador jugador) throws IOException{
        if(jugador==null)
            throw new NullPointerException("Debe registrar un Jugador");
        
        if(jugador.getCedula()==null || jugador.getCedula().isEmpty() )
            throw new NullPointerException("Debe registrar cedula del Jugador");
        
        if(jugador.getNombre()==null || jugador.getNombre().isEmpty())
            throw new NullPointerException("Debe registrar nombre del Jugador");
        
        if(jugador.getApellido()==null || jugador.getApellido().isEmpty())
            throw new NullPointerException("Debe registrar apellido del Jugador");
        
        if(jugador.getPerfil()==null || jugador.getPerfil().isEmpty())
            throw new NullPointerException("Debe registrar perfil del Jugador");
        
        if(jugador.getPosicion()==null || jugador.getPosicion().isEmpty())
            throw new NullPointerException("Debe registrar posicion del Jugador");
        
        if(jugador.getAltura()<=0)
            throw new NullPointerException("Debe registrar altura del Jugador");
        
        if(jugador.getEdad()<=0)
            throw new NullPointerException("Debe registrar edad del Jugador");
        
        if(jugador.getValor()<=0)
            throw new NullPointerException("Debe registrar valor del Jugador");
        
        if(this.datos.buscarJugador(jugador.getCedula())!=null)
            throw new NullPointerException("El Jugador ya se encuentra registrado");
        
        this.datos.registrarJugador(jugador);
        
    }
    
    public List<Jugador> leerJugadores()throws IOException{
        return this.datos.leerJugadores();
    }
    
    public Jugador buscarJugador(String cedula) throws IOException{
        return this.datos.buscarJugador(cedula);
    }
    public List<Jugador> buscarJugadores(String posicion)throws IOException{
        return this.datos.buscarJugadores(posicion);
    }
    
    public int eliminarJugadores(double valor, int modo)throws IOException{
        return this.datos.eliminarJugadores(valor, modo);
    }
    
    public void eliminarJugador(String cedula)throws IOException{
        if(cedula==null || cedula.isEmpty())
            throw new NullPointerException("Se debe registrar la cedula del Jugador a eliminar");
        
        this.datos.eliminarJugador(cedula);
    }

}
