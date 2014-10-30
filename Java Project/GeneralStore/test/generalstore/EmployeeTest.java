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
 * @author Fré-Meine
 */
public class EmployeeTest {
    
    public EmployeeTest() {
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
     * Test of setAlreadyWorking method, of class Employee.
     */
    @Test
    public void testSetAlreadyWorking() {
        System.out.println("setAlreadyWorking");
        Boolean alreadyWorking = null;
        Employee instance = null;
        instance.setAlreadyWorking(alreadyWorking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlreadyWorking method, of class Employee.
     */
    @Test
    public void testGetAlreadyWorking() {
        System.out.println("getAlreadyWorking");
        Employee instance = null;
        Boolean expResult = null;
        Boolean result = instance.getAlreadyWorking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOnCashRegister method, of class Employee.
     */
    @Test
    public void testGetOnCashRegister() {
        System.out.println("getOnCashRegister");
        Employee instance = null;
        Boolean expResult = null;
        Boolean result = instance.getOnCashRegister();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRefillProducts method, of class Employee.
     */
    @Test
    public void testGetRefillProducts() {
        System.out.println("getRefillProducts");
        Employee instance = null;
        Boolean expResult = null;
        Boolean result = instance.getRefillProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOnDepartement method, of class Employee.
     */
    @Test
    public void testGetOnDepartement() {
        System.out.println("getOnDepartement");
        Employee instance = null;
        Boolean expResult = null;
        Boolean result = instance.getOnDepartement();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeliveryWagonDuty method, of class Employee.
     */
    @Test
    public void testGetDeliveryWagonDuty() {
        System.out.println("getDeliveryWagonDuty");
        Employee instance = null;
        Boolean expResult = null;
        Boolean result = instance.getDeliveryWagonDuty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartment method, of class Employee.
     */
    @Test
    public void testGetDepartment() {
        System.out.println("getDepartment");
        Employee instance = null;
        Department expResult = null;
        Department result = instance.getDepartment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOnCashRegister method, of class Employee.
     */
    @Test
    public void testSetOnCashRegister() {
        System.out.println("setOnCashRegister");
        Boolean bool = false;
        Employee instance = new Employee(true, true, true, true, "henk", "henk", 10, "orc", true, 0, 0, true);
        instance.setOnCashRegister(bool);
        Boolean result = instance.getOnCashRegister();
        assertEquals(result, bool);
    }

    /**
     * Test of setRefillProducts method, of class Employee.
     */
    @Test
    public void testSetRefillProducts() {
        System.out.println("setRefillProducts");
        Boolean bool = null;
        Employee instance = null;
        instance.setRefillProducts(bool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOnDepartement method, of class Employee.
     */
    @Test
    public void testSetOnDepartement() {
        System.out.println("setOnDepartement");
        Boolean bool = null;
        Employee instance = null;
        instance.setOnDepartement(bool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeliveryWagonDuty method, of class Employee.
     */
    @Test
    public void testSetDeliveryWagonDuty() {
        System.out.println("setDeliveryWagonDuty");
        Boolean bool = null;
        Employee instance = null;
        instance.setDeliveryWagonDuty(bool);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartement method, of class Employee.
     */
    @Test
    public void testSetDepartement() {
        System.out.println("setDepartement");
        Department department = null;
        Employee instance = null;
        instance.setDepartement(department);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLabel method, of class Employee.
     */
    @Test
    public void testChangeLabel() {
        System.out.println("changeLabel");
        int x = 0;
        int y = 0;
        String text = "";
        Employee instance = null;
        instance.changeLabel(x, y, text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
//        try {
//            deel(3,0);
//            fail();
//        }
//        catch (DivideByZeroException e) {
//            
//        }
//        catch (Exception e) {
//            fail();
//        }
    }
}
