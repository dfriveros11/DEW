/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.EspectaculoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class EspectaculoLogic extends AbstractLogic<EspectaculoEntity> {
    
    @Inject
    private EspectaculoPersistence persistence;

    @Override
    protected AbstractPersistence<EspectaculoEntity> getPersistence() {
         return persistence;
    }

}
