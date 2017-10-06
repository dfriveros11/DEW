/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
import java.util.List;
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

    /**
     * Busca un usuario por un UserName dado por parametro.
     *
     * @param userName username del usuario a buscar.
     * @return UsuarioEntity encontrado.
     */
    public UsuarioEntity findByUserName(String userName) {
        TypedQuery query = em.createQuery("Select e From UsuarioEntity e where e.userName = :uName", UsuarioEntity.class);
        // Se remplaza el placeholder ":codigo" con el valor del argumento 
        query = query.setParameter("uName", userName);
        // Se invoca el query se obtiene la lista resultado
        List<UsuarioEntity> sameCodigo = query.getResultList();
        if (sameCodigo == null) {
            return null;
        }
        if (sameCodigo.isEmpty()) {
            return null;
        } else {
            return sameCodigo.get(0);
        }
    }
    
    /**
     * Indica si un usuario ha hecho un reembolso con id dado.
     * <pre> El Reembolso y el Usuario existen en el sistema.
     * @param idUsuario
     * @param reembolso
     * @return 
     */
    public boolean isReembolsoOnUsuario(long idUsuario,long idReembolso){
        //El usuario
        UsuarioEntity usuario = find(idUsuario);
        //Sus reembolsos
        List<ReembolsoEntity> reembolsos = usuario.getReembolsos();
        //veryficacion
        for (ReembolsoEntity reembolso : reembolsos) {
            if(reembolso.getId() == idReembolso)
                return true;
        }
        return false;
    }
    
    /**
     * Indica si un usuario ha comprado una boleta con el id dado.
     * <pre> El Usuario y la Boleta existen en el sistema.
     * @param idUsuario
     * @param idBoleta
     * @return 
     */
    public boolean isBoletaOnUsuario(long idUsuario, long idBoleta){
        //El usuario
        UsuarioEntity usuario = find(idUsuario);
        //Sus boletas
        List<BoletaEntity> boletas = usuario.getBoletas();
        //veryficacion
        for (BoletaEntity boleta : boletas) {
            if(boleta.getId() == idBoleta)
                return true;
        }
        return false;
    }
    

    
    
}
