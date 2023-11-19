package com.example.ap_project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

<<<<<<< Updated upstream
public class    Player {
    private Image img;
=======
public class Player {
>>>>>>> Stashed changes
    private ImageView imgv;
    private double stickLength;
    private boolean isFlipped;

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

    public void moveRight(double Xpos){
        this.imgv.setLayoutX(Xpos);
    }
    public void extendStick(){

    }
    public void flip(){

    }
}
