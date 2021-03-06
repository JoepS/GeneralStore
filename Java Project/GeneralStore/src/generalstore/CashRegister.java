package generalstore;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {

    private double goldStorage;
    private boolean checkoutEmployee;
    private List<Products> ShoppingCart;
    private int x, y;
    private Employee currentEmployee;

    //waiting list for the CashRegister
    public ArrayList<Person> waitingListCash;

    public ArrayList<Person> getWaitingListCash() {
        return waitingListCash;
    }

    public void setWaitingListCash(ArrayList<Person> waitingListCash) {
        this.waitingListCash = waitingListCash;
    }

    public double getGoldStorage() {
        return goldStorage;
    }

    public void setGoldStorage(double goldStorage) {
        this.goldStorage = goldStorage;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public CashRegister(double goldStorage, boolean checkoutEmployee, List<Products> ShoppingCart) {
        this.goldStorage = goldStorage;
        this.checkoutEmployee = checkoutEmployee;
        this.ShoppingCart = ShoppingCart;
    }

    public CashRegister(double goldStorage, boolean checkoutEmployee, int x, int y) {
        this.goldStorage = goldStorage;
        this.checkoutEmployee = checkoutEmployee;
        this.x = x;
        this.y = y;
    }

    public void createCashRegister() {

    }

    //Total product price of the shoppingcart
    public double calculatePrice(List<Products> productList) {

        ShoppingCart = productList;
        double price = 0;
        for (Products item : productList) {
            price += item.getProductPrice();
        }
        return price;
    }

    public void goldStorage(double gold) {
        goldStorage += gold;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Money in register: " + goldStorage;
    }
}
