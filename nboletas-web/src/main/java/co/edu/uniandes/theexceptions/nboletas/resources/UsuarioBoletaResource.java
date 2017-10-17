/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.BoletaDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.UsuarioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
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
@Path("/usuarios/{idUsuario: \\d+}/boletas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class UsuarioBoletaResource {

    @Inject
    private UsuarioLogic usuarioLogic;

    @Inject
    private BoletaLogic boletaLogic;

    /**
     * GET Retorna todos los objetos en representación Detail.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas
     *
     * @param idUsuario
     * @return las boletas del usuario en objetos json DTO.
     * @throws WebApplicationException En caso de no existir el id del Usuario
     * se retorna un 404 not found.
     */
    @GET
    public List<BoletaDetailDTO> getBoletasUsuario(@PathParam("idUsuario") Long idUsuario) throws WebApplicationException {
        UsuarioEntity usuario = usuarioLogic.find(idUsuario);
        if (usuario == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }
        usuario.getBoletas();
        return listEntity2DetailDTO(usuario.getBoletas());
    }

    /**
     * GET Retorna un Objeto de tipo Usuario en representación Detail.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas/idBoleta
     *
     * @param idUsuario
     * @param idBoleta
     * @return una boleta especifica del usuario en objeto json DTO.
     * @throws WebApplicationException En caso de no existir el id del usuario
     * se retorna un 404 not found. En caso de no existir el id de la Boleta se
     * retorna un 404 not found.
     */
    @GET
    @Path("{idBoleta: \\d+}")
    public BoletaDetailDTO getBoletaUsuario(@PathParam("idUsuario") Long idUsuario, @PathParam("idBoleta") Long idBoleta) throws WebApplicationException {
        UsuarioEntity entityUsuario = usuarioLogic.find(idUsuario);
        if (entityUsuario == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }

        List<BoletaEntity> boletas = entityUsuario.getBoletas();
        BoletaEntity entityBoleta = null;
        for (BoletaEntity bol : boletas) {
            if (bol.getId().equals(idBoleta)) {
                entityBoleta = bol;
            }
        }

        if (entityBoleta == null) {
            throw new WebApplicationException("El recurso boleta: " + idBoleta + " no existe, relacionada con"
                    + "el usuario de id: " + idUsuario, 404);
        }
        return new BoletaDetailDTO(entityBoleta);
    }

    /**
     * POST Crea un objeto de tipo boleta ya relacionada con el usuario de id
     * dado. <<Deprecated>>
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas
     *
     * @param idUsuario
     * @param boleta correponde a la representación java del objeto json enviado
     * en el llamado, para agregar la relacion al usuario.
     * @return la boleta que fue creada para la relacion con el usuario en
     * objeto json DTO.
     * @throws WebApplicationException En caso de no existir el id del usuario
     * se retorna un 404 not found.
     */
    @POST
    public BoletaDetailDTO createBoletaUsuario(@PathParam("idUsuario") Long idUsuario, BoletaDetailDTO boleta) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }
        BoletaEntity boletaEntity = boleta.toEntity();
        boletaEntity.setUsuario(usuarioEntity);
        boletaEntity = boletaLogic.create(boletaEntity);
        return new BoletaDetailDTO(boletaEntity);
    }

    /**
     * PUT Relaciona un usuario con id dado junto a una boleta con id dado. Esta
     * relación indica que dicho usuario compro la boleta.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas/idBoleta
     *
     * @param idUsuario
     * @param idBoleta
     * @return la boleta que fue creada para la relacion con el usuario en
     * objeto json DTO.
     * @throws WebApplicationException En caso de no existir el id del usuario
     * se retorna un 404 not found. En caso de no existir un reembolso con el id
     * por parametro se returna un 404 not found.
     */
    @PUT
    @Path("{idBoleta: \\d+}")
    public BoletaDetailDTO updateBoletaUsuario(@PathParam("idUsuario") Long idUsuario, @PathParam("idBoleta") Long idBoleta) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }

        BoletaEntity boletaEntity = boletaLogic.find(idBoleta);
        if (boletaEntity == null) {
            throw new WebApplicationException("El recurso reembolso: " + idBoleta + " no existe, relacionada con"
                    + "el usuario de id: " + idUsuario, 404);
        }
        boletaEntity.setUsuario(usuarioEntity);
        boletaEntity = boletaLogic.update(boletaEntity);
        return new BoletaDetailDTO(boletaEntity);
    }

    /**
     * DELETE Elimina una relación de tipo Usuario-Boleta.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas/idBoleta
     *
     * @param idUsuario
     * @param idBoleta
     * @throws WebApplicationException En caso de no existir el id del usuario
     * se retorna un 404 not found. En caso de no existir un reembolso con el id
     * por parametro se retorna un 404 not found.
     */
    @DELETE
    @Path("{idBoleta: \\d+}")
    public void deleteBoletaUsuario(@PathParam("idUsuario") Long idUsuario, @PathParam("idBoleta") Long idBoleta) throws WebApplicationException {
        UsuarioEntity usuarioEntity = usuarioLogic.find(idUsuario);
        if (usuarioEntity == null) {
            throw new WebApplicationException("El recurso usuario: " + idUsuario + " no existe.", 404);
        }

        List<BoletaEntity> boletas = usuarioEntity.getBoletas();
        BoletaEntity boletaEntity = null;
        for (BoletaEntity bol : boletas) {
            if (bol.getId().equals(idBoleta)) {
                boletaEntity = bol;
            }
        }
        if (boletaEntity == null) {
            throw new WebApplicationException("El recurso boleta: " + idBoleta + " no existe, relacionada con"
                    + "el usuario de id: " + idUsuario, 404);
        }
        boletaEntity.setUsuario(usuarioEntity);
        boletaLogic.delete(boletaEntity);
    }

    private List<BoletaDetailDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDetailDTO> list = new LinkedList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }

}
