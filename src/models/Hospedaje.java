/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.ErrorCodInvalidoException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author More Siciliano
 */
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;
    

    public Hospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws ErrorCodInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
       
        System.out.println("El servicio " + hospedaje + " se creo con exito");
    }

    
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
    
    @Override
    public String toString() {
        return String.format("%s\n Hospedaje: %s\n Precio por noche: %.2f", super.toString(), hospedaje, precioPorNoche );
    }
}
