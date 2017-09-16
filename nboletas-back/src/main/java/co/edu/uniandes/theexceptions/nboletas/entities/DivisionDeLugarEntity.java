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
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author fc.alvarez10
 */
@Entity
public class DivisionDeLugarEntity extends BaseEntity implements Serializable{
    
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "divisionDeLugar")
    private List<SillaEntity> sillas;
    
    
    @PodamExclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "divisionDeLugar")
    private LugarEntity lugar;
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
