/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexsudoku;

import static hexsudoku.HexSudoku.mainStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author Tomasz Zawistowski
 */
public class GameController implements Initializable {

    @FXML private Button gameButton0;
    @FXML private Button gameButton1;
    @FXML private Button gameButton2;  
    @FXML private Button gameButton3;      
    @FXML private Button gameButton4;
    @FXML private Button gameButton5;          
    @FXML private Button gameButton6;
    @FXML private Button gameButton7;
    @FXML private Button gameButton8;
    @FXML private Button gameButton9;
    @FXML private Button gameButtonA;
    @FXML private Button gameButtonB;
    @FXML private Button gameButtonC;
    @FXML private Button gameButtonD;
    @FXML private Button gameButtonE;
    @FXML private Button gameButtonF;
    
    @FXML private Button gameButtonPauseOrResume;
    @FXML private Button gameButtonSubmit;
    @FXML private Button gameButtonLeave;
    
    @FXML private Canvas gameCanvas;
    
    @FXML private Label gameLabelResult;
    @FXML public Label gameLabelTime;
    
    public static Boolean isGamePaused = false;
    private Boolean isGameFinished = false;
    
    private int selectedLevel;
    private GameBoard gameBoard;
    private GameTimer gameTimer;
    private GraphicsContext graphicsContext;
    private static final int numberOfFields = 16;
    private static final int sizeOfField = 35;
    private static final int gameCanvasSize = 560;
    
    // Variables responsible for recognizing field selected by player.
    private int selectedRow = 0;
    private int selectedColumn = 0;
    
    public void initData(int level){
        this.selectedLevel = level;
        
    }
    
