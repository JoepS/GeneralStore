package generalstore;

import java.util.ArrayList;

public class Department {

    private int id;
    private ArrayList<Products> products;
    private int maxAmount = 50;
    private Employee currentEmployee;
    private int x, y;   
    
    Warehouse w = new Warehouse();

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Department(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        products = new ArrayList<>();
    }

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
        Products p = new Products(0, "Invalid", 0, 0);
        if (products.size() > 0 && currentEmployee != null) {
            p = products.get(products.size() - 1);
        }
        return p;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public String toString() {
        String s = this.id + "";
        if (currentEmployee != null) {
            s += " Employee: " + currentEmployee.getFirstName();
        }
        else{
            s += "No employee?";
        }
        if (!products.isEmpty()) {
            s += " Product " + products.get(0).getProductName() + " aantal: " + products.size();
        }
        return s;
    }
    
    public Products removeProduct(){
        if(isProductEmpty()){
            refill();
        }
        Products p = products.get(products.size()-1);
        products.remove(products.size()-1);
        return p;
    }
    
    public Boolean isProductEmpty(){
        if(products.size() <= 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void refill(){
        Products p  = products.get(0);

        System.out.println("Refilling: " + p.getProductName());
        
        for (int i = 0; i < 20; i++) {
            products.add(p);
        }
        p.setProductAmount(p.getProductAmount() - 20);
        w.updateProduct(p);
    }

}
