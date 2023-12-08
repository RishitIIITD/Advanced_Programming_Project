package com.example.ap_project;

import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Stick extends Node {
    private Rectangle stick;
    private double height = 10;
    private final double width = 5;
    private final int Y_coord = 386;

    public Stick(double platform_max_X) {
        stick = new Rectangle(width, height);
        stick.setLayoutY(Y_coord);      // Adjust the layoutY to set the top of the stick
        stick.setLayoutX(platform_max_X - 5);
    }

    public Rectangle getStick() {
        return this.stick;
    }

    public void increaseHeight(double increment) {
        if (this.height<360) {
            height += increment;
            stick.setHeight(height);
            stick.setLayoutY(stick.getLayoutY() - increment); // Move the stick upwards
        }
    }

    public void rotate90degrees(){
        System.out.println("Before rotation:");
        System.out.println("Top of stick: "+this.getStick().getBoundsInParent().getMinY());
        System.out.println("Bottom of stick: "+this.getStick().getBoundsInParent().getMaxY());

        System.out.println("Left of stick: "+this.getStick().getBoundsInParent().getMinX());
        System.out.println("Right of stick: "+this.getStick().getBoundsInParent().getMaxX());
        System.out.println();

        Rotate r=new Rotate();

        r.setAngle(90);

        stick.getTransforms().add(r);

        stick.setLayoutX(80+stick.getHeight());
        stick.setLayoutY(397-6);

        System.out.println("After rotation:");
        System.out.println("Top of stick: "+this.getStick().getBoundsInParent().getMinY());
        System.out.println("Bottom of stick: "+this.getStick().getBoundsInParent().getMaxY());

        System.out.println("Left of stick: "+this.getStick().getBoundsInParent().getMinX());
        System.out.println("Right of stick: "+this.getStick().getBoundsInParent().getMaxX());
        System.out.println();
    }
}
