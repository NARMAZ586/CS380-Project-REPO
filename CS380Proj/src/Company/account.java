package Company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Name: account
 * Date of code: 8/4/25
 * @author Matthew B.
 * Class account contains all the attributes of a single account
 */
public class account {
	
	/**
	 * email is for the account email
	 */
	private String email;
	/**
	 * password is for the account password
	 */
    private String password;
    /**
	 * first name is for the first name that is linked to the account
	 */
    private String firstName;
    
    
    // Constructor
    /**
     * Constructor used for the account class
     * @param email takes input email and sets to account email
     * @param password takes input password and sets to account password
     * @param firstName takes input firstName and sets the first name for the account
     */
    public account(String email, String password, String firstName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
    }

    // Default constructor
    /**
     * Default constructor
     */
    public account() {
    }

    // Gets email
    /**
     * Getter method that gets account email
     * @return Returns the email for the account
     */
    public String getEmail() {
        return email;
    }
    
    //Sets email
    /**
     * Setter method that sets account email
     * @param email Takes input and sets it as email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    //Gets password
    /**
     * Getter method that gets account password
     * @return Returns the password for the account
     */
    public String getPassword() {
        return password;
    }
    
    //Sets password
  //Sets email
    /**
     * Setter method that sets account password
     * @param password Takes input and sets it as password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    //Gets firstName
    /**
     * Getter method that gets account first name
     * @return Returns the first name for the account
     */
    public String getFirstName() {
        return firstName;
    }
    
    //Sets firstName
  //Sets email
    /**
     * Setter method that sets account first name
     * @param firstName Takes input and sets it as first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	
    //From Marlon, copy and pasted from UserDatabase.java to account.java
    /**
     * makes a new array list of the accounts
     */
	private static List<account> accounts = new ArrayList<>();
	
	static {
		accounts.add(new account("Admin","123","Admin"));
	}
	/**
	 * adds account as a
	 * @param a uses a as an account method use
	 */
	public static void addAccount(account a) {
		accounts.add(a);
	}
	/**
	 * checks the credentials
	 * @param email checks the email
	 * @param password checks the password
	 * @return true when credentials are correct
	 */
	public static boolean checkCredentials(String email, String password) {
		for (account a : accounts ) {
			if (a.getEmail().equals(email) && a.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
    
    //FIX: Write to Csv 

    public static void readAccountsCSV(String fileName) {
    	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
    		String line;
    		boolean headerLine = true;
    		while ((line = br.readLine()) != null) {
    			if (headerLine) {
    				headerLine = false;
    				continue;
    			}
    			String[] columnValues = line.split(",");
    			if (columnValues.length >= 3) {
                    String email = columnValues[0];
                    String username = columnValues[1];
                    String password = columnValues[2];
                    addAccount(new account(email, password, username));
    			}
    			line = br.readLine();
    		}
    		System.out.println("Successful write: Accounts.csv");
    	} catch(IOException e) {
    		e.printStackTrace();
            System.out.println("Error occured while writing Accounts.csv");
    	}
    }
}
