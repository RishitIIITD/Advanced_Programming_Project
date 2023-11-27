package com.example.ap_project;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public class Stick extends Node {
    private Rectangle stick;
    private double height = 10;
    private final double width = 5;
    private final int Y_coord = 386;

    public Stick(double platform_max_X) {
        stick = new Rectangle(width, height);
        stick.setLayoutY(Y_coord); // Adjust the layoutY to set the top of the stick
        stick.setLayoutX(platform_max_X - 5);
    }

    public Rectangle getStick() {
        return this.stick;
    }

    public void increaseHeight(double increment) {
        height += increment;
        stick.setHeight(height);
        stick.setLayoutY(stick.getLayoutY() - increment); // Move the stick upwards
    }
}
