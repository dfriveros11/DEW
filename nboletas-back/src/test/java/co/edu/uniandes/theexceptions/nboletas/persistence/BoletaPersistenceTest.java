package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.BoletaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author df.riveros11
 */
@RunWith(Arquillian.class)
public class BoletaPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BoletaEntity.class.getPackage())
                .addPackage(BoletaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private BoletaPersistence persistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     *
     */
    private List<BoletaEntity> data = new ArrayList<BoletaEntity>();

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

        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        em.createQuery("delete from BoletaEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            BoletaEntity entity = factory.manufacturePojo(BoletaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreate() {
        BoletaPersistence connection = new BoletaPersistence();
        BoletaEntity boleta = new BoletaEntity();
        boleta.setId(new Long(1));
        boleta.setPrecio(123.22);
        boleta.setVenida(true);
        connection.create(boleta);
        PodamFactory factory = new PodamFactoryImpl();
        BoletaEntity newEntity = factory.manufacturePojo(BoletaEntity.class);
        BoletaEntity result = persistence.create(newEntity);
        Assert.assertNotNull(result);
        BoletaEntity entity = em.find(BoletaEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getPrecio(), entity.getPrecio(), 0.00);
    }

    /**
     * Test of update method, of class BoletaPersistence.
     */
    @Test
    public void testUpdate() {
        BoletaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        BoletaEntity newEntity = factory.manufacturePojo(BoletaEntity.class);
        newEntity.setId(entity.getId());
        persistence.update(newEntity);
        BoletaEntity resp = em.find(BoletaEntity.class, entity.getId());
        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of remove method, of class BoletaPersistence.
     */
    @Test
    public void testDelete() {
        BoletaEntity entity = data.get(0);
        persistence.delete(entity);
        BoletaEntity deleted = em.find(BoletaEntity.class, entity.getId());
        Assert.assertNull(deleted);
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
        BoletaEntity entity = data.get(0);
        BoletaEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findAll method, of class BoletaPersistence.
     */
    @Test
    public void testFindAll() {
        List<BoletaEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (BoletaEntity ent : list) {
            boolean found = false;
            for (BoletaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
