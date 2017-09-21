/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.ArtistaEntity;
import javax.ejb.Stateless;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class ArtistaPersistence extends AbstractPersistence<ArtistaEntity>{
    public ArtistaPersistence() {
        super(ArtistaEntity.class);
    }
}
