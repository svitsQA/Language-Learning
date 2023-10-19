package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartScreen extends Pane implements Screen {

    Button startButton;
    Button exitButton;

    public StartScreen() {
        startButton = new Button("Start");
        startButton.setLayoutX(((double) sceneX / 2) - 50);
        startButton.setLayoutY(((double) sceneY / 2) - 50);
        exitButton = new Button("Exit");
        exitButton.setLayoutX(sceneX - 100);
        exitButton.setLayoutY(sceneY - 100);
        exitButton.setOnAction(e ->
                System.exit(0));
        startButton.getStyleClass().add("button");
        getChildren().addAll(startButton, exitButton);
        getStylesheets().add("styles.css");
        startButton.setOnAction(e -> {
                    startButton.setDisable(true);
                    addAdditionalButtons();
                }
        );
    }

    private void addAdditionalButtons() {
        StackPane additionalButtons = new StackPane();
        exitButton.setOnAction(e ->
                System.exit(0));
        Button accountButton = new Button("Account");
        accountButton.getStyleClass().add("button-pressed");
        Button quizButton = new Button("Quiz");
        quizButton.setOnAction(e -> {
            Screen nextScreen = new QuizScreen();
            navigateToScreen(nextScreen);
        });
        Button grammarButton = new Button("Grammar");
        grammarButton.getStyleClass().add("button-pressed");

        double centerX = (double) (sceneX - 100) / 2;
        double centerY = (double) (sceneY - 100) / 2;
        double radius = 110;

        accountButton.setLayoutX(centerX);
        accountButton.setLayoutY(centerY);

        quizButton.setLayoutX(centerX);
        quizButton.setLayoutY(centerY);

        grammarButton.setLayoutX(centerX);
        grammarButton.setLayoutY(centerY);

        Pane buttonContainer = new Pane();
        buttonContainer.setPrefSize(sceneX, sceneY);
        buttonContainer.getChildren().addAll(accountButton, quizButton, grammarButton, exitButton);
        additionalButtons.getChildren().add(buttonContainer);
        additionalButtons.setAlignment(Pos.CENTER);

        getChildren().add(additionalButtons);
        addFadeInAnimation(accountButton);
        addFadeInAnimation(quizButton);
        addFadeInAnimation(grammarButton);
        positionButton(accountButton, centerX, centerY, radius, 270);
        positionButton(quizButton, centerX, centerY, radius, 0);
        positionButton(grammarButton, centerX, centerY, radius, 180);
    }

    private void positionButton(Button button, double centerX, double centerY, double radius, double angle) {
        double x = centerX + radius * Math.cos(Math.toRadians(angle));
        double y = centerY + radius * Math.sin(Math.toRadians(angle));
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), button);
        translateTransition.setToX(x - centerX);
        translateTransition.setToY(y - centerY);
        translateTransition.play();
    }


    private void addFadeInAnimation(Button button) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), button);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), button);
        translateTransition.setToX(0);
        translateTransition.setToY(0);
        translateTransition.play();
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
