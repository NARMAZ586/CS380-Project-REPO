package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProductItemController {

	//fx id for productItem
	@FXML
    private Label priceLabel;

    @FXML
    private ImageView productImg;

    @FXML
    private Label productLabel;


    public void setProductName(String name) {
        productLabel.setText(name);
    }

    public void setPrice(String price) {
        priceLabel.setText(price);
    }

    public void setImage(javafx.scene.image.Image image) {
        productImg.setImage(image);
    }

    

    
}
