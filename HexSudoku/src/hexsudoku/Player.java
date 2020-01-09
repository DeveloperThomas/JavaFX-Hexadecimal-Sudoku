/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexsudoku;

import java.io.Serializable;

/**
 *
 * @author Tomasz Zawistowski
 */
public class Player implements Serializable {
    
    private String playerLogin;
    private String playerPassword;
    
    public Player(String login, String password){
        this.playerLogin = login;
        this.playerPassword = password;
    }
    
    public String getPlayerLogin(){
        return playerLogin;
    }
    
    public String getPlayerPassword(){
        return playerPassword;
    }
}
