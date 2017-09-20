/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.theexceptions.nboletas.resources;

import co.edu.uniandes.theexceptions.nboletas.ejb.BoletaLogic;
import co.edu.uniandes.theexceptions.nboletas.dtos.BoletaDetailDTO;
import co.edu.uniandes.theexceptions.nboletas.ejb.ComentarioLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.EnvioLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.ReembolsoLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.SillaLogic;
import co.edu.uniandes.theexceptions.nboletas.ejb.UsuarioLogic;
import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.EnvioEntity;
import co.edu.uniandes.theexceptions.nboletas.entities.ReembolsoEntity;
import co.edu.uniandes.theexceptions.nboletas.exceptions.BusinessLogicException;
import co.edu.uniandes.theexceptions.nboletas.persistence.BoletaPersistence;
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
import javax.ws.rs.WebApplicationException;

/**
 * Clase que implementa el recurso REST correspondiente a "Boletas".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "Boletas". Al ejecutar la aplicación, el
 * recurso será accesibe a través de la ruta "/api/nboletas"
 *
 * @author ISIS2603
 *
 */
@Path("boletas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class BoletaResource {

    @Inject
    BoletaLogic boletaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private ReembolsoLogic reembolsoLogic;

    @Inject
    private EnvioLogic envioLogic;

    @Inject
    private SillaLogic sillaLogic;

    @Inject
    private ComentarioLogic comentarioLogic;

    @Inject
    private UsuarioLogic usuarioLogic;
    
    private static final Logger LOGGER = Logger.getLogger(BoletaResource.class.getName());

    /**
     * POST http://localhost:8080/nboletas-web/api/boletas
     *
     * @param Boleta correponde a la representación java del objeto json
     * enviado en el llamado.
     * @return Devuelve el objeto json de entrada que contiene el id creado por
     * la base de datos y el tipo del objeto java. Ejemplo: { "type":
     * "BoletaDetailDTO", "id": 1, atributo1 : "valor" }
     * @throws BusinessLogicException
     */
    @POST
    public BoletaDetailDTO createBoleta(BoletaDetailDTO Boleta) throws BusinessLogicException {
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        BoletaEntity BoletaEntity = Boleta.toEntity();
        // Invoca la lógica para crear la Boleta nueva
        BoletaEntity nuevoBoleta = boletaLogic.create(BoletaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        return new BoletaDetailDTO(nuevoBoleta);
    }

    /**
     * GET para todas las Boletas.
     * http://localhost:8080/nboletas-web/api/boletas
     *
     * @return la lista de todas las Boletas en objetos json DTO.
     * @throws BusinessLogicException
     */
    @GET
    public List<BoletaDetailDTO> getBoletas() throws BusinessLogicException {
        return listEntity2DetailDTO(boletaLogic.findAll());
    }

   
    /**
     * PUT http://localhost:8080/nboletas-web/api/boletas/1 Ejemplo
     * json { "id": 1, "atirbuto1": "Valor nuevo" }
     *
     * @param id corresponde a la Boleta a actualizar.
     * @param boleta corresponde  al objeto con los cambios que se van a
     * realizar.
     * @return La Boleta actualizada.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Boleta a actualizar se retorna un
     * 404 con el mensaje.
     */
    @PUT
    @Path("{id: \\d+}")
    public BoletaDetailDTO updateBoleta(@PathParam("id") Long id, BoletaDetailDTO boleta) throws BusinessLogicException, UnsupportedOperationException {
        BoletaEntity boletaActualizar = boleta.toEntity();
        if(null == boletaLogic.find(id)){
            throw new BusinessLogicException("No existe la boleta con el id: " + id);
        }
        boletaActualizar.setId(id);
        BoletaEntity boletaActualizada = boletaLogic.update(boletaActualizar);
        return (new BoletaDetailDTO(boletaActualizada));
    }

    /**
     * DELETE http://localhost:8080/nboletas-web/api/boletas/{id}
     *
     * @param id corresponde a la Boleta a borrar.
     * @throws BusinessLogicException
     *
     * En caso de no existir el id de la Boleta a actualizar se retorna un
     * 404 con el mensaje.
     *
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBoleta(@PathParam("id") Long id) throws BusinessLogicException {
         BoletaEntity boleta = boletaLogic.find(id);
         if(null == boleta){
             throw new BusinessLogicException("No existe la boleta con el id: " + id);
         }
         EnvioEntity envio = boleta.getEnvio();
         if(null != envio){
             /*borrar el envio*/
         }
         ComentarioEntity comentario = boleta.getComentario();
         if(null != comentario){
             /*borrar el comentario*/
         }
         ReembolsoEntity reembolso = boleta.getReembolso();
         if(null != reembolso){
             /*borrar el reembolso*/
         }
         boletaLogic.delete(boleta);
    }

    /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos BoletaEntity a una lista de
     * objetos BoletaDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Boletas de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Boletas en forma DTO (json)
     */
    private List<BoletaDetailDTO> listEntity2DetailDTO(List<BoletaEntity> entityList) {
        List<BoletaDetailDTO> list = new ArrayList<>();
        for (BoletaEntity entity : entityList) {
            list.add(new BoletaDetailDTO(entity));
        }
        return list;
    }

}
