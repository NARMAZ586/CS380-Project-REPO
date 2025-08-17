package application;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

import Company.orders;
import Company.products.product;
/**
OrdersController
Date of code: 8/15/25
This controller class handles all of the UI elements of the Orders page
This includes things like displaying the orders and putting it in a csv file
@author Nery A.
*/
public class OrdersController extends SceneController{
	/**
	 * default constructor for OrdersController
	 */
	public OrdersController() {}
	/**
	 * constructor of the write default orders
	 */
	public static void writeDefaultOrders() {
		File file = new File("Database/Orders.csv");
		file.getParentFile().mkdirs();
		
	}
	
//	public static void writeDefaultInventory() {
//		File file = new File("Database/Inventory.csv");
//		file.getParentFile().mkdirs();
//		List<product> keyboards = getAllKeyboards();
//		List<product> keycaps = getallKeycaps();
//		List<product> switches = getallSwitches();
//		try {
//			FileWriter writer = new FileWriter(file);
//			writer.append("Name, ID, Price, Type, Quantity, Description\n");
//			for (product k : keyboards) {
//				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", k.getName(), k.getprodID(), k.getPrice(), k.prodType(), k.getStockQuantity(),k.prodDescription()));
//			}
//			for (product kc : keycaps) {
//				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", kc.getName(), kc.getprodID(), kc.getPrice(), kc.prodType(), kc.getStockQuantity(),kc.prodDescription()));
//			}
//			for (product s : switches) {
//				writer.append(String.format("%s,%d,%.2f,%s,%d,%s\n", s.getName(), s.getprodID(), s.getPrice(), s.prodType(), s.getStockQuantity(),s.prodDescription()));
//			}
//			System.out.println("Successful write: Inventory.csv");
//			writer.close();
//		} catch(IOException e) {
//			System.out.println("Error occured while writing Inventory.csv");
//			e.printStackTrace();
//		}
//	}
}
