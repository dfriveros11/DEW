package co.edu.uniandes.theexceptions.nboletas.persistence;

import co.edu.uniandes.theexceptions.nboletas.entities.EspectaculoEntity;
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
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author df.riveros11
 */
@RunWith(Arquillian.class)
public class EspectaculoPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EspectaculoEntity.class.getPackage())
                .addPackage(EspectaculoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase XYZPersistence cuyos métodos se
     * van a probar.
     */
    @Inject
    private EspectaculoPersistence persistence;

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
    private List<EspectaculoEntity> data = new ArrayList<EspectaculoEntity>();

    public EspectaculoPersistenceTest() {
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
        em.createQuery("delete from EspectaculoEntity").executeUpdate();
    }

    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EspectaculoEntity entity = factory.manufacturePojo(EspectaculoEntity.class);
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
        EspectaculoEntity newEntity = factory.manufacturePojo(EspectaculoEntity.class);
        EspectaculoEntity result = persistence.create(newEntity);
        Assert.assertNotNull(result);
        EspectaculoEntity entity = em.find(EspectaculoEntity.class, result.getId());
        Assert.assertNotNull(entity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
        // Assert.assertEquals(newEntity.getPrecio(), entity.getPrecio(), 0.00);
    }

    /**
     * Test of uptade method, of class BoletaPersistence.
     */
    public void testUpdate() {
        EspectaculoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EspectaculoEntity newEntity = factory.manufacturePojo(EspectaculoEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        EspectaculoEntity resp = em.find(EspectaculoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Test of remove method, of class BoletaPersistence.
     */
    public void testDelete() {
        EspectaculoEntity entity = data.get(0);
        persistence.delete(entity);
        EspectaculoEntity deleted = em.find(EspectaculoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Test of find method, of class BoletaPersistence.
     */
    public void testFind() {
        EspectaculoEntity entity = data.get(0);
        EspectaculoEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Test of findAll method, of class BoletaPersistence.
     */
    @Test
    public void testFindAll() {
        List<EspectaculoEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (EspectaculoEntity ent : list) {
            boolean found = false;
            for (EspectaculoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

}
