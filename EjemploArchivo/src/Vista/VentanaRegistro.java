
package Vista;

import Modelo.Jugador;
import Negocio.GestionJugadores;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;


public class VentanaRegistro extends JDialog {
    private JLabel lCedula, lNombre, lApellido, lPerfil, lPosicion, lAltura, lEdad, lValor;
    private JTextField tCedula, tNombre, tApellido, tAltura, tEdad, tValor;
    private JComboBox cPosicion;
    private JRadioButton rIzquierdo, rDerecho;
    private ButtonGroup grupoRadio;
    private JButton bGuardar, bCancelar, bNuevo, bBuscar, bEliminar;
    
    private JPanel panelDatos, panelBotones;
    
    private Container contenedor;
    
    private GestionJugadores gestor;

    public VentanaRegistro(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor= new GestionJugadores();
        this.setTitle("Formulario Registro de Jugadores - V1");
        //this.setSize(400, 500);
        this.iniciarComponentes();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
       this.contenedor = this.getContentPane();
       this.contenedor.setLayout(new BorderLayout());
       this.iniciarPanelDatos();
       this.iniciarPanelBotones();
       
    }
    
    public void iniciarPanelDatos(){
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(9, 2, 5,5));
        
        this.lCedula = new JLabel("No cedula: ");
        this.lNombre = new JLabel("Nombre: ");
        this.lApellido= new JLabel("Apellido: ");
        this.lPerfil = new JLabel("Perfil: ");
        this.lPosicion= new JLabel("Posicio: ");
        this.lEdad= new JLabel("Edad: ");
        this.lAltura= new JLabel("Altura: ");
        this.lValor= new JLabel("Valor: ");
        
        this.tCedula = new JTextField(null);
        this.tCedula.setEnabled(false);
        
        this.tNombre= new JTextField(null);
        this.tApellido= new JTextField(null);
        this.tEdad= new JTextField(null);
        this.tAltura= new JTextField(null);
        this.tValor= new JTextField(null);
        
        this.cPosicion = new JComboBox();
        this.cPosicion.addItem("Portero");
        this.cPosicion.addItem("Defensa");
        this.cPosicion.addItem("Volante");
        this.cPosicion.addItem("Delantero");
        
        this.rIzquierdo = new JRadioButton("Izquierdo");
        this.rIzquierdo.setSelected(true);
        this.rDerecho = new JRadioButton("Derecho");
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rIzquierdo);
        this.grupoRadio.add(this.rDerecho);
        
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new ClickBotonGuardar());
        this.bGuardar.setEnabled(false);
        this.bCancelar = new JButton("Cancelar");
        this.bCancelar.setEnabled(false);
        
        this.panelDatos.add(this.lCedula);
        this.panelDatos.add(this.tCedula);
        
        this.panelDatos.add(this.lNombre);
        this.panelDatos.add(this.tNombre);
        
        this.panelDatos.add(this.lApellido);
        this.panelDatos.add(this.tApellido);
        
        
        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new FlowLayout());
        
        panelRadio.add(this.rIzquierdo);
        panelRadio.add(this.rDerecho);
        
        this.panelDatos.add(this.lPerfil);
        this.panelDatos.add(panelRadio);
        
        this.panelDatos.add(this.lPosicion);
        this.panelDatos.add(this.cPosicion);
        
        this.panelDatos.add(this.lEdad);
        this.panelDatos.add(this.tEdad);
        
        this.panelDatos.add(this.lAltura);
        this.panelDatos.add(this.tAltura);
        
        this.panelDatos.add(this.lValor);
        this.panelDatos.add(this.tValor);
        
        this.panelDatos.add(this.bGuardar);
        this.panelDatos.add(this.bCancelar);
        
        
        
        this.contenedor.add(this.panelDatos, BorderLayout.CENTER);
        
    }
    
    public void iniciarPanelBotones(){
        
        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(new GridLayout(3,1, 5,5));
        
        this.bNuevo = new JButton("Nuevo");
        this.bNuevo.addActionListener(new clickBotonNuevo());
        
        this.bBuscar = new JButton("Buscar");
        this.bBuscar.setEnabled(false);
        this.bEliminar= new JButton("Eliminar");
        this.bEliminar.setEnabled(false);
        
        this.panelBotones.add(this.bNuevo);
        this.panelBotones.add(this.bBuscar);
        this.panelBotones.add(this.bEliminar);
        
        JPanel panel = new JPanel();
        panel.add(this.panelBotones);
        
        this.contenedor.add(panel, BorderLayout.EAST);
    
    }
    
    public void activarComponentes(){
        this.tCedula.setEnabled(true);
        this.bGuardar.setEnabled(true);
        this.bCancelar.setEnabled(true);
        this.bBuscar.setEnabled(true);
        this.bEliminar.setEnabled(true);
        this.tCedula.grabFocus();
    }
    
    public Jugador leerComponentes(){
        
        String cedula = this.tCedula.getText();
        String nombre = this.tNombre.getText();
        String apellido = this.tApellido.getText();
        String perfil = this.rDerecho.isSelected()? "Derecho":"Izquierdo";
        String posicion = this.cPosicion.getSelectedItem().toString();
        double altura = Double.parseDouble(this.tAltura.getText());
        int edad = Integer.parseInt(this.tEdad.getText());
        double valor = Double.parseDouble(this.tValor.getText());
        
        Jugador jugador = new Jugador(cedula, nombre, apellido, posicion, perfil,altura, edad, valor);
        return jugador;
        
    }
    
    public void guardarJugador(){
        try{
            Jugador jugador = this.leerComponentes();
            this.gestor.registrarJugador(jugador);
            this.ventanaMsg("Datos guardados cone exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException ioe){
            this.ventanaMsg(ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        }catch(NumberFormatException nfe){
            this.ventanaMsg(nfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(NullPointerException npe){
            this.ventanaMsg(npe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void ventanaMsg(String msg, String titulo, int tipo){
      JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }
    
    
    class clickBotonNuevo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            activarComponentes();
        }
    }
    
    class ClickBotonGuardar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            guardarJugador();
        }
    
    }
    
    
}

