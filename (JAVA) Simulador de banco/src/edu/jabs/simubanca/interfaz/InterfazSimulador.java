package edu.jabs.simubanca.interfaz;

import edu.jabs.simubanca.mundo.CuentaBancaria;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;

/**
 * Presenta la información básica del cliente y la información de las cuentas que tiene en el banco
 */
public class InterfazSimulador extends JFrame
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    /**
     * CuentaBancaria del banco
     */
    private CuentaBancaria cuenta;

    //-----------------------------------
    // Atributos
    //-----------------------------------

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Panel de botones de accion para realizar transacciones
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel de visualizacion de datos de las cuentas
     */
    private PanelSaldos panelSaldos;

    /**
     * Panel de visualización de datos personales
     */
    private PanelDatosCliente panelDatos;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Crea una nueva ventana de simulación bancariacon sus componentes básicos
     * @param cli – Nuevo cliente para el simulador
     */
    public InterfazSimulador( CuentaBancaria cli )
    {
        setTitle( "Simulador Bancario" );
        panelOpciones = new PanelOpciones( this );
        panelSaldos = new PanelSaldos( );
        panelDatos = new PanelDatosCliente( this );

        // organizar el panel principal

        getContentPane( ).setLayout( new BorderLayout( ) );
        getContentPane( ).add( panelDatos, BorderLayout.NORTH );
        getContentPane( ).add( panelSaldos, BorderLayout.CENTER );
        getContentPane( ).add( panelOpciones, BorderLayout.SOUTH );

        setSize( 700, 350 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        cuenta = cli;
        actualizarCliente( );
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Este método sirve para actualizar los campos de la forma con los datos del empleado. Al finalizar los campos deben contener la información del empleado. <br>
     * <b>pre: </b> se ha realizado un cambio en el cliente <br>
     * <b>post: </b> se visualizan los cambios en los paneles correspondientes <br>
     */
    public void actualizarCliente( )
    {
        String nombre = cuenta.darNombre( );
        String cedula = cuenta.darCedula( );
        panelDatos.actualizarNombre( nombre );
        panelDatos.actualizarCedula( "" + cedula );
        panelDatos.actualizarMes( cuenta.darMesActualSimulacion( ).darMes( ) );
        panelSaldos.actualizarSaldoTotal( formatearValor( cuenta.saldoTotal( ) ) );
        panelSaldos.actualizarSaldoCorriente( formatearValor( cuenta.darCuentaCorriente( ).darSaldo( ) ) );
        panelSaldos.actualizarSaldoAhorros( formatearValor( cuenta.darCuentaAhorro( ).darSaldo( ) ) + "   [" + ( cuenta.darCuentaAhorro( ).darInteresMensual( ) * 100 ) + "%]" );
        panelSaldos.actualizarSaldoCDT( formatearValor( cuenta.darCDT( ).valorPresente( cuenta.darMesActualSimulacion( ) ) ) + "   [" + ( cuenta.darCDT( ).darInteresMensual( ) * 100 ) + "%]" );

    }

    /**
     * Toma el valor de inversion y los interesas y realiza la trasaccion de invertir en un CDT del cliente <br>
     * <b>post: </b> Se realiza la transaccion de invertir en el CDT del cliente <br>
     * @param strValor - El valor a invertir en el CDT
     * @param strInteres - El valor de los intereses en porcentaje
     */
    public void invertirCDT( String strValor, String strInteres )
    {
        if( strValor != null )
        {
            int monto = Integer.parseInt( strValor );
            double nInteres = Double.parseDouble( strInteres );
            cuenta.invertirCDT( monto, nInteres / 100 );
        }
    }

    /**
     * Cancela el CDT del cliente <br>
     * <b>post: </b> Se realiza la transaccion de cerrar el CDT del cliente <br>
     */
    public void cerrarCDT( )
    {
        cuenta.cerrarCDT( );
    }

    /**
     * Toma el valor del retiro en cuenta de ahorros y realiza la trasaccion en la cuenta del cliente <br>
     * <b>post: </b> Se realiza el retiro de la cuenta de ahorros del cliente <br>
     * @param strValor - el valor a retirar
     */
    public void retirarAhorros( String strValor )
    {
        cuenta.retirarCuentaAhorro( Integer.parseInt( strValor ) );
    }

    /**
     * Toma el valor de consignacion en cuenta de ahorros y realiza la trasaccion en la cuenta del cliente <br>
     * <b>post: </b> Se realizal a consignacion en la cuenta de ahorros del cliente <br>
     * @param strValor - el valor a consignar
     */
    public void consignarAhorros( String strValor )
    {
        cuenta.consignarCuentaAhorro( Integer.parseInt( strValor ) );
    }

    /**
     * Toma el valor del retiro en cuenta corriente y realiza la trasaccion en la cuenta del cliente <br>
     * <b>post: </b> Se realiza el retiro de la cuenta corriente del cliente <br>
     * @param strValor - el valor a retirar
     */
    public void retirarCorriente( String strValor )
    {
        cuenta.retirarCuentaCorriente( Integer.parseInt( strValor ) );
    }

    /**
     * Toma el valor de consignacion en cuenta corriente y realiza la trasaccion en la cuenta del cliente <br>
     * <b>post: </b> Se realiza la consignacion en la cuenta corriente del cliente <br>
     * @param strValor - el valor a consignar
     *
     */
    public void consignarCorriente( String strValor )
    {
        cuenta.consignarCuentaCorriente( Integer.parseInt( strValor ) );
    }

    /**
     * formatea un valor numerico para presentar en la interfaz <br>
     * @param valor - El valor numérico a ser formateado
     * @return Retorna un string con el valor formateado con puntos y signos.
     */
    private String formatearValor( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

    /**
     * Avanza un mes en la simulacion del banco
     */
    public void avanzarMesSimulacion( )
    {
        cuenta.avanzarMesSimulacion( );

    }

    /**
     * Llamado al metodo1 del mundo para realizar la extencion 1
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = cuenta.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta Extencion1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Llamado al metodo2 del mundo para realizar la extencion 2
     */
    public void reqFuncOpcion2( )
    {
        String respuesta = cuenta.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta Extencion1", JOptionPane.INFORMATION_MESSAGE );
    }

    //-----------------------------------------------------------------
    // Ejecución
    //-----------------------------------------------------------------
    /**
     * Programa principal
     * @param args Parametros de entrada. No deben ser usados
     */
    public static void main( String[] args )
    {
        // Crea una instancia del objeto CuentaBancaria y la inicializa
        CuentaBancaria c = new CuentaBancaria( );
        c.inicializar( "50.152.468", "Sergio López" );
        // Crea la ventana de visualizacion del cliente
        InterfazSimulador ventana = new InterfazSimulador( c );
        ventana.setVisible( true );
    }
}
