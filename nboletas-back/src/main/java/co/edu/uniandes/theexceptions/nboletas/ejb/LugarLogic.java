/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.LugarEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.LugarPersistence;
import javax.inject.Inject;

/**
 *
 * @author ja.gomez1
 */
public class LugarLogic extends AbstractLogic<LugarEntity>{
    @Inject
    private LugarPersistence persistence;
    
    @Override
    protected AbstractPersistence<LugarEntity> getPersistence() {
        return persistence;
    }
    
}
