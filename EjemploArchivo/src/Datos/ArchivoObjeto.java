package Datos;

import Modelo.Jugador;
import java.io.*;
import java.util.List;


public class ArchivoObjeto implements IAccesoDatos {

    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoObjeto(String name) {
        this.archivo = new File(name);
    }

    public ArchivoObjeto() {
        this("NominaJugadores.obj");
    }

    private void guardar(ListJugadores lista) throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(lista);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (oos != null) {
                oos.close();
            }

            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }

    private ListJugadores leer() throws IOException {
        ListJugadores lista = null;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                lista = (ListJugadores) ois.readObject();
                return lista;
            } catch (IOException ioe) {
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase ListJugador No existe");
            } finally {
                if (ois != null) {
                    ois.close();
                }
                if (this.aLectura != null) {
                    this.aLectura.close();
                }
            }
        }
        else{
            lista = new ListJugadores();
            return lista;
        }

    }

    @Override
    public void registrarJugador(Jugador jugador) throws IOException {
        ListJugadores lista = this.leer();
        lista.registrarJugador(jugador);
        this.guardar(lista);
    }

    @Override
    public List<Jugador> leerJugadores() throws IOException {
        ListJugadores lista = this.leer();
        return lista.leerJugadores();
    }

    @Override
    public Jugador buscarJugador(String cedula) throws IOException {
        ListJugadores lista = this.leer();
        return lista.buscarJugador(cedula);
    }

    @Override
    public List<Jugador> buscarJugadores(String posicion) throws IOException {
        ListJugadores lista = this.leer();
        return lista.buscarJugadores(posicion);
    }

    @Override
    public int eliminarJugadores(double valor, int modo) throws IOException {
        ListJugadores lista = this.leer();
        int eliminados =lista.eliminarJugadores(valor, modo);
        this.guardar(lista);
        return eliminados;
    }

    @Override
    public void eliminarJugador(String cedula) throws IOException {
        ListJugadores lista = this.leer();
        lista.eliminarJugador(cedula);
        this.guardar(lista);
    }

}
