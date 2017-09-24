/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.OrganizadorEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.OrganizadorPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author df.riveros11
 */
@Stateless
public class OrganizadorLogic extends AbstractLogic<OrganizadorEntity> {

    @Inject
    private OrganizadorPersistence persistence;

    @Override
    protected AbstractPersistence<OrganizadorEntity> getPersistence() {
        return persistence;
    }

}
