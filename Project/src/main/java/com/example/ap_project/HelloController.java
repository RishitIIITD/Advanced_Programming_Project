package com.example.ap_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HelloController {

    @FXML
    private Button btn;

    @FXML
    private AnchorPane pane;

    @FXML
    private Label welcomeText;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome to the Game!!");
        btn.setVisible(false);
    }

}
