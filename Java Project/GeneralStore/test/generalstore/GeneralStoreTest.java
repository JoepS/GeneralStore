/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joep
 */
public class GeneralStoreTest {
    
    public GeneralStoreTest() {
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
     * Test of main method, of class GeneralStore.
     */
    @Test
    public void testMain() {
        System.out.println("TEST: main");
        String[] args = null;
        GeneralStore.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCustomer method, of class GeneralStore.
     */
    @Test
    public void testCreateCustomer() {
        System.out.println("TEST: createCustomer");
        GeneralStore instance = new GeneralStore();
        instance.createCustomer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLabel method, of class GeneralStore.
     */
    @Test
    public void testChangeLabel() {
        System.out.println("TEST: changeLabel");
        int x = 0;
        int y = 0;
        String text = "hoi";
        GeneralStore instance = new GeneralStore();
        instance.changeLabel(x, y, text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEmployee method, of class GeneralStore.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("TEST: createEmployee");
        GeneralStore.createEmployee();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createProduct method, of class GeneralStore.
     */
    @Test
    public void testCreateProduct() {
        System.out.println("TEST: createProduct");
        GeneralStore.createProduct();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPathways method, of class GeneralStore.
     */
    @Test
    public void testCreatePathways() {
        System.out.println("TEST: createPathways");
        GeneralStore instance = new GeneralStore();
        instance.createPathways();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createDepartements method, of class GeneralStore.
     */
    @Test
    public void testCreateDepartements() {
        System.out.println("TEST: createDepartements");
        GeneralStore instance = new GeneralStore();
        instance.createDepartements();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCashRegister method, of class GeneralStore.
     */
    @Test
    public void testCreateCashRegister() {
        System.out.println("TEST: createCashRegister");
        GeneralStore instance = new GeneralStore();
        instance.createCashRegister();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createWareHouse method, of class GeneralStore.
     */
    @Test
    public void testCreateWareHouse() {
        System.out.println("TEST: createWareHouse");
        GeneralStore instance = new GeneralStore();
        instance.createWareHouse();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
