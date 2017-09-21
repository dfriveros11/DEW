/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import co.edu.uniandes.theexceptions.nboletas.persistence.AbstractPersistence;
import javax.ejb.Stateless;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class EspectaculoLogic extends AbstractLogic<EspectaculoEntity> {

    @Override
    protected AbstractPersistence<EspectaculoEntity> getPersistence() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
