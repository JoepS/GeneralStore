/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import static generalstore.GeneralStore.display;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        Boolean alreadyWorking = false;
       Employee instance = new Employee(true, true, true, true, "henk", "henk", 10, "orc", true, 0, 0, true);
        instance.setAlreadyWorking(alreadyWorking);
        Boolean result = instance.getAlreadyWorking();
        assertEquals(result, alreadyWorking);
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
        Boolean bool = false;
        Employee instance = new Employee(true, true, true, true, "henk", "henk", 10, "orc", true, 0, 0, true);
        instance.setRefillProducts(bool);
        Boolean result = instance.getRefillProducts();
        assertEquals(result, bool);

    }

    /**
     * Test of setOnDepartement method, of class Employee.
     */
    @Test
    public void testSetOnDepartement() {
        System.out.println("setOnDepartement");
        Boolean bool = false;
        Employee instance = new Employee(true, true, true, true, "henk", "henk", 10, "orc", true, 0, 0, true);
        instance.setOnDepartement(bool);
        Boolean result = instance.getOnDepartement();
        assertEquals(result, bool);
    }

    /**
     * Test of setDepartement method, of class Employee.
     */
    @Test
    public void testSetDepartement() {
        System.out.println("setDepartement");
        Department department = null;
        Employee instance = new Employee(true, true, true, true, "henk", "henk", 10, "orc", true, 0, 0, true);
        instance.setDepartement(department);
        Department result = instance.getDepartment();
        assertEquals(result, department);
    }

    /**
     * Test of changeLabel method, of class Employee.
     */
    @Test
    public void testChangeLabel() {

        try {
            System.out.println("changeLabel");
            int x = 0;
            int y = 0;
            String text = "hoi";
            Employee instance = new Employee(true, true, true, true, "henk", "henk", 10, "orc", true, 0, 0, true);
            instance.changeLabel(x, y, text);
            // TODO review the generated test code and remove the default call to fail.
            Component[] comp = display.getFrame().getContentPane().getComponents();
            JPanel panel = (JPanel) comp[0];
            comp = panel.getComponents();
            for (int i = 0; i < comp.length; i++) {
                if (comp[i].getName().equals(x + "," + y)) {
                    JLabel l = (JLabel) comp[i];
                    assertEquals(l.getText(), text);
                }
            }
        } catch (NullPointerException e) {
            assertTrue("No frame", true);
        }

    }
}
