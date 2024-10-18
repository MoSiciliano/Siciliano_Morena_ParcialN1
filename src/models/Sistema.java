/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.ErrorCodInvalidoException;
import exceptions.ErrrorNoHayServiciosEnPromoException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa un sistema de gestión de servicios de hospedaje y gastronomía.
 * Permite agregar, buscar y filtrar servicios según diferentes criterios, como 
 * código de servicio y promociones.
 * 
 * El sistema mantiene una lista de servicios que se pueden gestionar a través
 * de sus métodos.
 * 
 * Autor: More Siciliano
 */
public class Sistema {

   // Lista que almacena los servicios disponibles en el sistema.
    private List<Servicio> lstServicio;

    /**
     * Constructor de la clase Sistema.
     * Inicializa la lista de servicios.
     */

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }
    /**
     * Obtiene la lista de servicios en el sistema.
     * 
     * @return Lista de servicios.
     */
    public List<Servicio> getLstServicio() {
        return lstServicio;
    }
    
    /**
     * Busca un servicio en el sistema por su código.
     * Si el servicio existe, lo retorna; de lo contrario, lanza una excepción.
     * 
     * @param codServicio Código del servicio a buscar.
     * @return Servicio encontrado.
     * @throws ErrorCodInvalidoException Si no se encuentra un servicio con el código especificado.
     */
    
    public Servicio traerServicio(String codServicio) throws ErrorCodInvalidoException {
        for (Servicio s : this.lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        throw new ErrorCodInvalidoException("Error. No existe un servicio con ese codigo");
    }

    
    /**
     * Filtra los servicios según si están en promoción o no.
     * Si no hay servicios que cumplan con la condición, lanza una excepción.
     * 
     * @param enPromocion Estado de promoción que se desea filtrar.
     * @return Lista de servicios que cumplen con la condición.
     * @throws ErrrorNoHayServiciosEnPromoException Si no hay servicios en la condición especificada.
     */
    public List<Servicio> traerServicio(boolean enPromocion) throws ErrrorNoHayServiciosEnPromoException {
        List<Servicio> lstEnPromo = new ArrayList<>();
        for (Servicio s : this.lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                lstEnPromo.add(s);
            }
        }
        if (lstEnPromo.isEmpty()) {
            throw new ErrrorNoHayServiciosEnPromoException("Error.No existen servicios con esta condicion.");
        }
        return lstEnPromo;
    }
    /**
     * Filtra los servicios según si están en promoción y la fecha especificada.
     * Si no hay servicios que cumplan con la condición, lanza una excepción.
     * 
     * @param enPromocion Estado de promoción que se desea filtrar.
     * @param dia Fecha que se utiliza para filtrar los servicios.
     * @return Lista de servicios que cumplen con la condición.
     * @throws ErrrorNoHayServiciosEnPromoException Si no hay servicios en la condición especificada.
     */
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) throws ErrrorNoHayServiciosEnPromoException {
        List<Servicio> lstEnPromo = new ArrayList<>();
        DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
        int diaNumero = diaSemana.getValue();
        for (Servicio s : this.lstServicio) {
            if (s instanceof Gastronomia g) {
                if (g.isEnPromocion() && diaNumero == g.getDiaSemDesc()) {
                    lstEnPromo.add(s);
                } 
            } else if(s instanceof Hospedaje h){
                if(h.isEnPromocion()){
                    lstEnPromo.add(h);
                }
            }
        }
        if (lstEnPromo.isEmpty()) {
            throw new ErrrorNoHayServiciosEnPromoException("Error.No existen servicios con esta condicion.");
        }
        return lstEnPromo;
    }
        /**
     * Agrega un nuevo servicio de gastronomía al sistema.
     * Si el servicio ya existe, lanza una excepción.
     * 
     * @param codServicio Código del nuevo servicio.
     * @param porcentajeDescuento Porcentaje de descuento del servicio.
     * @param enPromocion Estado de promoción del servicio.
     * @param gastronomia Nombre del servicio gastronómico.
     * @param precio Precio del servicio gastronómico.
     * @param diaSemDesc Día de la semana con descuento para el servicio gastronómico.
     * @return true si el servicio fue agregado exitosamente.
     * @throws ErrorCodInvalidoException Si el servicio ya existe en el sistema.
     */
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws ErrorCodInvalidoException{
        for(Servicio s : this.lstServicio){
            if(s.getCodServicio().equals(codServicio)){
                throw new ErrorCodInvalidoException("Error. El servicio con codigo: " + codServicio + "ya existe.");
            } 
        }
        Gastronomia nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento,enPromocion,gastronomia,precio,diaSemDesc);
        return this.lstServicio.add(nuevoServicio);
        
    }
    /**
     * Agrega un nuevo servicio de hospedaje al sistema.
     * Si el servicio ya existe, lanza una excepción.
     * 
     * @param codServicio Código del nuevo servicio.
     * @param porcentajeDescuento Porcentaje de descuento del servicio.
     * @param enPromocion Estado de promoción del servicio.
     * @param hospedaje Nombre del servicio de hospedaje.
     * @param precioPorNoche Precio por noche del servicio de hospedaje.
     * @return true si el servicio fue agregado exitosamente.
     * @throws ErrorCodInvalidoException Si el servicio ya existe en el sistema.
     */
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje,double precioPorNoche) throws ErrorCodInvalidoException{
        for(Servicio s : this.lstServicio){
            if(s.getCodServicio().equals(codServicio)){
                throw new ErrorCodInvalidoException("Error. El servicio con codigo: " + codServicio + "ya existe.");
            } 
        }
        Hospedaje nuevoServicio = new Hospedaje(codServicio, porcentajeDescuento,enPromocion,hospedaje,precioPorNoche);
        return this.lstServicio.add(nuevoServicio);
    }

    
}
