package edu.jabs.simubanca.interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que crea el panel central de la ventana principal
 */
public class PanelSaldos extends JPanel
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    //-----------------------------------
    // Atributos de Interfaz
    //-----------------------------------

    /**
     * Etiqueta de saldo Total
     */
    private JLabel etiquetaSaldo;

    /**
     * Etiqueta del saldo de cuenta corriente
     */
    private JLabel etiquetaSaldoCorriente;

    /**
     * Etiqueta del saldo de cuenta de ahorros
     */
    private JLabel etiquetaSaldoAhorros;

    /**
     * Etiqueta del saldo del CDT
     */
    private JLabel etiquetaSaldoCdt;

    /**
     * Campo donde se visualiza el saldo total
     */
    private JTextField txtSaldo;

    /**
     * Campo donde se visualiza el saldo el saldo de la cuenta corriente
     */
    private JTextField txtSaldoCorriente;

    /**
     * Campo donde se visualiza el saldo de la cuenta de ahorros
     */
    private JTextField txtSaldoAhorros;

    /**
     * Campo donde se visualiza el saldo del CDT
     */
    private JTextField txtSaldoCdt;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    /**
     * Crea el nuevo panel Central, e inicializa todos sus componentes
     */
    public PanelSaldos( )
    {

        //Inicializa los elementos de panel
        etiquetaSaldo = new JLabel( "Total: " );
        etiquetaSaldoCorriente = new JLabel( "Saldo Corriente: " );
        etiquetaSaldoAhorros = new JLabel( "Saldo Ahorros: " );
        etiquetaSaldoCdt = new JLabel( "Saldo CDT: " );

        //Organiza los elementos en el panel
        txtSaldo = new JTextField( 12 );
        txtSaldoCorriente = new JTextField( 12 );
        txtSaldoAhorros = new JTextField( 12 );
        txtSaldoCdt = new JTextField( 12 );

        GridBagLayout gridbag = new GridBagLayout( );
        setLayout( gridbag );
        setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 5, 0 ), new TitledBorder( "Saldo" ) ) );
        GridBagConstraints gbc;

        gbc = new GridBagConstraints( 0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaSaldoCorriente, gbc );
        gbc = new GridBagConstraints( 1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtSaldoCorriente, gbc );
        txtSaldoCorriente.setEnabled( false );
        txtSaldoCorriente.setDisabledTextColor( Color.BLUE );

        gbc = new GridBagConstraints( 0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaSaldoAhorros, gbc );
        gbc = new GridBagConstraints( 1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtSaldoAhorros, gbc );
        txtSaldoAhorros.setEnabled( false );
        txtSaldoAhorros.setDisabledTextColor( Color.BLUE );

        gbc = new GridBagConstraints( 0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaSaldoCdt, gbc );
        gbc = new GridBagConstraints( 1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtSaldoCdt, gbc );
        txtSaldoCdt.setEnabled( false );
        txtSaldoCdt.setDisabledTextColor( Color.BLUE );

        gbc = new GridBagConstraints( 2, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( etiquetaSaldo, gbc );
        gbc = new GridBagConstraints( 3, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets( 5, 5, 5, 5 ), 0, 0 );
        add( txtSaldo, gbc );
        txtSaldo.setEnabled( false );
        txtSaldo.setDisabledTextColor( Color.BLUE );
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Actualiza el saldo total del cliente en la interfaz <b>post: </b> El campo que muestra el Saldo total, se actualiza con el saldo actual <br>
     * @param strValor Valor total
     */
    public void actualizarSaldoTotal( String strValor )
    {
        txtSaldo.setText( strValor );
    }

    /**
     * Actualiza el saldo de la cuenta de Ahorros del cliente en la interfaz <b>post: </b> El campo que muestra el Saldo de la cuenta de ahorros, se actualiza con el saldo
     * actual <br>
     * @param strValor Valor cuenta de ahorros
     */
    public void actualizarSaldoAhorros( String strValor )
    {
        txtSaldoAhorros.setText( strValor );
    }

    /**
     * Actualiza el saldo de la cuenta corriente del cliente en la interfaz <b>post: </b> El campo que muestra el Saldo de la cuenta corriente, se actualiza con el saldo
     * actual <br>
     * @param strValor Valor cuenta corriente
     */
    public void actualizarSaldoCorriente( String strValor )
    {
        txtSaldoCorriente.setText( strValor );
    }

    /**
     * Actualiza el saldo del CDT del cliente en la interfaz <b>post: </b> El campo que muestra el Saldo del CDT, se actualiza con el saldo actual <br>
     * @param strValor Valor CDT
     */
    public void actualizarSaldoCDT( String strValor )
    {
        txtSaldoCdt.setText( strValor );
    }
}
