/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.SillaEntity;

/**
 *
 * @author fc.alvarez10
 */
public class SillaDetailDTO extends SillaDTO{
    
    public SillaDetailDTO(){
        
    }
    
    public SillaDetailDTO(SillaEntity entity){
        super(entity);
    }
    
    public SillaEntity toEntity(){
        SillaEntity silla=super.toEntity();
        return silla;
    }
}
