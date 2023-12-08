package com.example.ap_project;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Reward {
    private Image img;
    private ImageView imgv;
    private int points;

    public Reward(){
        img=new Image(getClass().getResourceAsStream("cherry.png"));
        imgv=new ImageView(img);
        imgv.setFitWidth(40);
        imgv.setFitHeight(45);
        imgv.setPickOnBounds(true);
        imgv.setPreserveRatio(true);
    }

    public ImageView getImgv(){
        return this.imgv;
    }

    public void setImgv(ImageView new_cherry){
        this.imgv=new_cherry;
    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int new_points){
        this.points=new_points;
    }

    public void removeCherry(){
        Node parent = imgv.getParent();
        if (parent instanceof javafx.scene.layout.Pane) {
            ((javafx.scene.layout.Pane) parent).getChildren().remove(imgv);
        }
    }
}
