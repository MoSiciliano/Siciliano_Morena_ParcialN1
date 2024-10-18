/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import exceptions.ErrorCodInvalidoException;
import exceptions.ErrrorNoHayServiciosEnPromoException;
import java.time.LocalDate;
import models.Gastronomia;
import models.Hospedaje;
import models.Sistema;

/**
 *
 * @author More Siciliano
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("1-1");
            Gastronomia gastronomia1 = new Gastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);

        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("1-2");
            Gastronomia gastronomia2 = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("  2-1");
            LocalDate fecha = LocalDate.parse("2020-10-28");
            System.out.println("  El precio final es de $" + gastronomia2.calcularPrecioFinal(fecha));
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("1-3");
            Hospedaje hospedaje1 = new Hospedaje("2872", 10.0, true, "Cabaña 3 Personas", 1500.0);

        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("1-4");
            Hospedaje hospedaje2 = new Hospedaje("287282", 10.0, true, "Cabaña 3 Personas", 1500.0);
            System.out.println("  2-2");
            LocalDate fecha = LocalDate.parse("2020-10-27");
            System.out.println("  El precio final es de $" + hospedaje2.calcularPrecioFinal(fecha));
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("3");
        Sistema sistema1 = new Sistema();
        try {
            System.out.println("");
            sistema1.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);

        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("");
            sistema1.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);

        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("");
            sistema1.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);

        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("");
            sistema1.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);
            System.out.println("");
            System.out.println(sistema1.getLstServicio());
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        try{
            System.out.println("4-1");
            System.out.println(sistema1.traerServicio(true));
        } catch(ErrrorNoHayServiciosEnPromoException e){
            System.out.println(e.getMessage());
        }
        try{
            System.out.println("4-2");
            LocalDate fecha = LocalDate.parse("2020-10-28");
            System.out.println(sistema1.traerServicio(true, fecha));
        } catch(ErrrorNoHayServiciosEnPromoException e){
            System.out.println(e.getMessage());
        }

    }

}
