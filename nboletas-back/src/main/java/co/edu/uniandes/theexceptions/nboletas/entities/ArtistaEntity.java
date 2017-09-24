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
import javax.persistence.ManyToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jf.ramos
 */
@Entity
public class ArtistaEntity extends BaseEntity implements Serializable {

    private String nombre;

    @PodamExclude
    @ManyToMany(fetch = FetchType.LAZY)
    private List<EspectaculoEntity> espectaculos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EspectaculoEntity> getEspectaculos() {
        return espectaculos;
    }

    public void setEspectaculos(List<EspectaculoEntity> espectaculos) {
        this.espectaculos = espectaculos;
    }

}
