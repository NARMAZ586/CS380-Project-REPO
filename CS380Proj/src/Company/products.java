package Company;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Name: products
 * Date of code: 8/4/25
 * @author Nery Armaz, Marlon A. Matthew B.
 * Class products is used to encapsulate methods used for the products and it also contains the class attributes along with getters for class product(a single product)
 * Important functions: writeCSV(String fileName): void, getAllProducts(): ArrayList<product>
 * ArrayList was used a few times in this class mainly to organize all of the products into a single ArrayList
 * It was used in the getAllProducts method and in the products constructor
 */
public class products {
	/*public static void main(String[] args) {
		products p = new products();
		

	}*/
	/**
	 * An ArrayList of type product, which contains all of the default keyboards that are made at the start
	 */
	private ArrayList<product> keyboards;
	/**
	 * An ArrayList of type product, which contains all of the default switches that are made at the start
	 */
	private ArrayList<product> switches;
	/**
	 * An ArrayList of type product, which contains all of the default keycaps that are made at the start
	 */
	private ArrayList<product> keycaps;
	/**
	 * Default constructor for products, when called it creates the ArrayList for keyboards, switches, and keycaps.
	 * It will then fill the array list with objects of product 
	 */
	public products() {
		keyboards = new ArrayList<>();
		keyboards.add(new product("red Mechanical", 1, 150.0, "keyboard", "Red mechanical keyboard that comes with cherry mx red switches for a more silent experience and custom red patterned keycaps", "evaSwitch.jpg"));
		keyboards.add(new product("retroMechanical", 2, 200.00, "keyboard", "A retro themed mechanical keyboard that comes in 5 different shades of blue, purple, and neon green", "evaSwitch.jpg"));
		keyboards.add(new product("blueMechanical", 3, 150.00, "keyboard", "Blue mechanical keyboard that comes with blue mx switches and bright blue keycaps that are removeable", "evaSwitch.jpg"));
		keyboards.add(new product("CustomeBuild", 4, 250.00, "keyboard", "This is a fully custom build. This keyboard option gives full customizable options to the buyer", "evaSwitch.jpg"));
		switches = new ArrayList<>();
		switches.add(new product("cherry mx red", 5, 15.00, "switch", "These switches are for the user that wants a more tactile or stealthy sound to their keyboard", "evaSwitch.jpg"));
		switches.add(new product("cherry mx silent red", 6, 18.50, "switch", "These switches provide an even more tactile sound than the original cherry mx red switches", "pinkSwitch.png"));
		switches.add(new product("cherry mx brown", 7, 17.00, "switch", "A tactile key switch which offers a balance of feedback and oise", "cherrymxbrown.jpg"));
		switches.add(new product("Razer Yellow", 8, 20.00, "switch", "Fast linear designed for quick response times", "novelkey-creams-switches-596114.jpg"));
		keycaps = new ArrayList<>();
		keycaps.add(new product("neon retro", 9, 100.0, "keycap", "These neon retro themed keycaps come in multiple shade of an assortment of colors", "evaSwitch.jpg"));
		keycaps.add(new product("Cherry", 10, 120.00, "keycap", "ERgonomic with agnled tops and varying heights across rows, suitable for gaming and typing", "evaSwitch.jpg"));
		keycaps.add(new product("OEM", 11, 110.00, "keycap", "Common ergonomic type, taller and more angled than Cherry, used in most pre-built keyboards", "evaSwitch.jpg"));
		keycaps.add(new product("SA", 12, 135.00, "keycap", "Tall, rounded, and ergonomic with indented tops, offering comfort for extended typing sessions", "evaSwitch.jpg"));
		keycaps.add(new product("DSA", 13, 90.00, "keycap", "Non-ergonomic with a low-profile, flat shape, prodviding versatility for various keyboard setups", "evaSwitch.jpg"));
		keycaps.add(new product("MOA", 14, 105.00, "keycap", "Non-ergonomic with rounded shapes and smaller topds, giving keyboards a cozy, bubble-like appearance", "evaSwitch.jpg"));
		keycaps.add(new product("Custom caps", 15, 4.50, "keycap", "Offers a fully custom keycaps for any size of keyboard, each keycap is $4.50", "evaSwitch.jpg"));
		writeCSV("products.csv");
	}
	
