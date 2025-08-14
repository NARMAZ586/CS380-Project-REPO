package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
     * Sets the name of the product
     *@param String name, name of the product to display
     */
    public void setProductName(String name) {
        productLabel.setText(name);
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
