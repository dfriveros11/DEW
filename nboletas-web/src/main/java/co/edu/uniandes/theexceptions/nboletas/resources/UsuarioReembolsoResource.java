/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.ReembolsoLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.UsuarioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
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
@Path("/usuarios/{idUsuario: \\d+}/reembolsos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class UsuarioReembolsoResource {

    @Inject
    private UsuarioLogic usuarioLogic;

    @Inject
    private ReembolsoLogic reembolsoLogic;

    /**
     * GET
     * Retorna todos los objetos reembolsos en representación Detail. 
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos
     *
     * @param idUsuario
     * @return los reembolsos del usuario en objetos json DTO.
     * @throws WebApplicationException
     * En caso de no existir el id del Usuario se retorna un 404 not found.
     */
    @GET
    public List<ReembolsoDetailDTO> getReembolsosUsuario(@PathParam("idUsuario") Long idUsuario) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }
        List<ReembolsoDetailDTO> reembolsos = listEntity2DetailDTO(usuarioEntity.getReembolsos());
        return reembolsos;
    }

    /**
     * GET
     * Retorna un Objeto de tipo Reembolso en representación Detail.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos/idReembolso
     *
     * @param idUsuario
     * @param idReembolso
     * @return un reembolso especifico del usuario en objeto json DTO.
     * @throws WebApplicationException
     * En caso de no existir el id del usuario se retorna un 404 not found.
     * En caso de no existir el id del Reembolso se retorna un 404 not found.
     */
    @GET
    @Path("{idReembolso: \\d+}")
    public ReembolsoDetailDTO getUsuarioReembolso(@PathParam("idUsuario") Long idUsuario, @PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }

        ReembolsoEntity reembolso = reembolsoLogic.find(idReembolso);
        if (reembolso == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe, relacionada con"
                    + "el usuario de id: " + idUsuario, 404);
        }
        reembolso.setUsuario(usuarioEntity);
        return new ReembolsoDetailDTO(reembolso);
    }

    /**
     * POST
     * Crea un objeto de tipo reembolso ya relacionado con el usuario de id dado. 
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos
     *
     * @param idUsuario
     * @param reembolso correponde a la representación java del objeto json
     * enviado en el llamado, para agregar la relacion al usuario.
     * @return el reembolso que fue creado para la relacion con el usuario en
     * objeto json DTO.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del usuario se retorna un 404 not found.
     */
    @POST
    public ReembolsoDetailDTO createReembolsoUsuario(@PathParam("idUsuario") Long idUsuario, ReembolsoDetailDTO reembolso) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }
        ReembolsoEntity reembolsoEntity = reembolso.toEntity();
        reembolsoEntity.setUsuario(usuarioEntity);
        reembolsoEntity = reembolsoLogic.create(reembolsoEntity);
        return new ReembolsoDetailDTO(reembolsoEntity);
    }

    /**
     * PUT 
     * Es el encargado de actualizar objetos Reembolso.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos/idReembolso
     *
     * @param idUsuario
     * @param idReembolso
     * @return el reembolso que fue creado para la relacion con el usuario en
     * objeto json DTO.
     * @throws WebApplicationException
     * En caso de no existir el id del usuario se retorna un 404 not found.
     * En caso de no existir un reembolso con el id por parametro se returna un
     * 404 not found.
     */
    @PUT
    @Path("{idReembolso: \\d+}")
    public ReembolsoDetailDTO updateReembolsoUsuario(@PathParam("idUsuario") Long idUsuario, @PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }
        
        ReembolsoEntity reembolsoEntity = reembolsoLogic.find(idReembolso);
        if (reembolsoEntity == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe, relacionada con"
                    + "el usuario de id: " + idUsuario, 404);
        }
        reembolsoEntity.setUsuario(usuarioEntity);
        reembolsoEntity = reembolsoLogic.update(reembolsoEntity);
        return new ReembolsoDetailDTO(reembolsoEntity);
    }

    /**
     * DELETE
     * Elimina una relación de tipo Usuario-Reembolso.
     * http://localhost:8080/nboletas-web/api/funciones/idFuncion/boletas/idBoleta
     *
     * @param idUsuario
     * @param idReembolso
     * @throws WebApplicationException
     * En caso de no existir el usuario con id dado se retorna un 404 not found.
     * En caso de no existir un reembolso con el id por parametro se retorna un
     * 404 not found.
     */
    @DELETE
    @Path("{idReembolso: \\d+}")
    public void deleteReembolsoUsuario(@PathParam("idUsuario") Long idUsuario, @PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }

        List<ReembolsoEntity> reembolsos = usuarioEntity.getReembolsos();
        ReembolsoEntity reembolsoEntity = null;
        for (ReembolsoEntity reem : reembolsos) {
            if (reem.getId().equals(idReembolso)) {
                reembolsoEntity = reem;
            }
        }
        if (reembolsoEntity == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe, relacionada con"
                    + "el usuario de id: " + idUsuario, 404);
        }
        reembolsoEntity.setUsuario(usuarioEntity);
        reembolsoLogic.delete(reembolsoEntity);
    }

    private List<ReembolsoDetailDTO> listEntity2DetailDTO(List<ReembolsoEntity> entityList) {
        List<ReembolsoDetailDTO> list = new LinkedList<>();
        for (ReembolsoEntity entity : entityList) {
            list.add(new ReembolsoDetailDTO(entity));
        }
        return list;
    }

}
