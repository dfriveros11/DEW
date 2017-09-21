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
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author jf.ramos
 */
@Entity
public class EspectaculoEntity extends BaseEntity implements Serializable {
    
    @PodamExclude
    @ManyToMany(fetch = FetchType.LAZY)
    private List<OrganizadorEntity> organizador;
    
    @PodamExclude
    @ManyToMany(fetch = FetchType.LAZY)
    private List<ArtistaEntity> artista;
    
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY)
    private List<FuncionEntity> funcion;
    
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY)
    private List<ComentarioEntity> comentario;
    
    private String nombre;
    
    private String descripcion;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
