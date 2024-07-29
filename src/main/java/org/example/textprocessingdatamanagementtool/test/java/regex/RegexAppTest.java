package org.example.textprocessingdatamanagementtool.regex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class RegexAppTest extends ApplicationTest {

    private RegexApp regexApp;

    @Override
    public void start(Stage stage) {
        regexApp = new RegexApp();
        Scene scene = new Scene(regexApp.createRegexSection(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testInitialUIComponents() {
        // Check if the header label is present
        assertThat(lookup("#headerLabel").queryLabeled()).hasText("Regex Operations Tool");
        // Check if the text field is present
        assertThat(lookup("#textInput").queryTextInputControl()).isNotNull();
        // Check if the pattern field is present
        assertThat(lookup("#patternInput").queryTextInputControl()).isNotNull();
        // Check if the replacement field is present
        assertThat(lookup("#replacementInput").queryTextInputControl()).isNotNull();
        // Check if the result text area is present
        assertThat(lookup("#resultTextArea").queryTextArea()).isNotNull();
        // Check if buttons are present
        assertThat(lookup("#searchButton").queryButton()).hasText("Search");
        assertThat(lookup("#matchButton").queryButton()).hasText("Match");
        assertThat(lookup("#replaceButton").queryButton()).hasText("Replace");
    }

    @Test
    public void testSearchButtonFunctionality() {
        // Test searching for a pattern in the text
        clickOn("#textInput").write("Hello world");
        clickOn("#patternInput").write("world");
        clickOn("#searchButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Pattern found: true");
    }

    @Test
    public void testMatchButtonFunctionality() {
        // Test matching a pattern in the text
        clickOn("#textInput").write("Hello world");
        clickOn("#patternInput").write("world");
        clickOn("#matchButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Pattern matched: true");
    }

    @Test
    public void testReplaceButtonFunctionality() {
        // Test replacing a pattern in the text
        clickOn("#textInput").write("Hello world");
        clickOn("#patternInput").write("world");
        clickOn("#replacementInput").write("everyone");
        clickOn("#replaceButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Result: Hello everyone");
    }

    @Test
    public void testEmptyFieldsValidation() {
        // Test validation for empty fields
        clickOn("#searchButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Please enter text and a pattern to search.");

        clickOn("#textInput").write("Hello world");
        clickOn("#matchButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Please enter text and a pattern to match.");

        clickOn("#patternInput").write("world");
        clickOn("#replaceButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Please enter text, a pattern, and replacement text.");
    }

    @Test
    public void testSearchWithEmptyPattern() {
        // Test searching with an empty pattern
        clickOn("#textInput").write("Hello world");
        clickOn("#patternInput").clear(); // Clear pattern
        clickOn("#searchButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Please enter text and a pattern to search.");
    }

    @Test
    public void testReplaceWithEmptyReplacement() {
        // Test replacing with an empty replacement
        clickOn("#textInput").write("Hello world");
        clickOn("#patternInput").write("world");
        clickOn("#replacementInput").clear(); // Clear replacement
        clickOn("#replaceButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Please enter text, a pattern, and replacement text.");
    }

    @Test
    public void testSearchPatternNotFound() {
        // Test searching for a pattern that does not exist in the text
        clickOn("#textInput").write("Hello world");
        clickOn("#patternInput").write("foo");
        clickOn("#searchButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Pattern found: false");
    }

    @Test
    public void testMatchPatternNotFound() {
        // Test matching a pattern that does not exist in the text
        clickOn("#textInput").write("Hello world");
        clickOn("#patternInput").write("foo");
        clickOn("#matchButton");
        assertThat(lookup("#resultTextArea").queryTextArea()).hasText("Pattern matched: false");
    }
}
