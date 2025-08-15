package Company;

import Company.products.product;
import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {

    private static Map<product, Integer> cartItems = new HashMap<>();
    private static double currentTotalPrice = 0.0;

    public static void addItem(product p, int quantity) {
    	
    	if(quantity <= 0) {
    		return;
    	}
    	
    	int currentQuantity = cartItems.getOrDefault(p, 0);
    	int stock = p.getStockQuantity();
    	
    	if (currentQuantity + quantity > stock) {
            System.out.println("Cannot add more than stock. Only " + stock + " available.");
            return;
        }

        cartItems.put(p, currentQuantity + quantity);
        updateTotalPrice();
//        if (quantity > 0) {
//            cartItems.put(p, cartItems.getOrDefault(p, 0) + quantity);
//            updateTotalPrice();
//        }
    }

    public static void removeItem(product p) {
        cartItems.remove(p);
        updateTotalPrice();
    }

    public static Map<product, Integer> getCartItems() {
        return cartItems;
    }

    public static double getTotalPrice() {
        return currentTotalPrice;
    }

    private static void updateTotalPrice() {
        double total = 0.0;
        for (Map.Entry<product, Integer> entry : cartItems.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        currentTotalPrice = total;
    }

    public static void clearCart() {
        cartItems.clear();
        currentTotalPrice = 0.0;
    }

    public static void setTotalPrice(double newTotal) {
        currentTotalPrice = newTotal;
    }

}