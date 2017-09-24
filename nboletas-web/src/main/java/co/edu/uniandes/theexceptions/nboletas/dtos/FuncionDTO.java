/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.FuncionEntity;
import java.util.Date;

/**
 *
 * @author ja.gomez1
 */
public class FuncionDTO {

    private Long id;
    private Date fecha;

    public FuncionDTO() {
    }

    public FuncionDTO(FuncionEntity entity) {
        this.id = entity.getId();
        this.fecha = entity.getFecha();
    }

    public FuncionEntity toEntity() {
        FuncionEntity entity = new FuncionEntity();
        entity.setId(this.getId());
        entity.setFecha(this.getFecha());
        return entity;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
