/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.ReembolsoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jm.contreras10
 */
@Stateless
public class ReembolsoLogic extends AbstractLogic<ReembolsoEntity> {

    @Inject
    private ReembolsoPersistence persistence;

    @Override
    protected AbstractPersistence<ReembolsoEntity> getPersistence() {
        return persistence;
    }

}
