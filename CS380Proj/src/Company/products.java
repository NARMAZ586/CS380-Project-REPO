package Company;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Name: products
 * Date of code: 8/4/25
 * Class products is used to encapsulate methods used for the products and it also contains the class attributes along with getters for class product(a single product)
 * Important functions: writeCSV(String fileName): void, getAllProducts(): ArrayList product
 * ArrayList was used a few times in this class mainly to organize all of the products into a single ArrayList
 * It was used in the getAllProducts method and in the products constructor
 * @author Nery Armaz, Marlon A. Matthew B.
 */
public class products {
	
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
	
	public static product picked;
	
	/**
	 * Default constructor for products, when called it creates the ArrayList for keyboards, switches, and keycaps.
	 * It will then fill the array list with objects of product 
	 */
	public products() {}
	
	/**
	 * Method reads the DefaultProducts csv and it adds every entry into the inventory list
	 * @param fileName The filename that is being read "Database/DefaultProducts.csv"
	 */
	public static void readProductsCSV(String fileName){ 
		//List<product> readProducts = new ArrayList<>();
		try (BufferedReader BR = new BufferedReader(new FileReader(fileName))){
			String line;
			boolean headerLine = true;
			line = BR.readLine();
			while (line != null) {
				if (headerLine) {
					headerLine = false;
					line = BR.readLine();
					continue; //will skip over the header line
				}
				String[] columnValues = line.split(",");
				if(columnValues.length >= 1) {
					String prodName = columnValues[0];
					int prodId = Integer.parseInt(columnValues[1]);
					double prodPrice = Double.parseDouble(columnValues[2]);
					String prodType = columnValues[3];
					String prodDescription = columnValues[4];
					int prodStock = Integer.parseInt(columnValues[5]);
					String image = columnValues[6];
					inventory.addToInventory(prodName, prodId, prodPrice, prodType, prodDescription, prodStock, image);
				}
				line = BR.readLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * During runtime it updates the stock of the default products 
	 * This is because inventory list is filled from the contents of default products
	 * This means that default products must be updated in order to get an accurate representation of the stock being bought up
	 */
	public static void updateProductStockCSV() {
		File originalFile = new File("Database/DefaultProducts.csv");
		File tempFile = new File("Database/DefaultProducts_temp.csv");
		try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
			String line;
			while((line = reader.readLine()) != null) {
				String [] pieces = line.split(",");
				
				if(pieces[0].equals("Name")) {
					writer.write(line);
					writer.newLine();
					continue;
				}
				if(pieces[0].equals(picked.getName())) {
					pieces[5] = String.valueOf(picked.getStockQuantity());
					line = String.join(",", pieces);
				}
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Writing to Default Products csv successful");
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error occured while writing file");
		}
		try {
			Files.delete(originalFile.toPath());
			Files.move(tempFile.toPath(), originalFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occured while replacing original csv");
		}
	}
	
	/**
     * Method returns the private attribute from class products: ArrayList product switches
     * @return returns the switches in the array list
     */
    public ArrayList<product> getSwitches(){
    	ArrayList<product> product = new ArrayList<>();
    	product.addAll(switches);
 	    return product;
    }
    
    /**
     * Method returns the private attribute from class products: ArrayList product switches
     * @return returns the switches in the array list
     */
    public ArrayList<product> getKeyboards(){
    	ArrayList<product> product = new ArrayList<>();
    	product.addAll(keyboards);
 	    return product;
    }
    
    /**
     * Method returns the private attribute from class products: ArrayList product switches
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
	public ArrayList<product> getAllProducts() {
	    ArrayList<product> all = new ArrayList<>();
	    all.addAll(keyboards);
	    all.addAll(switches);
	    all.addAll(keycaps);
	    return all;
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
		/**
		 * displays the image
		 */
		private int stockQuantity;
		
		
		
		/**
		 * Constructor for the product class
		 * @param name product name
		 * @param ID product id
		 * @param price product price
		 * @param type product type
		 * @param description product description
		 * @param imgSrc product image source
		 * @param stockQuantity stock product quantity
		 */
		public product(String name, int ID, double price, String type, String description, int stockQuantity, String imgSrc) {
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
		/**
		 *  getter method for stock quantity
		 * @return will return the stockquantity attribute of the object product
		 */
		public int getStockQuantity() {
			return stockQuantity;
		}
		/**
		 *  setter method for stockquantity
		 * @param stockQuantity constructer
		 */
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}
	}
}