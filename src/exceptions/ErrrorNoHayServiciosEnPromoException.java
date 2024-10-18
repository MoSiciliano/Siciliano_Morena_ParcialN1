/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;
/**
 * Clase que representa una excepción personalizada que se lanza cuando no hay
 * servicios disponibles en promoción.
 * Esta excepción extiende la clase Exception y permite manejar
 * situaciones específicas relacionadas con la ausencia de servicios en promoción.
 * 
 * Autor: More Siciliano
 */
public class ErrrorNoHayServiciosEnPromoException extends Exception {
    // Mensaje que describe el motivo de la excepción.
    private String mensaje;

    /**
     * Constructor de la excepción que acepta un mensaje de error.
     * 
     * @param mensaje Mensaje que describe el error.
     */
    public ErrrorNoHayServiciosEnPromoException(String mensaje) {
        this.mensaje = mensaje;
    }
     /**
     * Método que retorna el mensaje de error asociado a la excepción.
     * 
     * @return Mensaje de error.
     */
    @Override
    public String getMessage() {
        return this.mensaje;
    }

    
}
