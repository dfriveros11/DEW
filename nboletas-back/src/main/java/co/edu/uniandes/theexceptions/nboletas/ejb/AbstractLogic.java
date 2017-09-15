/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author df.riveros11
 * @param <T>
 */
public abstract class AbstractLogic<T> {
    
    /**Crear un objeto tipo T
     * @param entity    
     * @return     
    */
    public abstract T create(T entity);
    
    /**Actualiza un obeto de tipo T 
     * @param entity    
     * @return     
    */
    public abstract T uptade(T entity);
    
    /**Elimina un objeto T
     * @param entity    
    */
    public abstract void delete(T entity);
    
    /**Encuentra un tipo T al mandar un identificador
     * @param id    
     * @return     
    */
    public abstract T find(Object id);
    
    /**Devuelve todo los objetos
     * @return list con todos los objetos
    */
    public abstract List<T> findAll();

}
