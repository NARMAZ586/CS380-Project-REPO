package Company;

public class account {
	//create log in button
	//connect to controller.java
	//work on account.java, add in attrributes, getters, and setters
	//create default accounts(one admin)
	//write accounts ot csv file
	//verify username and password when admin logs in
	//when successful login occurs, give admin option to modify products, with functions add or remove product
	
	//for nery
	//begin work on searching for items
	
	private String email;
    private String password;
    private String firstName;

    // Constructor
    public account(String email, String password, String firstName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
    }

    // Default constructor
    public account() {
    }

    // Gets email
    public String getEmail() {
        return email;
    }
    
    //Sets email
    public void setEmail(String email) {
        this.email = email;
    }

    //Gets password
    public String getPassword() {
        return password;
    }
    
    //Sets password
    public void setPassword(String password) {
        this.password = password;
    }

    //Gets firstName
    public String getFirstName() {
        return firstName;
    }
    
    //Sets firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	
    //FIX: Write to Csv 
    
    

}
