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
public class Customer extends Person{
    
    public List<Products> shoppingCart;
    
    public Customer(String fName, String lName, int lvl, String race, Boolean gender){
        super(fName, lName, lvl, race, gender);
    }
    
    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getRace() + " " + this.getLevel();
    }
}
