/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.BoletaDTO;
import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDTO;
import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.ReembolsoLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.UsuarioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
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
@Path("/usuarios/{idUsuario: \\d+}/boletas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class UsuarioBoletaResource {
    
    @Inject
    private UsuarioLogic usuarioLogic;
    
    @Inject
    private ReembolsoLogic boletaLogic;
    
        
    /**
     * GET para los Reembolsos de un usuario especifico.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas
     *
     * @return las boletas del usuario en objetos json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del Usuario se retorna un 404 not
     * found.
     */
    @GET
    public List<BoletaDTO> getBoletasUsuario(@PathParam("idUsuario") Long id) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        List<BoletaDTO> boletas = listEntity2DTO(entity.getBoletas());
        return boletas;
    }
    
   /**
     * GET para una boleta especifica de un Usuario especifico.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas/idBoleta
     *
     * @return una boleta especifica del usuario en objeto json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     * 
     * En caso de no existir el id de la Boleta se retorna un 404 not
     * found.
     */
    @GET
    @Path("{idReembolso: \\d+}")
    public  BoletaDTO getBoletaUsuario(@PathParam("idUsuario") Long id, @PathParam("idReembolso") Long idBoleta) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        
        List<BoletaEntity> boletas = entity.getBoletas();
        BoletaEntity boleta = null;
        for(BoletaEntity bol : boletas) if(bol.getId().equals(idBoleta)) boleta = bol;
        
        if(boleta == null) {
            throw new WebApplicationException("El recurso boleta: " + idBoleta + " no existe, relacionada con"
                    + "el usuario de id: "+ id, 404);
        }
        return new BoletaDTO(boleta);
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
        reembolsoEntity = boletaLogic.create(reembolsoEntity);
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
        
        ReembolsoEntity reembolso = boletaLogic.find(idReembolso);
        if(reembolso == null) {
            throw new WebApplicationException("El recurso reembolso: " + idReembolso + " no existe, relacionada con"
                    + "el usuario de id: "+ id, 404);
        }
        
        reembolso.setUsuario(entity);
        reembolso = boletaLogic.update(reembolso);
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
        boletaLogic.delete(reembolso);
    } 
        
            
    private List<BoletaDTO> listEntity2DTO(List<BoletaEntity> entityList) {
        List<BoletaDTO> list = new LinkedList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDTO(entity));
        }
        return list;
    }

    
}
