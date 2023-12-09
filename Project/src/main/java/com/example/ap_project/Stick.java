package com.example.ap_project;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Stick extends Node {
    private Rectangle stick;
    private double height = 10;
    private static final double width = 5;
    private static final int Y_coord = 386;

    public Stick(double platform_max_X) {
        stick = new Rectangle(width, height);
        stick.setLayoutY(Y_coord);      // Adjust the layoutY to set the top of the stick
        stick.setLayoutX(platform_max_X - 5);
    }

    public Rectangle getStick() {
        return this.stick;
    }

    public void increaseHeight(double increment, double X_coord) {
        if (this.height<360-X_coord) {      // increase as much so that horizontally it just touches the frame
            height += increment;
            stick.setHeight(height);
            stick.setLayoutY(stick.getLayoutY() - increment); // Move the stick upwards
        }
    }

    public void rotate90degrees(double X_coord){        // width of primary_platform
        System.out.println("Before rotation:");
        System.out.println("Top of stick: "+this.getStick().getBoundsInParent().getMinY());
        System.out.println("Bottom of stick: "+this.getStick().getBoundsInParent().getMaxY());

        System.out.println("Left of stick: "+this.getStick().getBoundsInParent().getMinX());
        System.out.println("Right of stick: "+this.getStick().getBoundsInParent().getMaxX());
        System.out.println();

        Rotate r=new Rotate();

        r.setAngle(90);

        stick.getTransforms().add(r);

        stick.setLayoutX(X_coord+stick.getHeight());        // offset to increase
        stick.setLayoutY(397-6);        // LayoutY of platform - width of thin stick(5) -1(to make separation visible)

        System.out.println("After rotation:");
        System.out.println("Top of stick: "+this.getStick().getBoundsInParent().getMinY());
        System.out.println("Bottom of stick: "+this.getStick().getBoundsInParent().getMaxY());

        System.out.println("Left of stick: "+this.getStick().getBoundsInParent().getMinX());
        System.out.println("Right of stick: "+this.getStick().getBoundsInParent().getMaxX());
        System.out.println();
    }

    public boolean did_land(double tip, Rectangle sec_platform){
        double min=sec_platform.getBoundsInParent().getMinX();
        double max=sec_platform.getBoundsInParent().getMaxX();
        System.out.println("MIN: "+min);
        System.out.println("MAX: "+max);
        if (min<=tip && tip <=max){
            return true;
        }
        return false;
    }

    public void removeStick(Pane pane){
        pane.getChildren().remove(this.getStick());
    }
}
