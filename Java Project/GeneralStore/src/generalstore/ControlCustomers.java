/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joep
 */
public class ControlCustomers implements Runnable {

    //static ArrayList<Customer> list;
    private static Customer c;

    public ControlCustomers(Customer c) {//ArrayList<Customer> list) {
        //this.list = list;

        this.c = c;
    }

    @Override
    public void run() {
        /*while (true) {
         for (int i = 0; i < list.size(); i++) {
         Customer c = list.get(i);
         Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
         Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
         boolean cango = true;
         for (int j = 0; j < threadArray.length; j++) {
         if (threadArray[i].getName().contains(c.getFirstName())) {
         cango = false;
         }
         }
         if (cango) {
         Thread t = new Thread(new customerThread(c), c.getFirstName());
         t.setName(c.getFirstName());
         t.start();
         }

         }
         //            try {
         //                Thread.sleep(1000);
         //            } catch (InterruptedException ex) {
         //                Logger.getLogger(ControlCustomers.class.getName()).log(Level.SEVERE, null, ex);
         //            }
         */
        boolean going = true;
        while (going) {
            going = c.update(GeneralStore.pathways, GeneralStore.departments);
        }
    }
}

class customerThread implements Runnable {

    private Customer c;

    public customerThread(Customer c) {
        this.c = c;
    }

    @Override
    public void run() {
        boolean going = true;
        while (going) {
            //going = c.update(GeneralStore.pathways, GeneralStore.departments);
        }
    }

}
