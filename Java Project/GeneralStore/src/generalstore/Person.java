/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generalstore;

/**
 *
 * @author Matthijs
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private int level;
    private String race;
    private Boolean gender; //True = male; False = female;
    
    private int x,y;
    
    public Person(String fName, String lName, int lvl, String race, Boolean gender){
        this.firstName = fName;
        this.lastName = lName;
        this.level = lvl;
        this.race = race;
        this.gender = gender;
    }
    
    //Getters of person
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getLevel(){
        return level;
    }
    public String getRace(){
        return race;
    }
    public Boolean getGender(){
        return gender;
    }
    //Setters of person
    public void setFirstName(String fName){
        this.firstName = fName;
    }
    public void setLastName(String lName){
        this.lastName = lName;
    }
    public void setLevel(int lvl){
        this.level = lvl;
    }
    public void setRace(String race){
        this.race = race;
    }
    public void setGender(Boolean gender){
        this.gender = gender;
    }
}
