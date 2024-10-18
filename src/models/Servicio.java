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
 * Clase abstracta Servicio que representa un servicio en el sistema.
 * Contiene atributos comunes a todos los servicios, como el código del servicio,
 * el porcentaje de descuento aplicable y el estado de promoción.
 * Esta clase sirve como base para otros tipos de servicios, como Gastronomía y Hospedaje.
 * 
 * @author More Siciliano
 */
public abstract class Servicio {
    // Atributo que almacena el código del servicio.
    protected String codServicio;
    // Atributo que almacena el código del servicio.
    protected double porcentajeDescuento;
    // Atributo que indica si el servicio está actualmente en promoción.
    protected boolean enPromocion;
     // Conjunto estático que almacena los códigos de servicios existentes para evitar duplicados.
    protected static final Set<String> codExist = new HashSet<>();

    /**
     * Constructor de la clase Servicio.
     * Inicializa los atributos y valida el código del servicio.
     *
     * @param codServicio Código del servicio que debe ser único.
     * @param porcentajeDescuento Porcentaje de descuento aplicable al servicio.
     * @param enPromocion Indica si el servicio está en promoción.
     * @throws ErrorCodInvalidoException Si el código del servicio no es válido.
     */
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) throws ErrorCodInvalidoException {
        validarCodServicio(codServicio);
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }
    /**
     * Método getter para obtener el código del servicio.
     *
     * @return El código del servicio.
     */
    public String getCodServicio() {
        return codServicio;
    }
        /**
     * Método getter para verificar si el servicio está en promoción.
     *
     * @return true si el servicio está en promoción, false en caso contrario.
     */

    public boolean isEnPromocion() {
        return enPromocion;
    }
    
    /**
     * Método que valida el código del servicio.
     * El código debe tener exactamente 6 caracteres y ser único.
     *
     * @param codServicio Código del servicio a validar.
     * @throws ErrorCodInvalidoException Si el código es nulo, no tiene 6 caracteres o ya existe.
     */
    public void validarCodServicio(String codServicio) throws ErrorCodInvalidoException {
        if (codServicio == null || codServicio.length() != 6) {
            throw new ErrorCodInvalidoException("Error. El codigo debe contener 6 caracteres.");
        }
        if (!codExist.add(codServicio)) {
            throw new ErrorCodInvalidoException("Error. El codigo " + codServicio + "ya existe.");
        }

    }
     /**
     * Método abstracto que debe ser implementado por las subclases para calcular el precio final
     * del servicio en función de una fecha dada.
     *
     * @param dia Fecha para calcular el precio final.
     * @return Precio final calculado.
     */
    protected abstract double calcularPrecioFinal(LocalDate dia);

    
    /**
     * Método toString que devuelve una representación en cadena del objeto Servicio.
     * Incluye información sobre el código del servicio, el porcentaje de descuento
     * y el estado de promoción.
     *
     * @return Representación en cadena del objeto Servicio.
     */

    @Override
    public String toString() {
        return String.format("\nCodigo de Servicio: %s\n porcentajeDescuento: %.2f\n enPromocion: %s",
                codServicio, porcentajeDescuento, (enPromocion ? "Si":"No"));
    }
 
}
