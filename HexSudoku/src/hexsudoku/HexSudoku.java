/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexsudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Tomasz Zawistowski
 */
public class HexSudoku extends Application {
    
    public static Stage mainStage; 
    
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/hexsudoku/Login.fxml"));
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        mainStage.setResizable(false);
        mainStage.setTitle("Login");
        Image image = new Image("/resources/controller_icon.png");
        mainStage.getIcons().add(image);
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
