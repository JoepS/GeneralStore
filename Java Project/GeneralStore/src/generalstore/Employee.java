/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import static generalstore.GeneralStore.display;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthijs
 */
public class Employee extends Person {

    private Boolean onCashRegister;
    private Boolean refillProducts;
    private Boolean onDepartment;
    private Boolean deliveryWagonDuty;
    private Boolean alreadyWorking;

    Department department;

    private Products refillProduct;

    public Employee(boolean cashier, boolean refill, boolean department, boolean wagonUnloader, String fName, String lName, int lvl, String race, Boolean gender, int x, int y, boolean working) {
        super(fName, lName, lvl, race, gender, x, y);
        this.onCashRegister = cashier;
        this.refillProducts = refill;
        this.onDepartment = department;
        this.deliveryWagonDuty = wagonUnloader;
        this.alreadyWorking = working;
    }

    public void setAlreadyWorking(Boolean alreadyWorking) {
        this.alreadyWorking = alreadyWorking;
    }

    public Boolean getAlreadyWorking() {
        return this.alreadyWorking;
    }

    public Boolean getOnCashRegister() {
        return this.onCashRegister;
    }

    public Boolean getRefillProducts() {
        return this.refillProducts;
    }

    public Boolean getOnDepartement() {
        return this.onDepartment;

    }

    public Boolean getDeliveryWagonDuty() {
        return deliveryWagonDuty;
    }

    public Department getDepartment() {
        if (onDepartment) {
            return department;
        } else {
            return null;
        }
    }

    public void setOnCashRegister(Boolean bool) {
        this.onCashRegister = bool;
    }

    public void setRefillProducts(Boolean bool) {
        this.refillProducts = bool;
    }

    public void setOnDepartement(Boolean bool) {
        this.onDepartment = bool;
    }

    public void setDeliveryWagonDuty(Boolean bool) {
        this.deliveryWagonDuty = bool;
    }

    public void setDepartement(Department department) {
        this.department = department;
    }

    public void changeLabel(int x, int y, String text) {
        Component[] comp = display.getFrame().getContentPane().getComponents();
        JPanel panel = (JPanel) comp[0];
        comp = panel.getComponents();
        for (int i = 0; i < comp.length; i++) {
            if (comp[i].getName().equals(x + "," + y)) {
                JLabel l = (JLabel) comp[i];
                l.setText(text);
            }
        }
    }

    public Products getRefillProduct() {
        return refillProduct;
    }

    public void refill(Pathway pathway, Products product) {

        Warehouse w = new Warehouse();

        if (pathway.getProductA().equals(product)) {
            this.setAlreadyWorking(true);
            changeLabel(pathway.getXa() + 1, pathway.getYa(), this.getFirstName());
            pathway.refillA();
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            changeLabel(pathway.getXa() + 1, pathway.getYa(), "");
            this.setAlreadyWorking(false);
        } else if (pathway.getProductB().equals(product)) {
            this.setAlreadyWorking(true);
            changeLabel(pathway.getXb() + 1, pathway.getYb(), this.getFirstName());
            pathway.refillB();
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            changeLabel(pathway.getXb() + 1, pathway.getYb(), "");
            this.setAlreadyWorking(false);
        } else {
            System.out.println("Oeps er is iets verkeerd gegaan");
        }

    }

}
