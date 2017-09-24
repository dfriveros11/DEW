/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import javax.ejb.Stateless;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class EspectaculoPersistence extends AbstractPersistence<EspectaculoEntity> {

    public EspectaculoPersistence() {
        super(EspectaculoEntity.class);
    }

}