    public void createBoard(){
        
        // Clears a portion of the canvas with a transparent color value.
        graphicsContext.clearRect(0, 0, gameCanvasSize, gameCanvasSize);
        
        // Creation of the Sudoku Grid.
        for(int i = 0; i < numberOfFields; i++){
            for(int j = 0; j < numberOfFields; j++){
                
                // Sets the value of the property fill.
                graphicsContext.setFill(Color.WHITE);
                // Drawing the rectangles.
                graphicsContext.fillRect(i*sizeOfField + 1, j*sizeOfField + 1, sizeOfField - 2, sizeOfField - 2);
            }
        }
        
        graphicsContext.setStroke(Color.DARKBLUE);
        
        // Vertical Lines.
        for(int i = 0; i < numberOfFields; i++){
            if(i%4 == 0 && i != 0){
                graphicsContext.setLineWidth(3.0);
                graphicsContext.strokeLine(i*sizeOfField, 0, i*sizeOfField, gameCanvasSize);
            }
        }
        
        // Horizontal Lines.
        for(int i = 0; i < numberOfFields; i++){
            if(i%4 == 0 && i != 0){
                graphicsContext.setLineWidth(3.0);
                graphicsContext.strokeLine(0, i*sizeOfField, gameCanvasSize, i*sizeOfField);
            }
        }
        
        // Set darkblue color when mouse hovered over field.
        graphicsContext.setStroke(Color.DARKBLUE);
        
        // Line around field has 2px of weight.
        graphicsContext.setLineWidth(2);
        graphicsContext.strokeRect(selectedColumn * sizeOfField + 1, selectedRow * sizeOfField + 1, sizeOfField - 2, sizeOfField - 2);
    
        // Table firstly shows fields which cannot be modified.
        Boolean[][] gameBoardEditable = gameBoard.getGameBoardEditable();
        char[][] gameBoardSolution = gameBoard.getGameBoardSolution();
        
        for(int i = 0; i < numberOfFields; i++){
            for(int j = 0; j < numberOfFields; j++){
                graphicsContext.setFill(Color.BLACK);
                graphicsContext.setFont(Font.font("SanSerif", 15));
                
                // X (unfilled table cells) will be represented as empty space on the board.
                if(gameBoardEditable[i][j] == false){
                    graphicsContext.fillText(""+gameBoardSolution[i][j], j*sizeOfField + 15, i*sizeOfField + 23);
                }
            }
        }
        
        // This table is useful after player put any number into field, for first invoke it does nothing.
        char[][] gameBoardPlayer = gameBoard.getGameBoardPlayer();
        
        for(int i = 0; i < numberOfFields; i++){
            for(int j = 0; j < numberOfFields; j++){
                graphicsContext.setFill(Color.BLUE);
                graphicsContext.setFont(Font.font("SanSerif", FontWeight.BOLD, 15));
                
                if(gameBoardPlayer[i][j] != 'X'){
                    graphicsContext.fillText(""+gameBoardPlayer[i][j], j*sizeOfField + 15, i*sizeOfField + 23);
                }
            }
        }
        
        gameCanvas.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(!isGamePaused){
                    double positionXFromMouse = event.getX();
                    double positionYFromMouse = event.getY();
                    selectedRow = (int)(positionYFromMouse / sizeOfField);
                    selectedColumn = (int)(positionXFromMouse / sizeOfField);
                    createBoard();
                }
            }
        });        
    }
    
    @FXML
    public void gameButton0Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('0', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton1Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('1', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton2Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('2', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton3Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('3', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton4Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('4', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton5Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('5', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton6Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('6', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton7Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('7', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton8Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('8', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButton9Clicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('9', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButtonAClicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('A', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButtonBClicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('B', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButtonCClicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('C', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButtonDClicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('D', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButtonEClicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('E', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void gameButtonFClicked(ActionEvent event){
        if(!isGamePaused){
            gameBoard.addNumber('F', selectedRow, selectedColumn);
            createBoard();
        }
    }
    
    @FXML
    public void showOrHideCanvas(ActionEvent event){
        
        if(!isGameFinished){
            if(!isGamePaused){
                gameTimer.pauseGameTimer();
                gameCanvas.setDisable(true);
                gameCanvas.setVisible(false);
                isGamePaused = true;
            }
            else{
                gameTimer.resumeGameTimer();
                gameTimer.importLabelFromGame(gameLabelTime);
                gameCanvas.setDisable(false);
                gameCanvas.setVisible(true);
                isGamePaused = false;
            }
        }
    }
    
    @FXML
    public void checkSolution(ActionEvent event){
        Boolean result = gameBoard.checkGameResult();
        
        if(!isGameFinished){
            if(result){
                gameButtonPauseOrResume.setDisable(true);
                gameButtonSubmit.setDisable(true);
                gameBoard.fullfillEditableTable();
                gameLabelResult.setStyle("-fx-text-inner-color: green;");
                gameLabelResult.setText("Congratulations, you win!");
                gameTimer.stopGameTimer();
                isGameFinished = true;
            }
            else{
                gameLabelResult.setStyle("-fx-text-inner-color: red;");
                gameLabelResult.setText("Incorrect");
            }
        }
    }
    
    @FXML
    public void leaveGame(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/hexsudoku/Menu.fxml"));
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        scene.getStylesheets().add(MenuController.class.getResource("styles.css").toExternalForm());
        mainStage.setResizable(false);
        mainStage.setTitle("Menu");
        Image image = new Image("/resources/controller_icon.png");
        mainStage.getIcons().add(image);
        mainStage.show();
//        Stage stage = (Stage) gameButtonLeave.getScene().getWindow();
//        stage.close();
    }
    
    public void updateTimeLabel(){
        String time = gameTimer.changeTimeToString();
        gameLabelTime.setText(time);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int level = MenuController.selectedLevelInteger;
        gameBoard = new GameBoard(level);
        // Creation of game board based on the selected level, constructor creates appropriate board
        graphicsContext = gameCanvas.getGraphicsContext2D();
        this.createBoard();
        gameTimer = new GameTimer();
        gameTimer.startGameTimer();
        gameTimer.importLabelFromGame(gameLabelTime);
    }    
    
}
