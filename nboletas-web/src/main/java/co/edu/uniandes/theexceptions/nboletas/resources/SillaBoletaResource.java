/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.BoletaDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.*;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.SillaEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author fc.alvarez10
 */
@Path("sillas/{sillasid: \\d+}/boletas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class SillaBoletaResource {
    
    @Inject
    SillaLogic sillaLogic;
    
    @Inject
    BoletaLogic boletaLogic;
    
    @POST
    public BoletaDetailDTO createSillaBoleta(@PathParam("sillasid") Long idSilla, BoletaDetailDTO boleta) throws BusinessLogicException {
        SillaEntity silla = sillaLogic.find(idSilla);
        if (silla == null) {
            throw new BusinessLogicException("No existe la silla con el id: " + idSilla);
        }
        BoletaEntity boletaE = boleta.toEntity();
        boletaE.setSilla(silla);
        BoletaEntity boletaCreada = boletaLogic.create(boletaE);
        return new BoletaDetailDTO(boletaCreada);
    }
    
    @GET
    public List<BoletaDetailDTO> getBoletas(@PathParam("sillasid") Long idSilla) throws BusinessLogicException {
        List<BoletaEntity> list = new ArrayList<>();
        SillaEntity silla = sillaLogic.find(idSilla);
        if (silla == null) {
            throw new BusinessLogicException("No existe la silla con ese id: " + idSilla);
        }
        List<BoletaEntity> boletas = silla.getBoletas();
        if (boletas != null) {
            for(BoletaEntity b: boletas){
                list.add(b);
            }
        }
        return listEntity2DetailDTO(list);
    }
    
    @GET
    @Path("{boletasid: \\d+}")
    public BoletaDetailDTO getBoleta(@PathParam("sillasid") Long idSilla, @PathParam("boletasid") Long idBoleta) throws BusinessLogicException {
        SillaEntity silla = sillaLogic.find(idSilla);
        if (silla == null) {
            throw new BusinessLogicException("No existe la silla con ese id: " + idSilla);
        }
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        boleta.setSilla(silla);
        return new BoletaDetailDTO(boleta);
    }
    
    @PUT
    @Path("{boletasid: \\d+}")
    public BoletaDetailDTO updateSillaBoleta(@PathParam("sillasid") Long idSilla, @PathParam("boletasid") Long idBoleta, BoletaDetailDTO boleta) throws BusinessLogicException {
        SillaEntity silla = sillaLogic.find(idSilla);
        if (silla == null) {
            throw new BusinessLogicException("No existe la silla con ese id: " + idSilla);
        }
        if (null == boletaLogic.find(idBoleta)) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        BoletaEntity boletaActualizar = boleta.toEntity();
        boletaActualizar.setSilla(silla);
        boletaActualizar.setId(idBoleta);
        BoletaEntity actual = boletaLogic.update(boletaActualizar);
        return new BoletaDetailDTO(actual);
    }

    @DELETE
    @Path("{boletasid: \\d+}")
    public void deleteSillaBoleta(@PathParam("sillasid") Long idSilla, @PathParam("boletasid") Long idBoleta) throws BusinessLogicException {
        SillaEntity silla = sillaLogic.find(idSilla);
        if (silla == null) {
            throw new BusinessLogicException("No existe la silla con ese id: " + idSilla);
        }
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        boleta.setSilla(silla);
        boletaLogic.delete(boleta);
    }
    
    private List<BoletaDetailDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDetailDTO> list = new ArrayList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }
}
