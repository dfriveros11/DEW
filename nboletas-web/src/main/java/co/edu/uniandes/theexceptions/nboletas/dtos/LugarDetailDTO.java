/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.LugarEntity;

/**
 *
 * @author ja.gomez1
 */
public class LugarDetailDTO extends LugarDTO {

    public LugarDetailDTO() {
    }

    public LugarDetailDTO(LugarEntity entity) {
        super(entity);
    }
    
    @Override
    public LugarEntity toEntity() {
        return super.toEntity();
    }
}
