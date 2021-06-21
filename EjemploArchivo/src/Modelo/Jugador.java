
package Modelo;

import java.io.Serializable;

public class Jugador implements Serializable  {
    private String cedula, nombre, apellido;
    private String posicion, perfil;
    private double altura;
    private int edad;
    private double valor;
    //private String equipos[]={"Barcelona", "Madrid", "Junior"};

    public Jugador() {
    }

    public Jugador(String cedula) {
        this.cedula = cedula;
    }

    public Jugador(String cedula, String nombre, String apellido, String posicion, String perfil, double altura, int edad, double valor) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.perfil = perfil;
        this.altura = altura;
        this.edad = edad;
        this.valor = valor;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * @param posicion the posicion to set
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getDataText(){
        return  this.cedula+";"
                +this.nombre+";"
                +this.apellido+";"
                +this.posicion+";"
                +this.perfil+";"
                +this.edad+";"
                +this.altura+";"
                +this.valor;
                
    }

    @Override
    public String toString() {
        return "Jugador{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", posicion=" + posicion + ", perfil=" + perfil + ", altura=" + altura + ", edad=" + edad + ", valor=" + valor + '}';
    }
    
    
    
}
