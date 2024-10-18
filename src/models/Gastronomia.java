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
public class Gastronomia extends Servicio{
    
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia( String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws ErrorCodInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
        System.out.println("El servicio " + gastronomia + " se creo con exito");
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }
    
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
     @Override
    public String toString() {
        return String.format("%s\n Gastronomia: %s\n Precio: %.2f\n Dia de la semana con descuento: %d", super.toString(), gastronomia, precio,diaSemDesc );
    }
}
