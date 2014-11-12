package generalstore;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hold count of all the products and updates the datebase if needs be
 * @author Skrylax
 */
public class Warehouse {

    private static SessionFactory factory;
    private ArrayList<Products> Products_warehouse;

    public Warehouse() {
        Products_warehouse = new ArrayList<>();
    }

    public void addProduct(Products p) {
        Products_warehouse.add(p);
    }

    public void createFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            factory = configuration.buildSessionFactory(builder.build());
            //factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /* Method to CREATE a product in the database */
    public Integer addProducts() {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer productID = null;
        try {
            tx = session.beginTransaction();

            for (Products product : Products_warehouse) {
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
    
    public void updateProduct(Products p) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.update(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
   
    @Override
    public String toString() {
        String s = "";
        if (!Products_warehouse.isEmpty()) {
            s += " Warehouse Products: " + Products_warehouse.get(0).getProductName() + " aantal: " + Products_warehouse.size();
        }
        return s;
    }
}
