/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.util.ArrayList;
import org.hibernate.SessionFactory;

/**
 *
 * @author Joep
 */
public class Warehouse {

    private static SessionFactory factory;
    private ArrayList<Products> Products_warehouse;
    private int maxAmount = 999999;

    public Warehouse() {
           Products_warehouse = new ArrayList<>();
    }

    public void addProduct(Products p) {
        Products_warehouse.add(p);
    }

    public int getMaxAmount() {
        return maxAmount;
    }
    
    
    
    
    
    //Create database session
//    public void createSession() {
//
//        Session session = factory.openSession();
//        Transaction tx = session.beginTransaction();
//        MyClass myObject = (MyClass) session.load(MyClass.class,
//                new Long(1));
//        myObject.setText("Changed Text");
//        MyClass myNewObject = new MyClass(
//        “new”, 42.4);
//        myObject.setNext(myNewObject);
//        tx.commit();
//        session.close();
//
//    }

    @Override
    public String toString() {
        String s = "";
        if(!Products_warehouse.isEmpty()){
            s += " Warehouse Products: " + Products_warehouse.get(0).getProductName() + " aantal: " + Products_warehouse.size();
        }
        return s;
    }
}
