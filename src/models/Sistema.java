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
 *
 * @author More Siciliano
 */
public class Sistema {

    private List<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }
    
    public Servicio traerServicio(String codServicio) throws ErrorCodInvalidoException {
        for (Servicio s : this.lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        throw new ErrorCodInvalidoException("Error. No existe un servicio con ese codigo");
    }

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
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws ErrorCodInvalidoException{
        for(Servicio s : this.lstServicio){
            if(s.getCodServicio().equals(codServicio)){
                throw new ErrorCodInvalidoException("Error. El servicio con codigo: " + codServicio + "ya existe.");
            } 
        }
        Gastronomia nuevoServicio = new Gastronomia(codServicio, porcentajeDescuento,enPromocion,gastronomia,precio,diaSemDesc);
        return this.lstServicio.add(nuevoServicio);
        
    }
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
