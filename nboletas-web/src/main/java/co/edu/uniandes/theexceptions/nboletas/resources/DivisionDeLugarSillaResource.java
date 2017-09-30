/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.SillaDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.*;
import co.edu.uniandes.theexceptions.nboletas.entities.DivisionDeLugarEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.SillaEntity;
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
 * @author fc.alvarez10
 */
@Path("divisiones/{divisionesid: \\d+}/sillas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class DivisionDeLugarSillaResource {
    
    @Inject
    DivisionDeLugarLogic divisionLogic;
    
    @Inject
    SillaLogic sillaLogic;
    
    @POST
    public SillaDetailDTO createDivisionSilla(@PathParam("divisionesid") Long idDivision, SillaDetailDTO silla) throws BusinessLogicException {
        DivisionDeLugarEntity division = divisionLogic.find(idDivision);
        if (division == null) {
            throw new BusinessLogicException("No existe la division con el id: " + idDivision);
        }
        SillaEntity sillaEntity = silla.toEntity();
        sillaEntity.setDivision(division);
        SillaEntity sillaCreada = sillaLogic.create(sillaEntity);
        return new SillaDetailDTO(sillaCreada);
    }
    
    @GET
    public List<SillaDetailDTO> getSillas(@PathParam("divisionesid") Long idDivision) throws BusinessLogicException {
        
        DivisionDeLugarEntity division = divisionLogic.find(idDivision);
        if (division == null) {
            throw new BusinessLogicException("No existe la division con ese id: " + idDivision);
        }
        List<SillaDetailDTO> list = listEntity2DetailDTO(division.getSillas());
        return list;
    }
    
    @GET
    @Path("{sillasid: \\d+}")
    public SillaDetailDTO getSilla(@PathParam("divisionesid") Long idDivision, @PathParam("sillasid") Long idSilla) throws BusinessLogicException {
        DivisionDeLugarEntity division = divisionLogic.find(idDivision);
        if (division == null) {
            throw new BusinessLogicException("No existe la division con ese id: " + idDivision);
        }
        SillaEntity silla = null;
        List<SillaEntity> sillas= division.getSillas();
        for(SillaEntity s:sillas){
            if(s.getId().equals(idSilla)){
                silla=s;
            }
        }
        if(silla==null){
            throw new BusinessLogicException("No existe una silla con id:" + idSilla + " relacionada con la división de id:"+idDivision );
        }
        silla.setDivision(division);
        return new SillaDetailDTO(silla);
    }
    
    @PUT
    @Path("{sillasid: \\d+}")
    public SillaDetailDTO updateDivisionSilla(@PathParam("divisionesid") Long idDivision, @PathParam("sillasid") Long idSilla, SillaDetailDTO silla) throws BusinessLogicException {
        DivisionDeLugarEntity division = divisionLogic.find(idDivision);
        if (division == null) {
            throw new BusinessLogicException("No existe una division con el id: " + idDivision);
        }
        SillaEntity sil=sillaLogic.find(idSilla);
        if (null == sil) {
            throw new BusinessLogicException("No existe una silla con el id: " + idSilla);
        }
        SillaEntity sillaActualizar = silla.toEntity();
        sillaActualizar.setDivision(division);
        sillaActualizar.setId(idSilla);
        SillaEntity actual = sillaLogic.update(sillaActualizar);
        return new SillaDetailDTO(actual);
    }
    
    @DELETE
    @Path("{sillasid: \\d+}")
    public void deleteDivisionSilla(@PathParam("divisionesid") Long idDivision, @PathParam("sillasid") Long idSilla) throws BusinessLogicException {
        DivisionDeLugarEntity division = divisionLogic.find(idDivision);
        if (division == null) {
            throw new BusinessLogicException("No existe una division con el id: " + idDivision);
        }
        SillaEntity silla = null;
        List<SillaEntity> sillas=division.getSillas();
        for(SillaEntity s:sillas){
            if(s.getId().equals(idSilla)){
                silla=s;
            }
        }
        if (silla == null) {
            throw new BusinessLogicException("No existe una silla con el id: " + idSilla + "relacionada con la división de id: " + idDivision );
        }
        silla.setDivision(null);
        sillaLogic.update(silla);
    }

    private List<SillaDetailDTO> listEntity2DetailDTO(List<SillaEntity> entityList) {
        List<SillaDetailDTO> list = new ArrayList<>();
        for (SillaEntity entity : entityList) {
            list.add(new SillaDetailDTO(entity));
        }
        return list;
    }
}
