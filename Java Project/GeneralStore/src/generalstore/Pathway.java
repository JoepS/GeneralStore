/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generalstore;

import java.util.ArrayList;

/**
 *
 * @author Fré-Meine
 */
public class Pathway {
    private int id;
    private ArrayList<Products> productsA;
    private ArrayList<Products> productsB;
    private int maxAmount = 50;
    
    public Pathway(int id){
        this.id = id;
        this.productsA = new ArrayList<>();
        this.productsB = new ArrayList<>();
    }
    
    public void addProduct(Products p){
        if(!productsA.isEmpty()){
            if(productsA.get(0).getProductID() == p.getProductID() && productsA.size() < maxAmount){
                productsA.add(p);
            }
        }
        else if(productsB.isEmpty()){
            productsA.add(p);
            return;
        }
        if(!productsB.isEmpty()){
            if(productsB.get(0).getProductID() == p.getProductID() && productsA.size() < maxAmount){
                productsB.add(p);
            }
        }
        else if(productsA.isEmpty()){
            productsB.add(p);
        }
    }
    
    public Products getProductA(){
        Products p = new Products("Invalid", 0, 0);
        if(!productsA.isEmpty()){
           p = productsA.get(productsA.size()-1);
        }
        return p;
    }
    
    public Products getProductB(){
        Products p = new Products("Invalid", 0, 0);
        if(!productsB.isEmpty()){
           p = productsB.get(productsB.size()-1);
        }
        return p;
    }
}
