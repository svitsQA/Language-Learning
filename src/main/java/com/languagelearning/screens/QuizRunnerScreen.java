package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.languagelearning.ExcelReader.*;

public class QuizRunnerScreen extends Pane implements Screen {
    TextField answerInputField;
    CheckAnswerScreen checkAnswerScreen;
    VBox taskBox;

    public QuizRunnerScreen(int sheetIndex) {
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e ->
                System.exit(0));
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            Screen nextScreen = new QuizScreen();
            navigateToScreen(nextScreen);
        });
        exitButton.setLayoutX(900);
        exitButton.setLayoutY(400);
        backButton.setLayoutX(0);
        backButton.setLayoutY(400);
        getStylesheets().add("styles.css");
        getTask(sheetIndex);
        taskBox.setLayoutX(250);
        taskBox.setLayoutY(150);
        getChildren().addAll(backButton, exitButton, taskBox);
    }


    @Override
    public void navigateToScreen(Screen nextScreen) {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        Scene nextScene = new Scene((Parent) nextScreen, 1000, 500);
        stage.setScene(nextScene);
        stage.show();
    }

    private Node getTask(int sheetIndex) {
        Text taskText = new Text("Task");
        taskText.setFont(Font.font("Arial", FontWeight.BOLD, 28));

        taskText.setFill(Color.WHITE);
        Text task = new Text(getTask(sheetIndex, 0));
        task.setWrappingWidth(500);
        task.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        task.setFill(Color.WHITESMOKE);
        Text taskSentence = new Text(getTask(sheetIndex, 1));
        taskSentence.setWrappingWidth(500);
        taskSentence.setFont(Font.font("Arial", 16));
        taskSentence.setFill(Color.SNOW);
        answerInputField = new TextField();
        answerInputField.setMaxWidth(500);
        answerInputField.setPromptText("Enter your answer");
        Button submitButton = new Button("Submit" + "\n\r" + "answer");
        submitButton.getStyleClass().add("button");
        Button nextTask = new Button("Next" + "\n\r" + "task");
        nextTask.getStyleClass().add("button");
        nextTask.setOnAction(e -> {
            task.setText(getTask(sheetIndex, 0));
            taskSentence.setText(getTask(sheetIndex, 1));
            answerInputField.clear();
        });
        HBox buttonsBox = new HBox();
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(10);
        buttonsBox.getChildren().addAll(submitButton, nextTask);
        submitButton.setOnAction(e -> {
            String answer = answerInputField.getText();
            String resultMessage;
            try {
                resultMessage = checkAnswer(sheetIndex, randomRowNumber, answer);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            checkAnswerScreen = new CheckAnswerScreen(answer, resultMessage, sheetIndex);
            checkAnswerScreen.show();
        });
        taskBox = new VBox(taskText, task, taskSentence, answerInputField, buttonsBox);
        taskBox.setSpacing(10);
        taskBox.setAlignment(Pos.CENTER);
        return taskBox;
    }

    public static String getTask(int sheetIndex, int columnIndex) {
        getRandomRowNumber(sheetIndex);
        readExcel(sheetIndex, randomRowNumber, columnIndex);
        return cellValue;
    }
}

