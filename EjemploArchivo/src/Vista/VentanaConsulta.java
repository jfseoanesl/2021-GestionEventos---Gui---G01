
package Vista;

import Modelo.Jugador;
import Negocio.GestionJugadores;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jairo
 */
public class VentanaConsulta extends JDialog {
    private Container contenedor;
    private JPanel panelFiltro;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modelo;
    private String titulos[]={"Cedula", "Nombre", "Apellido", "Perfil", "Posicion","Edad", "Altura", "Valor"};
    private GestionJugadores gestor;
    
    public VentanaConsulta(JFrame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("Busqueda de Jugadores - V1");
        this.gestor = new GestionJugadores();
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.actualizarTabla();
    }
    
    public void iniciarPanelFiltro(){
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.lFiltro= new JLabel("Filtro busqueda: ");
        this.tFiltro= new JTextField(10);
        
        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        
        this.contenedor.add(this.panelFiltro, BorderLayout.NORTH);
        
       
    }
    
    public void iniciarPanelResultado(){
        
        this.panelResultado = new JScrollPane();
        
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);
        
        this.contenedor.add(this.panelResultado, BorderLayout.CENTER);
    
    }
    
    public void actualizarTabla(){
        try{
            List<Jugador> lista = this.gestor.leerJugadores();
            this.modelo.setNumRows(0);
            for(Jugador j : lista){
                String linea[] ={j.getCedula(), j.getNombre(), j.getApellido(),
                                 j.getPerfil(), j.getPosicion(), ""+j.getAltura(),
                                 ""+j.getEdad(), ""+j.getValor()};
                this.modelo.addRow(linea);
            }
        }catch(IOException ioe){
            System.out.println(ioe);
        }    
    }
    
    
    
}
