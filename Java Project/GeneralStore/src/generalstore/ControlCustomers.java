package generalstore;

//Deze class word aan een customer thread gegeven en zorgt ervoor dat de customer geupdate word.
public class ControlCustomers implements Runnable {

    private static Customer c;

    public ControlCustomers(Customer c) {
        this.c = c;
    }
    /***
     * De run methode is de methode die uitgevoerd word bij het start commando.
     * Als de customer geupdate word geeft de methode een true of een false terug.
     * Als de customer klaar is, hij heeft dan dus afgerekent bij de kassa, dan gaat de while loop niet verder en stopt de thread.
     */
    @Override
    public void run() {
        boolean going = true;
        while (going) {
            going = c.update(GeneralStore.pathways, GeneralStore.departments);
        }
    }
}
