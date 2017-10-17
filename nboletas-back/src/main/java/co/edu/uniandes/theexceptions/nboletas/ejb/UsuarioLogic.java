/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.BoletaPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.ReembolsoPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jm.contreras10
 */
@Stateless
public class UsuarioLogic extends AbstractLogic<UsuarioEntity> {

    @Inject
    private UsuarioPersistence persistence;
    
    @Inject
    private ReembolsoPersistence reembolsoPersistence;
    
    @Inject
    private BoletaPersistence boletaPersistence;

    
    @Override
    protected AbstractPersistence<UsuarioEntity> getPersistence() {
        return persistence;
    }

    /**
     * Encuentra a un usuario dado su UserName.
     *
     * @param userName UserName del usuario a buscar.
     * @return UsuarioEntity encontrado, null en caso de no encontrarlo.
     */
    public UsuarioEntity findByUserName(String userName) {
        return persistence.findByUserName(userName);
    }
    
    /**
     * Retorna una lista de rembolsos del usuario dado.
     * @param idUsuario
     * @return
     * @throws BusinessLogicException
     *  Cuando no existe el Usuario con idDado.
     */
    public List<ReembolsoEntity> findUsuarioReembolsos(long idUsuario) throws BusinessLogicException{
        //Revision existencia del usuario
        UsuarioEntity usuarioEntity = persistence.find(idUsuario);
        if (usuarioEntity == null)
            throw new BusinessLogicException("No se encuentra el usuario con id: " + idUsuario);
        return usuarioEntity.getReembolsos();
    }
    
    /**
     * Retorna un reembolso dado que haya realizado un usuario dado.
     * @param idUsuario
     * @param idReembolso
     * @return
     * @throws BusinessLogicException 
     *  Cuando no existe el Usuario.
     *  Cuando no existe el reembolso.
     *  Cuando el usuario no ha realizado el reembolso.
     */
    public ReembolsoEntity findUsuarioReembolso(long idUsuario,long idReembolso) throws BusinessLogicException{
        //Revision existencia del usuario
        UsuarioEntity usuarioEntity = persistence.find(idUsuario);
        if (usuarioEntity == null) {
            throw new BusinessLogicException("No se encuentra el usuario con id: " + idUsuario);
        }
        //Revision existencia del Reembolso
        ReembolsoEntity reembolso = reembolsoPersistence.find(idReembolso);
        if (reembolso == null) {
            throw new BusinessLogicException("No se encuentra el reembolso con id: " + idReembolso);
        }
        //Revicion emparentacion usuario-reembolso
        if(persistence.isReembolsoOnUsuario(idUsuario, idReembolso))
            return reembolso;
        throw new BusinessLogicException("El usuario con id: "+idUsuario
                +", no ha realizado el reembolso co id: " + idReembolso);
    }
    
    
    public ReembolsoEntity createUsuarioReembolso(long idUsuario,ReembolsoEntity reembolso) throws BusinessLogicException{
        //Revision existencia del usuario
        UsuarioEntity usuarioEntity = persistence.find(idUsuario);
        if (usuarioEntity == null) {
            throw new BusinessLogicException("No se encuentra el usuario con id: " + idUsuario);
        }
        //Obtencion Boleta
        BoletaEntity boletaEnReembolso = reembolso.getBoleta();
        //Revision existencia de la Boleta a reembolsar
        BoletaEntity boletaEntity = boletaPersistence.find(boletaEnReembolso.getId());
        if (usuarioEntity == null) {
            throw new BusinessLogicException("No se encuentra la boleta con id: " + boletaEnReembolso.getId());
        }
        //Revisiom Usuario si posee la boleta
        if (persistence.isBoletaOnUsuario(idUsuario, boletaEntity.getId())) {
            throw new BusinessLogicException("El usuario con id: " + idUsuario
                    +", no ha comprado la boleta con id: " + boletaEntity.getId());
        }
        //Estableciendo boleta como "reembolsada"
        boletaEntity.setVendida(false);
        //Estableciendo usuario a boleta
        boletaEntity.setUsuario(null);
        //Eliminando boleta
        List<BoletaEntity> boletas = usuarioEntity.getBoletas();
        for (BoletaEntity boleta : boletas) {
            if(boleta.getId() == boletaEntity.getId()){
                boletas.remove(boleta);
            }
        }
        usuarioEntity.setBoletas(boletas);
        //Añadiendo reembolso a usuario
        List<ReembolsoEntity> reembolsos = usuarioEntity.getReembolsos();
        reembolsos.add(reembolso);
        usuarioEntity.setReembolsos(reembolsos);
        //Retornando
        return reembolso;
    }

}
