/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Matthijs
 */
@Entity
@Table(name = "PRODUCTS")
public class Products {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int productID;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_amount")
    private int productAmount;

    public Products(int productID, String productName, double productPrice, int productAmount) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }
    
    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getProductID() {
        return productID;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }
}
