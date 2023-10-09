package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.languagelearning.Constants.MESSAGE_CORRECT_ANSWER;
import static com.languagelearning.Constants.MESSAGE_WRONG_ANSWER;
import static com.languagelearning.ExcelReader.randomRowNumber;
import static com.languagelearning.ExcelReader.showAnswer;

public class CheckAnswerScreen extends Pane implements Screen {
    private Stage textStage;

    public CheckAnswerScreen(String answer, String resultMessage, int sheetIndex) {
        textStage = new Stage();
        textStage.setTitle("Answer result");

        VBox answerLayout = new VBox(10);
        answerLayout.setAlignment(Pos.CENTER);

        Text yourAnswerLabel = new Text("Your answer:");
        yourAnswerLabel.getStyleClass().add("text-label");

        Text yourAnswer = new Text(answer);
        yourAnswer.getStyleClass().add("text-label");

        Text result = new Text(resultMessage);
        if (resultMessage == MESSAGE_WRONG_ANSWER) {
            result.getStyleClass().add("wrong-result-style");
        } else if (resultMessage == MESSAGE_CORRECT_ANSWER) {
            result.getStyleClass().add("correct-result-style");
        }
        HBox buttonsBox = new HBox(10);
        Button correctAnswerButton = new Button("Show" + "\n\r" + "correct" + "\n\r" + "answer");
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


        Button showRule = new Button("Show" + "\n\r" + "rule");
        showRule.getStyleClass().add("button");

        showRule.setOnAction(e -> {
            RulesScreen rulesScreen = new RulesScreen(sheetIndex);
            navigateToScreen(rulesScreen);
            textStage.close();
        });
        buttonsBox.getChildren().addAll(correctAnswerButton, showRule);
        buttonsBox.setAlignment(Pos.CENTER);
        answerLayout.getChildren().addAll(yourAnswerLabel, yourAnswer, result, buttonsBox);
        Scene textScene = new Scene(answerLayout, 900, 450);
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
