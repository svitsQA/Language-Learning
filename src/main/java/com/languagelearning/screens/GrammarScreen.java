package com.languagelearning.screens;

import com.languagelearning.Screen;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GrammarScreen extends Pane implements Screen {
    VBox rulesViewBox;

    public GrammarScreen() {
        MainMenu menu = new MainMenu();
        getStylesheets().add("styles.css");
        rulesViewBox();
        rulesViewBox.setLayoutX(220);
        rulesViewBox.setLayoutY(200);
        getChildren().addAll(
                menu,
                rulesViewBox
        );
    }
    @Override
    public void navigateToScreen(Screen nextScreen) {
        Scene scene = getScene();
        Stage stage = (Stage) scene.getWindow();
        Scene nextScene = new Scene((Parent) nextScreen, 1000, 500);
        stage.setScene(nextScene);
        stage.show();
    }
    private Node rulesViewBox() {
        rulesViewBox = new VBox(20);
        HBox simpleTimesRules = new HBox(20);
        Button presentSimpleRulesButton = new Button("Present Simple");
        presentSimpleRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(0);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        Button pastSimpleRulesButton = new Button("Past Simple");
        pastSimpleRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(1);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        Button futureSimpleRulesButton = new Button("Future Simple");
        futureSimpleRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(2);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        HBox continuousTimesRules = new HBox(20);
        Button presentContinuousRulesButton = new Button("Present Continuous");
        presentContinuousRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(3);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        Button pastContinuousRulesButton = new Button("Past Continuous");
        pastContinuousRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(4);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        Button futureContinuousRulesButton = new Button("Future Continuous");
        futureContinuousRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(5);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        HBox perfectTimesRules = new HBox(20);
        Button presentPerfectRulesButton = new Button("Present Perfect");
        presentPerfectRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(6);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        Button pastPerfectRulesButton = new Button("Past Perfect");
        pastPerfectRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(6);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        Button futurePerfectRulesButton = new Button("Future Perfect");
        futurePerfectRulesButton.setOnAction(e -> {
            Stage rulesStage = new Stage();
            RulesScreen rulesScreen = new RulesScreen(8);
            Scene rulesScene = new Scene(rulesScreen, 1000, 500);
            rulesStage.setScene(rulesScene);
                }
        );
        simpleTimesRules.getChildren().addAll(presentSimpleRulesButton, pastSimpleRulesButton, futureSimpleRulesButton);
        continuousTimesRules.getChildren().addAll(presentContinuousRulesButton, pastContinuousRulesButton, futureContinuousRulesButton);
        perfectTimesRules.getChildren().addAll(presentPerfectRulesButton, pastPerfectRulesButton, futurePerfectRulesButton);
        rulesViewBox.getChildren().addAll(simpleTimesRules, continuousTimesRules, perfectTimesRules);
        return rulesViewBox;
    }
}

