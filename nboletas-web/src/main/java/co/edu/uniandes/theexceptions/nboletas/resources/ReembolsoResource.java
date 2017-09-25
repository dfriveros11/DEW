/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDTO;
import co.edu.uniandes.theexceptions.nboletas.dtos.ReembolsoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.ReembolsoLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
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
    
    private static final Logger LOGGER = Logger.getLogger(ReembolsoResource.class.getName());
    
    /**
     * GET para todos los Reembolsos.
     * http://localhost:8080/nboletas-web/api/reembolsos
     *
     * @return la lista de todos los reembolsos en objetos json DTO.
     */
    @GET
    public List<ReembolsoDTO> getReembolsos(){
        return listEntity2DTO(logic.findAll());
    }
    
    /**
     * GET para un Reembolso.
     * http://localhost:8080/nboletas-web/api/reembolsos/id
     *
     * @return la lista de todos los Reembolsos en objetos json DTO.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del Reembolso a buscar, retornando un 404:
     * not found.
     */
    @GET
    @Path("{id: \\d+}")
    public ReembolsoDetailDTO getReembolso(@PathParam("id") Long id) throws WebApplicationException {
        ReembolsoEntity entity = logic.find(id);
        if(entity==null)
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        return new ReembolsoDetailDTO(entity);
    }
    
    /**
     * POST http://localhost:8080/nboletas-web/api/reembolsos
     *
     * @param reembolso correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java.
     */
    @POST
    public ReembolsoDetailDTO createReembolso(ReembolsoDetailDTO reembolso) throws BusinessLogicException {
        ReembolsoEntity entity = reembolso.toEntity();
        ReembolsoEntity newEntity = logic.create(entity);
        return new ReembolsoDetailDTO(newEntity);
    }
    
    /**
     * PUT http://localhost:8080/nboletas-web/api/reembolsos/id
     *
     * @param id del Reembolso a actualizar.
     * @param reembolso datos a actualizar del Reembolso.
     * @return El Reembolso actualizado.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del Reembolso a actualizar, retornando un 404:
     * not found.
     */
    @PUT
    @Path("{id: \\d+}")
    public ReembolsoDetailDTO updateReembolso(@PathParam("id") Long id, ReembolsoDetailDTO reembolso) throws WebApplicationException{
        if(logic.find(id) == null)
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        ReembolsoEntity entity = reembolso.toEntity();
        entity.setId(id);
        ReembolsoEntity actualizedEntity = logic.update(entity);
        return new ReembolsoDetailDTO(actualizedEntity);
    }
    
    /**
     * DELETE http://localhost:8080/nboletas-web/api/reembolso/id
     *
     * @param id corresponde al Reembolso a borrar.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del Reembolso a borrar, retornando un 404 not:
     * found.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUsuario(@PathParam("id") Long id)throws WebApplicationException {
        ReembolsoEntity entity = logic.find(id);
        if(entity==null)
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        logic.delete(entity);
    }  
    
    private List<ReembolsoDTO> listEntity2DTO(List<ReembolsoEntity> entityList){
        List<ReembolsoDTO> list = new LinkedList<>();
        for (ReembolsoEntity entity : entityList)
            list.add(new ReembolsoDTO(entity));
        return list;
    }
    
    
}
