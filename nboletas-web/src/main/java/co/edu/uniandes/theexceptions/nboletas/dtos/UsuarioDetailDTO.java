/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;

/**
 *
 * @author jm.contreras10
 */
public class UsuarioDetailDTO extends UsuarioDTO {

    public UsuarioDetailDTO(UsuarioEntity entity) {
        super(entity);
    }

    @Override
    public UsuarioEntity toEntity() {
        return super.toEntity();
    }

}
