
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.sf.ehcache.util.ProductInfo;

/**
 *
 * @author Joep
 */
public class GeneralStore {

    static ArrayList<Customer> customers;
    static ArrayList<Employee> employees;
    static ArrayList<Products> products;
    static ArrayList<Department> departments;
    static ArrayList<Pathway> pathways;
    static ArrayList<Warehouse> warehouse;
    static ArrayList<CashRegister> casregisters;

    static Display display;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        display = new Display();
        display.makeFrame();

        customers = new ArrayList<>();
        employees = new ArrayList<>();
        products = new ArrayList<>();
        departments = new ArrayList<>();
        pathways = new ArrayList<>();
        warehouse = new ArrayList<>();

        casregisters = new ArrayList<>();
        GeneralStore gs = new GeneralStore(); 
        gs.Createproduct();
        gs.createCashRegister();
        gs.createWareHouse();

        
        
        gs.CreateEmployee();
        gs.createPatways();
        gs.createDepartements();
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
        
        Thread t = new Thread(new ControlCustomers(customers));
        t.start();

        Random rand1 = new Random();
        while (true) {
            randomName = words.get(rand1.nextInt(words.size() - 1));
            Customer cst = new Customer(randomName, "", rand1.nextInt(1000), races.get(rand1.nextInt(races.size() - 1)), rand1.nextBoolean(), 12, 1, rand1.nextInt(200 - 50) + 50);
            if (customers.size() < 1000) {
                customers.add(cst);
                //System.out.println(customers.size() + " " + cst.toString());
                changeLabel(cst.getX(), cst.getY(), cst.getFirstName());
            }
            try {
                Thread.sleep(rand1.nextInt(500 - 100) + 100);
            } catch (InterruptedException ex) {
                //Logger.getLogger(GeneralStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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

    static void CreateEmployee() {
        Employee emp1 = new Employee(true, true, false, false, "Orgrim", "Doomhammer", 12, "Orc", true, 0, 0);
        employees.add(emp1);
        Employee emp2 = new Employee(true, false, false, false, "Tyrande", "Whisperwind", 348, "Elf", false, 0, 0);
        employees.add(emp2);
        Employee emp3 = new Employee(true, false, true, false, "Jarod", "Shadowsong", 786, "Elf", true, 0, 0);
        employees.add(emp3);
        Employee emp4 = new Employee(true, false, true, false, "Garrosh", "Hellscream", 9, "Orc", true, 0, 0);
        employees.add(emp4);
        Employee emp5 = new Employee(false, true, true, false, "Vol'jin", "son of Sen'jin", 38, "Troll", true, 0, 0);
        employees.add(emp5);
        Employee emp6 = new Employee(false, true, false, true, "Uther", "the Lightbringer", 23, "Human", false, 0, 0);
        employees.add(emp6);
    }

    static void Createproduct() {
        //Elixir
        Products prd1 = new Products("Elixir of Healing", 3.00, 0);
        products.add(prd1);
        //Backpack
        Products prd2 = new Products("Bottomless Backpack", 34.00, 0);
        products.add(prd2);
        //Gear
        Products prd3 = new Products("Copper Chain Vest", 8.00, 0);
        products.add(prd3);
        //Weapons
        Products prd4 = new Products("Thori'dal, the Stars' Fury", 2.00, 0);
        products.add(prd4);
        Products prd5 = new Products("Thunderfury, Blessed Blade of the Windseeker", 1.00, 0);
        products.add(prd5);
        Products prd6 = new Products("Shadowmourne", 34.00, 0);
        products.add(prd6);
        //Alcohol
        Products prd7 = new Products("Banana Infused Rum", 5.00, 0);
        products.add(prd7);
        Products prd8 = new Products("Keg of Beer", 22.00, 0);
        products.add(prd8);
        //Food
        Products prd9 = new Products("Chun Tian Spring Rolls", 4.00, 0);
        products.add(prd9);
        //Mount
        Products prd10 = new Products("Domesticated Razorback", 51.00, 0);
        products.add(prd10);
        
        Products prd11 = new Products("Elixir of Mana", 4.00, 11);
        products.add(prd11);
        
        Products prd12 = new Products("Argent Warhorse", 25.00, 12);
        products.add(prd12);
        
        Products prd13 = new Products("Spice bread", 2.00, 13);
        products.add(prd13);
        
        Products prd14 = new Products("Primal Gladiator's Longbow", 20.00, 14);
        products.add(prd14);
        
        Products prd15 = new Products("Pauldrons of Guiding Light", 15.00, 15);
        products.add(prd15);
        
    }

    public void createPatways() {
        //for (int i = 0; i < 1; i++) {
            Pathway p = new Pathway(0, 12, 7);
            //Random r = new Random();
            //int productA = r.nextInt(products.size());
            //int productB = r.nextInt(products.size());
            for (int x = 0; x < p.getMaxAmount(); x++) {
                p.addProductA(products.get(6)); //p.addProductA(products.get(productA));
                p.addProductB(products.get(7));//       p.addProductB(products.get(productB));
            }
            System.out.println(p.toString());
            pathways.add(p);
            
            p = new Pathway(0, 8, 7);
            //Random r = new Random();
            //int productA = r.nextInt(products.size());
            //int productB = r.nextInt(products.size());
            for (int x = 0; x < p.getMaxAmount(); x++) {
                p.addProductA(products.get(3)); //p.addProductA(products.get(productA));
                p.addProductB(products.get(4));//       p.addProductB(products.get(productB));
            }
            System.out.println(p.toString());
            pathways.add(p);
            
            p = new Pathway(0, 4, 7);
            //Random r = new Random();
            //int productA = r.nextInt(products.size());
            //int productB = r.nextInt(products.size());
            for (int x = 0; x < p.getMaxAmount(); x++) {
                p.addProductA(products.get(0)); //p.addProductA(products.get(productA));
                p.addProductB(products.get(1));//       p.addProductB(products.get(productB));
            }
            System.out.println(p.toString());
            pathways.add(p);
            
             p = new Pathway(0, 16, 7);
            //Random r = new Random();
            //int productA = r.nextInt(products.size());
            //int productB = r.nextInt(products.size());
            for (int x = 0; x < p.getMaxAmount(); x++) {
                p.addProductA(products.get(2)); //p.addProductA(products.get(productA));
                p.addProductB(products.get(5));//       p.addProductB(products.get(productB));
            }
            System.out.println(p.toString());
            pathways.add(p);
            
             p = new Pathway(0, 20, 7);
            //Random r = new Random();
            //int productA = r.nextInt(products.size());
            //int productB = r.nextInt(products.size());
            for (int x = 0; x < p.getMaxAmount(); x++) {
                p.addProductA(products.get(8)); //p.addProductA(products.get(productA));
                p.addProductB(products.get(9));//       p.addProductB(products.get(productB));
            }
            System.out.println(p.toString());
            pathways.add(p);
            
            
       // }
    }

    public void createDepartements() {
        for (int i = 0; i < 5; i++) {
            Department d = new Department(i);
            for (int x = 0; x < d.getMaxAmount(); x++) {
                d.setCurrentEmployee(new Employee(false, true, false, true, "Uther", "the Lightbringer", 23, "Human", false, 0, 0));
                d.addProduct(new Products("Domesticated Razorback", 51.00, 10));
            }
            System.out.println(d.toString());
            departments.add(d);

        }
    }
    
    public void createCashRegister(){
        CashRegister c = new CashRegister(0, true, 16, 1);
        casregisters.add(c);
        c = new CashRegister(0, true, 18, 1);
        casregisters.add(c);        
        c = new CashRegister(0, true, 20, 1);
        casregisters.add(c);
    }

    public void createWareHouse() {
        Warehouse w = new Warehouse();
        w.createFactory();
        for (int i = 0; i < products.size(); i++) {
            
            for (int j = 0; j < w.getMaxAmount(); j++) {
                w.addProduct(products.get(i));
            }
            warehouse.add(w);
            System.out.println(warehouse.get(i));
        }
        w.addProducts();
    }
}
