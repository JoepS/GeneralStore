/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import static generalstore.GeneralStore.display;
import java.awt.Component;
import java.util.ArrayList;
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

        for (int i = 0; i < ran.nextInt(15); i++) {
            for (int j = 0; j < products.size(); j++) {
                if (cashLeft + products.get(j).getProductPrice() < totalCash) {
                    shoppingList.add(products.get(ran.nextInt(10)));
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

    public void update(ArrayList<Pathway> pathways) {
        for (int i = 0; i < shoppingList.size(); i++) {
            if (!shoppingCart.contains(shoppingList.get(i))) {
                for (int j = 0; j < pathways.size(); j++) {
                    if (pathways.get(j).getProductA().getProductID() == shoppingList.get(i).getProductID()) {
                        changeLabel(this.getX(), this.getY(), "");
                        this.destination(pathways.get(j).getX(), pathways.get(j).getY());
                        try {
                            Thread.sleep(00);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        changeLabel(this.getX(), this.getY(), this.getFirstName());
                        this.shoppingCart.add(pathways.get(j).removeProductA());
                        this.shoppingList.remove(shoppingList.get(i));
                        return;
                    } else if (pathways.get(j).getProductB().getProductID() == shoppingList.get(i).getProductID()) {
                        changeLabel(this.getX(), this.getY(), "");
                        this.destination(pathways.get(j).getX(), pathways.get(j).getY());
                        try {
                            Thread.sleep(00);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        changeLabel(this.getX(), this.getY(), this.getFirstName());
                        this.shoppingCart.add(pathways.get(j).removeProductB());                        
                        this.shoppingList.remove(shoppingList.get(i));
                        return;
                    }
                }
            }
        }
        System.out.println(this.getFirstName() + "is done shopping");
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
