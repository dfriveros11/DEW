/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.UsuarioDTO;
import co.edu.uniandes.theexceptions.nboletas.dtos.UsuarioDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.UsuarioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
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
@Path("usuarios")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class UsuarioResource {
    
    @Inject
    private UsuarioLogic logic;
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioResource.class.getName());
    
    /**
     * GET para todas las Funciones.
     * http://localhost:8080/nboletas-web/api/usuarios
     *
     * @return la lista de todas las Funciones en objetos json DTO.
     */
    @GET
    public List<UsuarioDetailDTO> getUsuarios(){
        return listEntity2DetailDTO(logic.findAll());
    }
    
    /**
     * GET para todos los Usuarios.
     * http://localhost:8080/nboletas-web/api/usuarios/id
     *
     * @return la lista de todos los Usuarios en objetos json DTO.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del Usuario a buscar, retornando un 404:
     * not found.
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDetailDTO getUsuario(@PathParam("id") Long id) throws WebApplicationException {
        UsuarioEntity entity = logic.find(id);
        if(entity==null)
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        return new UsuarioDetailDTO(entity);
    }
    
    /**
     * POST http://localhost:8080/nboletas-web/api/usuarios
     *
     * @param usuario correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java.
     */
    @POST
    public UsuarioDetailDTO createUsuario(UsuarioDetailDTO usuario) throws BusinessLogicException {
        UsuarioEntity entity = usuario.toEntity();
        if(logic.findByUserName(entity.getUserName())!=null)
            throw new BusinessLogicException("Ya se ha registrado un usuario con el user name: "+entity.getUserName());
        UsuarioEntity newEntity = logic.create(entity);
        return new UsuarioDetailDTO(newEntity);
    }
    
    /**
     * PUT http://localhost:8080/nboletas-web/api/usuarios/id
     *
     * @param id del Usuario a actualizar.
     * @param usuario datos a actualizar del Usuario.
     * @return El usuario actualizado.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del Usuario a actualizar, retornando un 404:
     * not found.
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDetailDTO updateUsuario(@PathParam("id") Long id, UsuarioDetailDTO usuario) throws WebApplicationException{
        if(logic.find(id) == null)
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        UsuarioEntity entity = usuario.toEntity();
        entity.setId(id);
        UsuarioEntity actualizedEntity = logic.update(entity);
        return new UsuarioDetailDTO(actualizedEntity);
    }
    
    /**
     * DELETE http://localhost:8080/nboletas-web/api/usuarios/id
     *
     * @param id corresponde al Usuario a borrar.
     * @throws WebApplicationException
     *
     * En caso de no existir el id del Usuario a borrar, retornando un 404 not:
     * found.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUsuario(@PathParam("id") Long id) throws WebApplicationException {
        UsuarioEntity entity = logic.find(id);
        if(entity==null)
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        logic.delete(entity);
    }  
    
    private List<UsuarioDetailDTO> listEntity2DetailDTO(List<UsuarioEntity> entityList){
        List<UsuarioDetailDTO> list = new LinkedList<>();
        for (UsuarioEntity entity : entityList)
            list.add(new UsuarioDetailDTO(entity));
        return list;
    }
    
}
