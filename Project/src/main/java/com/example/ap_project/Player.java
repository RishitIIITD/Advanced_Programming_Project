package com.example.ap_project;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Player {
    private ImageView imgv;
    private double stickLength;
    private boolean isFlipped;
    public static final double player_width=60;
    public static final double player_height=80;

    public Player(ImageView imgv){
        this.imgv=imgv;
    }

    public ImageView getImgv(){
        return this.imgv;
    }

    public void setImgv(ImageView new_img){
        this.imgv=new_img;
    }

    public double getStickLength(){
        return this.stickLength;
    }

    public void setStickLength(double new_length){
        this.stickLength=new_length;
    }

    public boolean isitFlipped(){
        return this.isFlipped;
    }

    public void Flip(){
        isFlipped=!isFlipped;
    }

    public void moveRight_when_landed(double Xpos){
        double currentX = this.imgv.getX();
        double destinationX = Xpos - player_width;

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(.5), this.imgv);
        translateTransition.setToX(destinationX);
        translateTransition.setFromX(currentX);

        translateTransition.play();

        System.out.println("Moved right: "+Xpos);
    }

    public void moveRight_when_failed(double Xpos){
        double currentX=this.imgv.getX();
        double destinationX=Xpos;

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(.5), this.imgv);
        translateTransition.setToX(destinationX);
        translateTransition.setFromX(currentX);

        translateTransition.play();

        System.out.println("Moved right: "+Xpos);
    }

    public void fall_down(double bottom){
        double currentY=this.imgv.getY();
        double destinationY=bottom-300;

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(.5), this.imgv);
        translateTransition.setToY(destinationY);
        translateTransition.setFromY(currentY);

        translateTransition.play();

        System.out.println("GAME OVER");
    }

    public void flip(){

    }
}
