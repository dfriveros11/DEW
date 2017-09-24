/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;

/**
 *
 * @author jf.ramos
 */
public class EspectaculoDTO {

    private Long id;
    private String nombre;
    private String descripcion;

    /**
     * Constructor por defecto
     */
    public EspectaculoDTO() {
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param espectaculo: Es la entidad que se va a convertir a DTO
     */
    public EspectaculoDTO(EspectaculoEntity espectaculo) {
        this.id = espectaculo.getId();
        this.nombre = espectaculo.getNombre();
        this.descripcion = espectaculo.getDescripcion();
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public EspectaculoEntity toEntity() {
        EspectaculoEntity entity = new EspectaculoEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setDescripcion(this.descripcion);
        return entity;
    }

}
