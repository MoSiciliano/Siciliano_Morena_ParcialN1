/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;
/**
 * Clase que representa una excepción personalizada para manejar errores
 * relacionados con códigos de servicio inválidos en el sistema.
 * Esta excepción se lanza cuando se intenta utilizar un código que no 
 * cumple con los criterios establecidos, como longitud o unicidad.
 * 
 * Extiende la clase Exception, lo que permite su uso en bloques try-catch 
 * para el manejo de errores.
 * 
 * @author More Siciliano
 */
public class ErrorCodInvalidoException extends Exception{
     // Mensaje que describe el error.
    private String mensaje;
    /**
     * Constructor de la clase ErrorCodInvalidoException.
     * Inicializa el mensaje de error que se asociará con la excepción.
     *
     * @param mensaje Descripción del error que se ha producido.
     */

    public ErrorCodInvalidoException(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
     * Método que devuelve el mensaje de error asociado a la excepción.
     * Este mensaje se puede utilizar para proporcionar información sobre 
     * la causa del error al usuario o a los desarrolladores.
     *
     * @return Mensaje de error.
     */
    @Override
    public String getMessage() {
        return this.mensaje;
    }
    
    
}
