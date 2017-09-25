/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.BoletaDetailDTO;
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
 * @author angeloMarcetty
 */
@Path("comentarios/{idComentario: \\d+}/boletas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ComentarioBoletaResource {
    
    @Inject
    ComentarioLogic comentarioLogic;
    
    @Inject
    BoletaLogic boletaLogic;
    
   
    
    @POST
    public BoletaDetailDTO creatComentarioBoleta(@PathParam("idComentario") Long idComentario, BoletaDetailDTO boleta)throws BusinessLogicException{
        ComentarioEntity comentario = comentarioLogic.find(idComentario);
        
        if(comentario == null){
                        throw new BusinessLogicException("No existe el comentario con el id: " + idComentario);
        }
        
        BoletaEntity boletaE = boleta.toEntity();
        boletaE.setComentario(comentario);
        BoletaEntity boletaCreada = boletaLogic.create(boletaE);
        return new BoletaDetailDTO(boletaCreada);   
    }

    
    @GET
    public List<BoletaDetailDTO> getBoletas(@PathParam("idComentario") Long idComentario)  throws BusinessLogicException{
        List<BoletaEntity> list = new ArrayList<>();
        ComentarioEntity comentario = comentarioLogic.find(idComentario);
        if(comentario == null){
                        throw new BusinessLogicException("No existe el comentario con ese id: " + idComentario);
        }
        BoletaEntity boleta = comentario.getBoleta();
        if(boleta !=null){
            list.add(comentario.getBoleta());
        }
        
        return listEntity2DetailDTO(list);
    }
    
    
    @GET
    @Path("{idBoleta: \\d+}")
    public BoletaDetailDTO getBoleta(@PathParam("idComentario") Long idComentario, @PathParam("idBoleta") Long idBoleta)throws BusinessLogicException{
        ComentarioEntity comentario = comentarioLogic.find(idComentario);
        if(comentario == null){
                        throw new BusinessLogicException("No existe el comentario con ese id: " + idComentario);
        }
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if(boleta == null){
                        throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }       
        boleta.setComentario(comentario);
        return new BoletaDetailDTO(boleta);
    }
    
    
    @PUT
    @Path("{idBoleta: \\d+}")
    public BoletaDetailDTO uodateComentarioBoleta(@PathParam("idComentario") Long idComentario, @PathParam("idBoleta") Long idBoleta, BoletaDetailDTO boleta)throws BusinessLogicException{
        ComentarioEntity comentario = comentarioLogic.find(idComentario);
        if(comentario == null){
                        throw new BusinessLogicException("No existe el comentario con ese id: " + idComentario);
        }
        if(boletaLogic.find(idBoleta) == null){
                        throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        BoletaEntity boletaActualizar = boleta.toEntity();
        boletaActualizar.setComentario(comentario);
        boletaActualizar.setId(idBoleta);
        BoletaEntity actual = boletaLogic.update(boletaActualizar);
        return new BoletaDetailDTO(actual);        
    }
    
    @DELETE
    @Path("{idBoleta: \\d+}")
    public void deleteComentarioBoleta(@PathParam("idComentario") Long idComentario, @PathParam("idBoleta") Long idBoleta) throws BusinessLogicException{
        ComentarioEntity comentario = comentarioLogic.find(idComentario);
        if(comentario == null){
          throw new BusinessLogicException("No existe el comentario con ese id: " + idComentario);
        }
        BoletaEntity boleta = boletaLogic.find(idBoleta);
        if(boleta == null){
            throw new BusinessLogicException("No existe la boleta con ese id: " + idBoleta);
        }
        boleta.setComentario(comentario);
        boletaLogic.delete(boleta);
    }



    
    private List<BoletaDetailDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDetailDTO> list = new ArrayList<>();
        for(BoletaEntity entity: entityList){
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }

    
    
    
    
    
}
