package Company;

import Company.products.product;
import java.util.Map;
import java.util.HashMap;
/**
 * Name: ShoppingCart
 * Date of code: 8/16/2025
 * Class Shopping Car holds all the methods and also class shopping cart
 * @author Nery A.
 */
public class ShoppingCart {
	/**
	 * default constructor of ShoppingCart
	 */
	public ShoppingCart () {}
	
	/**
	 * displays the hash map in product and integer in cartItems
	 */
    private static Map<product, Integer> cartItems = new HashMap<>();
    /**
     * display the current total price as 0.0 as default
     */
    private static double currentTotalPrice = 0.0;

    
    /**
     * adds the item in the shopping cart
     * @param p uses the product in the shopping cart
     * @param quantity quantity used to check if theres isnt enough stock
     */
    public static void addItem(product p, int quantity) {
    	
    	if(quantity <= 0) {
    		return;
    	}
    	
    	int currentQuantity = cartItems.getOrDefault(p, 0);
    	int stock = p.getStockQuantity();
    	
    	if (quantity > stock) {
            System.out.println("Cannot add more than stock. Only " + stock + " available.");
            return;
        }

        cartItems.put(p, currentQuantity + quantity);
        updateTotalPrice();
    }
    /**
     * removes the item from the shopping cart
     * @param p uses p to remoce an item and then updates the total price
     */
    public static void removeItem(product p) {
        cartItems.remove(p);
        updateTotalPrice();
    }
    /**
     * uses the product and integer to get it in cart items
     * @return returns tot eh cart items in shopping cart
     */
    public static Map<product, Integer> getCartItems() {
        return cartItems;
    }
    /**
     * gets the total price
     * @return returns the total price as the current total price
     */
    public static double getTotalPrice() {
        return currentTotalPrice;
    }
    /**
     * updates the total price of the shopping cart
     */
    private static void updateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<product, Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        currentTotalPrice = total;
    }
    /**
     * clears the cart alongside the proce to 0
     */
    public static void clearCart() {
        cartItems.clear();
        currentTotalPrice = 0.0;
    }
    /**
     * sets the total price as the current total
     * @param newTotal sets the new total as the current total
     */
    public static void setTotalPrice(double newTotal) {
        currentTotalPrice = newTotal;
    }

}