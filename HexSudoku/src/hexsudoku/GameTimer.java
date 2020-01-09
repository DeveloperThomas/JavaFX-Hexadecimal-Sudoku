/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexsudoku;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author Tomasz Zawistowski
 */
public class GameTimer {
    
    private int elapsedTime = 0;
    private final int interval = 1000;
    private Timer timer;
    private String time;
    
    // Label allows GameTimer class to modify GameController's time label.
    private Label timeLabel;
    
    TimerTask task = new TimerTask(){
        @Override
        public void run(){
            elapsedTime += 1;
            time = changeTimeToString();
            // Prevents from exception throwing.
            Platform.runLater(() -> {
                timeLabel.setText(time);
            });
        }
    };
    
    public GameTimer(){}
    
    public void startGameTimer(){
        if(timer == null){
            timer = new Timer();
            timer.schedule(task, 0, interval);
        }
    }
    
    // Invoked by clicking Pause/Resume button.
    public void pauseGameTimer(){
        this.timer.cancel();
    }
    
    // Invoked by clicking Pause/Resume button.
    public void resumeGameTimer(){
        this.timer = new Timer();
        createTimerTask();
        this.timer.schedule(task, 100, interval);
    }
    
    public void stopGameTimer(){
        this.timer.cancel();
        elapsedTime = 0;
    }
    
    public String changeTimeToString(){
        String hours = String.valueOf(this.elapsedTime/3600);
        if(hours.length() == 1){
            String formattedHours = "0" + hours;
            hours = formattedHours;
        }
        
        String minutes = String.valueOf(this.elapsedTime/60);
        if(minutes.length() == 1){
            String formattedMinutes = "0" + minutes;
            minutes = formattedMinutes;
        }
        
        String seconds = String.valueOf(this.elapsedTime%60);
        if(seconds.length() == 1){
            String formattedSeconds = "0" + seconds;
            seconds = formattedSeconds;
        }
        
        String time = hours + " : " + minutes + " : " + seconds;
        return time;
    }
    
    // Method used for recreating TimerTask when resuming Timer object.
    public void createTimerTask(){
        this.task = new TimerTask(){
            @Override
            public void run(){
                elapsedTime += 1;
                time = changeTimeToString();
                // Prevents from exception throwing.
                Platform.runLater(() -> {
                    timeLabel.setText(time);
                });
            }
        };
    }
    
    public void importLabelFromGame(Label label){
        timeLabel = label;
    }
}


