package Company;
import Company.products.product;


/**
* Name: inventory
* Date of code: 8/4/2025
* @author Nery A., Marlon S.
* Class inventory holds all the methods and also class inventories
*/
public class inventory {
	public static void main(String[] args) {
		
	}
	public static class inventories{
		/**
		* Name of the inventory
		*/
		private String name;
		/**
		* id of the product
		*/
		private int prodID;
		/**
		* the quantity that the inventory has
		*/
		private int quantity;
		/**
		* what type of product
		*/
		private String type;
		
		public inventories() {
	}
	
		//Constructor
		/**
		Constructor of the inventories class
		@param name inventories name
		@param prodID inventories prodID
		@param quanitity inventories quantity
		@param type inventories type
		*/
		public inventories(String name, int prodID, int quantity, String type) {
			this.name = name;
			this.prodID = prodID;
			this.quantity = quantity;
			this.type = type;
		}
		
		//Getters
		/**
		 * Getter method for name
		 * @return Will return the name attribute of the object inevntory
		 */
		public String getName() {
			return name;
		}
		/**
		 * Getter method for ID
		 * @return Will return the ID attribute of the object inventory
		 */
		public int getProdID() {
			return prodID;
		}
		/**
		 * Getter method for Quantity
		 * @return Will return the quantity attribute of the object inventory
		 */
		public int getQuantity() {
			return quantity;
		}
		/**
		 * Getter method for Type
		 * @return Will return the Type attribute of the object inventory
		 */
		public String getType() {
			return type;
		}
		
		//Setters
		/**
		* Setter method for inventory name
		* @param name takes input and sets the inventory name
		*/
		public void setName(String name) {
			this.name = name;
		}
		/**
		* Setter method for inventory name
		* @param prodID takes input and sets the inventory name
		*/
		
		public void setProdID(int prodID) {
			this.prodID = prodID;
		}
		
		/**
		 * Setter method for inventory item
		 * @param quantity takes input and sets inventory item type
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		/**
		 * Setter method for inventory item
		 * @param type takes input and sets inventory item type
		 */
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
		/**
		 * Method formats a readable string for the inventory item 
		 */
		public String toString() {
			return "Inventory Item: " + name + ", ID: " + prodID + ", Quantity: " + quantity;
		}
	}
}
