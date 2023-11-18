package com.example.ap_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML
    private ImageView bg;

    @FXML
    private Button btn;

    @FXML
    private ImageView img;

    @FXML
    private AnchorPane pane;

    @FXML
    private Rectangle platform;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome to the game!!");
        btn.setVisible(false);
        platform.setLayoutX(0);
        img.setLayoutX(0);
    }

}
