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
 /**
     * relacion con boleta 
     */
    private BoletaDTO boleta;
    
    /**
     * relacion con Espectaculo
     */
    private EspectaculoDTO espectaculo;
    
    
    
    
    
    /**
     * Constructor por defecto
     */
    public ComentarioDetailDTO(){
        super();
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public ComentarioDetailDTO(ComentarioEntity entity){
        super(entity);
        
        if(entity != null)
        {
           if(entity.getBoleta() !=null)
           {
               this.boleta = new BoletaDTO(entity.getBoleta());              
           }
           else
           {
               entity.setBoleta(null);
           }
           
           if(entity.getEspectaculo() !=null)
           {
               this.espectaculo = new EspectaculoDTO(entity.getEspectaculo());
           }
           else
           {
               entity.setEspectaculo(null);
           }

        }
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    public ComentarioEntity toEntity(){
        ComentarioEntity comentEnt = super.toEntity();
        
        if(this.getBoleta() != null)
        {
            comentEnt.setBoleta(this.getBoleta().toEntity());
        }
        if(this.getComentario() !=null)
        {
//            comentEnt.setComentario(this.getComentario().toEntity());
        }
        
        return comentEnt;
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

    /**
     * @return the espectaculo
     */
    public EspectaculoDTO getEspectaculo() {
        return espectaculo;
    }

    /**
     * @param espectaculo the espectaculo to set
     */
    public void setEspectaculo(EspectaculoDTO espectaculo) {
        this.espectaculo = espectaculo;
    }
    
    


}
