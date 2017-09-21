/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;

/**
 *
 * @author angeloMarcetty
 */
public class EnvioDetailDTO extends EnvioDTO {
    
  public EnvioDetailDTO(EnvioEntity entity){
      super(entity);
  }
  
  @Override
  public EnvioEntity toEntity(){
      return super.toEntity();
  }
    
    
}
