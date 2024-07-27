package org.example.textprocessingdatamanagementtool;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.textprocessingdatamanagementtool.data.Design;
import org.example.textprocessingdatamanagementtool.regex.RegexApp;

public class Main extends Application {

    private BorderPane root;
    private RegexApp regexApp;
    private Design designApp;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Processing and Data Management Tool");

        regexApp = new RegexApp();
        designApp = new Design();

        root = new BorderPane();
        root.setTop(createMenuBar());
        root.setCenter(regexApp.createRegexSection());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu viewMenu = new Menu("View");
        MenuItem regexMenuItem = new MenuItem("Regex Operations");
        MenuItem dataMenuItem = new MenuItem("Data Management");

        regexMenuItem.setOnAction(e -> showRegexSection());
        dataMenuItem.setOnAction(e -> showDataSection());

        viewMenu.getItems().addAll(regexMenuItem, dataMenuItem);
        menuBar.getMenus().add(viewMenu);

        return menuBar;
    }

    private void showRegexSection() {
        root.setCenter(regexApp.createRegexSection());
    }

    private void showDataSection() {
        root.setCenter(designApp.createDataSection());
    }
}
