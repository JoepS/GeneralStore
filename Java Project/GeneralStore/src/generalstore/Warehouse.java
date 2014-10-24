/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

    /* Method to CREATE a product in the database */
    public Integer addProducts() {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer productID = null;
        try {
            tx = session.beginTransaction();
            
            for(Products product : Products_warehouse){
                session.save(product);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return productID;
    }
    /* Method to  READ all the employees */

//    public void listEmployees() {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            List employees = session.createQuery("FROM Employee").list();
//            for (Iterator iterator
//                    = employees.iterator(); iterator.hasNext();) {
//                Employee employee = (Employee) iterator.next();
//                System.out.print("First Name: " + employee.getFirstName());
//                System.out.print("  Last Name: " + employee.getLastName());
//                System.out.println("  Salary: " + employee.getSalary());
//            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//    /* Method to UPDATE salary for an employee */
//
//    public void updateEmployee(Integer EmployeeID, int salary) {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            Employee employee
//                    = (Employee) session.get(Employee.class, EmployeeID);
//            employee.setSalary(salary);
//            session.update(employee);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
//    /* Method to DELETE an employee from the records */
//
//    public void deleteEmployee(Integer EmployeeID) {
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            Employee employee
//                    = (Employee) session.get(Employee.class, EmployeeID);
//            session.delete(employee);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }

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
        if (!Products_warehouse.isEmpty()) {
            s += " Warehouse Products: " + Products_warehouse.get(0).getProductName() + " aantal: " + Products_warehouse.size();
        }
        return s;
    }
}
