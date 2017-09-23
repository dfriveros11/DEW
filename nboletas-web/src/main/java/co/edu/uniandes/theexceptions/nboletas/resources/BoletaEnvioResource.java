/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.EnvioDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.EnvioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;
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
 * @author df.riveros11
 */
@Path("boletas/{boletaId: \\d+}/envios")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class BoletaEnvioResource {
    
    @Inject
    EnvioLogic envioLogic;
    
    @POST
    @Path("{id: \\d+}")
    public EnvioDetailDTO createBoletaEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio, EnvioDetailDTO envio) throws BusinessLogicException {
        return null;
    }
    
    @GET
    public List<EnvioDetailDTO> getEnvios(@PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        return null;
    }
    
    @GET
    @Path("{id: \\d+}")
    public EnvioDetailDTO getEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio) throws  BusinessLogicException {
        return null;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public EnvioDetailDTO updateBoletaEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio) throws BusinessLogicException{
        return null;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBoletaEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio) throws BusinessLogicException{
        
    }
    
    private List<EnvioDetailDTO> listEntity2DetailDTO(List<EnvioEntity> entityList) {
        List<EnvioDetailDTO> list = new ArrayList<>();
        for (EnvioEntity entity : entityList) {
            list.add(new EnvioDetailDTO(entity));
        }
        return list;
    }
}
