/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence.relacion;

import java.util.List;

/**
 *
 * @author df.riveros11
 * @param <T>
 * @param <P>
 */
public class AbstractPersistenceRelacion <T, P>{
    
    public P create(Object id, P entity){
        return null;
    }
    
    public void update(Object idT, Object idP){
        
    }
    
    public P delete(Object id, P entity){
        return null;
    }
    
    public P find(Object idT, Object idP){
        return null;
    }
    
    public List<P> findAll(Object id){
        return null;
    }
}
