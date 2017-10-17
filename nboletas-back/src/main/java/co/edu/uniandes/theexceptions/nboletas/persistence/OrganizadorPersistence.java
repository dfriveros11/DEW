/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.OrganizadorEntity;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

/**
 *
 * @author df.riveros11
 */
@Stateless
public class OrganizadorPersistence extends AbstractPersistence<OrganizadorEntity> {

    public OrganizadorPersistence() {
        super(OrganizadorEntity.class);
    }

    /*
    public List<OrganizadorEntity> findAll(){
    SELECT * FROM (ORGANIZADORENTITY LEFT JOIN ESPECTACULOENTITY_ORGANIZADORENTITY 
ON ORGANIZADORENTITY.ID = ESPECTACULOENTITY_ORGANIZADORENTITY.ORGANIZADOR_ID) 
LEFT JOIN ESPECTACULOENTITY ON ORGANIZADORENTITY.ID = ESPECTACULOENTITY_ORGANIZADORENTITY.ORGANIZADOR_ID;
        TypedQuery<OrganizadorEntity> query = em.createNamedQuery("select u from (OrganizadorEntity u left join fetch u.id) r left join EspectaculoEntity fetch u.id" ,OrganizadorEntity.class);
        LOGGER.log(Level.SEVERE, query.toString());
        return null;
    }
    **/
    @Override
    public OrganizadorEntity update(OrganizadorEntity entity) throws PersistenceException {
        String query = "UPDATE APP.ORGANIZADORENTITY SET";
        if (!entity.getNombreEmpresa().equals("") && !entity.getNombreEmpresa().equals(" ")) {
            query += " NOMBREEMPRESA = '" + entity.getNombreEmpresa() + "'";
        }
        query += " WHERE ID = " + entity.getId();
        em.createNativeQuery(query).executeUpdate();
        return entity;
    }

    public OrganizadorEntity updateOrganizadorEspectaculo(OrganizadorEntity entity, long idEspectaculo) throws PersistenceException {
        this.update(entity);
        String query = "UPDATE APP.ESPECTACULOENTITY_ORGANIZADORENTITY  SET ORGANIZADOR_ID = " + entity.getId() + " WHERE ESPECTACULOS_ID = " + idEspectaculo;
        em.createNativeQuery(query).executeUpdate();
        return entity;
    }
}
