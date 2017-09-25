/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.EspectaculoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.dtos.OrganizadorDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.EspectaculoLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.OrganizadorLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.OrganizadorEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author jf.ramos
 */
@Path("espectaculos/{idEspectaculo: \\d+}/organizadores")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class EspectaculoOrganizadorResources {
   
@Inject
    OrganizadorLogic organizadorLogic;

@Inject
    EspectaculoLogic espectaculoLogic;

    @POST
    public OrganizadorDetailDTO createEspectaculoOrganizador(@PathParam("idEspectaculo") Long idEspectaculo, OrganizadorDetailDTO organizador) throws BusinessLogicException {
        EspectaculoEntity espectaculo = espectaculoLogic.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con el id: " + idEspectaculo);
        }
        OrganizadorEntity organizadorE = organizador.toEntity();
        List<OrganizadorEntity> organizadores = new ArrayList<>();
        organizadores.add(organizadorE);
        espectaculo.setOrganizador(organizadores);
        OrganizadorEntity organizadorCreado = organizadorLogic.create(organizadorE);
        return new OrganizadorDetailDTO(organizadorCreado);
    }

    @GET
    public List<OrganizadorDetailDTO> getOrganizadores(@PathParam("idEspectaculo") Long idEspectaculo) throws BusinessLogicException {
        List<OrganizadorEntity> list = new ArrayList<>();
        EspectaculoEntity espectaculo = espectaculoLogic.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        }
        List<OrganizadorEntity> organizadores = espectaculo.getOrganizador();
        if (organizadores != null) {
            for (OrganizadorEntity organizador : organizadores) {
                list.add(organizador);
            }
        }
        return listEntity2DetailDTO(list);
    }

    @GET
    @Path("{idOrganizador: \\d+}")
    public OrganizadorDetailDTO getOrganizador(@PathParam("idEspectaculo") Long idEspectaculo, @PathParam("idOrganizador") Long idOrganizador) throws BusinessLogicException {
        EspectaculoEntity espectaculo = espectaculoLogic.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        }
        OrganizadorEntity organizador = organizadorLogic.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        return new OrganizadorDetailDTO(organizador);
    }

    @PUT
    @Path("{idOrganizador: \\d+}")
    public OrganizadorDetailDTO updateEspectaculoOrganizador(@PathParam("idEspectaculo") Long idEspectaculo, @PathParam("idOrganizador") Long idOrganizador, OrganizadorDetailDTO organizador ) throws BusinessLogicException {
        EspectaculoEntity espectaculo = espectaculoLogic.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        }
        if (null == organizadorLogic.find(idOrganizador)) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        OrganizadorEntity organizadorActualizar = organizador.toEntity();
        List<EspectaculoEntity> espectaculos = new ArrayList<>();
        espectaculos.add(espectaculo);
        organizadorActualizar.setEspectaculos(espectaculos);
        organizadorActualizar.setId(idOrganizador);
        OrganizadorEntity actual = organizadorLogic.update(organizadorActualizar);
        return new OrganizadorDetailDTO(actual);
    }

    @DELETE
    @Path("{idOrganizador: \\d+}")
    public void deleteEspectaculoOrganizador(@PathParam("idEspectaculo") Long idEspectaculo, @PathParam("idOrganizador") Long idOrganizador) throws BusinessLogicException {
        EspectaculoEntity espectaculo = espectaculoLogic.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        }
        OrganizadorEntity organizador = organizadorLogic.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        List<EspectaculoEntity> espectaculos= new ArrayList<>();
        espectaculos.add(espectaculo);
        organizador.setEspectaculos(espectaculos);
        organizadorLogic.delete(organizador);
    }

    private List<OrganizadorDetailDTO> listEntity2DetailDTO(List<OrganizadorEntity> entityList) {
        List<OrganizadorDetailDTO> list = new ArrayList<>();
        for (OrganizadorEntity entity : entityList) {
            list.add(new OrganizadorDetailDTO(entity));
        }
        return list;
    }
}

