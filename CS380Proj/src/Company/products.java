package Company;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
//Head
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
		keyboards.add(new product("red Mechanical", 1, 150.0, "keyboard", "Red mechanical keyboard that comes with cherry mx red switches for a more silent experience and custom red patterned keycaps", "redMech.png", 10));
		keyboards.add(new product("retroMechanical", 2, 200.00, "keyboard", "A retro themed mechanical keyboard that comes in 5 different shades of blue, purple, and neon green", "retroMech.jpg", 5));
		keyboards.add(new product("blueMechanical", 3, 150.00, "keyboard", "Blue mechanical keyboard that comes with blue mx switches and bright blue keycaps that are removeable", "blueMech.jpg", 8));
		keyboards.add(new product("CustomeBuild", 4, 250.00, "keyboard", "This is a fully custom build. This keyboard option gives full customizable options to the buyer", "owlKeyboard.jpg", 3));

		switches = new ArrayList<>();
		switches.add(new product("Eva-0", 5, 15.00, "switch", "These switches are for the user that wants a more tactile or stealthy sound to their keyboard", "evaSwitch.jpg", 100));
		switches.add(new product("BananaSplit", 6, 18.50, "switch", "These switches provide an even more tactile sound than the original cherry mx red switches", "pinkSwitch.png", 75));
		switches.add(new product("cherry mx brown", 7, 17.00, "switch", "A tactile key switch which offers a balance of feedback and noise", "cherrymxbrown.jpg", 60));
		switches.add(new product("Novelkey Creams", 8, 20.00, "switch", "Fast linear designed for quick response times", "novelkey-creams-switches-596114.jpg", 90));

		keycaps = new ArrayList<>();
		keycaps.add(new product("Retro", 9, 100.0, "keycap", "These neon retro themed keycaps come in multiple shade of an assortment of colors", "retro.png", 25));
		keycaps.add(new product("Cherry Blossom", 10, 120.00, "keycap", "Ergonomic with angled tops and varying heights across rows, suitable for gaming and typing", "cherryBloss.png", 15));
		keycaps.add(new product("Samurai", 11, 110.00, "keycap", "Common ergonomic type, taller and more angled than Cherry, used in most pre-built keyboards", "samurai.png", 12));
		keycaps.add(new product("Purple", 12, 135.00, "keycap", "Tall, rounded, and ergonomic with indented tops, offering comfort for extended typing sessions", "purple.png", 20));
		keycaps.add(new product("Charmer", 13, 90.00, "keycap", "Non-ergonomic with a low-profile, flat shape, providing versatility for various keyboard setups", "charmer.png", 30));
		keycaps.add(new product("Latin", 14, 105.00, "keycap", "Non-ergonomic with rounded shapes and smaller tops, giving keyboards a cozy, bubble-like appearance", "latin.png", 10));
		keycaps.add(new product("Katana", 15, 4.50, "keycap", "Offers fully custom keycaps for any size of keyboard, each keycap is $4.50", "katana.png", 1000));
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
     * Method returns the private attribute from class products: ArrayList<product> switches
     * @return returns the switches in the array list
     */
    public ArrayList<product> getSwitches(){
    	ArrayList<product> product = new ArrayList<>();
    	product.addAll(switches);
 	    return product;
    }
    
    /**
     * Method returns the private attribute from class products: ArrayList<product> switches
     * @return returns the switches in the array list
     */
    public ArrayList<product> getKeyboards(){
    	ArrayList<product> product = new ArrayList<>();
    	product.addAll(keyboards);
 	    return product;
    }
    
    /**
     * Method returns the private attribute from class products: ArrayList<product> switches
     * @return returns the switches in the array list
     */
    public ArrayList<product> getKeycaps(){
    	ArrayList<product> product = new ArrayList<>();
    	product.addAll(keycaps);
 	    return product;
    }
    
    
    /**
	 * Method creates a new ArrayList called getAllProducts
	 * It then adds all previous array lists into a single one 
	 * @return Will return an ArrayList of all products
	 */
	//----- SEARCH FUNCTION FOR CONTROLLER.JAVA ------
	public ArrayList<product> getAllProducts() {
	    ArrayList<product> all = new ArrayList<>();
	    all.addAll(keyboards);
	    all.addAll(switches);
	    all.addAll(keycaps);
	    return all;
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
		
		private int stockQuantity;
		
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
		public product(String name, int ID, double price, String type, String description, String imgSrc, int stockQuantity) {
			this.name = name;
			this.ID = ID;
			this.price = price;
			this.type = type;
			this.description = description;
			this.imgSrc = imgSrc;
			this.stockQuantity = stockQuantity;
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

		public int getStockQuantity() {
			return stockQuantity;
		}

		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
	}
}