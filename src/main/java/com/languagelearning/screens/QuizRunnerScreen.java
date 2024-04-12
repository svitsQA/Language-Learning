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

import static com.languagelearning.Constants.FILE_PATH_XLSX;
import static com.languagelearning.ExcelReader.*;

public class QuizRunnerScreen extends Pane implements Screen {
    TextField answerInputField;
    CheckAnswerScreen checkAnswerScreen;
    VBox taskBox;

    public QuizRunnerScreen(int sheetIndex) {
        MainMenu menu = new MainMenu();
        getStylesheets().add("styles.css");
        getTask(sheetIndex);
        taskBox.setLayoutX(250);
        taskBox.setLayoutY(150);
        getChildren().addAll(
                menu,
                taskBox);
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
        answerInputField.setMinSize(500, 40);
        answerInputField.setMaxWidth(500);
        answerInputField.setPromptText("Enter your answer");


        Button clearButton = new Button("X");
        clearButton.getStyleClass().add("clearInputField");
        clearButton.setOnAction(e -> answerInputField.clear());
        HBox fieldContainer = new HBox(answerInputField, clearButton);
        clearButton.setFocusTraversable(false);
        fieldContainer.setAlignment(Pos.CENTER);
        Button submitButton = new Button("Submit answer");
        submitButton.getStyleClass().add("button");
        Button nextTask = new Button("Next task");
        nextTask.getStyleClass().add("button");
        Button showRule = new Button("Rule");
        showRule.getStyleClass().add("button");
        showRule.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(sheetIndex);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
        });
        nextTask.setOnAction(e -> {
            task.setText(getTask(sheetIndex, 0));
            taskSentence.setText(getTask(sheetIndex, 1));
            answerInputField.clear();
        });
        HBox buttonsBox = new HBox();
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(10);
        if (sheetIndex>=9 ){
            buttonsBox.getChildren().addAll(submitButton, nextTask);
        }else{
        buttonsBox.getChildren().addAll(submitButton, nextTask, showRule);
        }
        submitButton.disableProperty().bind(
                answerInputField.textProperty().isEmpty());
        submitButton.setOnAction(e -> {
            String answer = answerInputField.getText();
            String resultMessage;
            if (!answer.isEmpty()){
            try {
                resultMessage = checkAnswer(sheetIndex, randomRowNumber, answer);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            checkAnswerScreen = new CheckAnswerScreen(answer, resultMessage, sheetIndex);
            checkAnswerScreen.show();
                }
        });
        taskBox = new VBox(taskText, task, taskSentence, fieldContainer, buttonsBox);
        taskBox.setSpacing(10);
        taskBox.setAlignment(Pos.CENTER);
        return taskBox;
    }

    public static String getTask(int sheetIndex, int columnIndex) {
        getRandomRowNumber(sheetIndex);
        readExcel(FILE_PATH_XLSX, sheetIndex, randomRowNumber, columnIndex);
        return cellValue;
    }
}

