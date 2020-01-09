package hexsudoku;

import static hexsudoku.HexSudoku.mainStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tomasz Zawistowski
 */
public class MenuController implements Initializable {

    @FXML private Button menuButtonPlay;
    @FXML private ChoiceBox menuLevelSelection;
    
    static int selectedLevelInteger = 0;
    
    @FXML
    public void startGame(ActionEvent event) throws IOException {
        
        String selectedLevelString = (String)menuLevelSelection.getValue();
        
        switch(selectedLevelString){
            case "Level 1: Easy":
                selectedLevelInteger = 0;
                break;
            case "Level 2: Medium":
                selectedLevelInteger = 1;
                break;
            case "Level 3: Hard":
                selectedLevelInteger = 2;
                break;
        }
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/hexsudoku/Game.fxml"));
        //Stage stage = new Stage();
        Parent root = loader.load();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        mainStage.setResizable(false);
        mainStage.setTitle("Game");
        Image image = new Image("/resources/controller_icon.png");
        mainStage.getIcons().add(image);
        mainStage.show();
    }
    
    @FXML
    public void logout() throws IOException{
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuLevelSelection.setItems(FXCollections.observableArrayList("Level 1: Easy", "Level 2: Medium", "Level 3: Hard")); 
        menuLevelSelection.getSelectionModel().select(0);
    }    
    
}
