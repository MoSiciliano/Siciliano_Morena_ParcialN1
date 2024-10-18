/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.ErrorCodInvalidoException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Clase Gastronomia que representa un tipo específico de servicio de alimentos.
 * Hereda de la clase Servicio e incluye atributos y métodos específicos
 * para calcular el precio final de la gastronomía, considerando descuentos
 * en función del día de la semana.
 * 
 * Esta clase permite la creación de objetos que representan diferentes
 * opciones gastronómicas con su respectivo costo y descuentos aplicables.
 * 
 * @author More Siciliano
 */
public class Gastronomia extends Servicio{
    
   // Atributo que almacena el tipo de gastronomía.
    private String gastronomia;
    
    // Atributo que almacena el precio del servicio de gastronomía.
    private double precio;
    
    // Atributo que indica el día de la semana en el que se aplica el descuento.
    private int diaSemDesc;

    /**
     * Constructor de la clase Gastronomia.
     * Inicializa los atributos de la gastronomía y valida el código del servicio.
     *
     * @param codServicio Código del servicio que debe ser único.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al servicio de gastronomía.
     * @param enPromocion Indica si el servicio está en promoción.
     * @param gastronomia Nombre o tipo de gastronomía.
     * @param precio Precio del servicio de gastronomía.
     * @param diaSemDesc Día de la semana en el que se aplica el descuento (1-7).
     * @throws ErrorCodInvalidoException Si el código del servicio no es válido.
     */
    
    public Gastronomia( String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws ErrorCodInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
        // Mensaje de confirmación de creación del servicio.
        System.out.println("El servicio " + gastronomia + " se creo con exito");
    }
      /**
     * Método que devuelve el día de la semana en el que se aplica el descuento.
     *
     * @return Día de la semana con descuento.
     */
    public int getDiaSemDesc() {
        return diaSemDesc;
    }
    /**
     * Método que calcula el precio final del servicio de gastronomía en función de la fecha
     * proporcionada y si está en promoción.
     *
     * @param dia Fecha para calcular el precio final.
     * @return Precio final calculado, aplicando descuentos si corresponde.
     */
    
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
        int diaNumero = diaSemana.getValue();
        double precioFinal = this.precio;
        if(this.enPromocion && diaNumero == this.diaSemDesc){
             precioFinal *= (1 - this.porcentajeDescuento / 100);
        }
       
       return precioFinal;
    }
    /**
     * Método toString que devuelve una representación en cadena del objeto Gastronomia.
     * Incluye información sobre el código del servicio, el tipo de gastronomía,
     * el precio y el día de la semana con descuento.
     *
     * @return Representación en cadena del objeto Gastronomia.
     */
     @Override
    public String toString() {
        return String.format("%s\n Gastronomia: %s\n Precio: %.2f\n Dia de la semana con descuento: %d", super.toString(), gastronomia, precio,diaSemDesc );
    }
}
