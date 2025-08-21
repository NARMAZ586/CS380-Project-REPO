package Company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import application.CheckOutController;

/**
 * Name: customer
 * Date of code: 8/8/25
 * Represents an individual customer order in the system
 * @author  Michelle L.
 */
public class customer {
	/**
		Customers first name
	*/
	private String firstName;
	/**
		Customers last name
	*/
	private String lastName;
	/**
		Customers email address
	*/
	private String email;
	/**
		Customers phone number
	*/
	private String phoneNumber;
	/**
		Customers address
	*/
	private String address;
	/**
		Customers unique ID
	*/
	private int ID;

	
	/**
	 * Default constructor for customer class
	 */
	public customer() {}

	/**
	 * Constructor for the class customer
	 * @param firstName customer's first name
	 * @param lastName customer's last name
	 * @param email customer's email
	 * @param phoneNumber customer's phone number
	 * @param address customer's address
	 * @param ID customer's ID
	 */
	public customer(String firstName, String lastName, String email, String phoneNumber, String address, int ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.ID = ID;
	}
	
		/**
		 * Getter method for customer first name
		 * @return returns the customer first name
		 */
		public String getFirstName() {
			return firstName;
		}
		
		/**
		 * Getter method for customer last name
		 * @return returns the customer last name
		 */
		public String getLastName() {
			return lastName;	
		}
		
		/**
		 * Getter method for customer email
		 * @return returns the customer email
		 */
		public String getEmail() {
			return email;
		}
		
		/**
		 * Getter method for customer phone number
		 * @return returns the customer phone number
		 */
		public String getPhoneNumber() {
			return phoneNumber;
		}
		
		/**
		 * Getter method for customer address
		 * @return returns the customer address
		 */
		public String getAddress() {
			return address;
		}
		
		/**
		 * Getter method for customer ID
		 * @return returns customer ID
		 */
		public int getID() {
			return ID;
		}

		/**
		 * Setter method for customer first name
		 * @param firstName takes input and sets for customer first name
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		/**
		 * Setter method for customer last name
		 * @param lastName takes input and sets for customer last name
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		/**
		 * Setter method for customer email
		 * @param email takes input and sets for customer email
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		
		/**
		 * Setter method for customer phone number
		 * @param phoneNumber takes input and sets for customer phone number
		 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		/**
		 * Setter method for customer address
		 * @param address takes input and sets for customer address
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		
		/**
		 * Setter method for customer ID
		 * @param ID takes input and sets for customer ID
		 */
		public void setID(int ID) {
			this.ID = ID;
		}
		
		@Override
		/**
		 * Method returns a formatted readable string
		 */
		public String toString() {
			return "Customer - ID: " + ID + "First Name: " + firstName + ", Last Name: " + lastName + ", Email: " + email + "Phone: " + phoneNumber + ", Address: " + address;
		}
		//public customer(String firstName, String lastName, String email, String phoneNumber, String address, int ID) {
		public static void readCustomersCSV() {
			try(BufferedReader br = new BufferedReader(new FileReader("Database/Customers.csv"))) {
				String line;
				boolean headerLine = true;
				while ((line = br.readLine()) != null) {
					if(headerLine) {
						headerLine = false;
						continue;
					}
					
					if (line.trim().isEmpty()) continue;
					
					String [] columnValues = line.split(",");
					if(columnValues.length >= 6) {
						String firstName = columnValues[0];
						String lastName = columnValues[1];
						String email = columnValues[2];
						String phone = columnValues[3];
						String address = columnValues[4];
						String id = columnValues[5];

						if (!id.isEmpty()) {
		                    CheckOutController.addCustomer(firstName, lastName, email, phone, address, Integer.parseInt(id));
		                } else {
		                    System.out.println("Skipping row with empty ID: " + line);
		                }
					}
				}
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("Error: system reading");
			}
		}
		public static void writeSinglecustomer(customer newCustomer) {
			File file = new File("Database/Customers.csv");
			try (FileWriter writer = new FileWriter(file, true)) {
				int index = 0;
				if (CheckOutController.customersSize() == 0) {
					index = 0;
				} else {
					index = CheckOutController.customersSize() - 1;
				}
				//customer newCustomer = CheckOutController.customers.get(index);
				writer.append(String.format("\n%s,%s,%s,%s,%s,%d", newCustomer.getFirstName(), newCustomer.getLastName(), newCustomer.getEmail(), newCustomer.getPhoneNumber(), newCustomer.getAddress(), newCustomer.getID()));
			} catch (IOException e){
	            System.out.println("Error writing to Customers.csv");
				e.printStackTrace();
			}
		}
}
