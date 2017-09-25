/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.UsuarioEntity;
import javax.ejb.Stateless;

/**
 *
 * @author jm.contreras10
 */
@Stateless
public class UsuarioPersistence extends AbstractPersistence<UsuarioEntity> {

    public UsuarioPersistence() {
        super(UsuarioEntity.class);
    }
}