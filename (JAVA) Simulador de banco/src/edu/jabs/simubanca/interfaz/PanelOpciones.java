package edu.jabs.simubanca.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que crea el panel Inferior de la ventana principal
 */
public class PanelOpciones extends JPanel implements ActionListener
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    /**
     * Constante ABRIR_CDT, usada para indicar esta acci�n en el action performed
     */
    private final static String ABRIR_CDT = "ABRIR CDT";

    /**
     * Constante CERRAR_CDT, usada para indicar esta acci�n en el action performed
     */
    private final static String CERRAR_CDT = "CERRAR CDT";

    /**
     * Constante CONSIGNAR_CUENTA_CORRIENTE, usada para indicar esta acci�n en el action performed
     */
    private final static String CONSIGNAR_CUENTA_CORRIENTE = "CONSIGNAR CUENTA CORRIENTE";

    /**
     * Constante RETIRAR_CUENTA_CORRIENTE, usada para indicar esta acci�n en el action performed
     */
    private final static String RETIRAR_CUENTA_CORRIENTE = "RETIRAR CUENTA CORRIENTE";

    /**
     * Constante RETIRAR_CUENTA_AHORRO, usada para indicar esta acci�n en el action performed
     */
    private final static String RETIRAR_CUENTA_AHORRO = "RETIRAR CUENTA AHORRO";

    /**
     * Constante CONSIGNAR_CUENTA_AHORRO, usada para indicar esta acci�n en el action performed
     */
    private final static String CONSIGNAR_CUENTA_AHORRO = "CONSIGNAR CUENTA AHORRO";

    /**
     * Constante OPCION_1, Usada para realizar la opcion de la extencion 1
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante OPCION_2, Usada para realizar la opcion de la extencion 2
     */
    private final static String OPCION_2 = "OPCION_2";

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
     * Boton para abrir un nuevo CDT
     */
    private JButton botonAbrirCDT;

    /**
     * Boton para cancelar un CDT
     */
    private JButton botonCerrarCdt;

    /**
     * Boton para consignar en la Cuenta Corriente
     */
    private JButton botonConsignarCuentaCorriente;

    /**
     * Boton Para hacer retiros de la cuenta corriente
     */
    private JButton botonRetirarCuentaCorriente;

    /**
     * Boton para consignar en la Cuenta de ahorros
     */
    private JButton botonConsignarCuentaAhorro;

    /**
     * Boton Para hacer retiros de la cuenta de ahorros
     */
    private JButton botonRetirarCuentaAhorro;

    /**
     * Boton Para hacer la extencion1
     */
    private JButton opcion1;

    /**
     * Boton Para hacer la extencion2
     */
    private JButton opcion2;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Crea un nuevo panel e Inicializa sus elementos
     * @param ven Ventana principal
     */
    public PanelOpciones( InterfazSimulador ven )
    {

        //Inicializa los elementos del panel
        principal = ven;
        botonAbrirCDT = new JButton( );
        botonCerrarCdt = new JButton( );
        botonConsignarCuentaCorriente = new JButton( );
        botonRetirarCuentaCorriente = new JButton( );
        botonConsignarCuentaAhorro = new JButton( );
        botonRetirarCuentaAhorro = new JButton( );
        opcion1 = new JButton( );
        opcion2 = new JButton( );

        // Ubica los elementos en el panel
        GridBagLayout gridbag = new GridBagLayout( );
        setLayout( gridbag );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Cálculos" ) ) );

        GridBagConstraints gbc;
        gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonAbrirCDT, gbc );

        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonCerrarCdt, gbc );

        gbc = new GridBagConstraints( 1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonConsignarCuentaCorriente, gbc );

        gbc = new GridBagConstraints( 1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonRetirarCuentaCorriente, gbc );

        gbc = new GridBagConstraints( 2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonConsignarCuentaAhorro, gbc );

        gbc = new GridBagConstraints( 2, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( botonRetirarCuentaAhorro, gbc );

        gbc = new GridBagConstraints( 3, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( opcion1, gbc );

        gbc = new GridBagConstraints( 3, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( opcion2, gbc );

        // inicializa las acciones de los botones
        inicializarBotones( );
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Inicializa las acciones de los botones <br>
     * <b>post: </b> Los botones del panel han sido inicializados con una accion <br>
     */
    private void inicializarBotones( )
    {

        botonAbrirCDT.setText( "Abrir inversion CDT" );
        botonAbrirCDT.setActionCommand( ABRIR_CDT );
        botonAbrirCDT.addActionListener( this );

        botonCerrarCdt.setText( "Cerrar inversion CDT" );
        botonCerrarCdt.setActionCommand( CERRAR_CDT );
        botonCerrarCdt.addActionListener( this );

        botonConsignarCuentaCorriente.setText( "Consignar cuenta corriente" );
        botonConsignarCuentaCorriente.setActionCommand( CONSIGNAR_CUENTA_CORRIENTE );
        botonConsignarCuentaCorriente.addActionListener( this );

        botonRetirarCuentaCorriente.setText( "Retirar cuenta corriente" );
        botonRetirarCuentaCorriente.setActionCommand( RETIRAR_CUENTA_CORRIENTE );
        botonRetirarCuentaCorriente.addActionListener( this );

        botonConsignarCuentaAhorro.setText( "Consignar cuenta ahorro" );
        botonConsignarCuentaAhorro.setActionCommand( CONSIGNAR_CUENTA_AHORRO );
        botonConsignarCuentaAhorro.addActionListener( this );

        botonRetirarCuentaAhorro.setText( "Retirar cuenta ahorro" );
        botonRetirarCuentaAhorro.setActionCommand( RETIRAR_CUENTA_AHORRO );
        botonRetirarCuentaAhorro.addActionListener( this );

        opcion1.setText( "Opcion1" );
        opcion1.setActionCommand( OPCION_1 );
        opcion1.addActionListener( this );

        opcion2.setText( "Opcion2" );
        opcion2.setActionCommand( OPCION_2 );
        opcion2.addActionListener( this );
    }

    /**
     * Este m�todo ejecuta las acciones adecuadas seg�n el bot�n que haya sido presionado <br>
     * <b>pre: </b> se ha realizado una accion <br>
     * <b>post: </b> Se realizan operaciones dependiendo de la accion realizada <br>
     * @param event - Es el evento o accion realizada por el usuario
     */
    public void actionPerformed( ActionEvent event )
    {
        try
        {
            String command = event.getActionCommand( );
            if( command.equals( ABRIR_CDT ) )
            {
                String strValor = JOptionPane.showInputDialog( this, "Introduzca el valor de la inversion" );
                String strInteres = JOptionPane.showInputDialog( this, "Introduzca el interés mensual en porcentaje" );
                principal.invertirCDT( strValor, strInteres );

            }
            else if( command.equals( CERRAR_CDT ) )
            {
                principal.cerrarCDT( );

            }
            else if( command.equals( CONSIGNAR_CUENTA_CORRIENTE ) )
            {
                String strValor = JOptionPane.showInputDialog( this, "Introduzca el valor a consignar" );
                principal.consignarCorriente( strValor );
            }
            else if( command.equals( RETIRAR_CUENTA_CORRIENTE ) )
            {
                String strValor = JOptionPane.showInputDialog( this, "Introduzca el valor a retirar" );
                principal.retirarCorriente( strValor );
            }
            else if( command.equals( CONSIGNAR_CUENTA_AHORRO ) )
            {
                String strValor = JOptionPane.showInputDialog( this, "Introduzca el valor a consignar" );
                principal.consignarAhorros( strValor );
            }
            else if( command.equals( RETIRAR_CUENTA_AHORRO ) )
            {
                String strValor = JOptionPane.showInputDialog( this, "Introduzca el valor a retirar" );
                principal.retirarAhorros( strValor );
            }
            else if( command.equals( OPCION_1 ) )
            {
                principal.reqFuncOpcion1( );
            }
            else if( command.equals( OPCION_2 ) )
            {
                principal.reqFuncOpcion2( );
            }
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "Información inválida: intente de nuevo..." );
        }
        principal.actualizarCliente( );

    }
}
