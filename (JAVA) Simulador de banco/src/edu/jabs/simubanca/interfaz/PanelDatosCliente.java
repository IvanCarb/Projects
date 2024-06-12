package edu.jabs.simubanca.interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que crea el panel superior de la ventana principal
 */
public class PanelDatosCliente extends JPanel implements ActionListener
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    /**
     * Constante AVANZAR_MES, usada para indicar esta acci�n en el action performed
     */
    private final static String AVANZAR_MES = "AVANZAR MES";

    //-----------------------------------
    // Atributos
    //-----------------------------------

    /**
     * Ventana principal del simulador
     */
    private InterfazSimulador principal;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiqueta de Nombre
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta de cedula
     */
    private JLabel etiquetaCedula;

    /**
     * Etiqeta mes
     */
    private JLabel etiquetaMes;

    /**
     * Campo para visualizar el nombre del cliente
     */
    private JTextField txtNombre;

    /**
     * Campo para visualizar la cedula del cliente
     */
    private JTextField txtCedula;

    /**
     * Campo para visualizar el mes actual de la simulacion
     */
    private JTextField txtMes;

    /**
     * Boton para avanzar de mes en la simulacion
     */
    private JButton botonAvanzarMes;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Crea un panel con los elementos necesarios para su operacion y los inicializa adecuadamente
     * @param ven Ventana principal
     */
    public PanelDatosCliente( InterfazSimulador ven )
    {

        //Inicializa los elementos del panel
        principal = ven;

        //Inicializa los elementos del panel
        etiquetaNombre = new JLabel( "Nombre: " );
        etiquetaCedula = new JLabel( "Cédula: " );
        etiquetaMes = new JLabel( "Mes: " );
        txtNombre = new JTextField( 11 );
        txtCedula = new JTextField( 7 );
        txtMes = new JTextField( 2 );
        botonAvanzarMes = new JButton( );
        botonAvanzarMes.setText( ">>" );
        botonAvanzarMes.setActionCommand( AVANZAR_MES );
        botonAvanzarMes.addActionListener( this );

        //ubica los elemento del panel
        GridBagLayout gridbag = new GridBagLayout( );
        setLayout( gridbag );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Datos Personales" ) ) );

        GridBagConstraints gbc;
        gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaNombre, gbc );

        gbc = new GridBagConstraints( 2, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaCedula, gbc );

        gbc = new GridBagConstraints( 1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtNombre, gbc );
        txtNombre.setEnabled( false );
        txtNombre.setDisabledTextColor( Color.BLUE );

        gbc = new GridBagConstraints( 3, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtCedula, gbc );
        txtCedula.setEnabled( false );
        txtCedula.setDisabledTextColor( Color.BLUE );

        gbc = new GridBagConstraints( 4, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaMes, gbc );

        gbc = new GridBagConstraints( 5, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtMes, gbc );
        txtMes.setEnabled( false );
        txtMes.setDisabledTextColor( Color.BLUE );

        gbc = new GridBagConstraints( 6, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonAvanzarMes, gbc );
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Este método ejecuta las acciones adecuadas según el botón que haya sido presionado <br>
     * <b>pre: </b> Se ha realizado una accion <br>
     * <b>post: </b> Se responde a la accion realizada adecuadamente <br>
     * @param event - Es el evento o accion realizada por el usuario
     */
    public void actionPerformed( ActionEvent event )
    {
        try
        {
            String command = event.getActionCommand( );
            if( command.equals( AVANZAR_MES ) )
            {
                principal.avanzarMesSimulacion( );
            }

        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Información inválida: intente de nuevo..." );
        }
        principal.actualizarCliente( );
    }

    /**
     * Actualiza en la interfaz el campo de nombre del cliente <br>
     * <b>pre: </b>Se ha realizado algun cambio en el mundo <br>
     * <b>post: </b>Se muestra el nombre del cliente en el campo correspondiente <br>
     * @param nombre Nombre nuevo
     */
    public void actualizarNombre( String nombre )
    {
        txtNombre.setText( nombre );
    }

    /**
     * Actualiza en la interfaz el campo de cedula del cliente <br>
     * <b>pre: </b>Se ha realizado algun cambio en el mundo <br>
     * <b>post: </b>Se muestra la cedula del cliente en el campo correspondiente <br>
     * @param cedula Cedula nueva
     */
    public void actualizarCedula( String cedula )
    {
        txtCedula.setText( "" + cedula );
    }

    /**
     * Actualiza en la interfaz el mes actual de la simuelacion <b>pre: </b>Se ha realizado algun cambio en el mundo <br>
     * <b>post: </b>Se muestra el nuevo mes actual de la simulacion <br>
     * @param mes Mes nuevo
     */
    public void actualizarMes( int mes )
    {
        txtMes.setText( "" + mes );
    }
}
