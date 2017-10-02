/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.ArtistaEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import co.edu.uniandes.theexceptions.nboletas.persistence.ArtistaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class ArtistaLogic extends AbstractLogic<ArtistaEntity> {

    @Inject
    private ArtistaPersistence persistence;

    @Override
    protected AbstractPersistence<ArtistaEntity> getPersistence() {
        return persistence;
    }

}
