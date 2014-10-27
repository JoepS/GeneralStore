/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import static generalstore.GeneralStore.display;
import java.awt.Component;
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

    Department department;

    public Employee(boolean cashier, boolean refill, boolean department, boolean wagonUnloader, String fName, String lName, int lvl, String race, Boolean gender, int x, int y) {
        super(fName, lName, lvl, race, gender, x, y);
        this.onCashRegister = cashier;
        this.refillProducts = refill;
        this.onDepartment = department;
        this.deliveryWagonDuty = wagonUnloader;
    }

    public Boolean getOnCashRegister() {
        return this.onCashRegister;
    }

    public Boolean getRefillProducts() {
        return this.refillProducts;
    }

    public Boolean getOnDepartment() {
        return onDepartment;
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

}

/*
 public class Employee extends Person {

 private boolean cashier;
 private boolean refill;
 private boolean department;
 private boolean wagonUnloader;

 public Employee(String fName, String lName, int lvl, String race, Boolean gender) {
 super(fName, lName, lvl, race, gender);
 }

 public Employee(boolean cashier, boolean refill, boolean department, boolean wagonUnloader, String fName, String lName, int lvl, String race, Boolean gender) {
 super(fName, lName, lvl, race, gender);
 this.cashier = cashier;
 this.refill = refill;
 this.department = department;
 this.wagonUnloader = wagonUnloader;
 }

 public void setCashier(boolean cashier) {
 this.cashier = cashier;
 }

 public void setDepartment(boolean department) {
 this.department = department;
 }

 public void setRefill(boolean refill) {
 this.refill = refill;
 }

 public void setWagonUnloader(boolean wagonUnloader) {
 this.wagonUnloader = wagonUnloader;
 }
    
 public Boolean getWagonUnloader(){
 return this.wagonUnloader;
 }

 }*/
