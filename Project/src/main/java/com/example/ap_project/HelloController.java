package com.example.ap_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    @FXML
    private ImageView bg;

    @FXML
    private Button btn;

    private Player player;

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
        btn.setText("Extend the stick");
        platform.setLayoutX(0);
        player.getImg().setLayoutX(platform.getLayoutX());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player=new Player(img);
    }
}
