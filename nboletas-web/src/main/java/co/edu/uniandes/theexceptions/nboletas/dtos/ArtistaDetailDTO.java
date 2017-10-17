/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.ArtistaEntity;

/**
 *
 * @author jf.ramos
 */
public class ArtistaDetailDTO extends ArtistaDTO {

    /**
     * Constructor por defecto
     */
    public ArtistaDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ArtistaDetailDTO(ArtistaEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return
     */
    @Override
    public ArtistaEntity toEntity() {
        ArtistaEntity BoletaE = super.toEntity();
        return BoletaE;
    }

}
