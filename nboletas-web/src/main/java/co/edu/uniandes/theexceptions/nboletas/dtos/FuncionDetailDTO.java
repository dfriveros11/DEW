/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.FuncionEntity;

/**
 *
 * @author ja.gomez1
 */
public class FuncionDetailDTO extends FuncionDTO {

    public FuncionDetailDTO(FuncionEntity entity) {
        super(entity);
    }
    
    @Override
    public FuncionEntity toEntity() {
        return super.toEntity();
    }
}
