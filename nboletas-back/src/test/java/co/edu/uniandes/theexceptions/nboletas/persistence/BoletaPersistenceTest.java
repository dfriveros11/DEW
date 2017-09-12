/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author df.riveros11
 */
@RunWith(Arquillian.class)
public class BoletaPersistenceTest {
    
    public BoletaPersistenceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class BoletaPersistence.
     */
    @Test
    public void testCreate() {
         BoletaPersistence connection = new BoletaPersistence();
         BoletaEntity boleta = new BoletaEntity();
         boleta.setId(new Long(1));
         boleta.setPrecio(123.22);
         boleta.setVenida(true);
         connection.create(boleta);
    }

    /**
     * Test of uptade method, of class BoletaPersistence.
     */
    @Test
    public void testUptade() {
       
    }

    /**
     * Test of remove method, of class BoletaPersistence.
     */
    @Test
    public void testRemove() {
        
    }

    /**
     * Test of find method, of class BoletaPersistence.
     */
    @Test
    public void testFind() {
         BoletaPersistence connection = new BoletaPersistence();
         BoletaEntity boleta = new BoletaEntity();
         boleta.setId(new Long(1));
         boleta.setPrecio(123.22);
         boleta.setVenida(true);
         connection.create(boleta);
         BoletaEntity boletaEncontrada = connection.find(1);
         assertNotNull(boletaEncontrada);
         assertEquals(boleta.getId(), boletaEncontrada.getId());
         assertEquals(boleta.getPrecio(), boletaEncontrada.getPrecio());
         assertEquals(boleta.isVenida(), boletaEncontrada.isVenida());
    }

    /**
     * Test of findAll method, of class BoletaPersistence.
     */
    @Test
    public void testFindAll() {
        
    }
    
}
