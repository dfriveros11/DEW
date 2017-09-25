/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDTO;
import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.ReembolsoLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.UsuarioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
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
     * GET para los Reembolsos de un usuario especifico.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos
     *
     * @return los reembolsos del usuario en objetos json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del Usuario se retorna un 404 not
     * found.
     */
    @GET
    public List<ReembolsoDTO> getReembolsosUsuario(@PathParam("idUsuario") Long id) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        List<ReembolsoDTO> reembolsos = listEntity2DTO(entity.getReembolsos());
        return reembolsos;
    }
    
   /**
     * GET para un Reembolso especifico de un Usuario especifico.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos/idReembolso
     *
     * @return un reembolso especifico del usuario en objeto json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     * 
     * En caso de no existir el id del Reembolso se retorna un 404 not
     * found.
     */
    @GET
    @Path("{idReembolso: \\d+}")
    public ReembolsoDetailDTO getUsuarioReembolso(@PathParam("idUsuario") Long id, @PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        
        List<ReembolsoEntity> reembolsos = entity.getReembolsos();
        ReembolsoEntity reembolso = null;
        for(ReembolsoEntity reem : reembolsos) if(reem.getId().equals(idReembolso)) reembolso = reem;
        
        if(reembolso == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe, relacionada con"
                    + "el usuario de id: "+ id, 404);
        }
        return new ReembolsoDetailDTO(reembolso);
    }
    
   /**
     * POST para crear una relacion usuario reembolso.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos
     *
     * @param reembolso correponde a la representación java del objeto json
     * enviado en el llamado, para agregar la relacion al usuario.
     * @return el reembolso que fue creado para la relacion con el usuario en objeto json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     */
    @POST
    public ReembolsoDetailDTO createReembolsoUsuario(@PathParam("idReembolso") Long id, ReembolsoDetailDTO reembolso) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        
        ReembolsoEntity reembolsoEntity = reembolso.toEntity();
        reembolsoEntity.setUsuario(entity);
        reembolsoEntity = reembolsoLogic.create(reembolsoEntity);
        return new ReembolsoDetailDTO(reembolsoEntity);
    }
    
   /**
     * PUT para modificar una relacion usuario reembolso con uno ya existente en el sistema.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/reembolsos/idReembolso
     *
     * @return el reembolso que fue creado para la relacion con el usuario en objeto json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     * 
     * En caso de no existir un reembolso con el id por parametro
     * se returna un 404 not found.
     */
    @PUT
    @Path("{idReembolso: \\d+}")
        public ReembolsoDetailDTO updateReembolsoUsuario(@PathParam("idUsuario") Long id, @PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        
        ReembolsoEntity reembolso = reembolsoLogic.find(idReembolso);
        if(reembolso == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe, relacionada con"
                    + "el usuario de id: "+ id, 404);
        }
        
        reembolso.setUsuario(entity);
        reembolso = reembolsoLogic.update(reembolso);
        return new ReembolsoDetailDTO(reembolso);
    }
    
    /**
     * DELETE para eliminar una relacion funcion-boleta ya existente en el sistema.
     * http://localhost:8080/nboletas-web/api/funciones/idFuncion/boletas/idBoleta
     *
     * @return el reembolso que fue creado para la relacion con el usuario en objeto json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     * 
     * En caso de no existir un reembolso con el id por parametro
     * se retorna un 404 not found.
     */
    @DELETE
    @Path("{idReembolso: \\d+}")
    public void deleteReembolsoUsuario(@PathParam("idUsuario") Long id, @PathParam("idReembolso") Long idReembolso) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        
        List<ReembolsoEntity> reembolsos = entity.getReembolsos();
        ReembolsoEntity reembolso = null;
        for(ReembolsoEntity reem : reembolsos) if(reem.getId().equals(idReembolso)) reembolso = reem;
        if(reembolso == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe, relacionada con"
                    + "el usuario de id: "+ id, 404);
        }
        
        reembolso.setUsuario(entity);
        reembolsoLogic.delete(reembolso);
    } 
        
            
    private List<ReembolsoDTO> listEntity2DTO(List<ReembolsoEntity> entityList) {
        List<ReembolsoDTO> list = new LinkedList<>();
        for (ReembolsoEntity entity : entityList) {
            list.add(new ReembolsoDTO(entity));
        }
        return list;
    }

    
}
