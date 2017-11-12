/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.BoletaPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.EnvioPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author angeloMarcetty
 */
@Stateless
public class EnvioLogic extends AbstractLogic<EnvioEntity> {

    @Inject
    private EnvioPersistence envioPersistence;
    
    @Inject
    private BoletaPersistence boletaPersistence;

    @Override
    protected AbstractPersistence<EnvioEntity> getPersistence() {
        return envioPersistence;
    }
    
    
    
    public BoletaEntity createBoletaEnvio(Long idEnvio, BoletaEntity boleta) throws BusinessLogicException {
        EnvioEntity e = envioPersistence.find(idEnvio);
        if (e == null) {
            throw new BusinessLogicException("No existe el envio con el id " + idEnvio);
        }
        boleta.setEnvio(e);
        boleta = boletaPersistence.create(boleta);
        return boleta;
    }
    

    public BoletaEntity updateBoletaEnvio(Long idEnvio, Long idBoleta) throws BusinessLogicException {
        EnvioEntity e = envioPersistence.find(idEnvio);
        if (e == null) {
            throw new BusinessLogicException("No existe el envio con el id " + idEnvio);
        }

        BoletaEntity b = boletaPersistence.find(idBoleta);
        if (b == null) {
            throw new BusinessLogicException("No existe una boleta con el id " + idBoleta);
        }

        b.setEnvio(e);
        b = boletaPersistence.update(b);
        return b;
    }

    
    //revision
    public void deleteBoletaEnvio(Long idEnvio, Long idBoleta) throws BusinessLogicException {
        EnvioEntity e = envioPersistence.find(idEnvio);
        if (e == null) {
            throw new BusinessLogicException("No existe el envio con el id " + idEnvio);
        }

        BoletaEntity b = boletaPersistence.find(idBoleta);
        if (b == null) {
            throw new BusinessLogicException("No existe una boleta con el id " + idBoleta);
        }

        b.setEnvio(null);
        b = boletaPersistence.update(b);
    }
    

    public BoletaEntity getBoletaEnvio(Long idEnvio, Long idBoleta) throws BusinessLogicException {
        EnvioEntity e = envioPersistence.find(idEnvio);
        if (e == null) {
            throw new BusinessLogicException("No existe el envio con el id " + idEnvio);
        }

        BoletaEntity b = boletaPersistence.find(idBoleta);
        if (b == null) {
            throw new BusinessLogicException("No existe una boleta con el id " + idBoleta);
        }

        return b;
    }

    
    public BoletaEntity findBoletaEnvio(long idEnvio) throws BusinessLogicException {

        EnvioEntity envioEnt = envioPersistence.find(idEnvio);

        if (envioEnt == null) {
            throw new BusinessLogicException("No se encontro el envio con id: " + idEnvio);
        }
        return envioEnt.getBoleta();
    }
    
    
    
    
    
    
    
    
    
}
