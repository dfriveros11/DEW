/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.entities;

import java.util.List;
import javax.persistence.OneToMany;

/**
 *
 * @author df.riveros11
 */
class Usuario {
    
    @OneToMany()
    private List<BoletaEntity> boletas;
    
}
