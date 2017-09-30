/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.EnvioDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.EnvioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import com.gs.collections.impl.list.fixed.ArrayAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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

/**
 *
 * @author df.riveros11
 */
@Path("boletas/{idBoleta: \\d+}/envios")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class BoletaEnvioResource {

    @Inject
    BoletaLogic boletaLogic;

    @Inject
    EnvioLogic envioLogic;

    @POST
    public EnvioDetailDTO createBoletaEnvio(@PathParam("idBoleta") Long idBoleta, EnvioDetailDTO envio) throws BusinessLogicException {
        EnvioEntity envioCreado = boletaLogic.createBoletaEnvio(idBoleta, envio.toEntity());
        return new EnvioDetailDTO(envioCreado);
    }

    @GET
    public List<EnvioDetailDTO> getEnvios(@PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        List<EnvioEntity> envios = new ArrayList();
        try{
            EnvioEntity envio  = boletaLogic.find(idBoleta).getEnvio();
            envios.add(envio);
        }catch(Exception e){
            throw new BusinessLogicException("No se encuentra la boleta con el id: " + idBoleta + " mayor infromacion: " + e.getMessage());
        }
        EnvioDetailDTO entrega = new EnvioDetailDTO();
        return entrega.listEnvioEntity2EnvioDetailDTO(envios);
    }

    @GET
    @Path("{idEnvio: \\d+}")
    public EnvioDetailDTO getEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio) {
        EnvioEntity envio = null;
        try {
            envio = boletaLogic.findBoletaEnvio(idBoleta, idEnvio);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(BoletaEnvioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new EnvioDetailDTO(envio);
    }

    @PUT
    @Path("{idEnvio: \\d+}")
    public EnvioDetailDTO updateBoletaEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio, EnvioDetailDTO envio) throws BusinessLogicException {
        EnvioEntity actual = boletaLogic.updateBoletaEnvio(idBoleta, idEnvio, envio.toEntity());
        return new EnvioDetailDTO(actual);
    }

    @DELETE
    @Path("{idEnvio: \\d+}")
    public void deleteBoletaEnvio(@PathParam("idBoleta") Long idBoleta, @PathParam("idEnvio") Long idEnvio) throws BusinessLogicException {
        boletaLogic.deleteBoletaEnvio(idBoleta, idEnvio);
    }
    
}
