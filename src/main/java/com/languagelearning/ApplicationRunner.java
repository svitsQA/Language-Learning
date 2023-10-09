package com.languagelearning;

import com.languagelearning.screens.StartScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static com.languagelearning.Screen.sceneX;
import static com.languagelearning.Screen.sceneY;

public class ApplicationRunner extends Application {

    public void start(Stage primaryStage) {
        StartScreen startScreen = new StartScreen();
        StackPane root = new StackPane();
        root.getChildren().addAll(startScreen);
        Scene scene = new Scene(root, sceneX, sceneY);
        scene.getStylesheets().add("styles.css");
        primaryStage.setTitle("English learning!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
