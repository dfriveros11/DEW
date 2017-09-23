/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb.relacion;

import co.edu.uniandes.theexceptions.nboletas.persistence.relacion.AbstractPersistenceRelacion;
import java.util.List;

/**
 *
 * @author df.riveros11
 * @param <T>
 * @param <P>
 */
public abstract class AbstractLogicRelacion <T, P> {
    
    protected abstract AbstractPersistenceRelacion<T, P> getPersistenceOne();
    protected abstract AbstractPersistenceRelacion<T, P> getPersistenceTwo();
    
    public P create(Object id, P entity){
        return getPersistenceTwo().create(id, entity);
    }

    public void update(Object idT, Object idP){
        getPersistenceOne().update(idT, idP);
    }
    
    public P delete(Object id, P entity){
        return getPersistenceTwo().delete(id, entity);
    }
    
    public P find(Object idT, Object idP){
        return getPersistenceTwo().find(idT, idP);
    }
    
    public List<P> findAll(Object id){
        return getPersistenceTwo().findAll(id);
    }  
}
