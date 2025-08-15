package Company;
import Company.products.product;
import java.util.List;
import java.util.ArrayList;


/**
* Name: inventory
* Date of code: 8/4/2025
* @author Nery A., Marlon S.
* Class inventory holds all the methods and also class inventories
* Inventory by itself represents all products on the application, despite their type
*/
public class inventory {
	/**
	* Class inventories is used to describe a group of products
	* For example the brand sells keyboards, switches, and keycaps, so each of these is considered their own inventory group 
	*/
	
	private static final List<product> allProducts = new ArrayList<>();
	
	public static void InitialProducts() {
		if(!allProducts.isEmpty()) {
			return;
		}
		//keyboards
		allProducts.add(new product("red Mechanical", 1, 150.0, "keyboard", "Red mechanical keyboard that comes with cherry mx red switches for a more silent experience and custom red patterned keycaps", "redMech.png", 10));
		allProducts.add(new product("retroMechanical", 2, 200.00, "keyboard", "A retro themed mechanical keyboard that comes in 5 different shades of blue, purple, and neon green", "retroMech.jpg", 5));
		allProducts.add(new product("blueMechanical", 3, 150.00, "keyboard", "Blue mechanical keyboard that comes with blue mx switches and bright blue keycaps that are removeable", "blueMech.jpg", 8));
		allProducts.add(new product("CustomeBuild", 4, 250.00, "keyboard", "This is a fully custom build. This keyboard option gives full customizable options to the buyer", "owlKeyboard.jpg", 3));
		//switches
		allProducts.add(new product("Eva-0", 5, 15.00, "switch", "These switches are for the user that wants a more tactile or stealthy sound to their keyboard", "evaSwitch.jpg", 100));
		allProducts.add(new product("BananaSplit", 6, 18.50, "switch", "These switches provide an even more tactile sound than the original cherry mx red switches", "pinkSwitch.png", 75));
		allProducts.add(new product("cherry mx brown", 7, 17.00, "switch", "A tactile key switch which offers a balance of feedback and noise", "cherrymxbrown.jpg", 60));
		allProducts.add(new product("Novelkey Creams", 8, 20.00, "switch", "Fast linear designed for quick response times", "novelkey-creams-switches-596114.jpg", 90));
		//keycaps
		allProducts.add(new product("Retro", 9, 100.0, "keycap", "These neon retro themed keycaps come in multiple shade of an assortment of colors", "retro.png", 25));
		allProducts.add(new product("Cherry Blossom", 10, 120.00, "keycap", "Ergonomic with angled tops and varying heights across rows, suitable for gaming and typing", "cherryBloss.png", 15));
		allProducts.add(new product("Samurai", 11, 110.00, "keycap", "Common ergonomic type, taller and more angled than Cherry, used in most pre-built keyboards", "samurai.png", 12));
		allProducts.add(new product("Purple", 12, 135.00, "keycap", "Tall, rounded, and ergonomic with indented tops, offering comfort for extended typing sessions", "purple.png", 20));
		allProducts.add(new product("Charmer", 13, 90.00, "keycap", "Non-ergonomic with a low-profile, flat shape, providing versatility for various keyboard setups", "charmer.png", 30));
		allProducts.add(new product("Latin", 14, 105.00, "keycap", "Non-ergonomic with rounded shapes and smaller tops, giving keyboards a cozy, bubble-like appearance", "latin.png", 10));
		allProducts.add(new product("Katana", 15, 4.50, "keycap", "Offers fully custom keycaps for any size of keyboard, each keycap is $4.50", "katana.png", 1000));
	}
	
	public static List<product> getAllProducts(){
		return allProducts;
	}
	
	public static product getProductByID (int ID) {
		for(product p: allProducts) {
			if(p.getprodID() == ID) {
				return p;
			}
		}
		return null;
	}
	
	public static ArrayList<product> getAllKeyboards () {
		ArrayList<product> allKeyboards = new ArrayList<> ();
		for(product p: allProducts) {
			if("keyboard".equals(p.prodType())) {
				allKeyboards.add(p);
			}
		}
		return allKeyboards;
	}
	
	public static ArrayList<product> getallKeycaps() {
		ArrayList<product> allKeycaps = new ArrayList<> ();
		for (product p: allProducts) {
			if("keycap".equals(p.prodType())) {
				allKeycaps.add(p);
			}
		}
		return allKeycaps;
	}
	
	public static ArrayList<product> getallSwitches() {
		ArrayList<product> allSwitches = new ArrayList<>();
		for (product p : allProducts) {
			if ("switch".equals(p.prodType())){
				allSwitches.add(p);
			}
		}
		return allSwitches;
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
		
		/**
		* Default constructor for inventories 
		*/
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
		 * @return Will return the name attribute of the object inventory
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
