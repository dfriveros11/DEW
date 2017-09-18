/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author df.riveros11
 */
@Entity
public class ComentarioEntity extends BaseEntity implements Serializable {
    
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comentario")
    private List<BoletaEntity> boletas;
    
}