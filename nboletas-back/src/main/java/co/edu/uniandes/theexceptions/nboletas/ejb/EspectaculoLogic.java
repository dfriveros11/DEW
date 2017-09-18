/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.ejb;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jf.ramos
 */
@Stateless
public class EspectaculoLogic extends AbstractLogic<EspectaculoEntity> {

    @Override
    public EspectaculoEntity create(EspectaculoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EspectaculoEntity update(EspectaculoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(EspectaculoEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EspectaculoEntity find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EspectaculoEntity> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
