/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author jm.contreras10
 */
@Stateless
public class UsuarioPersistence extends AbstractPersistence<UsuarioEntity> {

    public UsuarioPersistence() {
        super(UsuarioEntity.class);
    }
    
    public UsuarioEntity findByUserName(String userName){
        TypedQuery query = em.createQuery("Select e From UsuarioEntity e where e.userName = :uName", UsuarioEntity.class);
                // Se remplaza el placeholder ":codigo" con el valor del argumento 
        query = query.setParameter("uName", userName);
        // Se invoca el query se obtiene la lista resultado
        List<UsuarioEntity> sameCodigo = query.getResultList();
        if (sameCodigo.isEmpty()) {
            return null;
        } else {
            return sameCodigo.get(0);
        }
    }
}
