/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.entities;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author df.riveros11
 */
class ReembolsoEntity {
    
    @PodamExclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "reembolso")
    private BoletaEntity boleta;
    
    
    
}
