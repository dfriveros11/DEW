/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.ComentarioEntity;

/**
 *
 * @author am.valero10
 */
public class ComentarioPersistence extends AbstractPersistence<ComentarioEntity> {
    
    public ComentarioPersistence(){
                super(ComentarioEntity.class);
            }
}
