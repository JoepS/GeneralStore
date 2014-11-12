package generalstore;

/**
 * Abstract class for creating a default person
 * @author Skrylax
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private int level;
    private String race;
    private Boolean gender; //True = male; False = female;
    
    private int x,y;
    
    public Person(String fName, String lName, int lvl, String race, Boolean gender, int x, int y){
        this.firstName = fName;
        this.lastName = lName;
        this.level = lvl;
        this.race = race;
        this.gender = gender;
        this.x = x;
        this.y = y;
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

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void currentLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void destination(int x, int y){
        this.x = x;
        this.y = y;
    }
}
