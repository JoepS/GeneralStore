/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generalstore;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Fré-Meine
 */
public class Customer extends Person{
    
    public List<Products> shoppingCart;
    //List of what the customer wants to buy
    public List<Products> shoppingList;
    
    double cash;
    
    public Customer(String fName, String lName, int lvl, String race, Boolean gender, double cash){
        
        super(fName, lName, lvl, race, gender);
        shoppingCart = new ArrayList<>();
        shoppingList = new ArrayList<>();
        this.cash = cash;
    }
    
    public List<Products> getCart(){
        return this.shoppingCart;
    }
    
    public void setCart(List<Products> newcart){
        this.shoppingCart = newcart;
    }
    
    public void addToCart(Products p){
        this.shoppingCart.add(p);
    }
    
    public Products removeLast(){
        Products temp = shoppingCart.get(shoppingCart.size() -1);
        this.shoppingCart.remove(shoppingCart.size() - 1);
        return temp;
    }   
    
        public void createShoppingList(ArrayList<Products> products) {
        Random ran = new Random();
        double totalCash = cash;
        double cashLeft = 0;
        
        for (int i = 0; i < ran.nextInt(15); i++) {
            if (cashLeft + products.get(i).getProductPrice() < totalCash) {
                shoppingList.add(products.get(ran.nextInt(10)));
                cashLeft += shoppingList.get(i).getProductPrice();
            }
        }
    }
    
    @Override
    public String toString(){
        String gender = "Female";
        if(this.getGender()){
            gender = "Male";
        }
        return this.getFirstName() + " " + this.getLevel() + " " + this.getRace() + " " + gender;
    }
}
