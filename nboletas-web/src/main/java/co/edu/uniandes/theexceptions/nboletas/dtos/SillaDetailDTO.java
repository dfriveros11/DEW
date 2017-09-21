/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.SillaEntity;
import java.util.List;

/**
 *
 * @author fc.alvarez10
 */
public class SillaDetailDTO extends SillaDTO{
    
    private DivisionDeLugarDTO divisionDeLugar;
    
    private List<BoletaDTO> boletas;
    
    public SillaDetailDTO(){
        
    }
    
    public SillaDetailDTO(SillaEntity entity){
        super(entity);
    }
    
    @Override
    public SillaEntity toEntity(){
        SillaEntity silla=super.toEntity();
        return silla;
    }

    public DivisionDeLugarDTO getDivisionDeLugar() {
        return divisionDeLugar;
    }

    public void setDivisionDeLugar(DivisionDeLugarDTO divisionDeLugar) {
        this.divisionDeLugar = divisionDeLugar;
    }

    public List<BoletaDTO> getBoletas() {
        return boletas;
    }

    public void setBoletas(List<BoletaDTO> boletas) {
        this.boletas = boletas;
    }
    
    
}
