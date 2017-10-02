/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class EspectaculoPersistence extends AbstractPersistence<EspectaculoEntity> {

    public EspectaculoPersistence() {
        super(EspectaculoEntity.class);
    }

    /*
    public List<EspectaculoEntity> findOrganizadorEspectaculo(Long idOrganizador) {
        TypedQuery query = em.createNamedQuery("select u from EspectaculoEntity u left join fetch u.id where (u.id = :id)", EspectaculoEntity.class);
        query.setParameter(":id", idOrganizador);
        return query.getResultList();
    }
    **/
    @Override
    public EspectaculoEntity update(EspectaculoEntity entity) {
        String query = "UPDATE APP.ESPECTACULOENTITY SET";
        if (!entity.getNombre().equals("") && !entity.getNombre().equals(" ")) {
            query += " NOMBRE = '" + entity.getNombre() + "'";
        }
        if (!entity.getDescripcion().equals("") && !entity.getDescripcion().equals(" ")) {
            query += ", DESCRIPCION = '" + entity.getDescripcion() + "'";
        }
        query += " WHERE ID = " + entity.getId();
        em.createNativeQuery(query).executeUpdate();
        return entity;
    }

    public EspectaculoEntity updateOrganizadorEspectaculo(EspectaculoEntity entity, long idOrganizador) throws PersistenceException {
        this.update(entity);
        String query = "UPDATE APP.ESPECTACULOENTITY_ORGANIZADORENTITY  SET ESPECTACULOS_ID = " + entity.getId() + " WHERE ORGANIZADOR_ID = " + idOrganizador;
        em.createNativeQuery(query).executeUpdate();
        return entity;
    }
}
