/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.dtos;

import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;

/**
 *
 * @author jm.contreras10
 */
public class ReembolsoDTO {

    private Long id;
    private Double valor;

    public ReembolsoDTO() {

    }

    public ReembolsoDTO(ReembolsoEntity entity) {
        this.id = entity.getId();
        this.valor = entity.getValor();
    }

    public ReembolsoEntity toEntity() {
        ReembolsoEntity entity = new ReembolsoEntity();
        entity.setId(this.id);
        entity.setValor(this.valor);
        return entity;
    }

}
