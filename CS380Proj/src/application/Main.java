package application;
    
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import application.Controller;
import javafx.application.Platform;


public class Main extends Application {
    private static Stage primaryStage;
    private static Scene mainScene;
    @Override
    public void start(Stage stage) {
        try {
            primaryStage = stage;
            Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
            mainScene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();
            mainScene.getStylesheets().add(css);
            primaryStage.setResizable(false);
            primaryStage.setFullScreen(true);
            primaryStage.setScene(mainScene);
            //uncomment this if program is not fully closing when you close it out
            /*primaryStage.setOnCloseRequest(e -> {
            	Platform.exit();
            	System.exit(0);
            }); */
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static Scene getMainScene() {
        return mainScene;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}