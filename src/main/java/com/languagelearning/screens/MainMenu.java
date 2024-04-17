package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenu extends Pane implements Screen {
    public MainMenu() {

        Menu accountMenuItem = new Menu("Account");
        Menu quizMenuItem = new Menu("Quiz");
        Menu grammarMenuItem = new Menu("Grammar");

        MenuItem idiomsMenuItem = new MenuItem("IDIOMS");
        idiomsMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(9);
            navigateToScreen(nextScreen);
        });
        idiomsMenuItem.setGraphic(null);
        MenuItem irregularVerbsMenuItem = new MenuItem("Irregular verbs");
        irregularVerbsMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(10);
            navigateToScreen(nextScreen);
        });
        MenuItem presentSimpleMenuItem = new MenuItem("Present Simple");
        presentSimpleMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(0);
            navigateToScreen(nextScreen);
        });
        MenuItem pastSimpleMenuItem = new MenuItem("Past Simple");
        pastSimpleMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(1);
            navigateToScreen(nextScreen);
        });
        MenuItem futureSimpleMenuItem = new MenuItem("Future Simple");
        futureSimpleMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(2);
            navigateToScreen(nextScreen);
        });
        MenuItem presentContinuousMenuItem = new MenuItem("Present Continuous");
        presentContinuousMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(3);
            navigateToScreen(nextScreen);
        });
        MenuItem pastContinuousMenuItem = new MenuItem("Past Continuous");
        pastContinuousMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(4);
            navigateToScreen(nextScreen);
        });
        MenuItem futureContinuousMenuItem = new MenuItem("Future Continuous");
        futureContinuousMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(5);
            navigateToScreen(nextScreen);
        });
        MenuItem presentPerfectMenuItem = new MenuItem("Present Perfect");
        presentPerfectMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(6);
            navigateToScreen(nextScreen);
        });
        MenuItem pastPerfectMenuItem = new MenuItem("Past Perfect");
        pastPerfectMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(7);
            navigateToScreen(nextScreen);
        });
        MenuItem futurePerfectMenuItem = new MenuItem("Future Perfect");
        futurePerfectMenuItem.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(8);
            navigateToScreen(nextScreen);
        });

        quizMenuItem.getItems().addAll(idiomsMenuItem, irregularVerbsMenuItem, presentSimpleMenuItem, pastSimpleMenuItem, futureSimpleMenuItem,
                presentContinuousMenuItem, pastContinuousMenuItem, futureContinuousMenuItem, presentPerfectMenuItem, pastPerfectMenuItem, futurePerfectMenuItem);

        Menu menu = new Menu("Menu");
        Button exitButton = new Button("Exit");
        exitButton.getStyleClass().add("exitButton");
        exitButton.setLayoutX(81);
        exitButton.setOnAction(e -> {
            Scene scene = getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.close();
        });

        MenuBar menuBar = new MenuBar();
        menu.getItems().addAll(accountMenuItem, quizMenuItem, grammarMenuItem);
        menuBar.getMenus().addAll(menu);
        getChildren().addAll(menuBar, exitButton);
    }

    @Override
    public void navigateToScreen(Screen nextScreen) {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        Scene nextScene = new Scene((Parent) nextScreen, sceneX, sceneY);
        stage.setScene(nextScene);
        stage.show();
    }
}
