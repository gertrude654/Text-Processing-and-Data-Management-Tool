package org.example.textprocessingdatamanagementtool.data;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.TextInputControlMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class DesignTest extends ApplicationTest {

    private Design design;

    @Override
    public void start(Stage stage) {
        design = new Design();
        Scene scene = new Scene(design.createDataSection(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testInitialUIComponents() {
        // Test if the initial UI components are present and properly configured
        assertThat(lookup(".label").queryLabeled()).hasText("Data Management");
        assertThat(lookup(".combo-box").queryComboBox().getItems()).containsExactly("List", "Set", "Map");
    }

    @Test
    public void testAddButtonFunctionality() {
        // Test adding an item to the List
        clickOn(".combo-box").clickOn("List");
        clickOn(".text-field").write("Item1");
        clickOn(".button").lookup("Add").queryButton();
        assertThat(lookup(".text-area").queryTextArea()).hasText("ArrayList: [Item1]");
    }

    @Test
    public void testEditButtonFunctionality() {
        // Test editing an item in the List
        clickOn(".combo-box").clickOn("List");
        clickOn(".text-field").write("Item1");
        clickOn(".button").lookup("Add").queryButton();
        clickOn(".list-view").clickOn("Item1");
        clickOn(".text-field").write("Item1-edited");
        clickOn(".button").lookup("Edit").queryButton();
        assertThat(lookup(".text-area").queryTextArea()).hasText("ArrayList: [Item1-edited]");
    }

    @Test
    public void testDeleteButtonFunctionality() {
        // Test deleting an item from the List
        clickOn(".combo-box").clickOn("List");
        clickOn(".text-field").write("Item1");
        clickOn(".button").lookup("Add").queryButton();
        clickOn(".list-view").clickOn("Item1");
        clickOn(".button").lookup("Delete").queryButton();
        assertThat(lookup(".text-area").queryTextArea()).hasText("ArrayList: []");
    }

    @Test
    public void testClearButtonFunctionality() {
        // Test clearing the List
        clickOn(".combo-box").clickOn("List");
        clickOn(".text-field").write("Item1");
        clickOn(".button").lookup("Add").queryButton();
        clickOn(".button").lookup("Clear").queryButton();
        assertThat(lookup(".text-area").queryTextArea()).hasText("ArrayList: []");
    }

    @Test
    public void testFindItemButtonFunctionality() {
        // Test finding an item in the List
        clickOn(".combo-box").clickOn("List");
        clickOn(".text-field").write("Item1");
        clickOn(".button").lookup("Add").queryButton();
        clickOn(".text-field").write("Item1");
        clickOn(".button").lookup("Find Item").queryButton();
        assertThat(lookup(".text-area").queryTextArea()).hasText("Item found in List.");
    }
}
