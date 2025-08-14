package application;

import Company.products;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProductItemController {

	//fx id for productItem
	@FXML
    private Label priceLabel;

    @FXML
    private ImageView productImg;

    @FXML
    private Label productLabel;
    
    @FXML
    private void click(MouseEvent mouseEvent) {
    	clickListener.onActionListener(item);
    }
    
    private InterfaceListener clickListener;
    private products.product item;

    public void setData(products.product product, InterfaceListener listener) {
        this.item = product;
        this.clickListener = listener;
        
        productLabel.setText(product.getName());
        priceLabel.setText("$" + product.getPrice());
        
        // Assuming the image is available as a resource
        Image img = new Image(getClass().getResourceAsStream(product.getImgSrc()));
        productImg.setImage(img);
    }

//    public void setProductName(String name) {
//        productLabel.setText(name);
//    }
//
//    public void setPrice(String price) {
//        priceLabel.setText(price);
//    }
//
//    public void setImage(javafx.scene.image.Image image) {
//        productImg.setImage(image);
//    }

    

    
}
