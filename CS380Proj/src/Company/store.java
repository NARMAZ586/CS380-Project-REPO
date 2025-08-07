package Company;

public class store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static class product{
		private int price;
		private String name;
		private int ID;
		private String type;
		private String description;
		
		public product(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
	}
	
	public static class customer{
		private String firstName;
		private String lastName;
		private String email;
		private int phone;
		private String address;
		private int ID;
		
		public customer() {}
	}

}

