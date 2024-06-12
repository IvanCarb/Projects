package edu.jabs.simubanca.util;

/**
 * Esta clase representa un mes. Se utiliza para representar el numero de meses transcurridos en la simulacion
 */
public class Mes
{

    //-----------------------------------
    // Constantes
    //-----------------------------------

    //-----------------------------------
    // Atributos
    //-----------------------------------

    /**
     * Numero de mes
     */
    private int mes;

    //-----------------------------------
    // Constructor
    //-----------------------------------

    public Mes()
    {
    }

    //-----------------------------------
    // Métodos
    //-----------------------------------

    /**
     * Inicializa la fecha en el mes especificado
     * @param mesP mes inicial
     */
    public void inicializar( int mesP )
    {
        mes = mesP;
    }

    /**
     * @return retorna el mes
     */
    public int darMes( )
    {
        return mes;
    }

    /**
     * Calcula el numero de meses transcurridos desde una fecha hasta el mes
     * @param desdeFecha Mes desde donde se calcula
     * @return numero de meses transcurridos desde el mes de inicio
     */
    public int calcularMesesDiferencia( Mes desdeFecha )
    {
        return mes - desdeFecha.mes;
    }

    /**
     * avanza un mes
     */
    public void avanzarMes( )
    {
        mes = mes + 1;
    }
}
