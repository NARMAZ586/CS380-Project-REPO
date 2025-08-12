package Company;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class products {
	/*public static void main(String[] args) {
		products p = new products();
		

	}*/
	private ArrayList<product> keyboards;
	private ArrayList<product> switches;
	private ArrayList<product> keycaps;
	public products() {
		keyboards = new ArrayList<>();
		keyboards.add(new product("red Mechanical", 1, 150.0, "keyboard", "Red mechanical keyboard that comes with cherry mx red switches for a more silent experience and custom red patterned keycaps"));
		keyboards.add(new product("retroMechanical", 2, 200.00, "keyboard", "A retro themed mechanical keyboard that comes in 5 different shades of blue, purple, and neon green"));
		keyboards.add(new product("blueMechanical", 3, 150.00, "keyboard", "Blue mechanical keyboard that comes with blue mx switches and bright blue keycaps that are removeable"));
		keyboards.add(new product("CustomeBuild", 4, 250.00, "keyboard", "This is a fully custom build. This keyboard option gives full customizable options to the buyer"));
		switches = new ArrayList<>();
		switches.add(new product("cherry mx red", 5, 15.00, "switch", "These switches are for the user that wants a more tactile or stealthy sound to their keyboard"));
		switches.add(new product("cherry mx silent red", 6, 18.50, "switch", "These switches provide an even more tactile sound than the original cherry mx red switches"));
		switches.add(new product("cherry mx brown", 7, 17.00, "switch", "A tactile key switch which offers a balance of feedback and oise"));
		switches.add(new product("Razer Yellow", 8, 20.00, "switch", "Fast linear designed for quick response times"));
		keycaps = new ArrayList<>();
		keycaps.add(new product("neon retro", 9, 100.0, "keycap", "These neon retro themed keycaps come in multiple shade of an assortment of colors"));
		keycaps.add(new product("Cherry", 10, 120.00, "keycap", "ERgonomic with agnled tops and varying heights across rows, suitable for gaming and typing"));
		keycaps.add(new product("OEM", 11, 110.00, "keycap", "Common ergonomic type, taller and more angled than Cherry, used in most pre-built keyboards"));
		keycaps.add(new product("SA", 12, 135.00, "keycap", "Tall, rounded, and ergonomic with indented tops, offering comfort for extended typing sessions"));
		keycaps.add(new product("DSA", 13, 90.00, "keycap", "Non-ergonomic with a low-profile, flat shape, prodviding versatility for various keyboard setups"));
		keycaps.add(new product("MOA", 14, 105.00, "keycap", "Non-ergonomic with rounded shapes and smaller topds, giving keyboards a cozy, bubble-like appearance"));
		keycaps.add(new product("Custom caps", 15, 4.50, "keycap", "Offers a fully custom keycaps for any size of keyboard, each keycap is $4.50"));
		writeCSV("products.csv");
	}
	
	public void writeCSV(String fileName) {
		File file = new File("Database/" + fileName);
		file.getParentFile().mkdirs();
		try {
			FileWriter writer = new FileWriter(file);
			writer.append("Name,ID,Price,Type,Description\n");
			for(product k : keyboards) {
				writer.append(String.format("%s,%d,%f,%s,%s\n", k.getName(), k.getprodID(), k.getPrice(), k.prodType(), k.prodDescription()));
			}
			for(product s : switches) {
				writer.append(String.format("%s,%d,%f,%s,%s\n", s.getName(), s.getprodID(), s.getPrice(), s.prodType(), s.prodDescription()));
			}
			for(product c : keycaps) {
				writer.append(String.format("%s,%d,%f,%s,%s\n", c.getName(), c.getprodID(), c.getPrice(), c.prodType(), c.prodDescription()));
			}
			System.out.println("Writing to file successful");
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Error occured while writing file");
		}
	}
	
	public void attempt(String n) {
		System.out.println(n);
	}

	public static class product{
		private double price;
		private String name;
		private int ID;
		private String type;
		private String description;
		
		public product() {}
		
		public product(String name, int ID, double price, String type, String description) {
			this.name = name;
			this.ID = ID;
			this.price = price;
			this.type = type;
			this.description = description;
		}
		
		
		public String getName() {
			return name;
		}
		
		public double getPrice() {
			return price;
		}
		
		public int getprodID() {
			return ID;
		}
		
		public String prodType() {
			return type;
		}
		
		public String prodDescription() {
			return description;
		}
	}
	
	
	
	//----- SEARCH FUNCTION FOR CONTROLLER.JAVA ------
	public ArrayList<product> getAllProducts() {
		ArrayList<product> all = new ArrayList<>();
		all.addAll(keyboards);
		all.addAll(switches);
		all.addAll(keycaps);
		return all;
	}
}