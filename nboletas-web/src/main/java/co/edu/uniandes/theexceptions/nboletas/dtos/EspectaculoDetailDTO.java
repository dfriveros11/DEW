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
public class EspectaculoDetailDTO extends EspectaculoDTO{
    /**
     * Constructor por defecto
     */
    public EspectaculoDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public EspectaculoDetailDTO(EspectaculoEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public EspectaculoEntity toEntity() {
        EspectaculoEntity BoletaE = super.toEntity();
        return BoletaE;
    }
}