	/**
	 * Method creates a CSV and fills it up with all of the products that were created in the constructor
	 * @param fileName Just the naming of the csv file
	 */
	public void writeCSV(String fileName) {
		File file = new File("Database/" + fileName);
		file.getParentFile().mkdirs();
		try {
			FileWriter writer = new FileWriter(file);
			writer.append("Name,ID,Price,Type,Description\n");
			for(product k : keyboards) {
				writer.append(String.format("%s,%d,%f,%s,%s,%s\n", k.getName(), k.getprodID(), k.getPrice(), k.prodType(), k.prodDescription(), k.getImgSrc()));
			}
			for(product s : switches) {
				writer.append(String.format("%s,%d,%f,%s,%s,%s\n", s.getName(), s.getprodID(), s.getPrice(), s.prodType(), s.prodDescription(), s.getImgSrc()));
			}
			for(product c : keycaps) {
				writer.append(String.format("%s,%d,%f,%s,%s,%s\n", c.getName(), c.getprodID(), c.getPrice(), c.prodType(), c.prodDescription(), c.getImgSrc()));
			}
			System.out.println("Writing to file successful");
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error occured while writing file");
		}
	}
	
	/**
	 * Small method used to test if class object was correctly be used in controller.java
	 * @param n Just the string that is meant to be printed to console
	 */
	public void attempt(String n) {
		System.out.println(n);
	}
	
	/**
	 * This class contains all the attributes of a single product such as the name, price, etc
	 */
	public static class product{
		/**
		 * Price of the product
		 */
		private double price;
		/**
		 * Name of the product
		 */
		private String name;
		/**
		 * Id of the product
		 */
		private int ID;
		/**
		 * what type of product this is
		 */
		private String type;
		/**
		 * Description of the product
		 */
		private String description;
		/**
		 * What image is used for this product
		 */
		private String imgSrc;
		
		//public product() {}
		
		/**
		 * Constructor for the product class
		 * @param name product name
		 * @param ID product id
		 * @param price product price
		 * @param type product type
		 * @param description product description
		 * @param imgSrc product image source
		 */
		public product(String name, int ID, double price, String type, String description, String imgSrc) {
			this.name = name;
			this.ID = ID;
			this.price = price;
			this.type = type;
			this.description = description;
			this.imgSrc = imgSrc;
		}
		
		/**
		 * Getter method for name
		 * @return Will return the name attribute of the object product
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * Getter method for price
		 * @return Will return the price attribute of the object product
		 */
		public double getPrice() {
			return price;
		}
		
		/**
		 * Getter method for ID
		 * @return Will return the ID attribute of the object product
		 */
		public int getprodID() {
			return ID;
		}
		
		/**
		 * Getter method for type
		 * @return Will return the type attribute of the object product
		 */
		public String prodType() {
			return type;
		}
		
		/**
		 * Getter method for description
		 * @return Will return the description attribute of the object product
		 */
		public String prodDescription() {
			return description;
		}
		
		/**
		 * Getter method for image source
		 * @return Will return the imgSrc attribute of the object product
		 */
		public String getImgSrc() {
			return imgSrc;
		}
	}
	
	
	/**
	 * Method creates a new ArrayList called getAllProducts
	 * It then adds all previous array lists into a single one 
	 * @return Will return an ArrayList of all products
	 */
	//----- SEARCH FUNCTION FOR CONTROLLER.JAVA ------
	public ArrayList<product> getAllProducts() {
	    ArrayList<product> all = new ArrayList<>();
	   // all.addAll(keyboards);
	    all.addAll(switches);
	    //all.addAll(keycaps);
	    return all;
	}
	
	/**
	 * Method returns the private attribute from class products: ArrayList<product> switches
	 * @return
	 */
	private ArrayList<product> getSwitches(){
		return switches;
	}

}