/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.EspectaculoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class EspectaculoLogic extends AbstractLogic<EspectaculoEntity> {

    @Inject
    private EspectaculoPersistence persistence;
    
    @Inject
    private OrganizadorPersistence organizadorPersistence;

    @Override
    protected AbstractPersistence<EspectaculoEntity> getPersistence() {
        return persistence;
    }
   
    @Override
    public void delete(EspectaculoEntity entity){
        try {
            Long id=entity.getId();
            persistence.deleteArtistaEspectaculo(id);
            persistence.deleteComentarioEspectaculo(id);
            persistence.deleteFuncionEspectaculo(id);
            persistence.deleteOrganizadorEspectaculo(id);
            persistence.delete(entity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("La instancia no es una entidad", e);
        } catch (TransactionRequiredException e) {
            throw new TransactionRequiredException("No existe ninguna transaccion");
        }
    }
    /**Recibimos todo el id del organizador que vamos a desasociar**/
    public void deleterEspectaculoOrganizado(Long idOrganizador, Long idEspectaculo) throws BusinessLogicException {
        OrganizadorEntity organizador = persistenceOrganizador.find(idOrganizador);
        if (organizador == null) {
            throw new BusinessLogicException("No existe el organizador con ese id: " + idOrganizador);
        }
        EspectaculoEntity espectaculo = persistenceEspectaculo.find(idEspectaculo);
        if (espectaculo == null) {
            throw new BusinessLogicException("No existe el espectaculo con ese id: " + idEspectaculo);
        };
        try{
            persistence.deleteEspectaculoTablaIntermediaOrganizador(idOrganizador, idEspectaculo);
        }catch(PersistenceException e){
            throw new PersistenceException("No se puede eliminar el espectaculo con el id: " + idEspectaculo + " relacionado al organizador con el id: " + idOrganizador + " El error es: " + e.getMessage());
        }
    }
}
