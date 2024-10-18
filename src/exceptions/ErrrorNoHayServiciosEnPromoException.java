/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author More Siciliano
 */
public class ErrrorNoHayServiciosEnPromoException extends Exception {
    private String mensaje;

    public ErrrorNoHayServiciosEnPromoException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }

    
}
