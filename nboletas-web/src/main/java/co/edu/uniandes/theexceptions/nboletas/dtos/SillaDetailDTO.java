/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.SillaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fc.alvarez10
 */
public class SillaDetailDTO extends SillaDTO {

    private DivisionDeLugarDTO division;
    
    private List<BoletaDTO> boletas;
    
    public SillaDetailDTO() {
    }

    public SillaDetailDTO(SillaEntity entity) {
        super(entity);
        if(entity.getDivision()!=null){
            this.division= new DivisionDeLugarDTO(entity.getDivision());
        }
        if(entity.getBoletas()!=null){
            this.boletas = new ArrayList<>();
        for (BoletaEntity b : entity.getBoletas()) {
            boletas.add(new BoletaDTO(b));
        }
        }
    }

    public DivisionDeLugarDTO getDivision() {
        return division;
    }

    public void setDivision(DivisionDeLugarDTO division) {
        this.division = division;
    }

    public List<BoletaDTO> getBoletas() {
        return boletas;
    }

    public void setBoletas(List<BoletaDTO> boletas) {
        this.boletas = boletas;
    }

    @Override
    public SillaEntity toEntity() {
        SillaEntity silla = super.toEntity();
        if(getDivision()!=null){
            silla.setDivision(division.toEntity());
        }
        if(getBoletas()!=null){
            List<BoletaEntity> boletasE= new ArrayList<>();
            for(BoletaDTO b:getBoletas()){
                boletasE.add(b.toEntity());
            }
            silla.setBoletas(boletasE);
        }
        return silla;
    }

}
