/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.ReembolsoLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import java.util.LinkedList;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author jm.contreras10
 */
@Path("reembolsos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ReembolsoResource {

    @Inject
    private ReembolsoLogic logic;

    /**
     * GET Retorna una colección de objetos Reembolso en representación Detail.
     * http://localhost:8080/nboletas-web/api/reembolsos
     *
     * @return la lista de todos los reembolsos en objetos json detail DTO.
     */
    @GET
    public List<ReembolsoDetailDTO> getReembolsos() {
        return listEntity2DetailDTO(logic.findAll());
    }

    /**
     * GET Retorna todos los objetos Reembolso en representación Detail.
     * http://localhost:8080/nboletas-web/api/reembolsos/id
     *
     * @param idReembolso
     * @return la lista de todos los Reembolsos en objetos json detail DTO.
     * @throws WebApplicationException En caso de no existir el id del Reembolso
     * a buscar, retornando un 404: not found.
     */
    @GET
    @Path("{idReembolso: \\d+}")
    public ReembolsoDetailDTO getReembolso(@PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        ReembolsoEntity reembolsoEntity = logic.find(idReembolso);
        if (reembolsoEntity == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe.", 404);
        }
        return new ReembolsoDetailDTO(reembolsoEntity);
    }

    /**
     * POST Crea un objeto de tipo Reembolso.
     * http://localhost:8080/nboletas-web/api/reembolsos
     *
     * @param reembolso correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java.
     */
    @POST
    public ReembolsoDetailDTO createReembolso(ReembolsoDetailDTO reembolso) {
        ReembolsoEntity reembolsoEntity = reembolso.toEntity();
        ReembolsoEntity newEntity = logic.create(reembolsoEntity);
        return new ReembolsoDetailDTO(newEntity);
    }

    /**
     * PUT Es el encargado de actualizar objetos Reembolso.
     * http://localhost:8080/nboletas-web/api/reembolsos/id
     *
     * @param idReembolso
     * @param reembolso
     * @return El Reembolso actualizado.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del Reembolso a actualizar, retornando un
     * error 404: not found.
     */
    @PUT
    @Path("{idReembolso: \\d+}")
    public ReembolsoDetailDTO updateReembolso(@PathParam("idReembolso") Long idReembolso, ReembolsoDetailDTO reembolso) throws WebApplicationException {
        if (logic.find(idReembolso) == null) {
            throw new WebApplicationException("El recurso usuario: " + idReembolso + " no existe.", 404);
        }
        ReembolsoEntity reembolsoEntity = reembolso.toEntity();
        reembolsoEntity.setId(idReembolso);
        ReembolsoEntity actualizedEntity = logic.update(reembolsoEntity);
        return new ReembolsoDetailDTO(actualizedEntity);
    }

    /**
     * DELETE Elimina un objeto Reembolso.
     * http://localhost:8080/nboletas-web/api/reembolso/id
     *
     * @param idReembolso
     * @throws WebApplicationException En caso de no existir el id del Reembolso
     * a borrar, retornando un 404 not: found.
     *
     */
    @DELETE
    @Path("{idReembolso: \\d+}")
    public void deleteUsuario(@PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        ReembolsoEntity reembolsoEntity = logic.find(idReembolso);
        if (reembolsoEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idReembolso + " no existe.", 404);
        }
        logic.delete(reembolsoEntity);
    }

    private List<ReembolsoDetailDTO> listEntity2DetailDTO(List<ReembolsoEntity> entityList) {
        List<ReembolsoDetailDTO> list = new LinkedList<>();
        for (ReembolsoEntity entity : entityList) {
            list.add(new ReembolsoDetailDTO(entity));
        }
        return list;
    }

}
