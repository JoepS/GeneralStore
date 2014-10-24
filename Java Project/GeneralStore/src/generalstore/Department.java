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
public class Department {

    private int id;
    private ArrayList<Products> products;
    private int maxAmount = 50;
    private Employee currentEmployee;

    public Department(int id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }
    
    public void addProduct(Products p) {
        if (products.size() < maxAmount) {
            products.add(p);
        }
    }

    public Products getProduct() {
        Products p = new Products("Invalid", 0, 0);
        if (products.size() > 0 && currentEmployee != null) {
            p = products.get(products.size() - 1);
        }
        return p;
    }
    
    public int getMaxAmount(){
        return maxAmount;
    }
    
    public String toString(){
        String s = this.id + "";
        if(currentEmployee != null){
           s += " Employee: " + currentEmployee.getFirstName();
        }
        if(!products.isEmpty()){
            s += " Product " + products.get(0).getProductName() + " aantal: " + products.size();
        }
        return s;
    }

}
