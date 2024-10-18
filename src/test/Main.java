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
 * Clase principal que ejecuta el programa y realiza pruebas sobre las
 * funcionalidades de las clases de modelos de servicio (Gastronomia y Hospedaje)
 * y del sistema que gestiona esos servicios.
 * 
 * Autor: More Siciliano
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * @param args los argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Prueba de creación de un objeto Gastronomia con código inválido
        try {
            System.out.println("1-1");
            Gastronomia gastronomia1 = new Gastronomia("4892", 15.0, true, "Hamburguesa criolla", 180.0, 4);
        } catch (ErrorCodInvalidoException e) {
            // Captura y muestra el mensaje de error por código inválido
            System.out.println(e.getMessage());
        }
        // Prueba de creación de un objeto Gastronomia y cálculo de precio final
        try {
            System.out.println("1-2");
            Gastronomia gastronomia2 = new Gastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("  2-1");
            LocalDate fecha = LocalDate.parse("2020-10-28"); // Fecha de prueba
            System.out.println("  El precio final es de $" + gastronomia2.calcularPrecioFinal(fecha));
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Prueba de creación de un objeto Hospedaje con código inválido
        try {
            System.out.println("1-3");
            Hospedaje hospedaje1 = new Hospedaje("2872", 10.0, true, "Cabaña 3 Personas", 1500.0);
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Prueba de creación de un objeto Hospedaje y cálculo de precio final
        try {
            System.out.println("1-4");
            Hospedaje hospedaje2 = new Hospedaje("287282", 10.0, true, "Cabaña 3 Personas", 1500.0);
            System.out.println("  2-2");
            LocalDate fecha = LocalDate.parse("2020-10-27"); // Fecha de prueba
            System.out.println("  El precio final es de $" + hospedaje2.calcularPrecioFinal(fecha));
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Creación de un sistema para gestionar servicios
        System.out.println("3");
        Sistema sistema1 = new Sistema();

        // Pruebas para agregar servicios de Gastronomía
        try {
            System.out.println("");
            sistema1.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Pruebas para agregar servicios de Hospedaje
        try {
            System.out.println("");
            sistema1.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Otra prueba para agregar un servicio de Gastronomía
        try {
            System.out.println("");
            sistema1.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Agregando más servicios de Hospedaje y mostrando la lista de servicios
        try {
            System.out.println("");
            sistema1.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);
            System.out.println("");
            System.out.println(sistema1.getLstServicio()); // Muestra la lista de servicios agregados
        } catch (ErrorCodInvalidoException e) {
            System.out.println(e.getMessage());
        }

        // Prueba para traer servicios en promoción
        try {
            System.out.println("4-1");
            System.out.println(sistema1.traerServicio(true)); // Servicios en promoción
        } catch (ErrrorNoHayServiciosEnPromoException e) {
            System.out.println(e.getMessage());
        }

        // Prueba para traer servicios en promoción para una fecha específica
        try {
            System.out.println("4-2");
            LocalDate fecha = LocalDate.parse("2020-10-28"); // Fecha de prueba
            System.out.println(sistema1.traerServicio(true, fecha)); // Servicios en promoción para la fecha
        } catch (ErrrorNoHayServiciosEnPromoException e) {
            System.out.println(e.getMessage());
        }
    }
}