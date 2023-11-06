package com.languagelearning;

import com.languagelearning.screens.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static com.languagelearning.Screen.sceneX;
import static com.languagelearning.Screen.sceneY;

public class ApplicationRunner extends Application {

    public void start(Stage primaryStage) {

        MainMenu menu = new MainMenu();
        StackPane root = new StackPane(menu);
        root.getChildren().addAll();
        Scene scene = new Scene(root, sceneX, sceneY);
        scene.getStylesheets().add("styles.css");
        primaryStage.setResizable(false);
        primaryStage.setTitle("English learning!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
