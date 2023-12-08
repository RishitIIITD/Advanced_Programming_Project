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
    private double pane_width=360;
    private double pane_height=430;

    @FXML
    private ImageView bg;
    @FXML
    private Label welcomeText;

    //button and look of it
    @FXML
    private Button btn;
    @FXML
    private Circle circle;
    @FXML
    private Text txt;

    //cherry
    @FXML
    private ImageView cherry_icon;
    private Reward reward;
    @FXML
    private Text counter;

    // player
    @FXML
    private ImageView player_icon;
    private Player player;

    //platforms
    @FXML
    private Rectangle primary_platform;
    private Rectangle secondary_platform;
    private double platform_height=119;
    private double platform_layoutY=397;

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
            secondary_platform.setHeight(platform_height);
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
            secondary_platform.setLayoutY(platform_layoutY);
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
            System.out.println("Max X of platform: "+primary_platform.getWidth());
            new_stick.rotate90degrees(primary_platform.getWidth());     // pass width as argument to upperlimit height
            double tip_of_stick=new_stick.getStick().getBoundsInParent().getMaxX();      // steps to move right
            System.out.println(tip_of_stick);
            boolean landed=new_stick.did_land(tip_of_stick, secondary_platform);
            if (landed){
                double steps_to_move=secondary_platform.getBoundsInParent().getMaxX();
                player.moveRight_when_landed(steps_to_move, reward);
            }
            else{
                System.out.println("YOU SHALL NOT LAND");
                player.fall_down(tip_of_stick, pane_height);
                btn.setDisable(true);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        player=new Player(player_icon);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            if (isIncreasing) {
                new_stick.increaseHeight(3,primary_platform.getWidth()); // You can adjust the length increment as needed
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}
