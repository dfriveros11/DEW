/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.SillaEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.SillaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author fc.alvarez10
 */
@Stateless
public class SillaLogic extends AbstractLogic<SillaEntity> {

    @Inject
    private SillaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Override
    protected AbstractPersistence<SillaEntity> getPersistence() {
        return persistence;
    }
}
