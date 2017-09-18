/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.EnvioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author angeloMarcetty
 */
@Stateless
public class EnvioLogic extends AbstractLogic<EnvioEntity>{
    
    private static final Logger LOGGER = Logger.getLogger(EnvioLogic.class.getName());

    
    @Inject
   private EnvioPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    // Inject relaciones ????
    
    
    @Override
    public EnvioEntity create(EnvioEntity entity) {
        LOGGER.info("Inicia proceso de creación de envio");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de envio");
        return entity;
    }

    @Override
    public EnvioEntity uptade(EnvioEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar envio con id={0}", entity.getId());
        EnvioEntity newEntity = persistence.uptade(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar envio con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void delete(EnvioEntity entity) {
         LOGGER.log(Level.INFO, "Inicia proceso de borrar envio con id={0}", entity.getId());
        persistence.delete(entity);
         LOGGER.log(Level.INFO, "Termina proceso de borrar envio con id={0}", entity.getId());
    }

    @Override
    public EnvioEntity find(Object id) {
       EnvioEntity env = persistence.find(id);
        return env; 
    }

    @Override
    public List<EnvioEntity> findAll() {
         LOGGER.info("Inicia proceso de consultar todos los envios");
        List<EnvioEntity> envios = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los envios");
        return envios;
    }
    
}
