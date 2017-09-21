/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;

/**
 *
 * @author angeloMarcetty
 */
public class ComentarioDetailDTO extends ComentarioDTO {
    
    public ComentarioDetailDTO(ComentarioEntity entity){
        super(entity);
    }
    
    @Override
    public ComentarioEntity toEntity(){
        return super.toEntity();
    }
    
    
}
