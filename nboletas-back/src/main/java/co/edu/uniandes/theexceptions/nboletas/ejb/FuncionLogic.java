/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.FuncionEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.FuncionPersistence;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author ja.gomez1
 */
@Stateful
public class FuncionLogic extends AbstractLogic<FuncionEntity>{
    @Inject
    private FuncionPersistence persistence;
    
    @Override
    protected AbstractPersistence<FuncionEntity> getPersistence() {
        return persistence;
    }
    
}
