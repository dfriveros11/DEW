/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jm.contreras10
 */

public class UsuarioDetailDTO extends UsuarioDTO{
    
    private List<BoletaDTO> boletasCompradas;
    
    private List<ReembolsoDTO> reembolsos;

    public UsuarioDetailDTO(UsuarioEntity entity) {
        super(entity);
        List<BoletaDTO> bols = new LinkedList<>();
        for(BoletaEntity b : entity.getBoletas()){
            bols.add(new BoletaDTO(b));
        }
        List<ReembolsoDTO> reem = new LinkedList<>();
        for(ReembolsoEntity r : entity.getReembolsos()){
            reem.add(new ReembolsoDTO(r));
        }
        
        boletasCompradas = bols;
        reembolsos = reem;
        
    }

    @Override
    public UsuarioEntity toEntity() {
        UsuarioEntity entity = super.toEntity();
        
        List<BoletaEntity> bols = new LinkedList<>();
        for(BoletaDTO b : this.boletasCompradas){
            bols.add(b.toEntity());
        }
        
        List<ReembolsoEntity> reems = new LinkedList<>();
        for(ReembolsoDTO r : this.reembolsos){
            reems.add(r.toEntity());
        }
        entity.setBoletas(bols);
        entity.setReembolsos(reems);
        
        return entity;
    }

    public List<BoletaDTO> getBoletasCompradas() {
        return boletasCompradas;
    }

    public void setBoletasCompradas(List<BoletaDTO> boletasCompradas) {
        this.boletasCompradas = boletasCompradas;
    }

    public List<ReembolsoDTO> getReembolsos() {
        return reembolsos;
    }

    public void setReembolsos(List<ReembolsoDTO> reembolsos) {
        this.reembolsos = reembolsos;
    }

}
