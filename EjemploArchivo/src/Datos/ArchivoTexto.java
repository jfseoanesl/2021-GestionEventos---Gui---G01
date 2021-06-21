package Datos;

import Modelo.Jugador;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoTexto implements IAccesoDatos {

    private File archivo;
    private FileWriter modoEscritura; // abre el archivo para escritura
    private Scanner modoLectura; // abre el archivo en modo lectura

    public ArchivoTexto() {
        this.archivo = new File("NominaJugadores.dat");
    }

    public ArchivoTexto(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }

    @Override
    public void registrarJugador(Jugador jugador) throws IOException {

        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(jugador.getDataText());
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (pw != null) {
                pw.close();
            }
            this.modoEscritura.close();
        }

    }

    private Jugador crearJugador(String linea) {

        String datos[] = linea.split(";");
        Jugador jugador = new Jugador();
        jugador.setCedula(datos[0]);
        jugador.setNombre(datos[1]);
        jugador.setApellido(datos[2]);
        jugador.setPosicion(datos[3]);
        jugador.setPerfil(datos[4]);
        jugador.setEdad(Integer.parseInt(datos[5]));
        jugador.setAltura(Double.parseDouble(datos[6]));
        jugador.setValor(Double.parseDouble(datos[7]));

        return jugador;
    }

    @Override
    public List<Jugador> leerJugadores() throws IOException {
        List<Jugador> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Jugador jugador = this.crearJugador(linea);
                listado.add(jugador);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }

    }

    @Override
    public Jugador buscarJugador(String cedula) throws IOException {
        Jugador encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Jugador jugador = this.crearJugador(linea);
                if (jugador.getCedula().equalsIgnoreCase(cedula)) {
                    encontrado = jugador;
                    break;
                }
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    @Override
    public List<Jugador> buscarJugadores(String posicion) throws IOException {
        List<Jugador> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Jugador jugador = this.crearJugador(linea);
                if (jugador.getPosicion().equalsIgnoreCase(posicion)) {
                    listado.add(jugador);
                }
                
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    private void renombrarArchivo(File nvoArchivo) throws IOException {
        // se crea el archivo temporal si no existe
        if (!nvoArchivo.exists()) {
            nvoArchivo.createNewFile();
        }

        //se elimina el archivo original
        if (!this.archivo.delete()) {
            throw new IOException("No fue posible eliminar el archivo original");
        }

        //se renombra el archivo temporal
        if (!nvoArchivo.renameTo(this.archivo)) {
            throw new IOException("No fue posible renombrar el archivo temporal");
        }

    }

    @Override
    public int eliminarJugadores(double valor, int modo) throws IOException {
        int contador = 0;
        try {

            this.modoLectura = new Scanner(this.archivo);
            ArchivoTexto archivoTemporal = new ArchivoTexto("Temporal.dat");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Jugador jugador = this.crearJugador(linea);
                if (modo == 0) { // valores por encima
                    if (jugador.getValor() > valor) {// eliminar
                        contador++;
                    } else {
                        archivoTemporal.registrarJugador(jugador);
                    }
                } else { // valores por debajo
                    if (jugador.getValor() < valor) { // eliminar
                        contador++;
                    } else {
                        archivoTemporal.registrarJugador(jugador);
                    }
                }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
            return contador;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.modoLectura.close();
        }

    }

    @Override
    public void eliminarJugador(String cedula) throws IOException {
       
        try {
            this.modoLectura = new Scanner(this.archivo);
            ArchivoTexto archivoTemporal = new ArchivoTexto("Temporal.dat");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Jugador jugador = this.crearJugador(linea);
                    if (!jugador.getCedula().equalsIgnoreCase(cedula)) {// eliminar
                        archivoTemporal.registrarJugador(jugador);
                    }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
            
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.modoLectura.close();
        }
    }

}
