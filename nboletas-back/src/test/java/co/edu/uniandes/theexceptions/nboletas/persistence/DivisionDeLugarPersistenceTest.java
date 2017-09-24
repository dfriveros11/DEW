/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.DivisionDeLugarEntity;
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
import org.junit.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author fc.alvarez10
 */
@RunWith(Arquillian.class)
public class DivisionDeLugarPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DivisionDeLugarEntity.class.getPackage())
                .addPackage(DivisionDeLugarPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private DivisionDeLugarPersistence persistence;

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
    private List<DivisionDeLugarEntity> data = new ArrayList<DivisionDeLugarEntity>();

    public DivisionDeLugarPersistenceTest() {
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
        em.createQuery("delete from DivisionDeLugarEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DivisionDeLugarEntity entity = factory.manufacturePojo(DivisionDeLugarEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class BoletaPersistence.
     */
    @Test
    public void testCreate() {

        PodamFactory factory = new PodamFactoryImpl();
        DivisionDeLugarEntity newEntity = factory.manufacturePojo(DivisionDeLugarEntity.class);
        DivisionDeLugarEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);
        DivisionDeLugarEntity entity = em.find(DivisionDeLugarEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
    }

    /**
     * Test of uptade method, of class BoletaPersistence.
     */
    @Test
    public void testUptade() {
        DivisionDeLugarEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DivisionDeLugarEntity newEntity = factory.manufacturePojo(DivisionDeLugarEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        DivisionDeLugarEntity resp = em.find(DivisionDeLugarEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of remove method, of class BoletaPersistence.
     */
    @Test
    public void testDelete() {
        DivisionDeLugarEntity entity = data.get(0);
        persistence.delete(entity);
        DivisionDeLugarEntity deleted = em.find(DivisionDeLugarEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class BoletaPersistence.
     */
    @Test
    public void testFind() {
        DivisionDeLugarEntity entity = data.get(0);
        DivisionDeLugarEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findAll method, of class BoletaPersistence.
     */
    @Test
    public void testFindAll() {
        List<DivisionDeLugarEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (DivisionDeLugarEntity ent : list) {
            boolean found = false;
            for (DivisionDeLugarEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
