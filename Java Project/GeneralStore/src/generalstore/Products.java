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

    @Id @GeneratedValue
    @Column(name = "id")
    private int productID;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_price")
    private double productPrice;
    

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

    public int getProductID() {
        return productID;
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
    
    create table PRODUCTS (
        product_id INT NOT NULL auto_increment,
        product_name VARCHAR(50) default NULL,
        product_price  VARCHAR(50) default NULL,
        PRIMARY KEY (id)
    );
}
