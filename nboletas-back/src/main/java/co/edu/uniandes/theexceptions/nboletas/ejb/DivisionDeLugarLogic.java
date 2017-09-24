/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.DivisionDeLugarEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.DivisionDeLugarPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author fc.alvarez10
 */
public class DivisionDeLugarLogic extends AbstractLogic<DivisionDeLugarEntity> {

    private static final Logger LOGGER = Logger.getLogger(DivisionDeLugarLogic.class.getName());

    @Inject
    private DivisionDeLugarPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private SillaLogic boletaLogic;

    @Inject
    private LugarLogic lugarLogic;

    @Override
    public DivisionDeLugarEntity create(DivisionDeLugarEntity entity) {
        LOGGER.info("Inicia proceso de creación de Division de lugar");
        // Invoca la persistencia para crear la Boleta
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Division de lugar");
        return entity;
    }

    @Override
    public DivisionDeLugarEntity update(DivisionDeLugarEntity entity) {
        LOGGER.info("Inicia proceso de actualización de Silla");
        // Invoca la persistencia para crear la Boleta
        persistence.update(entity);
        LOGGER.info("Termina proceso de actualizacion de Silla");
        return entity;
    }

    @Override
    public void delete(DivisionDeLugarEntity entity) {
        LOGGER.info("Inicia proceso de eliminación de Silla");
        // Invoca la persistencia para crear la Boleta
        persistence.delete(entity);
        LOGGER.info("Termina proceso de eliminacion de Silla");
    }

    @Override
    public DivisionDeLugarEntity find(Object id) {
        LOGGER.info("Inicia proceso de busqueda de una Silla");
        // Invoca la persistencia para crear la Boleta
        DivisionDeLugarEntity x = persistence.find(id);
        LOGGER.info("Termina proceso de busqueda de una Silla");
        return x;
    }

    @Override
    public List<DivisionDeLugarEntity> findAll() {
        LOGGER.info("Inicia proceso de busqueda de todas las Sillas");
        // Invoca la persistencia para crear la Boleta
        List<DivisionDeLugarEntity> x = persistence.findAll();
        LOGGER.info("Termina proceso de busqueda de todas las Silla");
        return x;
    }

    @Override
    protected AbstractPersistence<DivisionDeLugarEntity> getPersistence() {
        return persistence;
    }

}
