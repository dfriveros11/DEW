/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.OrganizadorEntity;

/**
 *
 * @author df.riveros11
 */
public class OrganizadorDetailDTO extends OrganizadorDTO{
    
    public OrganizadorDetailDTO(){
    }
    
    public OrganizadorDetailDTO(OrganizadorEntity entity){
        super(entity);
    }
    
    @Override
    public OrganizadorEntity toEntity(){
        OrganizadorEntity entity = super.toEntity();
        return entity;
    }
}
