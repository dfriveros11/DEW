/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.UsuarioPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jm.contreras10
 */
@Stateless
public class UsuarioLogic extends AbstractLogic<UsuarioEntity> {

    @Inject
    private UsuarioPersistence persistence;

    @Override
    protected AbstractPersistence<UsuarioEntity> getPersistence() {
        return persistence;
    }
    
    public UsuarioEntity findByUserName(String userName){
        return persistence.findByUserName(userName);
    }

}
