/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

/**
 *
 * @author Joep
 */
public class GeneralStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreateEmployee();



    }

    static void CreateEmployee() {
        Employee emp1 = new Employee(true, true, false, false, "Orgrim", "Doomhammer", 12, "Orc", true);
        Employee emp2 = new Employee(true, false, false, false, "Tyrande", "Whisperwind", 348, "Elf", false);
        Employee emp3 = new Employee(true, false, true, false, "Jarod", "Shadowsong", 786, "Elf", true);
        Employee emp4 = new Employee(true, false, true, false, "Garrosh", "Hellscream", 9, "Orc", true);
        Employee emp5 = new Employee(false, true, true, false, "Vol'jin", "son of Sen'jin", 38, "Troll", true);
        Employee emp6 = new Employee(false, true, false, true, "Uther", "the Lightbringer", 23, "Human", false);
    }
}
