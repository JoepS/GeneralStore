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

    public void CreateEmployee() {
        Employee emp1 = new Employee(true, true, false, false, "Orgrim", "Doomhammer", 12, "Orc", true);
        Employee emp2 = new Employee(true, false, false, false, "Tyrande", "Whisperwind", 348, "Elf", false);
        Employee emp3 = new Employee(true, false, true, false, "Jarod", "Shadowsong", 786, "Elf", true);
        Employee emp4 = new Employee(true, false, true, false, "Garrosh", "Hellscream", 9, "Orc", true);
        Employee emp5 = new Employee(false, true, true, false, "Vol'jin", "son of Sen'jin", 38, "Troll", true);
        Employee emp6 = new Employee(false, true, false, true, "Uther", "the Lightbringer", 23, "Human", false);
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
