/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import static generalstore.GeneralStore.display;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fré-Meine
 */
public class Customer extends Person {

    public List<Products> shoppingCart;
    //List of what the customer wants to buy
    public List<Products> shoppingList;

    double cash;

    boolean updatable = true;

    public Customer(String fName, String lName, int lvl, String race, Boolean gender, int x, int y, double cash) {
        super(fName, lName, lvl, race, gender, x, y);
        shoppingCart = new ArrayList<>();
        shoppingList = new ArrayList<>();
        this.cash = cash;
        createShoppingList(GeneralStore.products);
    }

    public List<Products> getCart() {
        return this.shoppingCart;
    }

    public void setCart(List<Products> newcart) {
        this.shoppingCart = newcart;
    }

    public void addToCart(Products p) {
        this.shoppingCart.add(p);
    }

    public Products removeLast() {
        Products temp = shoppingCart.get(shoppingCart.size() - 1);
        this.shoppingCart.remove(shoppingCart.size() - 1);
        return temp;
    }

    public void createShoppingList(ArrayList<Products> products) {
        Random ran = new Random();
        double totalCash = cash;
        double cashLeft = 0;

        int num = ran.nextInt(14) + 1;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < products.size(); j++) {
                if (cashLeft + products.get(j).getProductPrice() < totalCash) {
                    shoppingList.add(products.get(ran.nextInt(14)));
                    cashLeft += shoppingList.get(shoppingList.size() - 1).getProductPrice();
                }
            }
        }
    }

    @Override
    public String toString() {
        String gender = "Female";
        if (this.getGender()) {
            gender = "Male";
        }
        return this.getFirstName() + " " + this.getLevel() + " " + this.getRace() + " " + gender;
    }

    public synchronized boolean update(ArrayList<Pathway> pathways, ArrayList<Department> departments) {
        if (updatable) {
            for (int i = 0; i < shoppingList.size(); i++) {
                if (!shoppingCart.contains(shoppingList.get(i))) {
                    for (int j = 0; j < pathways.size(); j++) {
                        if (pathways.get(j).getProductA().getProductID() == shoppingList.get(i).getProductID()) {

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            changeLabel(this.getX(), this.getY(), "");
                            this.destination(pathways.get(j).getXa(), pathways.get(j).getYa());
                            changeLabel(this.getX(), this.getY(), this.getFirstName());
                            this.shoppingCart.add(pathways.get(j).removeProductA());
                            break;
                        } else if (pathways.get(j).getProductB().getProductID() == shoppingList.get(i).getProductID()) {

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            changeLabel(this.getX(), this.getY(), "");
                            this.destination(pathways.get(j).getXb(), pathways.get(j).getYb());
                            changeLabel(this.getX(), this.getY(), this.getFirstName());
                            this.shoppingCart.add(pathways.get(j).removeProductB());
                            break;
                        }
                    }
                    for (int j = 0; j < departments.size(); j++) {
                        if (departments.get(j).getProduct().getProductID() == shoppingList.get(i).getProductID()) {

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            changeLabel(this.getX(), this.getY(), "");
                            this.destination(departments.get(j).getX(), departments.get(j).getY());
                            changeLabel(this.getX(), this.getY(), this.getFirstName());
                            this.shoppingCart.add(departments.get(j).removeProduct());
                        }
                    }
                }
            }
            boolean doneshopping = false;

            /*if (shoppingList.size() == shoppingCart.size()) {
             for (int i = 0; i < shoppingList.size() && i < shoppingCart.size(); i++) {
             if (shoppingList.get(i).getProductID() == shoppingCart.get(i).getProductID()) {
             doneshopping = true;
             } else {
             doneshopping = false;
             break;
             }
             }
             }*/
            // if(shoppingCart.size() == shoppingList.size()){
            doneshopping = true;
            //}
            if (doneshopping) {
                System.out.println(this.getFirstName() + "is done shopping");

                changeLabel(this.getX(), this.getY(), "");
                Random r = new Random();
                CashRegister cr = GeneralStore.cashregisters.get(r.nextInt(2));
                this.destination(cr.getX(), cr.getY());
                changeLabel(this.getX(), this.getY(), this.getFirstName());
                cr.goldStorage(cr.calculatePrice(this.shoppingCart));
                System.out.println(cr.toString());
                try {
                    this.finalize();
                } catch (Throwable ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.updatable = false;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }

                changeLabel(this.getX(), this.getY(), "");
                System.out.println("REMOVE" + this.getFirstName());
                GeneralStore.customers.remove(this);
            }
        } else {
            return false;
        }
        return true;
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
