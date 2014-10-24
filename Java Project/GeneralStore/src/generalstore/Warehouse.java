/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Joep
 */
public class Warehouse {

    private static SessionFactory factory;
    private List<Products> Products_warehouse;
    private int maxAmount = 999999;

    public Warehouse() {

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
}
