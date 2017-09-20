/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.LugarEntity;
/**
 *
 * @author ja.gomez1
 */
public class LugarPersistence extends AbstractPersistence<LugarEntity> {
    public LugarPersistence() {
        super(LugarEntity.class);
    }
}
