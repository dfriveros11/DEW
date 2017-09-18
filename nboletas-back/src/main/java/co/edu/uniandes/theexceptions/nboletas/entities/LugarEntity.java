/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 *
 * @author ja.gomez1
 */
@Entity
public class LugarEntity extends BaseEntity implements Serializable {
    private String tipo;
    private String direccion;
    private String ubicacion;
    
    @PodamExclude
    @OneToMany
    private List<FuncionEntity> funciones;
    
    @PodamExclude
    @OneToMany
    private List<DivisionLugarEntity> divisiones;
}