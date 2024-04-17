package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.languagelearning.Constants.*;
import static com.languagelearning.ExcelReader.randomRowNumber;
import static com.languagelearning.ExcelReader.showAnswer;

public class CheckAnswerScreen extends Pane implements Screen {
    private Stage textStage;

    public CheckAnswerScreen(String answer, String resultMessage, int sheetIndex) {
        textStage = new Stage();
        textStage.setTitle("Answer result");

        VBox answerResultScreen = new VBox();

        HBox header = new HBox();
        header.setAlignment(Pos.TOP_LEFT);
        Button backButton = new Button("Close");
        backButton.getStyleClass().add("exitButton");
        backButton.setOnAction(e -> {
            textStage.close();
        });

        VBox answerLayout = new VBox(30);
        answerLayout.setAlignment(Pos.CENTER);
        Text yourAnswerLabel = new Text("Your answer:");
        yourAnswerLabel.getStyleClass().add("text-label");
        Text yourAnswer = new Text(answer);
        yourAnswer.getStyleClass().add("text-label");
        Text result = new Text(resultMessage);
        ImageView imageView = new ImageView();
        Image image = null;
        if (resultMessage.equals(MESSAGE_WRONG_ANSWER)) {
            result.getStyleClass().add("wrong-result-style");
            image = new Image(FILE_PATH_WRONG_ANSWER);
        } else if (resultMessage.equals(MESSAGE_CORRECT_ANSWER)) {
            result.getStyleClass().add("correct-result-style");
            image = new Image(FILE_PATH_CORRECT_ANSWER);
        }
        imageView.setImage(image);
        HBox imageBox = new HBox(10);
        imageBox.getChildren().add(imageView);
        imageBox.setAlignment(Pos.CENTER);
        imageBox.maxHeight(10);
        imageBox.maxWidth(10);
        HBox buttonsBox = new HBox(10);
        Button correctAnswerButton = new Button("Correct answer");
        correctAnswerButton.getStyleClass().add("button");
        Text correctAnswerLabel = new Text("Correct answer:");
        correctAnswerLabel.getStyleClass().add("text-label");
        Text correctAnswer = new Text(showAnswer(sheetIndex, randomRowNumber));
        correctAnswer.getStyleClass().add("text-label");
        correctAnswerButton.setOnAction(e -> {
            int buttonsBoxIndex = answerLayout.getChildren().indexOf(buttonsBox);
            if (buttonsBoxIndex != -1) {
                VBox correctAnswerBox = new VBox(10);
                correctAnswerBox.setAlignment(Pos.CENTER);
                correctAnswerBox.getChildren().addAll(correctAnswerLabel, correctAnswer);
                answerLayout.getChildren().set(buttonsBoxIndex, correctAnswerBox);
            }
        });

        Button showRule = new Button("Rule");
        showRule.getStyleClass().add("button");
        showRule.setOnAction(e -> {
            RulesScreen rulesScreen = new RulesScreen(sheetIndex);
            navigateToScreen(rulesScreen);
            textStage.close();
        });
        buttonsBox.getChildren().addAll(correctAnswerButton, showRule);
        buttonsBox.setAlignment(Pos.CENTER);
        header.getChildren().addAll(backButton);
        answerLayout.getChildren().addAll(yourAnswerLabel, yourAnswer, result, imageBox, buttonsBox);
        answerResultScreen.getChildren().addAll(header, answerLayout);
        answerResultScreen.setStyle(IMAGE_PATH_SCHOOL_BOARD);
        Scene textScene = new Scene(answerResultScreen, 900, 450);
        textScene.getStylesheets().add("styles.css");
        textStage.setScene(textScene);
        textStage.show();
    }

    public void show() {
        textStage.show();
    }

    @Override
    public void navigateToScreen(Screen nextScreen) {
        Scene scene = textStage.getScene();
        if (scene != null) {
            Stage stage = (Stage) scene.getWindow();
            Scene nextScene = new Scene((Parent) nextScreen, 1000, 500);
            stage.setScene(nextScene);
            stage.show();
        }
    }
}
