/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

/**
 *
 * @author Matthijs
 */
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
}
