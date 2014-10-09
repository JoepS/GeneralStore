/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generalstore;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fré-Meine
 */
public class Customer extends Person{
    
    public List<Products> shoppingCart;
    
    public Customer(String fName, String lName, int lvl, String race, Boolean gender){
        super(fName, lName, lvl, race, gender);
        shoppingCart = new ArrayList<>();
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
    @Override
    public String toString(){
        String gender = "Female";
        if(this.getGender()){
            gender = "Male";
        }
        return this.getFirstName() + " " + this.getLevel() + " " + this.getRace() + " " + gender;
    }
}
