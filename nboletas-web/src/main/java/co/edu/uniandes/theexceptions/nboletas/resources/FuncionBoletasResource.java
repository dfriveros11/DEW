/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.BoletaDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.FuncionLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.FuncionEntity;
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
 * @author ja.gomez1
 */
@Path("/funciones/{idFuncion: \\d+}/boletas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class FuncionBoletasResource {
    @Inject
    private FuncionLogic funcionLogic;
    
    @Inject
    private BoletaLogic boletaLogic;
    
    /**
     * GET para las boletas de una funcion especifica.
     * http://localhost:8080/nboletas-web/api/funciones/idFuncion/boletas
     *
     * @return las boletas de la funcion en objetos json DTO.
     * @throws BusinessLogicException
     * 
     * En caso de no existir el id de la Funcion se retorna un 404 not
     * found.
     */
    @GET
    public List<BoletaDetailDTO> getBoletasFuncion(@PathParam("idFuncion") Long id) throws BusinessLogicException {
        FuncionEntity f = funcionLogic.find(id);
        if(f == null) {
            throw new BusinessLogicException("No existe funcion con el id " + id);
        }
        List<BoletaDetailDTO> list = listEntity2DetailDTO(f.getBoletas());
        return list;
    }
    
    /**
     * GET para una boleta especifica de una funcion especifica.
     * http://localhost:8080/nboletas-web/api/funciones/idFuncion/boletas/idBoleta
     *
     * @return una boleta especifica de la funcion en objeto json DTO.
     * @throws BusinessLogicException
     * 
     * En caso de no existir el id de la Funcion se retorna un 404 not
     * found.
     * 
     * En caso de no existir el id de la Boleta se retorna un 404 not
     * found.
     */
    @GET
    @Path("{idBoleta: \\d+}")
    public BoletaDetailDTO getBoletaFuncion(@PathParam("idFuncion") Long id, @PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        FuncionEntity f = funcionLogic.find(id);
        if(f == null) {
            throw new BusinessLogicException("No existe funcion con el id " + id);
        }
        
        List<BoletaEntity> boletas = f.getBoletas();
        BoletaEntity boleta = null;
        for(BoletaEntity b : boletas) if(b.getId().equals(idBoleta)) boleta = b;
        
        if(boleta == null) {
            throw new BusinessLogicException("No existe boleta con el id " + idBoleta + " relacionada "
                    + "con la funcion de id " + id);
        }
        return new BoletaDetailDTO(boleta);
    }
    
    /**
     * POST para crear una relacion funcion boleta.
     * http://localhost:8080/nboletas-web/api/funciones/idFuncion/boletas
     *
     * @param Boleta correponde a la representación java del objeto json
     * enviado en el llamado, para agregar la relacion a la funcion.
     * @return la boleta que fue creada para la relacion con la funcion en objeto json DTO.
     * @throws BusinessLogicException
     * 
     * En caso de no existir el id de la Funcion se retorna un 404 not
     * found.
     */
    @POST
    public BoletaDetailDTO createBoletaFuncion(@PathParam("idFuncion") Long id, BoletaDetailDTO boleta) throws BusinessLogicException {
        FuncionEntity f = funcionLogic.find(id);
        if(f == null) {
            throw new BusinessLogicException("No existe funcion con el id " + id);
        }
        
        BoletaEntity b = boleta.toEntity();
        b.setFuncion(f);
        b = boletaLogic.create(b);
        return new BoletaDetailDTO(b);
    }
    
    /**
     * PUT para crear una relacion funcion boleta con una ya existente en el sistema.
     * http://localhost:8080/nboletas-web/api/funciones/idFuncion/boletas/idBoleta
     *
     * @return la boleta que fue creada para la relacion con la funcion en objeto json DTO.
     * @throws BusinessLogicException
     * 
     * En caso de no existir el id de la Funcion se retorna un 404 not
     * found.
     * 
     * En caso de no existir una boleta con el id por parametro
     * se returna un 404 not found.
     */
    @PUT
    @Path("{idBoleta: \\d+}")
    public BoletaDetailDTO updateBoletaFuncion(@PathParam("idFuncion") Long id, @PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        FuncionEntity f = funcionLogic.find(id);
        if(f == null) {
            throw new BusinessLogicException("No existe funcion con el id " + id);
        }
        
        BoletaEntity b = boletaLogic.find(idBoleta);
        if(b == null) {
            throw new BusinessLogicException("No existe una boleta con el id " + idBoleta);
        }
        
        b.setFuncion(f);
        b = boletaLogic.update(b);
        return new BoletaDetailDTO(b);
    }
    
    /**
     * DELETE para eliminar una relacion funcion-boleta ya existente en el sistema.
     * http://localhost:8080/nboletas-web/api/funciones/idFuncion/boletas/idBoleta
     *
     * @return la boleta que fue creada para la relacion con dla funcion en objeto json DTO.
     * @throws BusinessLogicException
     * 
     * En caso de no existir el id de la Funcion se retorna un 404 not
     * found.
     * 
     * En caso de no existir una boleta con el id por parametro
     * se retorna un 404 not found.
     */
    @DELETE
    @Path("{idBoleta: \\d+}")
    public void deleteBoletaFuncion(@PathParam("idFuncion") Long id, @PathParam("idBoleta") Long idBoleta) throws BusinessLogicException {
        FuncionEntity f = funcionLogic.find(id);
        if(f == null) {
            throw new BusinessLogicException("No existe funcion con el id " + id);
        }
        
        List<BoletaEntity> boletas = f.getBoletas();
        BoletaEntity boleta = null;
        for(BoletaEntity b : boletas) if(b.getId().equals(idBoleta)) boleta = b;
        if(boleta == null) {
            throw new BusinessLogicException("No existe una boleta con el id " + idBoleta + " relacionada "
                    + "con la funcion de id " + id);
        }
        
        boleta.setFuncion(null);
        boleta = boletaLogic.update(boleta);
    }
    
    
    
    private List<BoletaDetailDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDetailDTO> list = new ArrayList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }
}