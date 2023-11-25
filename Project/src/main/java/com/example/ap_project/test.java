package com.example.ap_project;

import javafx.application.Application;      // this abstract class is entry point for javafx applications
// it executes user application and processes input events
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;      // container for all content in a scene graph
import javafx.stage.Stage;      // Top level javafx container

import java.io.IOException;

public class test extends Application {     // main class extends Application
    @Override
    public void start(Stage stage) throws IOException {     // start method is main entry point for javafx applications
        Parent root= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setScene(new Scene(root,360,516));
        stage.setTitle("Stick Hero Game");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
