/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence.relacion;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author df.riveros11
 * @param <T>
 * @param <P>
 */
@Stateless
public class AbstractPersistenceRelacion <T, P>{
    
    private final Class<T> entityClassT;
    private final Class<P> entityClassP;
            
    public AbstractPersistenceRelacion(Class<T> entityClassT, Class<P> entityClassP){
        this.entityClassT = entityClassT; 
        this.entityClassP = entityClassP;
    }
    
      
    @PersistenceContext(unitName = "nboletasPU")
    private EntityManager em;
    
    public P create(Object id, P entity){
        em.createQuery("INSERT INTO c values (c)", entity.getClass());
        em.createQuery("INSERT INTO d values ")
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
