/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.OrganizadorEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author df.riveros11
 */
@Stateless
public class OrganizadorPersistence extends AbstractPersistence<OrganizadorEntity> {

    public OrganizadorPersistence() {
        super(OrganizadorEntity.class);
    }

}
