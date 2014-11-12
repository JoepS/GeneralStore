package generalstore;

//import com.mchange.v2.c3p0.C3P0Registry;
import static generalstore.GeneralStore.display;
import java.awt.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pathway {

    private int id;
    private ArrayList<Products> productsA;
    private Products productA;
    private ArrayList<Products> productsB;
    private Products productB;
    private int maxAmount = 50;

    private int xa, ya;
    private int xb, yb;

    Warehouse w = new Warehouse();

    public Pathway(int id, int xa, int ya, int xb, int yb) {
        this.id = id;
        this.productsA = new ArrayList<>();
        this.productsB = new ArrayList<>();
        this.xa = xa;
        this.ya = ya;
        this.xb = xb;
        this.yb = yb;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void addProductA(Products p) {
        if (productsA.size() < maxAmount) {
            productsA.add(p);
        }
        if(productA == null){
            productA = p;
        }
    }

    public void addProductB(Products p) {
        if (productsB.size() < maxAmount) {
            productsB.add(p);
        }
        if(productB == null){
            productB = p;
        }
    }

    public void addProduct(Products p) {
        if (productsA.isEmpty() && productsB.isEmpty()) {
            productsA.add(p);
        } else if (productsA.isEmpty() && !productsB.isEmpty()) {
            if (productsB.get(0).getProductID() == p.getProductID()) {
                productsB.add(p);
            }
        } else if (productsB.isEmpty() && !productsA.isEmpty()) {
            if (productA.getProductID() == p.getProductID()) {
                productsA.add(p);
            }
        } else {
            if (productA.getProductID() == p.getProductID()) {
                productsA.add(p);
            } else if (productB.getProductID() == p.getProductID()) {
                productsB.add(p);
            }
        }
    }

    public Products getProductA() {
        Products p = new Products(0, "Invalid", 0, 0);
        if (!productsA.isEmpty()) {
            p = productsA.get(productsA.size() - 1);
        }
        return p;
    }

    public Products getProductB() {
        Products p = new Products(0, "Invalid", 0, 0);
        if (!productsB.isEmpty()) {
            p = productsB.get(productsB.size() - 1);
        }
        return p;
    }

    @Override
    public String toString() {
        String s = "" + this.id;

        if (!productsA.isEmpty()) {
            s += " Product 1:" + productA.getProductName() + " aantal: " + productsA.size();
        }
        if (!productsB.isEmpty()) {
            s += " Product 2:" + productB.getProductName() + " aantal: " + productsB.size();
        }

        return s;
    }

    public Products removeProductA() {
        if (isProductAEmpty()) {
            for (int i = 0; i < GeneralStore.employees.size(); i++) {
                if (GeneralStore.employees.get(i).getRefillProducts() == true && GeneralStore.employees.get(i).getAlreadyWorking() == false) {
                    GeneralStore.employees.get(i).refill(this, productA, true);
                    break;
                }
            }
        }
        Products a = null;
        if (productsA.size() - 1 >= 0) {
            a = productsA.get(productsA.size() - 1);
            productsA.remove(productsA.size() - 1);
        }
        changeLabel(this.getXa(), this.getYa() + 1, productsA.size() + "");
        return a;
    }

    public Products removeProductB() {
        if (isProductBEmpty()) {
            for (int i = 0; i < GeneralStore.employees.size(); i++) {
                if (GeneralStore.employees.get(i).getRefillProducts() == true && GeneralStore.employees.get(i).getAlreadyWorking() == false) {
                    GeneralStore.employees.get(i).refill(this, productB, false);
                    break;
                }
            }
        }
        Products b = null;
        if (productsB.size() - 1 >= 0) {
            b = productsB.get(productsB.size() - 1);
            productsB.remove(productsB.size() - 1);
        }
        changeLabel(this.getXb(), this.getYb() - 1, productsB.size() + "");
        return b;
    }

    public int getXa() {
        return xa;
    }

    public int getYa() {
        return ya;
    }

    public int getXb() {
        return xb;
    }

    public int getYb() {
        return yb;
    }

    public Boolean isProductAEmpty() {
        if (productsA.size() <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isProductBEmpty() {
        if (productsB.size() <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public void refillA() {
        //Products a = productsA.get(0);

        System.out.println("Refilling: " + productA.getProductName());

        for (int i = 0; i < maxAmount; i++) {
            productsA.add(productA);
        }
        productA.setProductAmount(productA.getProductAmount() - maxAmount);
        w.updateProduct(productA);
    }

    public void refillB() {
        //Products b = productsB.get(0);

        System.out.println("Refilling: " + productB.getProductName());

        for (int i = 0; i < maxAmount; i++) {
            productsB.add(productB);
        }
        productB.setProductAmount(productB.getProductAmount() - maxAmount);
        w.updateProduct(productB);
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
