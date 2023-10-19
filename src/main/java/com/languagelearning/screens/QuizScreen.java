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
        startQuizButton.setLayoutX((double) (sceneX - 100) / 2);
        startQuizButton.setLayoutY((double) (sceneY - 100) / 2);
        exitButton.setLayoutX(sceneX - 100);
        exitButton.setLayoutY(sceneY - 100);
        backButton.setLayoutX(0);
        backButton.setLayoutY(sceneY - 100);
        startQuizButton.getStyleClass().add("button");
        getChildren().addAll(startQuizButton, exitButton, backButton);
        getStylesheets().add("styles.css");
        startQuizButton.setOnAction(e -> {
                    startQuizButton.setDisable(true);
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
        Button idiomsButton = new Button("IDIOMS");
        idiomsButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(9);
            navigateToScreen(nextScreen);
        });
        Button irregularVerbsButton = new Button("Irregular" + "\n\r" + "Verbs");
        irregularVerbsButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(10);
            navigateToScreen(nextScreen);
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
        futureSimpleButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(2);
            navigateToScreen(nextScreen);
        });
        Button presentContinuousButton = new Button("Present" + "\n\r" + "Continuous");
        presentContinuousButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(3);
            navigateToScreen(nextScreen);
        });
        Button pastContinuousButton = new Button("Past" + "\n\r" + "Continuous");
        pastContinuousButton.setOnAction(e -> {
            Screen nextScreen = new QuizRunnerScreen(4);
            navigateToScreen(nextScreen);
        });
        Button futureContinuousButton = new Button("Future" + "\n\r" + " Continuous");
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


        double centerX = (double) (sceneX - 100) / 2;
        double centerY = (double) (sceneY - 100) / 2;

        double radius1 = 100;
        double radius2 = 200;

        idiomsButton.setLayoutX(centerX);
        idiomsButton.setLayoutY(centerY);
        irregularVerbsButton.setLayoutX(centerX);
        irregularVerbsButton.setLayoutY(centerY);
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
        buttonContainer.setPrefSize(sceneX, sceneY);
        buttonContainer.getChildren().addAll(idiomsButton, irregularVerbsButton, presentSimpleButton, pastSimpleButton, futureSimpleButton,
                presentContinuousButton, pastContinuousButton, futureContinuousButton,
                presentPerfectButton, pastPerfectButton, futurePerfectButton,
                exitButton, backButton);
        additionalButtons.getChildren().add(buttonContainer);
        additionalButtons.setAlignment(Pos.CENTER);
        double angleIncrement = 360.0 / 9;
        getChildren().add(additionalButtons);
        addFadeInAnimation(idiomsButton);
        addFadeInAnimation(irregularVerbsButton);
        addFadeInAnimation(presentSimpleButton);
        addFadeInAnimation(pastSimpleButton);
        addFadeInAnimation(futureSimpleButton);
        addFadeInAnimation(presentContinuousButton);
        addFadeInAnimation(pastContinuousButton);
        addFadeInAnimation(futureContinuousButton);
        addFadeInAnimation(presentPerfectButton);
        addFadeInAnimation(pastPerfectButton);
        addFadeInAnimation(futurePerfectButton);
        positionButton(idiomsButton, centerX, centerY, radius1, 0);
        positionButton(irregularVerbsButton, centerX, centerY, radius1, 180);
        positionButton(presentSimpleButton, centerX, centerY, radius2, 0);
        positionButton(pastSimpleButton, centerX, centerY, radius2, angleIncrement);
        positionButton(futureSimpleButton, centerX, centerY, radius2, angleIncrement * 2);
        positionButton(presentContinuousButton, centerX, centerY, radius2, angleIncrement * 3);
        positionButton(pastContinuousButton, centerX, centerY, radius2, angleIncrement * 4);
        positionButton(futureContinuousButton, centerX, centerY, radius2, angleIncrement * 5);
        positionButton(presentPerfectButton, centerX, centerY, radius2, angleIncrement * 6);
        positionButton(pastPerfectButton, centerX, centerY, radius2, angleIncrement * 7);
        positionButton(futurePerfectButton, centerX, centerY, radius2, angleIncrement * 8);
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
