package generalstore;

import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlCustomers implements Runnable {

    private static Customer c;

    public ControlCustomers(Customer c) {
        this.c = c;
    }

    @Override
    public void run() {
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
