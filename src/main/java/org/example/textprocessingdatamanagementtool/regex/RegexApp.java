package org.example.textprocessingdatamanagementtool.regex;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class RegexApp {

    private TextField textInput;
    private TextField patternInput;
    private TextField replacementInput;
    private TextArea resultTextArea;
    private RegularExpressions regexExpression;

    public RegexApp() {
        regexExpression = new RegularExpressions();
    }

    public VBox createRegexSection() {
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Header Label
        Label headerLabel = new Label("Regex Operations Tool");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headerLabel.setTextFill(Color.DARKBLUE);

        // UI Components for Regex functionality
        Label textLabel = new Label("Text:");
        textLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        textInput = new TextField();

        Label patternLabel = new Label("Pattern:");
        patternLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        patternInput = new TextField();

        Label replacementLabel = new Label("Replacement:");
        replacementLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        replacementInput = new TextField();

        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        searchButton.setOnAction(e -> searchPattern());

        Button matchButton = new Button("Match");
        matchButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        matchButton.setOnAction(e -> matchPattern());

        Button replaceButton = new Button("Replace");
        replaceButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white;");
        replaceButton.setOnAction(e -> replacePattern());

        resultTextArea = new TextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setWrapText(true);
        resultTextArea.setPrefHeight(150);
        resultTextArea.setFont(Font.font("Arial", 14));
        resultTextArea.setStyle("-fx-control-inner-background: #f5f5f5;");

        VBox inputBox = new VBox(10, textLabel, textInput, patternLabel, patternInput, replacementLabel, replacementInput);
        inputBox.setAlignment(Pos.CENTER_LEFT);
        inputBox.setPadding(new Insets(10));

        HBox buttonBox = new HBox(10, searchButton, matchButton, replaceButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        vBox.getChildren().addAll(headerLabel, inputBox, buttonBox, resultTextArea);
        return vBox;
    }

    private void searchPattern() {
        String text = textInput.getText();
        String pattern = patternInput.getText();
        if (!text.isEmpty() && !pattern.isEmpty()) {
            boolean found = regexExpression.searchPatternInText(text, pattern);
            displayResult("Pattern found: " + found);
        } else {
            displayResult("Please enter text and a pattern to search.");
        }
    }

    private void matchPattern() {
        String text = textInput.getText();
        String pattern = patternInput.getText();
        if (!text.isEmpty() && !pattern.isEmpty()) {
            boolean matched = regexExpression.matchPatternInText(text, pattern);
            displayResult("Pattern matched: " + matched);
        } else {
            displayResult("Please enter text and a pattern to match.");
        }
    }

    private void replacePattern() {
        String text = textInput.getText();
        String pattern = patternInput.getText();
        String replacement = replacementInput.getText();
        if (!text.isEmpty() && !pattern.isEmpty() && !replacement.isEmpty()) {
            String result = regexExpression.replacePatternInText(text, pattern, replacement);
            displayResult("Result: " + result);
        } else {
            displayResult("Please enter text, a pattern, and replacement text.");
        }
    }

    private void displayResult(String message) {
        resultTextArea.setText(message);
    }


}
