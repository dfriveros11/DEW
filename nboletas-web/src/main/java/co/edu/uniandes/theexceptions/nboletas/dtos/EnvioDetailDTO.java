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
public class EnvioDetailDTO extends EnvioDTO { /**
     * relacion con boleta 
     */
    private BoletaDTO boleta;
    
   
      /**
     * Constructor por defecto
     */
    public EnvioDetailDTO(){
        super();
    }
    
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public EnvioDetailDTO(EnvioEntity entity){
        super(entity);
        
        if(entity.getBoleta() !=null)
        {
            this.boleta = new BoletaDTO(entity.getBoleta());
        }
        else
        {
            entity.setBoleta(null);
        }
        
    }
    
    
    
    
    
      /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    public EnvioEntity toEntity() {
        EnvioEntity envEnt = super.toEntity();

        if (this.getBoleta() != null)
        {
            envEnt.setBoleta(this.getBoleta().toEntity());
        }

       return envEnt;
    }

    
    
    
       
   
  
    /**
     * @return the boleta
     */
    public BoletaDTO getBoleta() {
        return boleta;
    }

    /**
     * @param boleta the boleta to set
     */
    public void setBoleta(BoletaDTO boleta) {
        this.boleta = boleta;
    }
    
    
    
    
}
