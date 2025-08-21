package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import Company.account;
import Company.products;
import Company.products.product;

class AdminPageControllerTest {

    private AdminPageController controller;
    private TableView<product> tableView;

    @BeforeEach
    void setUp() {
        new JFXPanel();  

        controller = new AdminPageController();
        
        //products.updateProductStockCSV = () -> {};

        tableView = new TableView<>();
        TableColumn<product, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<product, Integer> qtyCol = new TableColumn<>("Quantity");
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("stockQuantity"));


        controller.tblViewProductStock = tableView;
        controller.tblColumnProductName = nameCol;
        controller.tblColumnQuantity = qtyCol;

        product p = new product("productkeyboard", 5, 0, null, null, 5, null);
        tableView.setItems(FXCollections.observableArrayList(p));
        tableView.getSelectionModel().select(p);
    }

    @Test
    void testHandleBtnAddStock() {
        product selected = tableView.getSelectionModel().getSelectedItem();
        int initialQty = selected.getStockQuantity();

        controller.handleBtnAddStock(new ActionEvent());

        assertEquals(initialQty + 1, selected.getStockQuantity(),
            "Stock quantity should increase by 1 after Add Stock");
    }
    @Test
    void testHandleBtnRemoveStock() {
        product selected = tableView.getSelectionModel().getSelectedItem();
        int initialQty = selected.getStockQuantity();

        controller.handleBtnRemoveStock(new ActionEvent());

        assertEquals(initialQty - 1, selected.getStockQuantity(),
            "Stock quantity should decrease by 1 after Remove Stock");
    }
}