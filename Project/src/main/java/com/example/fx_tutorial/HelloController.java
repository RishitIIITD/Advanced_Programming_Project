package com.example.fx_tutorial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
     // System.out.println("Welcome to JavaFX Application!"); would have printed it on console
    }
}