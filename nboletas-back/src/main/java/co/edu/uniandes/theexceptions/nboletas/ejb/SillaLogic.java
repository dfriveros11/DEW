/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.SillaEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.SillaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author fc.alvarez10
 */
@Stateless
public class SillaLogic extends AbstractLogic<SillaEntity> {

    private static final Logger LOGGER = Logger.getLogger(SillaLogic.class.getName());

    @Inject
    private SillaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Override
    public SillaEntity create(SillaEntity entity) {
        LOGGER.info("Inicia proceso de creación de Silla");
        // Invoca la persistencia para crear la Boleta
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Silla");
        return entity;
    }

    @Override
    public SillaEntity update(SillaEntity entity) {
        LOGGER.info("Inicia proceso de actualización de Silla");
        // Invoca la persistencia para crear la Boleta
        persistence.update(entity);
        LOGGER.info("Termina proceso de actualizacion de Silla");
        return entity;
    }

    @Override
    public void delete(SillaEntity entity) {
        LOGGER.info("Inicia proceso de eliminación de Silla");
        // Invoca la persistencia para crear la Boleta
        persistence.delete(entity);
        LOGGER.info("Termina proceso de eliminacion de Silla");
    }

    @Override
    public SillaEntity find(Object id) {
        LOGGER.info("Inicia proceso de busqueda de una Silla");
        // Invoca la persistencia para crear la Boleta
        SillaEntity x = persistence.find(id);
        LOGGER.info("Termina proceso de busqueda de una Silla");
        return x;
    }

    @Override
    public List<SillaEntity> findAll() {
        LOGGER.info("Inicia proceso de busqueda de todas las Sillas");
        // Invoca la persistencia para crear la Boleta
        List<SillaEntity> x = persistence.findAll();
        LOGGER.info("Termina proceso de busqueda de todas las Silla");
        return x;
    }

    @Override
    protected AbstractPersistence<SillaEntity> getPersistence() {
        return persistence;
    }
}
