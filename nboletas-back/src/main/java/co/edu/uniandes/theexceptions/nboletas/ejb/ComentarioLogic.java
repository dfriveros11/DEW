/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.ComentarioPersistence;
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
public class ComentarioLogic extends AbstractLogic<ComentarioEntity> {

    
    private static final Logger LOGGER = Logger.getLogger(ComentarioLogic.class.getName());

    
     @Inject
   private ComentarioPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Override
    public ComentarioEntity create(ComentarioEntity entity) {
        LOGGER.info("Inicia proceso de creación de comentario");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de comentario");
        return entity;
    }

    @Override
    public ComentarioEntity uptade(ComentarioEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar comentario con id={0}", entity.getId());
        ComentarioEntity newEntity = persistence.uptade(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar comentario con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void delete(ComentarioEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar comentario con id={0}", entity.getId());
        persistence.delete(entity);
         LOGGER.log(Level.INFO, "Termina proceso de borrar comentario con id={0}", entity.getId());
    }

    @Override
    public ComentarioEntity find(Object id) {
        ComentarioEntity coment = persistence.find(id);
        return coment;
    }

    @Override
    public List<ComentarioEntity> findAll() {
        LOGGER.info("Inicia proceso de consultar todos los comentarios");
        List<ComentarioEntity> comentarios = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los comentario");
        return comentarios;
    }

    
    
    
}
