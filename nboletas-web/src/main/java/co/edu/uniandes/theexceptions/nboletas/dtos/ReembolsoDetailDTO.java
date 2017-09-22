/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;

/**
 *
 * @author jm.contreras10
 */
public class ReembolsoDetailDTO extends ReembolsoDTO{
            
    public ReembolsoDetailDTO(ReembolsoEntity entity) {
        super(entity);
    }
    
    @Override
    public ReembolsoEntity toEntity() {
        return super.toEntity();
    }
    
}
