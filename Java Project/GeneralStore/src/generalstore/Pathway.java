/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package generalstore;

import com.mchange.v2.c3p0.C3P0Registry;
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
    
    private int x, y;
    
    public Pathway(int id, int x, int y){
        this.id = id;
        this.productsA = new ArrayList<>();
        this.productsB = new ArrayList<>();
        this.x = x;
        this.y = y;
    }
    
    public int getMaxAmount(){
        return maxAmount;
    }
    
    public void addProductA(Products p){
        if(productsA.size() < maxAmount){
            productsA.add(p);
        }
    }
    
    public void addProductB(Products p){
        if(productsB.size() < maxAmount){
            productsB.add(p);
        }
    }
    
    public void addProduct(Products p){
        if(productsA.isEmpty() && productsB.isEmpty()){
            productsA.add(p);
        }
        else if(productsA.isEmpty() && !productsB.isEmpty()){
            if(productsB.get(0).getProductID() == p.getProductID()){
                productsB.add(p);
            }
        }
        else if(productsB.isEmpty() && !productsA.isEmpty()){
            if(productsA.get(0).getProductID() == p.getProductID()){
                productsA.add(p);
            }
        }
        else{
            if(productsA.get(0).getProductID() == p.getProductID()){
                productsA.add(p);
            }
            else if(productsB.get(0).getProductID() == p.getProductID()){
                productsB.add(p);
            }
        }
    }
    
    public Products getProductA(){
        Products p = new Products(0, "Invalid", 0, 0);
        if(!productsA.isEmpty()){
           p = productsA.get(productsA.size()-1);
        }
        return p;
    }
    
    public Products getProductB(){
        Products p = new Products(0, "Invalid", 0, 0);
        if(!productsB.isEmpty()){
           p = productsB.get(productsB.size()-1);
        }
        return p;
    }
    
    @Override
    public String toString(){
        String s = "" + this.id;
        
        if(!productsA.isEmpty()){
            s += " Product 1:" + productsA.get(0).getProductName() + " aantal: " + productsA.size();
        }
        if(!productsB.isEmpty()){
            s += " Product 2:" + productsB.get(0).getProductName() + " aantal: " + productsB.size();
        }
        
        return s;
    }
    
    public Products removeProductA(){
        if(isProductAEmpty()){
            refillA();
        }
        Products a = productsA.get(productsA.size()-1);
        productsA.remove(productsA.size()-1);
        return a;        
    }
    
    public Products removeProductB(){
        if(isProductBEmpty()){
            refillB();
        }
        Products b = productsB.get(productsB.size()-1);
        productsB.remove(productsB.size()-1);
        return b;        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public Boolean isProductAEmpty(){
        if(productsA.size() <= 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public Boolean isProductBEmpty(){
        if(productsB.size() <= 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public void refillA(){
        Products a = productsA.get(0);
        for (int i = 0; i < maxAmount - 1; i++) {
            productsA.add(a);
        }
    }
    
    public void refillB(){
        Products b = productsB.get(0);
        for (int i = 0; i < maxAmount - 1; i++) {
            productsB.add(b);
        }
    }
}
