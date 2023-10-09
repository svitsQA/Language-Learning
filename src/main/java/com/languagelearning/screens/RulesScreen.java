package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.languagelearning.Constants.IMAGE_PATH_PAST_SIMPLE_RULES;
import static com.languagelearning.Constants.IMAGE_PATH_PRESENT_SIMPLE_RULES;
import static com.languagelearning.Constants.IMAGE_PATH_ANSWER_BOX;

public class RulesScreen extends Pane implements Screen {
    public static String background;

    public RulesScreen(int sheetIndex) {
        setBackground(sheetIndex);
        rulesSetup(background);
    }

    public static String setBackground(int sheetIndex) {
        if (sheetIndex == 0) {
            background = IMAGE_PATH_PRESENT_SIMPLE_RULES;
        } else if (sheetIndex == 1) {
            background = IMAGE_PATH_PAST_SIMPLE_RULES;
        } else {
            background = IMAGE_PATH_ANSWER_BOX;
        }
        return background;
    }

    public static void rulesSetup(String background) {
        Stage textStage = new Stage();
        textStage.setTitle("Rule");
        VBox answerLayout = new VBox(10);
        answerLayout.setStyle(background);
        answerLayout.setAlignment(Pos.CENTER);
        answerLayout.getChildren().addAll();
        Scene textScene = new Scene(answerLayout, sceneX, sceneY);
        textScene.getStylesheets().add("styles.css");
        textStage.setScene(textScene);
        textStage.show();
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
