/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import co.edu.uniandes.theexceptions.nboletas.persistence.BoletaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class BoletaLogic extends AbstractLogic<BoletaEntity> {

    private static final Logger LOGGER = Logger.getLogger(BoletaLogic.class.getName());

    @Inject
    private BoletaPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private ReembolsoLogic reembolsoLogic;

    @Inject
    private EnvioLogic envioLogic;

    @Inject
    private SillaLogic sillaLogic;

    @Inject
    private ComentarioLogic comentarioLogic;

    @Inject
    private UsuarioLogic usuarioLogic;

    @Override
    public BoletaEntity create(BoletaEntity entity) {
        LOGGER.info("Inicia proceso de creación de Boleta");
        // Invoca la persistencia para crear la Boleta
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Boleta");
        return entity;
    }

    @Override
    public BoletaEntity update(BoletaEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(BoletaEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BoletaEntity find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BoletaEntity> findAll() {
        LOGGER.info("Inicia proceso de consultar todas las Boletaes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<BoletaEntity> boletas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Boletaes");
        return boletas;
    }

    public List<BoletaEntity> getBoletas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
