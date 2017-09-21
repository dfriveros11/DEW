/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author angeloMarcetty
 */
@Entity
public class ComentarioEntity extends BaseEntity implements Serializable {
    
    @PodamExclude   
    private BoletaEntity boleta;
   
    
    @PodamExclude
    @ManyToOne(fetch = FetchType.LAZY)
    private EspectaculoEntity espectaculo;
        
    
    private String comentario;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the boleta
     */
    public BoletaEntity getBoleta() {
        return boleta;
    }

    /**
     * @param boleta the boleta to set
     */
    public void setBoleta(BoletaEntity boleta) {
        this.boleta = boleta;
    }

    /**
     * @return the espectaculo
     */
    public EspectaculoEntity getEspectaculo() {
        return espectaculo;
    }

    /**
     * @param espectaculo the espectaculo to set
     */
    public void setEspectaculo(EspectaculoEntity espectaculo) {
        this.espectaculo = espectaculo;
    }
    
    
    
    
    
    
    
    
}
