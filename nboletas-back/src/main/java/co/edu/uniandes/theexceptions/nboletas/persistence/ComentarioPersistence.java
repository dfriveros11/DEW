/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author angeloMarcetty
 */
@Stateless
public class ComentarioPersistence extends AbstractPersistence<ComentarioEntity> {

    public ComentarioPersistence() {
        super(ComentarioEntity.class);
    }
    
    
    
    public ComentarioEntity update(ComentarioEntity entity)throws IllegalArgumentException {
        String setStatement = "";
        if(entity.getComentario() != null) setStatement += "COMENTARIO = '" + entity.getComentario() + "', ";
        if(!setStatement.equals("")) setStatement = setStatement.substring(0, setStatement.length() - 2);
        
        Query q = em.createNativeQuery("UPDATE COMENTARIOENTITY SET " + setStatement + " WHERE ID = " + entity.getId());
        q.executeUpdate();
        return entity;
     
    }
    
    
    
    
}
