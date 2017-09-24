/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.EnvioDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.EnvioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;
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
 * @author df.riveros11
 */
@Path("boletas/{idBoleta: \\d+}/envios")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class BoletaEnvioResource {

    @Inject
    BoletaLogic boletaLogic;

    @Inject
    EnvioLogic envioLogic;

    @POST
    public EnvioDetailDTO createBoletaEnvio(@PathParam("idBoleta") Long idBoleta, EnvioDetailDTO envio) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con el id: " + idBoleta);
        }
        EnvioEntity envioE = envio.toEntity();
        envioE.setBoleta(boleta);
        EnvioEntity envioCreado = envioLogic.create(envioE);
        return new EnvioDetailDTO(envioCreado);
    }

    @GET
    public List<EnvioDetailDTO> getEnvios(@PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        List<EnvioEntity> list = new ArrayList<>();
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        EnvioEntity envio = boleta.getEnvio();
        if (envio != null) {
            list.add(boleta.getEnvio());
        }
        return listEntity2DetailDTO(list);
    }

    @GET
    @Path("{idEnvio: \\d+}")
    public EnvioDetailDTO getEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        EnvioEntity envio = envioLogic.find(idEnvio);
        if (envio == null) {
            throw new BusinessLogicException("No existe el envio con ese id: " + idEnvio);
        }
        envio.setBoleta(boleta);
        return new EnvioDetailDTO(envio);
    }

    @PUT
    @Path("{idEnvio: \\d+}")
    public EnvioDetailDTO updateBoletaEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio, EnvioDetailDTO envio) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        if (null == envioLogic.find(idEnvio)) {
            throw new BusinessLogicException("No existe el envio con ese id: " + idEnvio);
        }
        EnvioEntity envioActualizar = envio.toEntity();
        envioActualizar.setBoleta(boleta);
        envioActualizar.setId(idEnvio);
        EnvioEntity actual = envioLogic.update(envioActualizar);
        return new EnvioDetailDTO(actual);
    }

    @DELETE
    @Path("{idEnvio: \\d+}")
    public void deleteBoletaEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        EnvioEntity envio = envioLogic.find(idEnvio);
        if (envio == null) {
            throw new BusinessLogicException("No existe el envio con ese id: " + idEnvio);
        }
        envio.setBoleta(boleta);
        envioLogic.delete(envio);
    }

    private List<EnvioDetailDTO> listEntity2DetailDTO(List<EnvioEntity> entityList) {
        List<EnvioDetailDTO> list = new ArrayList<>();
        for (EnvioEntity entity : entityList) {
            list.add(new EnvioDetailDTO(entity));
        }
        return list;
    }
}
