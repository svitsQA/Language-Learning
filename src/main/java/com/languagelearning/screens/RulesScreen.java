package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.languagelearning.Constants.*;
import static com.languagelearning.ExcelReader.readExcel;

public class RulesScreen extends Pane implements Screen {
    private Text topicName;
    private VBox affirmativeForm;
    private VBox negativeForm;
    private VBox interrogativeForm;
    private HBox rulesBox;
    private VBox examplesForm;
    private String rulesFilePath = "C:\\Users\\sanzharevska.PAYSAXAS\\CODE\\Language-Learning\\src\\main\\resources\\com\\Rules.xlsx";
    private int rulesRowNumber;
    private int rulesSheetIndex = 0;

    public RulesScreen(int sheetIndex) {
        Stage textStage = new Stage();
        textStage.setTitle("Rules");
        VBox rulesLayout = new VBox(10);
        rulesLayout.setStyle(IMAGE_PATH_SCHOOL_BOARD);
        rulesLayout.setAlignment(Pos.TOP_CENTER);
        Button backButton = new Button("Close");
        backButton.getStyleClass().add("exitButton");
        backButton.setOnAction(e -> {
            textStage.close();
        });
        getRuleTopic(sheetIndex);
        getRulesBox(sheetIndex);
        getExamplesForm(sheetIndex);
        getRuleRowNumber(sheetIndex);
        examplesForm.setAlignment(Pos.BOTTOM_CENTER);
        HBox header = new HBox(300);
        HBox topic = new HBox();
        topic.getChildren().setAll(topicName);
        header.getChildren().addAll(backButton, topic);
        rulesLayout.getChildren().addAll(header, rulesBox, examplesForm);
        Scene textScene = new Scene(rulesLayout, sceneX, sceneY);
        textScene.getStylesheets().add("styles.css");
        textStage.setScene(textScene);
        textStage.show();
    }

    private Text getRuleTopic(int sheetIndex) {
        getRuleRowNumber(sheetIndex);
        topicName = new Text();
        topicName.setText(readExcel(rulesFilePath, rulesSheetIndex, rulesRowNumber, 0));
        topicName.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        topicName.setFill(Color.WHITE);
        return topicName;
    }

    private VBox getAffirmativeForm(int sheetIndex) {
        getRuleRowNumber(sheetIndex);
        affirmativeForm = new VBox(10);
        affirmativeForm.setPrefSize(300, 200);
        Text affirmativeFormName = new Text(AFFIRMATIVE_FORM_BOX_NAME);
        Text affirmativeFormContent = new Text();
        affirmativeFormContent.setText(readExcel(rulesFilePath, rulesSheetIndex, rulesRowNumber, 1));
        affirmativeFormName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        affirmativeFormName.setFill(Color.WHITE);
        affirmativeFormContent.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        affirmativeFormContent.setFill(Color.WHITE);
        affirmativeForm.getStyleClass().add("vbox-with-border");
        affirmativeForm.getChildren().addAll(affirmativeFormName, affirmativeFormContent);
        return affirmativeForm;
    }

    private VBox getNegativeForm(int sheetIndex) {
        getRuleRowNumber(sheetIndex);
        negativeForm = new VBox(10);
        negativeForm.setPrefSize(300, 200);
        Text negativeFormName = new Text(NEGATIVE_FORM_BOX_NAME);
        Text negativeFormContent = new Text();
        negativeFormContent.setText(readExcel(rulesFilePath, rulesSheetIndex, rulesRowNumber, 2));
        negativeFormName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        negativeFormName.setFill(Color.WHITE);
        negativeFormContent.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        negativeFormContent.setFill(Color.WHITE);
        negativeForm.getStyleClass().add("vbox-with-border");
        negativeForm.getChildren().addAll(negativeFormName, negativeFormContent);
        return negativeForm;
    }

    private VBox getInterrogativeForm(int sheetIndex) {
        getRuleRowNumber(sheetIndex);
        interrogativeForm = new VBox(10);
        interrogativeForm.setPrefSize(300, 200);
        Text interrogativeFormName = new Text(INTERROGATIVE_BOX_NAME);
        Text interrogativeFormContent = new Text();
        interrogativeFormContent.setText(readExcel(rulesFilePath, rulesSheetIndex, rulesRowNumber, 3));
        interrogativeFormName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        interrogativeFormName.setFill(Color.WHITE);
        interrogativeFormContent.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        interrogativeFormContent.setFill(Color.WHITE);
        interrogativeForm.getStyleClass().add("vbox-with-border");
        interrogativeForm.getChildren().addAll(interrogativeFormName, interrogativeFormContent);
        return interrogativeForm;
    }

    private HBox getRulesBox(int sheetIndex) {
        getAffirmativeForm(sheetIndex);
        affirmativeForm.setTranslateX(20);
        affirmativeForm.setTranslateY(50);
        getNegativeForm(sheetIndex);
        negativeForm.setTranslateX(40);
        negativeForm.setTranslateY(50);
        getInterrogativeForm(sheetIndex);
        interrogativeForm.setTranslateX(50);
        interrogativeForm.setTranslateY(50);
        rulesBox = new HBox();
        rulesBox.getChildren().addAll(affirmativeForm, negativeForm, interrogativeForm);
        return rulesBox;
    }

    private VBox getExamplesForm(int sheetIndex) {
        getRuleRowNumber(sheetIndex);
        examplesForm = new VBox(10);
        Text exampleFormName = new Text(EXAMPLES_BOX_NAME);
        Text exampleFormContent = new Text();
        exampleFormContent.setText(readExcel(rulesFilePath, rulesSheetIndex, rulesRowNumber, 4));
        exampleFormName.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        exampleFormName.setFill(Color.WHITE);
        exampleFormContent.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        exampleFormContent.setFill(Color.WHITE);
        examplesForm.setPrefWidth(200);
        examplesForm.setPrefHeight(200);
        examplesForm.getChildren().addAll(exampleFormName, exampleFormContent);
        return examplesForm;
    }

    private int getRuleRowNumber(int sheetIndex) {
        if (sheetIndex == 0) {
            rulesRowNumber = 1;
        } else if (sheetIndex == 1) {
            rulesRowNumber = 2;
        } else if (sheetIndex == 2) {
            rulesRowNumber = 3;
        } else if (sheetIndex == 3) {
            rulesRowNumber = 4;
        } else if (sheetIndex == 4) {
            rulesRowNumber = 5;
        } else if (sheetIndex == 5) {
            rulesRowNumber = 6;
        } else if (sheetIndex == 6) {
            rulesRowNumber = 7;
        } else if (sheetIndex == 7) {
            rulesRowNumber = 8;
        } else if (sheetIndex == 8) {
            rulesRowNumber = 9;
        }
        return rulesRowNumber;
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
