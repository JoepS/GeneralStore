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
    static ArrayList<CashRegister> cashregisters;

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

        cashregisters = new ArrayList<>();
        GeneralStore gs = new GeneralStore();
        Database db = new Database();
        Warehouse w = new Warehouse();

        db.createDatabase();
        gs.createProduct();
        gs.createWareHouse();
        w.createFactory();

        gs.createEmployee();

        gs.createPathways();
        gs.createDepartements();
        gs.createCashRegister();
        gs.createCustomer();

    }

    public void createCustomer() {
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

        //Thread t = new Thread(new ControlCustomers(customers));
        //t.start();
        Random rand1 = new Random();
        changeLabel(1, 26, "Customers:");
        while (true) {
            randomName = words.get(rand1.nextInt(words.size() - 1));
            Customer cst = new Customer(randomName, "", rand1.nextInt(1000), races.get(rand1.nextInt(races.size() - 1)), rand1.nextBoolean(), 12, 1, rand1.nextInt(200 - 50) + 50);
            if (customers.size() < 1000) {
                customers.add(cst);
                //System.out.println(customers.size() + " " + cst.toString());
                changeLabel(cst.getX(), cst.getY(), cst.getFirstName());
                               
                Thread t = new Thread(new ControlCustomers(cst), cst.getFirstName());
                t.start();
                changeLabel(2, 26, "" + customers.size());
                addEmployeeToCashRegister();
                showEmployees();
                updateMoneys();
            }
            try {
                Thread.sleep(rand1.nextInt(2500));
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

    static void createEmployee() {
        Employee emp = new Employee(true, true, false, false, "Orgrim", "Doomhammer", 12, "Orc", true, 0, 0, false);
        employees.add(emp);
        emp = new Employee(true, false, false, false, "Tyrande", "Whisperwind", 348, "Elf", false, 0, 0, false);
        employees.add(emp);
        emp = new Employee(true, false, false, false, "Jarod", "Shadowsong", 786, "Elf", true, 0, 0, false);
        employees.add(emp);
        emp = new Employee(false, false, true, false, "Garrosh", "Hellscream", 9, "Orc", true, 0, 0, false);
        employees.add(emp);
        emp = new Employee(false, true, true, false, "Vol'jin", "son of Sen'jin", 38, "Troll", true, 0, 0, false);
        employees.add(emp);
        emp = new Employee(false, true, true, true, "Uther", "the Lightbringer", 23, "Human", false, 0, 0, false);
        employees.add(emp);
        emp = new Employee(true, true, false, true, "Headless", "Horseman", 298, "Orc", false, 0, 0, false);
        employees.add(emp);
        emp = new Employee(false, true, false, false, "Fre", "Botter", 0, "Orc", false, 0, 0, false);
        employees.add(emp);
        emp = new Employee(false, true, false, false, "Matthijs", "Hovestad", 20, "Troll", true, 0, 0, false);
        employees.add(emp);
        emp = new Employee(false, true, false, false, "Joep", "Sijtsma", 20, "Human", true, 0, 0, false);
        employees.add(emp);
    }

    static void createProduct() {
        int max = 5000;

        //Elixir
        Products prd1 = new Products(0, "Elixir of Healing", 3.00, max);
        products.add(prd1);
        //Backpack
        Products prd2 = new Products(0, "Bottomless Backpack", 34.00, max);
        products.add(prd2);
        //Gear
        Products prd3 = new Products(0, "Copper Chain Vest", 8.00, max);
        products.add(prd3);
        //Weapons
        Products prd4 = new Products(0, "Thori'dal, the Stars' Fury", 2.00, max);
        products.add(prd4);
        Products prd5 = new Products(0, "Thunderfury, Blessed Blade of the Windseeker", 1.00, max);
        products.add(prd5);
        Products prd6 = new Products(0, "Shadowmourne", 34.00, max);
        products.add(prd6);
        //Alcohol
        Products prd7 = new Products(0, "Banana Infused Rum", 5.00, max);
        products.add(prd7);
        Products prd8 = new Products(0, "Keg of Beer", 22.00, max);
        products.add(prd8);
        //Food
        Products prd9 = new Products(0, "Chun Tian Spring Rolls", 4.00, max);
        products.add(prd9);
        //Mount
        Products prd10 = new Products(0, "Domesticated Razorback", 51.00, max);
        products.add(prd10);

        Products prd11 = new Products(0, "Elixir of Mana", 4.00, max);
        products.add(prd11);

        Products prd12 = new Products(0, "Argent Warhorse", 25.00, max);
        products.add(prd12);

        Products prd13 = new Products(0, "Spice bread", 2.00, max);
        products.add(prd13);

        Products prd14 = new Products(0, "Primal Gladiator's Longbow", 20.00, max);
        products.add(prd14);

        Products prd15 = new Products(0, "Pauldrons of Guiding Light", 15.00, max);
        products.add(prd15);

    }

    public void createPathways() {
        //for (int i = 0; i < 1; i++) {
        Pathway p = new Pathway(0, 12, 7, 12, 22);
        //Random r = new Random();
        //int productA = r.nextInt(products.size());
        //int productB = r.nextInt(products.size());
        for (int x = 0; x < p.getMaxAmount(); x++) {
            p.addProductA(products.get(6)); //p.addProductA(products.get(productA));
            p.addProductB(products.get(7));//       p.addProductB(products.get(productB));
        }
        System.out.println(p.toString());
        pathways.add(p);

        p = new Pathway(0, 8, 7, 8, 22);
        //Random r = new Random();
        //int productA = r.nextInt(products.size());
        //int productB = r.nextInt(products.size());
        for (int x = 0; x < p.getMaxAmount(); x++) {
            p.addProductA(products.get(3)); //p.addProductA(products.get(productA));
            p.addProductB(products.get(4));//       p.addProductB(products.get(productB));
        }
        System.out.println(p.toString());
        pathways.add(p);

        p = new Pathway(0, 4, 7, 4, 22);
        //Random r = new Random();
        //int productA = r.nextInt(products.size());
        //int productB = r.nextInt(products.size());
        for (int x = 0; x < p.getMaxAmount(); x++) {
            p.addProductA(products.get(0)); //p.addProductA(products.get(productA));
            p.addProductB(products.get(1));//       p.addProductB(products.get(productB));
        }
        System.out.println(p.toString());
        pathways.add(p);

        p = new Pathway(0, 16, 7, 16, 22);
        //Random r = new Random();
        //int productA = r.nextInt(products.size());
        //int productB = r.nextInt(products.size());
        for (int x = 0; x < p.getMaxAmount(); x++) {
            p.addProductA(products.get(2)); //p.addProductA(products.get(productA));
            p.addProductB(products.get(5));//       p.addProductB(products.get(productB));
        }
        System.out.println(p.toString());
        pathways.add(p);

        p = new Pathway(0, 20, 7, 20, 22);
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
        Department d = new Department(0, 3, 6);
        departments.add(d);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getAlreadyWorking() == false) {
                if (employees.get(i).getOnDepartement() == true) {
                    employees.get(i).setAlreadyWorking(true);
                    d.setCurrentEmployee(employees.get(i));
                    changeLabel(d.getX(), d.getY() - 1, employees.get(i).getFirstName());
                    break;
                }

            }
        }
        for (int x = 0; x < d.getMaxAmount(); x++) {
            d.addProduct(products.get(10));
        }
        System.out.println(d.toString());

        d = new Department(1, 12, 18);
        departments.add(d);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getAlreadyWorking() == false) {
                if (employees.get(i).getOnDepartement() == true) {
                    employees.get(i).setAlreadyWorking(true);
                    d.setCurrentEmployee(employees.get(i));
                    changeLabel(d.getX(), d.getY() - 1, employees.get(i).getFirstName());
                    break;

                }
            }
        }
        for (int x = 0; x < d.getMaxAmount(); x++) {
            d.addProduct(products.get(11));
        }
        System.out.println(d.toString());

        d = new Department(2, 15, 3);
        departments.add(d);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getAlreadyWorking() == false) {
                if (employees.get(i).getOnDepartement() == true) {
                    employees.get(i).setAlreadyWorking(true);
                    d.setCurrentEmployee(employees.get(i));
                    changeLabel(d.getX(), d.getY() + 1, employees.get(i).getFirstName());
                    break;
                }
            }
        }
        for (int x = 0; x < d.getMaxAmount(); x++) {
            d.addProduct(products.get(12));
        }
        System.out.println(d.toString());
    }

    public void createCashRegister() {
        CashRegister c = new CashRegister(0, true, 16, 1);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getAlreadyWorking() == false) {
                if (employees.get(i).getOnCashRegister() == true) {
                    c.setCurrentEmployee(employees.get(i));
                    employees.get(i).setAlreadyWorking(true);
                    changeLabel(c.getX() + 1, c.getY(), employees.get(i).getFirstName());
                    break;
                }
            }
        }
        cashregisters.add(c);

        c = new CashRegister(1, true, 18, 1);
        cashregisters.add(c);

        c = new CashRegister(2, true, 20, 1);
        cashregisters.add(c);

        c = new CashRegister(2, true, 22, 1);
        cashregisters.add(c);
    }

    public void addEmployeeToCashRegister() {

        if (customers.size() >= 10 && cashregisters.get(1).getCurrentEmployee() == null) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getAlreadyWorking() == false) {
                    if (employees.get(i).getOnCashRegister() == true) {
                        cashregisters.get(1).setCurrentEmployee(employees.get(i));
                        employees.get(i).setAlreadyWorking(true);
                        changeLabel(cashregisters.get(1).getX() + 1, cashregisters.get(1).getY(), employees.get(i).getFirstName());
                        break;
                    }
                }
            }
        } else if (customers.size() < 10 && cashregisters.get(1).getCurrentEmployee() != null) {
            changeLabel(cashregisters.get(1).getX() + 1, cashregisters.get(1).getY(), "");
            cashregisters.get(1).getCurrentEmployee().setAlreadyWorking(false);
            cashregisters.get(1).setCurrentEmployee(null);
        }

        if (customers.size() >= 15 && cashregisters.get(2).getCurrentEmployee() == null) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getAlreadyWorking() == false) {
                    if (employees.get(i).getOnCashRegister() == true) {
                        cashregisters.get(2).setCurrentEmployee(employees.get(i));
                        employees.get(i).setAlreadyWorking(true);
                        changeLabel(cashregisters.get(2).getX() + 1, cashregisters.get(2).getY(), employees.get(i).getFirstName());
                        break;
                    }
                }
            }
        } else if (customers.size() < 15 && cashregisters.get(2).getCurrentEmployee() != null) {
            changeLabel(cashregisters.get(2).getX() + 1, cashregisters.get(2).getY(), "");
            cashregisters.get(2).getCurrentEmployee().setAlreadyWorking(false);
            cashregisters.get(2).setCurrentEmployee(null);
        }

        if (customers.size() >= 20 && cashregisters.get(3).getCurrentEmployee() == null) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getAlreadyWorking() == false) {
                    if (employees.get(i).getOnCashRegister() == true) {
                        cashregisters.get(3).setCurrentEmployee(employees.get(i));
                        employees.get(i).setAlreadyWorking(true);
                        changeLabel(cashregisters.get(3).getX() + 1, cashregisters.get(3).getY(), employees.get(i).getFirstName());
                        break;
                    }
                }
            }
        } else if (customers.size() < 20 && cashregisters.get(3).getCurrentEmployee() != null) {
            changeLabel(cashregisters.get(3).getX() + 1, cashregisters.get(3).getY(), "");
            cashregisters.get(3).getCurrentEmployee().setAlreadyWorking(false);
            cashregisters.get(3).setCurrentEmployee(null);
        }
    }

    public void createWareHouse() {
        Warehouse w = new Warehouse();
        w.createFactory();
        for (int i = 0; i < products.size(); i++) {

            for (int j = 0; j < 1; j++) {
                w.addProduct(products.get(i));
            }
            warehouse.add(w);
        }
        w.addProducts();
    }
    
    public void showEmployees(){
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getAlreadyWorking() == false){
                changeLabel(i, 1, employees.get(i).getFirstName());
            }
            else{
                changeLabel(i, 1, "");
            }
        }
    }
    
    public void updateMoneys(){
        double money = 0;
        for (int i = 0; i < cashregisters.size(); i++) {
            money += cashregisters.get(i).getGoldStorage();
        }        
        changeLabel(7, 26, "Gold:");
        String k = "";
        if(money >= 1000){
            money = money / 1000;
            money = Math.round(money);
            k = "k";
        }
        changeLabel(8, 26, money + k);
    }
}
