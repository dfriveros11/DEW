/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.DivisionDeLugarEntity;
import javax.ejb.Stateless;

/**
 *
 * @author fc.alvarez10
 */
@Stateless
public class DivisionDeLugarPersistence extends AbstractPersistence<DivisionDeLugarEntity> {

    public DivisionDeLugarPersistence() {
        super(DivisionDeLugarEntity.class);
    }

}
