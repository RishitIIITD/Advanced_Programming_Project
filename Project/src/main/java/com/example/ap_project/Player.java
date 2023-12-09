package com.example.ap_project;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

// Implemented Singleton Pattern
public class Player {
    private static Player instance;     // public static instance
    private ImageView imgv;
    private boolean isFlipped;
    public static final double player_width=60;
    public static final double player_height=80;

    private Player(ImageView imgv) {        // private constructor
        this.imgv = imgv;
    }

    // Public method to get the single instance
    public static Player getInstance(ImageView imgv) {      // public static getInstance() method
        if (instance == null) {
            instance = new Player(imgv);
        }
        return instance;
    }

    public ImageView getImgv(){
        return this.imgv;
    }

    public boolean isItFlipped(){
        return this.isFlipped;
    }

    public void Flip(){
        isFlipped=!isFlipped;
    }

    public void moveRight_when_landed(double Xpos, Reward reward, Pane pane, int ct, Text text){
        double currentX = this.getImgv().getX();
        double destinationX = Xpos - player_width;

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(.5), this.getImgv());
        translateTransition.setToX(destinationX);
        translateTransition.setFromX(currentX);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), event -> {
            checkAndHandleRewardCollision(reward, pane, ct, text);
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Play the translation transition
        translateTransition.play();

        translateTransition.setOnFinished(event -> {
            System.out.println("Moved right: " + Xpos);
            timeline.stop(); // Stop the timeline when the translation is finished
            checkAndHandleRewardCollision(reward, pane, ct, text);
        });
    }

    private void checkAndHandleRewardCollision(Reward reward, Pane pane, int ct, Text text) {
        if (this.getImgv().getBoundsInParent().intersects(reward.getImgv().getBoundsInParent())) {
            System.out.println("Before score: "+ct);
            ct++;       // increment the counter
            text.setText(String.valueOf(ct));       // set as the score
            System.out.println("After score: "+ct);
            reward.getImgv().setVisible(false);
            reward.removeCherry(pane);
        }
    }

    public void fall_down(double Xpos, double bottom){
        double currentX=this.imgv.getX();
        double destinationX=Xpos;

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(.5), this.imgv);
        translateTransition.setToX(destinationX);
        translateTransition.setFromX(currentX);

        double currentY=this.imgv.getY();
        double destinationY=bottom-300;

        translateTransition.setToY(destinationY);
        translateTransition.setFromY(currentY);

        translateTransition.play();

        System.out.println("GAME OVER");
    }

    public void flip(){

    }
}
