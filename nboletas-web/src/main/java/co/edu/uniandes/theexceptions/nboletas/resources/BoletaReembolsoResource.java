/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.ReembolsoLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
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
@Path("boletas/{idBoleta: \\d+}/reembolso")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class BoletaReembolsoResource {

    @Inject
    BoletaLogic boletaLogic;

    @Inject
    ReembolsoLogic reembolsoLogic;

    @POST
    public ReembolsoDetailDTO createBoletaReembolso(@PathParam("idBoleta") Long idBoleta, ReembolsoDetailDTO reembolso) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con el id: " + idBoleta);
        }
        ReembolsoEntity reembolsoE = reembolso.toEntity();
        reembolsoE.setBoleta(boleta);
        ReembolsoEntity reembolsoCreado = reembolsoLogic.create(reembolsoE);
        return new ReembolsoDetailDTO(reembolsoCreado);
    }

    @GET
    public List<ReembolsoDetailDTO> getReembolsos(@PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        List<ReembolsoEntity> list = new ArrayList<>();
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        ReembolsoEntity reembolso = boleta.getReembolso();
        if (reembolso != null) {
            list.add(boleta.getReembolso());
        }
        return listEntity2DetailDTO(list);
    }

    @GET
    @Path("{idReembolso: \\d+}")
    public ReembolsoDetailDTO getReembolso(@PathParam("idBoleta") Long idBoleta, @PathParam("idReembolso") Long idReembolso) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        ReembolsoEntity reembolso = reembolsoLogic.find(idReembolso);
        if (reembolso == null) {
            throw new BusinessLogicException("No existe el reembolso con ese id: " + idReembolso);
        }
        reembolso.setBoleta(boleta);
        return new ReembolsoDetailDTO(reembolso);
    }

    @PUT
    @Path("{idReembolso: \\d+}")
    public ReembolsoDetailDTO updateBoletaReembolso(@PathParam("idBoleta") Long idBoleta, @PathParam("idReembolso") Long idReembolso, ReembolsoDetailDTO reembolso) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        if (null == reembolsoLogic.find(idReembolso)) {
            throw new BusinessLogicException("No existe el reembolso con ese id: " + idReembolso);
        }
        ReembolsoEntity envioActualizar = reembolso.toEntity();
        envioActualizar.setBoleta(boleta);
        envioActualizar.setId(idReembolso);
        ReembolsoEntity actual = reembolsoLogic.update(envioActualizar);
        return new ReembolsoDetailDTO(actual);
    }

    @DELETE
    @Path("{idReembolso: \\d+}")
    public void deleteBoletReembolso(@PathParam("idBoleta") Long idBoleta, @PathParam("idReembolso") Long idReembolso) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        ReembolsoEntity reembolso = reembolsoLogic.find(idReembolso);
        if (reembolso == null) {
            throw new BusinessLogicException("No existe el reembolso con ese id: " + idReembolso);
        }
        reembolso.setBoleta(boleta);
        reembolsoLogic.delete(reembolso);
    }

    private List<ReembolsoDetailDTO> listEntity2DetailDTO(List<ReembolsoEntity> entityList) {
        List<ReembolsoDetailDTO> list = new ArrayList<>();
        for (ReembolsoEntity entity : entityList) {
            list.add(new ReembolsoDetailDTO(entity));
        }
        return list;
    }
}
