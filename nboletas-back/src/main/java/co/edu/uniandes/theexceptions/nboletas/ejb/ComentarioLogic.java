/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.ComentarioPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author angeloMarcetty
 */
@Stateless
public class ComentarioLogic extends AbstractLogic<ComentarioEntity> {

    @Inject
    private ComentarioPersistence persistence;
    
        @Override
        protected AbstractPersistence<ComentarioEntity> getPersistence(){
            return persistence;
        }
    

}
