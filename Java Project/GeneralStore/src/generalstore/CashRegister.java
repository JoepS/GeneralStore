/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import java.util.List;

/**
 *
 * @author Fré-Meine
 */
public class CashRegister {

    private double goldStorage;
    private boolean checkoutEmployee;
    private List<Products> ShoppingCart;

    public CashRegister(double goldStorage, boolean checkoutEmployee, List<Products> ShoppingCart) {
        this.goldStorage = goldStorage;
        this.checkoutEmployee = checkoutEmployee;
        this.ShoppingCart = ShoppingCart;
    }

    public void createCashRegister() {

    }

    //Total product price of the shoppingcart
    public double calculatePrice(List<Products> productList) {

        ShoppingCart = productList;
        double price = 0;

        for (Products item : ShoppingCart) {
            price += item.getProductPrice();
        }
        return price;
    }

    public void goldStorage(double gold) {
        goldStorage += gold;
    }
}
