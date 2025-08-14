package application;

import Company.products;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/** 
 * ProductItemController
 * 08/12/2025
 * @author Matthew Berleson
 * 
 * Class Description:Class is meant to be a controller for individual product items, while managing
 * display name, price, and picture.
 * 
 * Important Functions:
 * setProductName(String name), sets product name.
 * setPrice(String price), sets price to product.
 * setImage(String image), sets product image.
 */

public class ProductItemController {

	//fx id for productItem, FXML linked
	@FXML
    private Label priceLabel;

    @FXML
    private ImageView productImg;

    @FXML
    private Label productLabel;
    
    /**
     * click method that expects a mouse click as its event
     * @param mouseEvent this is just the mouse click that it expects
     */
    @FXML
    private void click(MouseEvent mouseEvent) {
    	clickListener.onActionListener(item);
    }
    
    /**
     * Variable of type InterfaceListen
     */
    private InterfaceListener clickListener;
    /**
     * variable is called item and it is a product from the products class
     */
    private products.product item;



    /**
     * Sets the name of the product
     *@param String name, name of the product to display
     */
    public void setProductName(String name) {
        productLabel.setText(name);
    }
    
    /**
     * Method sets the data of the product within the item card
     * @param product Just a product from the products class
     * @param listener Variable of type InterfaceListen
     */
    public void setData(products.product product, InterfaceListener listener) {
        this.item = product;
        this.clickListener = listener;
        
        productLabel.setText(product.getName());
        priceLabel.setText("$" + product.getPrice());
        
        // Assuming the image is available as a resource
        Image img = new Image(getClass().getResourceAsStream(product.getImgSrc()));
        productImg.setImage(img);
    }

    /**
     * Sets the price of the product
     *@param String price, price of the product to display
     */
    public void setPrice(String price) {
        priceLabel.setText(price);
    }

    /**
     * Sets the image of the product
     *@param String image, image of the product to display
     */
    public void setImage(javafx.scene.image.Image image) {
        productImg.setImage(image);
    }

    

    
}
