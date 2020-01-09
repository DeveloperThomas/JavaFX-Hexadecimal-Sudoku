package hexsudoku;

import static hexsudoku.HexSudoku.mainStage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tomasz Zawistowski
 */
public class LoginController implements Initializable {

    @FXML private TextField login_username;
    @FXML private TextField login_password;
    @FXML private Label loginAlertLabel;
    @FXML private Button login_button_exit;
    
    @FXML
    public void login(ActionEvent event) throws Exception {
        
        String currentPlayerLogin = login_username.getText().trim();
        String currentPlayerPassword = login_password.getText();
        String fileName = "players.txt";
        ArrayList<Player> players = new ArrayList<>();
        Boolean isDataValid = false;
        
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            
            players = (ArrayList) ois.readObject();
            for(int i=0; i<players.size();i++){
                if(players.get(i).getPlayerLogin().equals(currentPlayerLogin) && players.get(i).getPlayerPassword().equals(currentPlayerPassword)){
                    isDataValid = true;
                    break;
                }
            }
            if(isDataValid) {
                //Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/hexsudoku/Menu.fxml"));
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
                mainStage.setResizable(false);
                mainStage.setTitle("Menu");
                Image image = new Image("/resources/controller_icon.png");
                mainStage.getIcons().add(image);
                mainStage.show();
                fis.close();
                ois.close();
            }
            else {
                loginAlertLabel.setText("Incorrect login or password!");
                fis.close();
                ois.close();
            }
        }
    }
    
    @FXML
    public void startRegistration(ActionEvent event) throws IOException {
        //Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/hexsudoku/Registration.fxml"));
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        mainStage.setResizable(false);
        Image image = new Image("/resources/controller_icon.png");
        mainStage.getIcons().add(image);
        mainStage.setTitle("Registration");
        mainStage.show(); 
    }
    
    @FXML
    public void exitApplication(ActionEvent event){
        Stage stage = (Stage) login_button_exit.getScene().getWindow();
        stage.close();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
