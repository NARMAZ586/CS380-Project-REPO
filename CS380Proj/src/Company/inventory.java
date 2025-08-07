package Company;
import Company.products.product;

public class inventory {
	public static void main(String[] args) {
		
	}
	public static class inventories{
		private String name;
		private int prodID;
		private int quantity;
		private String type;
		
		public inventories() {
	}
	
		//Constructor
		public inventories(String name, int prodID, int quantity, String type) {
			this.name = name;
			this.prodID = prodID;
			this.quantity = quantity;
			this.type = type;
		}
		
		//Getters
		public String getName() {
			return name;
		}
		
		public int getProdID() {
			return prodID;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public String getType() {
			return type;
		}
		
		//Setters
		public void setName(String name) {
			this.name = name;
		}
		
		public void setProdID(int prodID) {
			this.prodID = prodID;
		}
		
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		
		//Inventory.csv ---prodID---> Product.csv
		//To associate with product.java
		//To be changed later
		/*public product getProduct(product[] allProducts) {
			for (product p : allProducts) {
				if (p.getProdID() == this.prodID) {
					return p;
				}
			}
			return null;
		}
		*/
		
		
		@Override
		public String toString() {
			return "Inventory Item: " + name + ", ID: " + prodID + ", Quantity: " + quantity;
		}
	}
}
