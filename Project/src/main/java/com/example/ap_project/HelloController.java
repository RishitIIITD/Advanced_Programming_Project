package com.example.ap_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView bg;
    @FXML
    private Label welcomeText;

    @FXML
    private Button btn;
    @FXML
    private Circle circle;
    @FXML
    private Text txt;

    @FXML
    private ImageView cherry_icon;
    private Reward reward;
    @FXML
    private Text counter;

    @FXML
    private ImageView player_icon;
    private Player player;

    @FXML
    private Rectangle platform;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
        txt.setText("EXTEND");
        counter.setVisible(true);
        cherry_icon.setVisible(true);
        platform.setLayoutX(0);
        player.getImgv().setLayoutX(0);
        cherry_icon.setVisible(true);
        reward=new Reward();
        pane.getChildren().add(reward.getImgv());
        reward.getImgv().setLayoutX(platform.getBoundsInParent().getMaxX()+20);
        reward.getImgv().setLayoutY(platform.getLayoutY()-57);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player=new Player(player_icon);
    }
}
