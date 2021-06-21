
package Datos;

import Modelo.Jugador;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListJugadores implements IAccesoDatos, Serializable {
    private List<Jugador> lista;

    public ListJugadores() {
        this.lista = new ArrayList();
    }

    @Override
    public void registrarJugador(Jugador jugador) throws IOException {
        this.lista.add(jugador);
    }

    @Override
    public List<Jugador> leerJugadores() throws IOException {
        return this.lista;
    }

    @Override
    public Jugador buscarJugador(String cedula) throws IOException {
        for(Jugador j: this.lista){
            if(j.getCedula().equalsIgnoreCase(cedula)){
                return j;
            }
        }
        return null;
    }

    @Override
    public List<Jugador> buscarJugadores(String posicion) throws IOException {
        List<Jugador> encontrados = new ArrayList();
        for(Jugador j: this.lista){
            if(j.getPosicion().equalsIgnoreCase(posicion)){
                encontrados.add(j);
            }
        }
        return encontrados;
    }

    @Override
    public int eliminarJugadores(double valor, int modo) throws IOException {
        int contador=0;
        Iterator<Jugador> i = this.lista.iterator();
        while(i.hasNext()){
            Jugador j = i.next();
            if(modo==0){
                if(j.getValor()>valor){
                    i.remove();
                    contador++;
                }
            }
            else{
                if(j.getValor()<valor){
                    i.remove();
                    contador++;
                }
            }
        }
        return contador;
        
    }

    @Override
    public void eliminarJugador(String cedula) throws IOException {
        int contador=0;
        Iterator<Jugador> i = this.lista.iterator();
        while(i.hasNext()){
            Jugador j = i.next();
            if(j.getCedula().equalsIgnoreCase(cedula)){
                i.remove();
            }
        }
        
    }
    
    
}
