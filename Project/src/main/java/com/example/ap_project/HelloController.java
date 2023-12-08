package com.example.ap_project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
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
    private Rectangle primary_platform;
    private Rectangle secondary_platform;

    private boolean clicked_play=false;

    private Stick new_stick;

    private boolean isIncreasing=false;

    Random rand=new Random();

    @FXML
    void onHelloButtonClick(MouseEvent event) {
        bg.setVisible(false);
        welcomeText.setVisible(false);
        txt.setText("EXTEND");
        counter.setVisible(true);
        cherry_icon.setVisible(true);

        primary_platform.setLayoutX(0);
        player.getImgv().setLayoutX(0);

        reward=new Reward();
        pane.getChildren().add(reward.getImgv());
        reward.getImgv().setLayoutX(primary_platform.getBoundsInParent().getMaxX()+20);
        reward.getImgv().setLayoutY(primary_platform.getLayoutY()-57);

        if (clicked_play==false) {      // to ensure that only 1 platform is generated at a time. may change
            System.out.println(clicked_play);
            // creating new platform
            secondary_platform = new Rectangle();
            secondary_platform.setHeight(119);
            double gap = primary_platform.getBoundsInParent().getMaxX() + 20;
            double high = rand.nextDouble(360 - gap + 1) + gap;
            double low = rand.nextDouble(high - gap + 1) + gap;
            double width;
            if (high - low < 20) {       // minimum width should be 20
                width = 20;
            } else {
                width = high - low;
            }
            secondary_platform.setWidth(width);
            secondary_platform.setLayoutX(low);
            secondary_platform.setLayoutY(397);
            pane.getChildren().add(secondary_platform);
            System.out.println("Created a second platform");
        }
        clicked_play=true;

        new_stick=new Stick(primary_platform.getBoundsInParent().getMaxX());
        btn.setOnMousePressed(mouseEvent -> {
            pane.getChildren().add(new_stick.getStick());
            isIncreasing=true;
        });
        btn.setOnMouseReleased(mouseEvent -> {
            isIncreasing=false;
            new_stick.rotate90degrees();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player=new Player(player_icon);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            if (isIncreasing) {
                new_stick.increaseHeight(5); // You can adjust the length increment as needed
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}
