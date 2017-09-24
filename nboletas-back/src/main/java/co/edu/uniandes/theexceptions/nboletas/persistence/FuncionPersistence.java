/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.FuncionEntity;
import javax.ejb.Stateless;

/**
 *
 * @author ja.gomez1
 */
@Stateless
public class FuncionPersistence extends AbstractPersistence<FuncionEntity> {

    public FuncionPersistence() {
        super(FuncionEntity.class);
    }
}
