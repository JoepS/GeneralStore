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
    
    static ArrayList<Customer> customers;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        customers = new ArrayList<>();
        GeneralStore gs = new GeneralStore();
        gs.CreateEmployee();
        gs.CreateCustomer();

    }

    public void CreateCustomer() {
        List<String> races = new ArrayList();
        races.add("Orc");
        races.add("Elf");
        races.add("Human");
        races.add("Troll");
        String randomName = null;
        List<String> words = new ArrayList<String>();
        try {
            
             BufferedReader reader = new BufferedReader(new FileReader("src/name.txt")); //"/com/generalstore/name.txt"
             String line = reader.readLine();
             while (line != null) {
             String[] wordsLine = line.split(" ");
             for (String word : wordsLine) {
             words.add(word);
             }
             line = reader.readLine();
             } 

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        Random rand1 = new Random();
        while (true) {
            randomName = words.get(rand1.nextInt(words.size() - 1));
            Customer cst = new Customer(randomName, "", rand1.nextInt(1000), races.get(rand1.nextInt(races.size() - 1)), rand1.nextBoolean());
            customers.add(cst);
            System.out.println(cst.toString());
            try {
                Thread.sleep(rand1.nextInt(5000 - 1000) + 1000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(GeneralStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
