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
    private BoletaLogic boletaLogic;
    
        
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
    public List<BoletaDetailDTO> getBoletasUsuario(@PathParam("idUsuario") Long id) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        List<BoletaDetailDTO> boletas = listEntity2DetailDTO(entity.getBoletas());
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
    public  BoletaDetailDTO getBoletaUsuario(@PathParam("idUsuario") Long id, @PathParam("idReembolso") Long idBoleta) throws WebApplicationException {
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
        return new BoletaDetailDTO(boleta);
    }
    
   /**
     * POST para crear una relacion usuario boleta.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas
     *
     * @param boleta correponde a la representación java del objeto json
     * enviado en el llamado, para agregar la relacion al usuario.
     * @return la boleta que fue creada para la relacion con el usuario en objeto json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     */
    @POST
    public BoletaDetailDTO createBoletaUsuario(@PathParam("idBoleta") Long id, BoletaDetailDTO boleta) throws WebApplicationException,BusinessLogicException{
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        BoletaEntity boletaEntity = boleta.toEntity();
        if(boletaEntity == null){
            throw new BusinessLogicException("La boleta no puede ser nula");
        }
        boletaEntity.setUsuario(entity);
        boletaEntity = boletaLogic.create(boletaEntity);
        return new BoletaDetailDTO(boletaEntity);
    }
    
   /**
     * PUT para modificar una relacion usuario boleta con una ya existente en el sistema.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas/idBoleta
     *
     * @return la boleta que fue creada para la relacion con el usuario en objeto json DTO.
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     * 
     * En caso de no existir un reembolso con el id por parametro
     * se returna un 404 not found.
     */
    @PUT
    @Path("{idBoleta: \\d+}")
        public BoletaDetailDTO updateBoletaUsuario(@PathParam("idUsuario") Long id, @PathParam("idBoleta") Long idBoleta) throws WebApplicationException {
        UsuarioEntity entity = usuarioLogic.find(id);
        if(entity == null) {
            throw new WebApplicationException("El recurso usuario: " + id + " no existe.", 404);
        }
        
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if(boleta == null) {
            throw new WebApplicationException("El recurso reembolso: " + idBoleta + " no existe, relacionada con"
                    + "el usuario de id: "+ id, 404);
        }
        
        boleta.setUsuario(entity);
        boleta = boletaLogic.update(boleta);
        return new BoletaDetailDTO(boleta);
    }
    
    /**
     * DELETE para eliminar una relacion usuario-boleta ya existente en el sistema.
     * http://localhost:8080/nboletas-web/api/usuarios/idUsuario/boletas/idBoleta
     * 
     * @throws WebApplicationException
     * 
     * En caso de no existir el id del usuario se retorna un 404 not
     * found.
     * 
     * En caso de no existir un reembolso con el id por parametro
     * se retorna un 404 not found.
     */
    @DELETE
    @Path("{idBoleta: \\d+}")
    public void deleteBoletaUsuario(@PathParam("idUsuario") Long id, @PathParam("idBoleta") Long idBoleta) throws WebApplicationException {
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
        boleta.setUsuario(entity);
        boletaLogic.delete(boleta);
    } 
        
            
    private List<BoletaDetailDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDetailDTO> list = new LinkedList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }

    
}
