/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.ErrorCodInvalidoException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Clase Hospedaje que representa un tipo específico de servicio de alojamiento.
 * Hereda de la clase Servicio e incluye atributos y métodos específicos
 * para calcular el precio final del hospedaje, considerando descuentos
 * en función del día de la semana.
 * 
 * Esta clase permite la creación de objetos que representan diferentes
 * opciones de hospedaje con su respectivo costo y descuentos.
 * 
 * @author More Siciliano
 */
public class Hospedaje extends Servicio {
    // Atributo que almacena el nombre o tipo de hospedaje.
    private String hospedaje;
    
    // Atributo que almacena el precio por noche del hospedaje.
    private double precioPorNoche;

    /**
     * Constructor de la clase Hospedaje.
     * Inicializa los atributos del hospedaje y valida el código del servicio.
     *
     * @param codServicio Código del servicio que debe ser único.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al hospedaje.
     * @param enPromocion Indica si el hospedaje está en promoción.
     * @param hospedaje Nombre o tipo de hospedaje.
     * @param precioPorNoche Precio por noche del hospedaje.
     * @throws ErrorCodInvalidoException Si el código del servicio no es válido.
     */
    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws ErrorCodInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
        // Mensaje de confirmación de creación del servicio.
        System.out.println("El servicio " + hospedaje + " se creo con exito");
    }
     /**
     * Método que calcula el precio final del hospedaje en función de la fecha
     * proporcionada y si está en promoción.
     *
     * @param dia Fecha para calcular el precio final.
     * @return Precio final calculado, aplicando descuentos si corresponde.
     */
    
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        DayOfWeek diaSemana = dia.getDayOfWeek();
        int diaNumero = diaSemana.getValue();
        double precioFinal = this.precioPorNoche;
        if(this.enPromocion && (diaNumero >= 1 && diaNumero <= 5)){
            precioFinal *= (1 - this.porcentajeDescuento / 100);
        }
       
       return precioFinal;
    }
    /**
     * Método toString que devuelve una representación en cadena del objeto Hospedaje.
     * Incluye información sobre el código del servicio, el tipo de hospedaje
     * y el precio por noche.
     *
     * @return Representación en cadena del objeto Hospedaje.
     */
    
    @Override
    public String toString() {
        return String.format("%s\n Hospedaje: %s\n Precio por noche: %.2f", super.toString(), hospedaje, precioPorNoche );
    }
}
