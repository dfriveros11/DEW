/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.entities;

import java.io.Serializable;
import java.util.Date;
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
 * @author df.riveros11
 */
@Entity
public class FuncionEntity extends BaseEntity implements Serializable {
   @Temporal(TemporalType.DATE)
   private Date fecha;
   
   @PodamExclude
   @OneToMany(fetch = FetchType.LAZY, mappedBy = "funcion")
   private List<BoletaEntity> boletas;
   
   @PodamExclude
   @ManyToOne(fetch = FetchType.LAZY)
   private List<LugarEntity> funciones;
   
   @PodamExclude
   @OneToOne(fetch = FetchType.LAZY)
   private EspectaculoEntity espectaculo;
}
