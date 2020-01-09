/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexsudoku;

import static hexsudoku.HexSudoku.mainStage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class RegistrationController implements Initializable {

    @FXML private TextField registrationLogin;
    @FXML private TextField registrationPassword;
    @FXML private Button registrationExit;
    @FXML private Label registrationAlertLabel;
    
    @FXML
    public void register(ActionEvent event) throws IOException, ClassNotFoundException {
        
        String fileName = "players.txt";
        ArrayList<Player> players = new ArrayList<>();
        Boolean isLoginUnique = true;
        
        File file = new File(fileName);
        if (file.createNewFile()) {
            try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(players);
            }
        } else {}
        
        String newPlayerLogin = registrationLogin.getText().trim();
        String newPlayerPassword = registrationPassword.getText();
        
        
        Player newPlayer = new Player(newPlayerLogin, newPlayerPassword);
        
        
        try(FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis)){
                players = (ArrayList) ois.readObject();
                for(int i=0; i<players.size();i++){
                    if(players.get(i).getPlayerLogin().equals(newPlayerLogin)){
                        isLoginUnique = false;
                    }
                }
                fis.close();
                ois.close();
                
            if(isLoginUnique){
                try (FileOutputStream fos = new FileOutputStream(fileName);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    players.add(newPlayer);
                    oos.writeObject(players);
                    fos.close();
                    oos.close();
                    Parent root = FXMLLoader.load(getClass().getResource("/hexsudoku/Login.fxml"));
                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    scene.getStylesheets().addAll(this.getClass().getResource("styles.css").toExternalForm());
                    mainStage.setResizable(false);
                    mainStage.setTitle("Login");
                    Image image = new Image("/resources/controller_icon.png");
                    mainStage.getIcons().add(image);
                    mainStage.show();
                }
            }
            else{
                registrationAlertLabel.setText("This login is already registered! Please select another one.");
            }
        }
        catch (FileNotFoundException e) {}
        catch (IOException e) {}
    }
    
    @FXML
    public void backToLoginPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/hexsudoku/Login.fxml"));
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        mainStage.setResizable(false);
        mainStage.setTitle("Login");
        Image image = new Image("/resources/controller_icon.png");
        mainStage.getIcons().add(image);
        mainStage.show();
//        Stage stage = (Stage) registrationExit.getScene().getWindow();
//        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
