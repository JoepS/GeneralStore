/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

/**
 *
 * @author Matthijs
 */
public class Products {

    private String productName;
    private double productPrice;
    private int productID;

    public Products(String productName, double productPrice, int productID) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productID = productID;
    }
    
    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
