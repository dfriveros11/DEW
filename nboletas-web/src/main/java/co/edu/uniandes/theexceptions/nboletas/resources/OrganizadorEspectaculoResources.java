/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.dtos.EnvioDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.dtos.EspectaculoDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.EnvioLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.EspectaculoLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.OrganizadorLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.OrganizadorEntity;
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
@Path("organizadores/{idOrganizador: \\d+}/espectaculos")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class OrganizadorEspectaculoResources {
@Inject
    OrganizadorLogic organizadorLogic;

    @Inject
    EspectaculoLogic espectaculoLogic;

    @POST
    public EspectaculoDetailDTO createOrganizadorEspectaculo(@PathParam("idOrganizador") Long idOrganizador, EspectaculoDetailDTO espectaculo) throws BusinessLogicException {
        OrganizadorEntity organizador = organizadorLogic.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con el id: " + idOrganizador);
        }
        EspectaculoEntity espectaculoE = espectaculo.toEntity();
        List<OrganizadorEntity> organizadores = new ArrayList<>();
        organizadores.add(organizador);
        espectaculoE.setOrganizador(organizadores);
        EspectaculoEntity espectaculoCreado = espectaculoLogic.create(espectaculoE);
        return new EspectaculoDetailDTO(espectaculoCreado);
    }

    @GET
    public List<EspectaculoDetailDTO> getEspectaculos(@PathParam("idOrganizador") Long idOrganizador) throws BusinessLogicException {
        List<EspectaculoEntity> list = new ArrayList<>();
        OrganizadorEntity organizador = organizadorLogic.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        List<EspectaculoEntity> espectaculos = organizador.getEspectaculos();
        if (espectaculos != null) {
            for (EspectaculoEntity espectaculo : espectaculos) {
                list.add(espectaculo);
            }
        }
        return listEntity2DetailDTO(list);
    }

    @GET
    @Path("{idEspectaculo: \\d+}")
    public EspectaculoDetailDTO getEspectaculo(@PathParam("idOrganizador") Long idOrganizador, @PathParam("idEspectaculo") Long idEspectaculo) throws BusinessLogicException {
        OrganizadorEntity organizador = organizadorLogic.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        EspectaculoEntity espectaculo = espectaculoLogic.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        }
        List<OrganizadorEntity> organizadores = new ArrayList<>();
        organizadores.add(organizador);
        espectaculo.setOrganizador(organizadores);
        return new EspectaculoDetailDTO(espectaculo);
    }

    @PUT
    @Path("{idEspectaculo: \\d+}")
    public EspectaculoDetailDTO updateOrganizadorEspectaculo(@PathParam("idOrganizador") Long idOrganizador, @PathParam("idEspectaculo") Long idEspectaculo, EspectaculoDetailDTO espectaculo) throws BusinessLogicException {
        OrganizadorEntity organizador = organizadorLogic.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        if (null == espectaculoLogic.find(idEspectaculo)) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        }
        EspectaculoEntity espectaculoActualizar = espectaculo.toEntity();
        List<OrganizadorEntity> organizadores = new ArrayList<>();
        organizadores.add(organizador);
        espectaculoActualizar.setOrganizador(organizadores);
        espectaculoActualizar.setId(idEspectaculo);
        EspectaculoEntity actual = espectaculoLogic.update(espectaculoActualizar);
        return new EspectaculoDetailDTO(actual);
    }

    @DELETE
    @Path("{idEspectaculo: \\d+}")
    public void deleteOrganizadorEspectaculo(@PathParam("idOrganizador") Long idOrganizador, @PathParam("idEspectaculo") Long idEspectaculo) throws BusinessLogicException {
        OrganizadorEntity organizador = organizadorLogic.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        EspectaculoEntity espectaculo = espectaculoLogic.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        }
        List<OrganizadorEntity> organizadores = new ArrayList<>();
        organizadores.add(organizador);
        espectaculo.setOrganizador(organizadores);
        espectaculoLogic.delete(espectaculo);
    }

    private List<EspectaculoDetailDTO> listEntity2DetailDTO(List<EspectaculoEntity> entityList) {
        List<EspectaculoDetailDTO> list = new ArrayList<>();
        for (EspectaculoEntity entity : entityList) {
            list.add(new EspectaculoDetailDTO(entity));
        }
        return list;
    }
}
