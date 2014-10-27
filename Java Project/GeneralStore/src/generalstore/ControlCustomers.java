/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joep
 */
public class ControlCustomers implements Runnable {

    static ArrayList<Customer> list;

    public ControlCustomers(ArrayList<Customer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).update(GeneralStore.pathways);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlCustomers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
