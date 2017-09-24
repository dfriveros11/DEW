/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author df.riveros11
 * @param <T>
 */
@Stateless
public abstract class AbstractPersistence<T> {

    private final Class<T> entityClass;

    public AbstractPersistence(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @PersistenceContext(unitName = "nboletasPU")
    private EntityManager em;

    /**
     * Crear un objeto tipo T
     *
     * @param entity
     * @return
     */
    public T create(T entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un obeto de tipo T
     *
     * @param entity
     * @return
     */
    public T update(T entity) {
        em.merge(entity);
        return entity;
    }

    /**
     * Elimina un objeto T
     *
     * @param entity
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    /**
     * Encuentra un tipo T al mandar un identificador
     *
     * @param id
     * @return
     */
    public T find(Object id) {
        return (em.find(entityClass, id));
    }

    /**
     * Devuelve todo los objetos
     *
     * @return list con todos los objetos
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery oq = em.getCriteriaBuilder().createQuery();
        oq.select(oq.from(entityClass));
        return em.createQuery(oq).getResultList();
    }

}
