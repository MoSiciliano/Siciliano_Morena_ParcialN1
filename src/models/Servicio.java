/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.ErrorCodInvalidoException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author More Siciliano
 */
public abstract class Servicio {

    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected static final Set<String> codExist = new HashSet<>();

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws ErrorCodInvalidoException {
        validarCodServicio(codServicio);
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }
    
    
    public void validarCodServicio(String codServicio) throws ErrorCodInvalidoException {
        if (codServicio == null || codServicio.length() != 6) {
            throw new ErrorCodInvalidoException("Error. El codigo debe contener 6 caracteres.");
        }
        if (!codExist.add(codServicio)) {
            throw new ErrorCodInvalidoException("Error. El codigo " + codServicio + "ya existe.");
        }

    }

    protected abstract double calcularPrecioFinal(LocalDate dia);

    @Override
    public String toString() {
        return String.format("\nCodigo de Servicio: %s\n porcentajeDescuento: %.2f\n enPromocion: %s",
                codServicio, porcentajeDescuento, (enPromocion ? "Si":"No"));
    }
 
}
