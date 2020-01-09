/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexsudoku;

/**
 *
 * @author Tomasz Zawistowski
 */
public class GameBoard {
    
    // Table responsible for keeping game solution
    private char[][] gameBoardSolution;
    
    // Table responsible for recognizing the editable fields (X)
    private Boolean[][] gameBoardEditable;
    
    // Table responsible for modifying fields
    private char[][] gameBoardPlayer = new char[16][16];
    
    public GameBoard(int level){
        
        for(int i = 16; i < 16; i++){
            for(int j = 0; j < 16; j++){
                gameBoardPlayer[i][j] = 'X';
            }
        }
        
        switch(level){
            
            // Level: Easy
            case 0:
                gameBoardSolution = new char[][] {
                {'9', '3', '8', '7', '2', 'C', 'E', 'D', '4', 'A', '6', 'B', 'F', '5', '1', '0'},
                {'E', '0', 'F', 'B', '6', '5', '4', 'A', '3', 'C', '1', '2', '8', 'D', '9', '7'},
                {'A', 'D', 'C', '5', '1', '0', 'B', '7', '9', 'F', '8', 'E', '4', '2', '6', '3'},
                {'4', '1', '6', '2', '9', '3', 'F', '8', '0', '7', '5', 'D', 'B', 'E', 'C', 'A'},
                {'D', 'C', '1', '3', '8', 'F', '0', 'B', '7', 'E', 'A', '9', '2', '6', '4', '5'},
                {'0', '6', '7', '8', 'E', '1', 'A', '4', '5', '2', 'B', 'F', 'C', '9', '3', 'D'},
                {'F', '2', 'B', '9', 'D', '6', '5', '3', '1', '0', 'C', '4', 'A', '7', '8', 'E'},
                {'5', 'E', 'A', '4', '7', '2', 'C', '9', '6', '3', 'D', '8', '1', 'F', '0', 'B'},
                {'1', 'A', '2', 'E', 'C', '4', '3', 'F', 'D', '8', '9', '5', '0', 'B', '7', '6'},
                {'8', '5', '4', 'D', 'B', '7', '9', '2', 'F', '6', '3', '0', 'E', 'C', 'A', '1'},
                {'C', '7', '9', '6', '5', '8', '1', '0', 'E', 'B', '2', 'A', '3', '4', 'D', 'F'},
                {'3', 'B', '0', 'F', 'A', 'D', '6', 'E', 'C', '4', '7', '1', '5', '8', '2', '9'},
                {'B', '9', '3', 'C', '0', 'E', 'D', '1', '8', '5', '4', '7', '6', 'A', 'F', '2'},
                {'6', '8', '5', '0', 'F', 'A', '7', 'C', '2', 'D', 'E', '3', '9', '1', 'B', '4'},
                {'7', '4', 'E', '1', '3', 'B', '2', '6', 'A', '9', 'F', 'C', 'D', '0', '5', '8'},
                {'2', 'F', 'D', 'A', '4', '9', '8', '5', 'B', '1', '0', '6', '7', '3', 'E', 'C'},
                };
                
                gameBoardEditable = new Boolean[][] {
                {false, false, false, false, false, true, false, false, false, false, false, false, true, false, false, false},
                {false, true, false, false, false, false, false, false, false, false, false, false, false, true, false, false},
                {false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false},
                {true, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false},
                {false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false, false, false, false, true, false, false},
                {false, false, false, false, true, false, false, false, false, true, false, false, false, false, false, false},
                {false, false, false, false, false, true, false, false, false, false, false, false, false, false, true, false},
                {false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false},
                {false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, false, false, false, false, false, true, false, false, false, false},
                {false, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false},
                {false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, false},
                {false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true},
                };
            break;
            
            // Level: Medium
            case 1:
                gameBoardSolution = new char[][] {
                {'B', 'A', 'E', '8', '6', '3', 'C', 'D', '5', '9', '7', 'F', '0', '1', '4', '2'},
                {'4', '1', 'F', 'D', '5', '2', 'B', '7', 'C', '0', 'A', 'E', '9', '6', '8', '3'},
                {'0', 'C', '5', '6', '4', '8', '1', '9', '3', 'B', 'D', '2', 'F', 'E', 'A', '7'},
                {'3', '7', '9', '2', 'A', '0', 'E', 'F', '1', '8', '6', '4', 'D', 'C', '5', 'B'},
                {'F', '4', '7', '0', 'E', '9', '5', '1', 'A', 'D', '3', 'B', '2', '8', 'C', '6'},
                {'E', 'B', '8', '1', 'C', 'D', '7', '2', '6', '5', '4', '0', '3', 'A', '9', 'F'},
                {'2', '9', 'A', '5', '3', '6', '8', '4', 'E', '1', 'F', 'C', '7', 'B', '0', 'D'},
                {'6', '3', 'D', 'C', 'F', 'B', 'A', '0', '8', '2', '9', '7', '4', '5', 'E', '1'},
                {'9', '5', '0', 'B', '2', 'C', '3', 'A', '7', 'F', '8', '1', '6', '4', 'D', 'E'},
                {'C', 'D', '6', 'E', '1', 'F', '9', '8', '0', '4', '2', '3', '5', '7', 'B', 'A'},
                {'8', '2', '3', '7', '0', '4', '6', '5', 'B', 'A', 'E', 'D', '1', '9', 'F', 'C'},
                {'A', 'F', '1', '4', '7', 'E', 'D', 'B', '9', 'C', '5', '6', '8', '3', '2', '0'},
                {'7', '8', 'B', 'F', 'D', '1', '0', '3', '4', 'E', 'C', '9', 'A', '2', '6', '5'},
                {'1', '6', '4', '9', 'B', 'A', '2', 'E', 'F', '3', '0', '5', 'C', 'D', '7', '8'},
                {'5', 'E', '2', 'A', '9', '7', 'F', 'C', 'D', '6', '1', '8', 'B', '0', '3', '4'},
                {'D', '0', 'C', '3', '8', '5', '4', '6', '2', '7', 'B', 'A', 'E', 'F', '1', '9'},
                };
                
                gameBoardEditable = new Boolean[][] {
                {false, false, false, false, false, true, true, false, false, false, false, true, false, false, true, false},
                {false, true, false, true, false, false, true, false, false, false, false, false, true, false, false, true},
                {false, false, true, true, false, false, false, false, false, false, false, false, false, true, false, false},
                {true, false, false, true, false, false, false, false, false, false, false, false, false, true, false, false},
                {false, false, true, false, false, true, false, false, true, false, false, false, false, false, false, true},
                {false, false, false, false, false, false, false, true, false, true, false, false, false, true, false, false},
                {false, true, false, false, false, true, false, false, false, false, true, false, false, false, false, false},
                {true, true, false, false, true, false, true, false, false, false, true, false, true, false, false, false},
                {false, false, true, false, false, false, false, true, false, false, false, false, false, false, true, false},
                {true, false, true, false, false, false, false, false, true, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, false, true, false, false, true, false, false, true, false, true},
                {true, false, false, false, false, false, false, false, true, false, false, true, false, false, false, false},
                {false, false, false, true, false, false, false, false, false, false, false, false, true, false, false, true},
                {false, false, false, false, true, true, false, false, true, false, false, false, false, false, false, false},
                {false, true, false, false, false, false, true, false, false, false, false, true, false, false, false, true},
                {false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, true},
                };
            break;
            
            // Level: Hard
            case 2:
                gameBoardSolution = new char[][] {
                {'7', 'B', 'C', '5', 'A', 'F', '8', '3', '4', '2', '1', '9', 'E', 'D', '0', '6'},
                {'A', '6', '4', '8', 'B', '7', '2', '0', 'E', '3', 'D', '5', '1', 'C', '9', 'F'},
                {'D', '0', '3', 'E', '6', '5', '1', '9', 'F', 'C', '8', '7', '4', 'A', '2', 'B'},
                {'9', '2', '1', 'F', '4', 'D', 'C', 'E', 'B', '0', '6', 'A', '5', '8', '3', '7'},
                {'6', '8', 'A', 'C', '3', '4', '9', 'D', '1', '7', '5', 'E', 'F', '2', 'B', '0'},
                {'5', 'E', 'B', '3', '2', '8', 'F', '7', 'C', '6', '0', 'D', 'A', '9', '1', '4'},
                {'0', 'F', 'D', '9', '5', '1', '6', 'B', '3', '4', 'A', '2', '8', '7', 'E', 'C'},
                {'2', '1', '7', '4', '0', 'C', 'E', 'A', '8', 'F', '9', 'B', 'D', '6', '5', '3'},
                {'4', 'A', '0', '1', 'E', '6', '5', 'F', 'D', 'B', '7', 'C', '9', '3', '8', '2'},
                {'3', 'C', '9', '2', '7', 'B', 'A', '1', '0', '5', '4', '8', '6', 'E', 'F', 'D'},
                {'E', '7', 'F', 'D', '9', '3', '4', '8', 'A', '1', '2', '6', '0', 'B', 'C', '5'},
                {'8', '5', '6', 'B', 'D', '2', '0', 'C', '9', 'E', '3', 'F', '7', '4', 'A', '1'},
                {'B', '3', '2', 'A', '1', 'E', 'D', '5', '6', '9', 'F', '4', 'C', '0', '7', '8'},
                {'C', 'D', '5', '6', '8', '0', 'B', '2', '7', 'A', 'E', '1', '3', 'F', '4', '9'},
                {'1', '4', 'E', '0', 'F', '9', '7', '6', '2', '8', 'C', '3', 'B', '5', 'D', 'A'},
                {'F', '9', '8', '7', 'C', 'A', '3', '4', '5', 'D', 'B', '0', '2', '1', '6', 'E'},
                };
                
                gameBoardEditable = new Boolean[][] {
                {false, true, false, false, false, true, true, false, true, false, false, false, false, true, true, false},
                {true, false, false, false, false, false, false, true, false, false, false, true, false, true, false, false},
                {true, false, true, false, true, true, false, true, false, false, false, true, false, true, false, true},
                {false, false, false, true, true, false, true, true, true, false, false, false, true, false, true, false},
                {true, true, false, false, true, false, false, true, false, true, true, false, false, true, false, false},
                {false, true, false, true, false, false, true, false, true, true, false, false, false, true, false, false},
                {false, false, true, true, false, true, true, false, false, true, false, true, false, false, true, false},
                {false, true, false, true, false, true, false, true, true, false, false, false, true, false, true, false},
                {true, false, false, true, false, true, false, false, true, false, false, false, true, false, false, true},
                {true, false, true, true, true, false, true, true, false, false, true, true, false, false, false, true},
                {true, true, false, false, true, false, false, false, true, false, true, false, false, false, true, true},
                {false, false, false, true, false, true, false, false, false, true, false, true, false, true, false, false},
                {false, true, false, false, true, false, true, true, true, false, true, false, false, true, false, false},
                {false, true, false, true, true, false, false, false, false, false, true, false, false, false, true, false},
                {true, false, true, true, false, true, false, true, false, false, true, false, true, false, false, true},
                {false, false, true, false, false, true, true, true, true, false, false, true, false, false, true, false},
                };
            break;
        }    
    }
    
    public char[][] getGameBoardSolution(){
        return gameBoardSolution;
    }
    
    public Boolean[][] getGameBoardEditable(){
        return gameBoardEditable;
    }
    
    public char[][] getGameBoardPlayer(){
        return gameBoardPlayer;
    }
    
    public void addNumber(char number, int row, int column){
        
        // Check if number is able to be modified
        if(gameBoardEditable[row][column] == true){
            gameBoardPlayer[row][column] = number;
        }
        else{
            return;
        }
    }
    
    public Boolean checkGameResult(){
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                if(gameBoardEditable[i][j] == true){
                    if(gameBoardSolution[i][j] != gameBoardPlayer[i][j])
                        return false;
                }
            }
        }
        return true;
    }
    
    
    // Fulfilling Editable Table guarantee that user can not change any field.
    public void fullfillEditableTable(){
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                gameBoardEditable[i][j] = false;
            }
        }
    }
}
