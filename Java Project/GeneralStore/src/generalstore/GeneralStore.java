/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    static void CreateCustomer(String name) {
        List<String> races = new ArrayList();
        races.add("Orc");
        races.add("Elf");
        races.add("Human");
        races.add("Troll");
        String randomName = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Words.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<String>();
            while (line != null) {
                String[] wordsLine = line.split(" ");
                for (String word : wordsLine) {
                    words.add(word);
                }
                line = reader.readLine();
            }

            Random rand = new Random(words.size());
            randomName = words.get(rand.nextInt(words.size()));

        } catch (Exception e) {
            // Handle this
        }
        Random rand1 = new Random();

        Customer cst = new Customer(randomName, "", rand1.nextInt(100), races.get(i), rand1.nextBoolean());

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
