/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.DivisionDeLugarEntity;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
//import javax.persistence.PersistenceException;

/**
 *
 * @author fc.alvarez10
 */
@Stateless
public class DivisionDeLugarPersistence extends AbstractPersistence<DivisionDeLugarEntity> {

    public DivisionDeLugarPersistence() {
        super(DivisionDeLugarEntity.class);
    }
   
    public DivisionDeLugarEntity update(DivisionDeLugarEntity entity) throws PersistenceException{
        String query ="";
        if(entity.getNombre()!=null){
            query += "NOMBRE= '" + entity.getNombre() + "',";
        }
        if(entity.getLugar()!=null){
            query += "LUGAR_ID= " + entity.getLugar().getId() + ",";
        }
        if(!query.equals("")){
            query = query.substring(0, query.length()-2);
        }
        Query q = em.createNativeQuery("UPDATE APP.DIVISIONDELUGARENTITY SET " + query + " WHERE ID = " + entity.getId());
        q.executeUpdate();
        return entity;
    }
    
 }
