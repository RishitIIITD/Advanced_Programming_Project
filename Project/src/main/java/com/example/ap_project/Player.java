package com.example.ap_project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private ImageView img;
    private double stickLength;
    private boolean isFlipped;

    public Player(ImageView img){
        this.img=img;
    }

    public ImageView getImg(){
        return this.img;
    }

    public void setImg(ImageView img){
        this.img=img;
    }

    public double getStickLength(){
        return this.stickLength;
    }

    public void setStickLength(double length){
        this.stickLength=length;
    }

    public boolean isitFlipped(){
        return this.isFlipped;
    }

    public void Flip(){
        isFlipped=!isFlipped;
    }

    public void moveRight(double Xpos){
        this.img.setLayoutX(Xpos);
    }
    public void extendStick(){

    }
    public void flip(){

    }
}
