/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;

/**
 *
 * @author angeloMarcetty
 */
public class EnvioDetailDTO extends EnvioDTO {
    
    private BoletaDTO boleta;
    
    public EnvioDetailDTO(){
        super();
    }
    
  public EnvioDetailDTO(EnvioEntity entity){
      super(entity);
      BoletaEntity boletaA = entity.getBoleta();
      if(null != boletaA){
          this.boleta = new BoletaDTO(boletaA);
      }
  }
  
  @Override
  public EnvioEntity toEntity(){
      EnvioEntity envioE = super.toEntity();
      if(this.boleta != null){
          envioE.setBoleta(boleta.toEntity());
      }
      return envioE;
  }
    
    
}
