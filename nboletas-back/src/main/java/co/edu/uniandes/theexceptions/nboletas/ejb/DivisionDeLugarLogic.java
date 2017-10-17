/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.DivisionDeLugarEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.DivisionDeLugarPersistence;
import javax.inject.Inject;

/**
 *
 * @author fc.alvarez10
 */
public class DivisionDeLugarLogic extends AbstractLogic<DivisionDeLugarEntity> {

    @Inject
    private DivisionDeLugarPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Override
    protected AbstractPersistence<DivisionDeLugarEntity> getPersistence() {
        return persistence;
    }

}
