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
<<<<<<< HEAD
=======
    private static SessionFactory factory; 
>>>>>>> 0529121c880deb0997ec373c3fe840cb3807fb07
    private List<Products> Products_warehouse;

    public Warehouse() {
    }
<<<<<<< HEAD
    
    
    
    
    
    
    
=======

    //Create database session
<<<<<<< HEAD
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
=======
    public void createSession() {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        MyClass myObject = (MyClass) session.load(MyClass.class,
                new Long(1));
        myObject.setText("Changed Text");
        MyClass myNewObject = new MyClass(
        “new”, 42.4);
myObject.setNext(myNewObject);
        tx.commit();
        session.close();

    }
>>>>>>> 0529121c880deb0997ec373c3fe840cb3807fb07
>>>>>>> origin/master
}
