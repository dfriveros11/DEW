/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.ComentarioDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.ComentarioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;
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
 * @author am.valero10
 */
@Path("/boletas/{idBoleta: \\d+}/comentarios")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class BoletaComentarioResource {
    
    @Inject
    BoletaLogic boletaLogic;
    
    @Inject
    ComentarioLogic comentarioLogic;
    
    
    @POST
    public ComentarioDetailDTO createBoletaComentario(@PathParam("idBoleta") Long idBoleta, ComentarioDetailDTO comentario) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con el id: " + idBoleta);
        }
        ComentarioEntity comentarioE = comentario.toEntity();
        comentarioE.setBoleta(boleta);
        ComentarioEntity comentarioCreado = comentarioLogic.create(comentarioE);
        return new ComentarioDetailDTO(comentarioCreado);
    }
    
    
    
    @GET
    public List<ComentarioDetailDTO> getComentarios(@PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        List<ComentarioEntity> list = new ArrayList<>();
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        ComentarioEntity comentario = boleta.getComentario();
        if (comentario != null) {
            list.add(boleta.getComentario());
        }
        return listEntity2DetailDTO(list);
    }
    
    
    @GET
    @Path("{idComentario: \\d+}")
    public ComentarioDetailDTO getComentario(@PathParam("idBoleta") Long idBoleta, @PathParam("idComentario") Long idComentario) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        ComentarioEntity comentario = comentarioLogic.find(idComentario);
        if (comentario == null) {
            throw new BusinessLogicException("No existe el comentario con ese id: " + idComentario);
        }
        comentario.setBoleta(boleta);
        return new ComentarioDetailDTO(comentario);
    }

    
    
    @PUT
    @Path("{idComentario: \\d+}")
    public ComentarioDetailDTO updateBoletaComentario(@PathParam("idBoleta") Long idBoleta, @PathParam("idComentario") Long idComentario, ComentarioDetailDTO comentario) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        if (null == comentarioLogic.find(idComentario)) {
            throw new BusinessLogicException("No existe el comentario con ese id: " + idComentario);
        }
        ComentarioEntity comentarioActualizar = comentario.toEntity();
        comentarioActualizar.setBoleta(boleta);
        comentarioActualizar.setId(idComentario);
        ComentarioEntity actual = comentarioLogic.update(comentarioActualizar);
        return new ComentarioDetailDTO(actual);
    }
    
    
    
     @DELETE
    @Path("{idComentario: \\d+}")
    public void deleteBoletaComenario(@PathParam("idBoleta") Long idBoleta, @PathParam("idComentario") Long idComentario) throws BusinessLogicException {
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if (boleta == null) {
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        ComentarioEntity comentario = comentarioLogic.find(idComentario);
        if (comentario == null) {
            throw new BusinessLogicException("No existe el comentario con ese id: " + idComentario);
        }
        comentario.setBoleta(boleta);
        comentarioLogic.delete(comentario);
    }
    
    
    
    
    private List<ComentarioDetailDTO> listEntity2DetailDTO(List<ComentarioEntity> entityList) {
        List<ComentarioDetailDTO> list = new ArrayList<>();
        for (ComentarioEntity entity : entityList) {
            list.add(new ComentarioDetailDTO(entity));
        }
        return list;    }
    
    
    
    
    
}
