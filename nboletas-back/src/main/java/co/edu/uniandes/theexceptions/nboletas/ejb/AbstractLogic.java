/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import java.util.List;

/**
 *
 * @author df.riveros11
 * @param <T> Entity
 */
public abstract class AbstractLogic<T> {

    protected abstract AbstractPersistence<T> getPersistence();

    /**
     * Crear un objeto tipo T
     *
     * @param entity
     * @return
     */
    public T create(T entity) {
        return getPersistence().create(entity);
    }

    /**
     * Actualiza un obeto de tipo T
     *
     * @param entity
     * @return
     */
    public T update(T entity) {
        return getPersistence().update(entity);
    }

    /**
     * Elimina un objeto T
     *
     * @param entity
     */
    public void delete(T entity) {
        getPersistence().delete(entity);
    }

    /**
     * Encuentra un tipo T al mandar un identificador
     *
     * @param id
     * @return
     */
    public T find(Object id) {
        return getPersistence().find(id);
    }

    /**
     * Devuelve todo los objetos
     *
     * @return list con todos los objetos
     */
    public List<T> findAll() {
        return getPersistence().findAll();
    }

}
