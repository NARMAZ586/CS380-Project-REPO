package Company;

public class customer {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private int ID;
	
	
	// --- Default constructor ---
	customer() {
		
	}
	
	
	// --- Constructor ---
	public customer(String firstName, String lastName, String email, String username, String phoneNumber, String address, int ID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.ID = ID;
	}
		
	
		//--- Getters ---
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;	
		}
		
		public String getEmail() {
			return email;
		}
		
		public String getPhoneNumber() {
			return phoneNumber;
		}
		
		public String getAddress() {
			return address;
		}
		
		public int getID() {
			return ID;
		}
		

		//--- Setters ---
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public void setAddress(String address) {
			this.address = address;
		}
		
		public void setID(int ID) {
			this.ID = ID;
		}
		
		
		
		@Override
		public String toString() {
			return "Customer - ID: " + ID + "First Name: " + firstName + ", Last Name: " + lastName + ", Email: " + email + "Phone: " + phoneNumber + ", Address: " + address;
		}
}
