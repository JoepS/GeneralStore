
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
    static ArrayList<Products> products;
    static ArrayList<Employee> employees;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        customers = new ArrayList<>();
        products = new ArrayList<>();
        employees = new ArrayList<>();

        GeneralStore gs = new GeneralStore();
        gs.CreateEmployee();
        gs.makePathways();
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
            Customer cst = new Customer(randomName, "", rand1.nextInt(1000), races.get(rand1.nextInt(races.size() - 1)), rand1.nextBoolean(), rand1.nextInt(200 - 50) + 50);
            cst.createShoppingList(products);
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
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);
    }

    static void Createproduct() {
        //Elixir
        Products prd1 = new Products("Elixir of Healing", 3.00, 1);
        //Backpack
        Products prd2 = new Products("Bottomless Backpack", 34.00, 2);
        //Gear
        Products prd3 = new Products("Copper Chain Vest", 8.00, 3);
        //Weapons
        Products prd4 = new Products("Thori'dal, the Stars' Fury", 2.00, 4);
        Products prd5 = new Products("Thunderfury, Blessed Blade of the Windseeker", 1.00, 5);
        Products prd6 = new Products("Shadowmourne", 34.00, 6);
        //Alcohol
        Products prd7 = new Products("Banana Infused Rum", 5.00, 7);
        Products prd8 = new Products("Keg of Beer", 22.00, 8);
        //Food
        Products prd9 = new Products("Chun Tian Spring Rolls", 4.00, 9);
        //Mount
        Products prd10 = new Products("Domesticated Razorback", 51.00, 10);
        products.add(prd1);
        products.add(prd2);
        products.add(prd3);
        products.add(prd4);
        products.add(prd5);
        products.add(prd6);
        products.add(prd7);
        products.add(prd8);
        products.add(prd9);
        products.add(prd10);

    }

    public void makePathways() {
        for (int i = 0; i < 5; i++) {
            Pathway p = new Pathway(i);
            for (int x = 0; x < p.getMaxAmount(); x++) {
                p.addProduct(new Products("Banana Infused Rum", 5.00, 7));
                p.addProduct(new Products("Keg of Beer", 22.00, 8));
            }
            System.out.println(p.toString());
        }
    }
}
