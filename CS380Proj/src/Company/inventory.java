package Company;
import Company.products.product;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Name: inventory
 * Date of code: 8/4/2025
 * Class inventory holds all the methods and also class inventories
 * Inventory by itself represents all products on the application, despite their type
 * @author Nery A., Marlon S.
*/
public class inventory {
	/**
	 * default constructor of inventory
	 */
	public inventory() {}
	/**
	* Class inventories is used to describe a group of products
	* For example the brand sells keyboards, switches, and keycaps, so each of these is considered their own inventory group 
	*/
	
	private static final List<product> allProducts = new ArrayList<>();
	

	/**
	 * class for the default inventory
	 */
	public static void writeDefaultInventory() {
		File file = new File("Database/Inventory.csv");
		file.getParentFile().mkdirs();
		List<product> keyboards = getAllKeyboards();
		List<product> keycaps = getallKeycaps();
		List<product> switches = getallSwitches();
		try {
			FileWriter writer = new FileWriter(file);
			writer.append("Name, ID, Price, Type, Quantity, Description\n");
			for (product k : keyboards) {
				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", k.getName(), k.getprodID(), k.getPrice(), k.prodType(), k.getStockQuantity(),k.prodDescription()));
			}
			for (product kc : keycaps) {
				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", kc.getName(), kc.getprodID(), kc.getPrice(), kc.prodType(), kc.getStockQuantity(),kc.prodDescription()));
			}
			for (product s : switches) {
				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", s.getName(), s.getprodID(), s.getPrice(), s.prodType(), s.getStockQuantity(),s.prodDescription()));
			}
			System.out.println("Successful write: Inventory.csv");
			writer.close();
		} catch(IOException e) {
			System.out.println("Error occured while writing Inventory.csv");
			e.printStackTrace();
		}
	}
	/**
	 * adds to inventory from allProducts
	 * @param name adds name to the inventory
	 * @param id adds ID to the inventory
	 * @param price adds the price to the inventory
	 * @param type adds the type to the inventory
	 * @param description adds the description to the inventory
	 * @param stock adds the stock to the inventory
	 * @param imgSRC adds the image to the inventory
	 */
	public static void addToInventory(String name, int id, double price, String type, String description, int stock, String imgSRC) {
		allProducts.add(new product(name, id, price, type, description, stock, imgSRC));
	}
	/**
	 * gets all products
	 * @return returns to allProducts
	 */
	public static List<product> getAllProducts(){
		return allProducts;
	}

	/**
	 * gets all Products by ID
	 * @param ID if the prod id is the correct one
	 * @return returns the product
	 */
	public static product getProductByID (int ID) {
		for(product p: allProducts) {
			if(p.getprodID() == ID) {
				return p;
			}
		}
		return null;
	}
	/**
	 * gets all the keyboards
	 * @return returns all the keyboards in the inventory
	 */
	public static ArrayList<product> getAllKeyboards () {
		ArrayList<product> allKeyboards = new ArrayList<> ();
		for(product p: allProducts) {
			if("keyboard".equals(p.prodType())) {
				allKeyboards.add(p);
			}
		}
		return allKeyboards;
	}
	/**
	 * gets all the keycaps
	 * @return returns all the keycaps from the inventory
	 */
	public static ArrayList<product> getallKeycaps() {
		ArrayList<product> allKeycaps = new ArrayList<> ();
		for (product p: allProducts) {
			if("keycap".equals(p.prodType())) {
				allKeycaps.add(p);
			}
		}
		return allKeycaps;
	}
	/**
	 * gets all the switches
	 * @return returns all the switches from the inventory
	 */
	public static ArrayList<product> getallSwitches() {
		ArrayList<product> allSwitches = new ArrayList<>();
		for (product p : allProducts) {
			if ("switch".equals(p.prodType())){
				allSwitches.add(p);
			}
		}
		return allSwitches;
	}
	/**
	 * class for the inventories that has name, prodID, quantity, and type
	 */
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
		@param quantity inventories quantity
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
		
		@Override
		/**
		 * Method formats a readable string for the inventory item 
		 */
		public String toString() {
			return "Inventory Item: " + name + ", ID: " + prodID + ", Quantity: " + quantity;
		}
	}
}
