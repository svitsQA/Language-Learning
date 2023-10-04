package com.languagelearning;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static com.languagelearning.ExcelReader.*;

public class ApplicationRunner extends Application{
    private VBox mainMenuPane;
    private VBox quizPane;
    private VBox quizRunnerStage;
    private VBox welcomePane;
    private int sheetIndex;
    private TextField answerInputField;
    private Text questionText;

    @Override
public void start(Stage primaryStage) {

welcomePane = new VBox(10);
welcomePane.setAlignment(Pos.CENTER);
mainMenuPane = new VBox(10);
        mainMenuPane.setAlignment(Pos.CENTER);
mainMenuPane.setVisible(false);
quizPane = new VBox(10);
        quizPane.setAlignment(Pos.CENTER);
quizPane.setVisible(false);
quizRunnerStage = new VBox(10);
        quizRunnerStage.setAlignment(Pos.CENTER);
quizRunnerStage.setVisible(false);
StackPane root = new StackPane();

//Welcome Screen
Button startButton = new Button("Start");
startButton.setOnAction(e -> showNextScreen(welcomePane, mainMenuPane));
welcomePane.getChildren().addAll(startButton);

//Main menu Screen
Button accountItem = new Button("Account");
Button grammarItem = new Button("Grammar");
Button quizItem = new Button("Quiz");
    quizItem.setOnAction(e -> showNextScreen(mainMenuPane, quizPane));
Button menuPaneBackItem = new Button("Back");
    menuPaneBackItem.setOnAction(e -> showPreviousScreen(mainMenuPane, welcomePane));
Button menuPaneExitItem = new Button("Exit");
    menuPaneExitItem.setOnAction(e -> primaryStage.close());
mainMenuPane.getChildren().addAll(accountItem, grammarItem, quizItem, menuPaneBackItem, menuPaneExitItem);

//Quiz Screen
Button presentSimpleItem = new Button("Present Simple");
Button pastSimpleItem = new Button("Past Simple");
Button idiomsItem = new Button("IDIOMS");
Button irregularVerbsItem = new Button("Irregular Verbs");
Button menuQuizBackItem = new Button("Back");
    menuQuizBackItem.setOnAction(e -> showPreviousScreen(quizPane, mainMenuPane));
Button quizPaneExitItem = new Button("Exit");
    quizPaneExitItem.setOnAction(e -> primaryStage.close());
quizPane.getChildren().addAll(presentSimpleItem, pastSimpleItem, idiomsItem, irregularVerbsItem, menuQuizBackItem, quizPaneExitItem);

setupQuizButton(presentSimpleItem, 0);
setupQuizButton(pastSimpleItem, 1);
setupQuizButton(idiomsItem, 2);
setupQuizButton(irregularVerbsItem, 3);

//Quiz Runner Screen
Text taskText = new Text("Task");
questionText = new Text(QuizFlow.getTask(sheetIndex));
answerInputField = new TextField();
answerInputField.setPromptText("Enter your answer");
Button submitButton = new Button("Submit answer");
    submitButton.setOnAction(e -> {
        try {
            showAnswerResult(String.valueOf(answerInputField.getText()));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    });
Button nextQuestionButton = new Button("Next question");
    nextQuestionButton.setOnAction(e -> updateQuestionText());
Button quizRunBackItem = new Button("Back");
    quizRunBackItem.setOnAction(e -> showPreviousScreen(quizRunnerStage, quizPane));
Button quizRunExitItem = new Button("Exit");
    quizRunExitItem.setOnAction(e -> primaryStage.close());
    quizRunnerStage.getChildren().addAll(taskText, questionText, answerInputField, submitButton, nextQuestionButton, quizRunBackItem, quizRunExitItem);

root.getChildren().addAll(welcomePane, mainMenuPane, quizPane, quizRunnerStage);
Scene scene = new Scene(root, 1000, 500);
primaryStage.setTitle("English learning!");
primaryStage.setScene(scene);
primaryStage.show();
}

 private void showNextScreen(VBox currentScreen, VBox nextScreen) {
     currentScreen.setVisible(false);
     nextScreen.setVisible(true);
}
private void showPreviousScreen(VBox currentScreen, VBox prevScreen) {
    currentScreen.setVisible(false);
    prevScreen.setVisible(true);
}
private void setupQuizButton(Button menuItem, int sheetIndex) {
    menuItem.setOnAction(e -> {
        showNextScreen(quizPane, quizRunnerStage);
        this.sheetIndex = sheetIndex;
        updateQuestionText();
     });
}
private void updateQuestionText() {
    questionText.setText(QuizFlow.getTask(sheetIndex));
    }
private void showAnswerResult(String text) throws IOException {
        Stage textStage = new Stage();
        textStage.setTitle("Answer result");
    VBox answerLayout = new VBox(10);
    answerLayout.setAlignment(Pos.CENTER);
        Text yourAnswerLabel = new Text("Your answer");
        Text yourAnswer = new Text(text);
        Text result = new Text(checkAnswer(sheetIndex, randomRowNumber, String.valueOf(answerInputField.getText())));
        Button showAnswer = new Button("Show answer");

        Text correctAnswer = new Text(showAnswer(sheetIndex, randomRowNumber));
    answerLayout.getChildren().addAll(yourAnswerLabel, yourAnswer, result, showAnswer);

    showAnswer.setOnAction(e -> {
        int resultIndex = answerLayout.getChildren().indexOf(showAnswer);
        if (resultIndex != -1) {
            answerLayout.getChildren().set(resultIndex, correctAnswer);
        }
    });

        Scene textScene = new Scene(answerLayout, 300, 300);
        textStage.setScene(textScene);
        textStage.show();
}

public static void main(String[] args) {
            launch(args);
}
}

