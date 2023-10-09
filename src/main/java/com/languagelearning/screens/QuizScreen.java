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

public class QuizScreen extends Pane implements Screen {
    Button exitButton;
    Button backButton;

    public QuizScreen() {
        Button startQuizButton = new Button("Start" + "\n\r" + "Quiz");
        exitButton = new Button("Exit");
        exitButton.setOnAction(e ->
                System.exit(0));
        backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Screen previousScreen = new StartScreen();
            navigateToScreen(previousScreen);
        });
        startQuizButton.setLayoutX(450);
        startQuizButton.setLayoutY(225);
        exitButton.setLayoutX(900);
        exitButton.setLayoutY(400);
        backButton.setLayoutX(0);
        backButton.setLayoutY(400);
        startQuizButton.getStyleClass().add("button");
        getChildren().addAll(startQuizButton, exitButton, backButton);
        getStylesheets().add("styles.css");
        startQuizButton.setOnAction(e -> {
                    startQuizButton.getStyleClass().add("button-pressed");
                    addAdditionalButtons();
                }
        );
    }

    private void addAdditionalButtons() {
        StackPane additionalButtons = new StackPane();
        exitButton.setOnAction(e ->
                System.exit(0));
        backButton.setOnAction(e -> {
            Screen previousScreen = new StartScreen();
            navigateToScreen(previousScreen);
        });
        Button presentSimpleButton = new Button("Present" + "\n\r" + "Simple");
        presentSimpleButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(0);
            navigateToScreen(nextScreen);
        });
        Button pastSimpleButton = new Button("Past" + "\n\r" + "Simple");
        pastSimpleButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(1);
            navigateToScreen(nextScreen);
        });
        Button futureSimpleButton = new Button("Future" + "\n\r" + "Simple");
        futureSimpleButton.getStyleClass().add("button-pressed");
        futureSimpleButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(2);
            navigateToScreen(nextScreen);
        });
        Button presentContinuousButton = new Button("Present" + "\n\r" + "Continuous");
        presentContinuousButton.getStyleClass().add("button-pressed");
        presentContinuousButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(3);
            navigateToScreen(nextScreen);
        });
        Button pastContinuousButton = new Button("Past" + "\n\r" + "Continuous");
        pastContinuousButton.getStyleClass().add("button-pressed");
        pastContinuousButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(4);
            navigateToScreen(nextScreen);
        });
        Button futureContinuousButton = new Button("Future" + "\n\r" + " Continuous");
        futureContinuousButton.getStyleClass().add("button-pressed");
        futureContinuousButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(5);
            navigateToScreen(nextScreen);
        });
        Button presentPerfectButton = new Button("Present" + "\n\r" + "Perfect");
        presentPerfectButton.getStyleClass().add("button-pressed");
        presentPerfectButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(6);
            navigateToScreen(nextScreen);
        });
        Button pastPerfectButton = new Button("Past" + "\n\r" + "Perfect");
        pastPerfectButton.getStyleClass().add("button-pressed");
        pastPerfectButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(7);
            navigateToScreen(nextScreen);
        });
        Button futurePerfectButton = new Button("Future" + "\n\r" + "Perfect");
        futurePerfectButton.getStyleClass().add("button-pressed");
        futurePerfectButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(8);
            navigateToScreen(nextScreen);
        });


        double centerX = 450;
        double centerY = 225;
        double radius = 150;

        presentSimpleButton.setLayoutX(centerX);
        presentSimpleButton.setLayoutY(centerY);
        pastSimpleButton.setLayoutX(centerX);
        pastSimpleButton.setLayoutY(centerY);
        futureSimpleButton.setLayoutX(centerX);
        futureSimpleButton.setLayoutY(centerY);
        presentContinuousButton.setLayoutX(centerX);
        presentContinuousButton.setLayoutY(centerY);
        pastContinuousButton.setLayoutX(centerX);
        pastContinuousButton.setLayoutY(centerY);
        futureContinuousButton.setLayoutX(centerX);
        futureContinuousButton.setLayoutY(centerY);
        presentPerfectButton.setLayoutX(centerX);
        presentPerfectButton.setLayoutY(centerY);
        pastPerfectButton.setLayoutX(centerX);
        pastPerfectButton.setLayoutY(centerY);
        futurePerfectButton.setLayoutX(centerX);
        futurePerfectButton.setLayoutY(centerY);

        Pane buttonContainer = new Pane();
        buttonContainer.setPrefSize(1000, 500);
        buttonContainer.getChildren().addAll(presentSimpleButton, pastSimpleButton, futureSimpleButton,
                presentContinuousButton, pastContinuousButton, futureContinuousButton,
                presentPerfectButton, pastPerfectButton, futurePerfectButton,
                exitButton, backButton);
        additionalButtons.getChildren().add(buttonContainer);
        additionalButtons.setAlignment(Pos.CENTER);
        double angleIncrement = 360.0 / 9;

        getChildren().add(additionalButtons);
        addFadeInAnimation(presentSimpleButton);
        addFadeInAnimation(pastSimpleButton);
        addFadeInAnimation(futureSimpleButton);
        addFadeInAnimation(presentContinuousButton);
        addFadeInAnimation(pastContinuousButton);
        addFadeInAnimation(futureContinuousButton);
        addFadeInAnimation(presentPerfectButton);
        addFadeInAnimation(pastPerfectButton);
        addFadeInAnimation(futurePerfectButton);
        positionButton(presentSimpleButton, centerX, centerY, radius, 0);
        positionButton(pastSimpleButton, centerX, centerY, radius, angleIncrement);
        positionButton(futureSimpleButton, centerX, centerY, radius, angleIncrement * 2);
        positionButton(presentContinuousButton, centerX, centerY, radius, angleIncrement * 3);
        positionButton(pastContinuousButton, centerX, centerY, radius, angleIncrement * 4);
        positionButton(futureContinuousButton, centerX, centerY, radius, angleIncrement * 5);
        positionButton(presentPerfectButton, centerX, centerY, radius, angleIncrement * 6);
        positionButton(pastPerfectButton, centerX, centerY, radius, angleIncrement * 7);
        positionButton(futurePerfectButton, centerX, centerY, radius, angleIncrement * 8);
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
        Scene nextScene = new Scene((Parent) nextScreen, 1000, 500);
        stage.setScene(nextScene);
        stage.show();
    }
}
