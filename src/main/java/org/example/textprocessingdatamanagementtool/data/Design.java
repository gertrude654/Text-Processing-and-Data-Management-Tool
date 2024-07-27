package org.example.textprocessingdatamanagementtool.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Design {

    private DataManager<String> dataManager;
    private ListView<String> listView;

    public Design() {
        dataManager = new DataManager<>();
        listView = new ListView<>();
    }

    public VBox createDataSection() {
        VBox box = new VBox();
        box.setSpacing(10);
        box.setPadding(new Insets(20));

        box.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Heading for the data management section
        Label headingLabel = new Label("Data Management");
        headingLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        headingLabel.setTextFill(Color.DARKBLUE);

        Label collectionTypeLabel = new Label("Collection Type:");
        collectionTypeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        ComboBox<String> collectionTypeComboBox = new ComboBox<>();
        collectionTypeComboBox.setItems(FXCollections.observableArrayList("List", "Set", "Map"));
        collectionTypeComboBox.setValue("List");

        TextArea collectionDisplayArea = new TextArea();
        collectionDisplayArea.setEditable(false);
        collectionDisplayArea.setPrefHeight(100);
        collectionDisplayArea.setFont(Font.font("Arial", 14));
        collectionDisplayArea.setStyle("-fx-control-inner-background: #f5f5f5;");

        listView.setPrefHeight(100);

        Button addButton = new Button("Add");
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        Button clearButton = new Button("Clear");

        styleButton(addButton, "#4CAF50");
        styleButton(editButton, "#2196F3");
        styleButton(deleteButton, "#F44336");
        styleButton(clearButton, "#FF9800");

        Label itemOperationsLabel = new Label("Item Operations:");
        itemOperationsLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        TextField itemField = new TextField();
        itemField.setPromptText("Enter item here");

        Button findItemButton = new Button("Find Item");
        styleButton(findItemButton, "#9C27B0");

        box.getChildren().addAll(
                headingLabel,
                new HBox(collectionTypeLabel, collectionTypeComboBox),
                collectionDisplayArea,
                listView,
                new HBox(10, addButton, editButton, deleteButton, clearButton),
                itemOperationsLabel,
                itemField,
                new HBox(findItemButton)
        );

        collectionTypeComboBox.setOnAction(e -> {
            String selectedType = collectionTypeComboBox.getValue();
            updateCollectionDisplay(selectedType, collectionDisplayArea);
        });

        addButton.setOnAction(e -> {
            String item = itemField.getText().trim();
            if (!item.isEmpty()) {
                String selectedType = collectionTypeComboBox.getValue();
                if (selectedType.equals("List")) {
                    dataManager.addToList(item);
                    updateCollectionDisplay(selectedType, collectionDisplayArea);
                } else if (selectedType.equals("Set")) {
                    if (dataManager.findInSet(item)) {
                        collectionDisplayArea.setText("Duplicate items are not allowed in a Set.");
                    } else {
                        dataManager.addToSet(item);
                        updateCollectionDisplay(selectedType, collectionDisplayArea);
                    }
                } else if (selectedType.equals("Map")) {
                    String[] keyValue = item.split("=");
                    if (keyValue.length == 2) {
                        dataManager.addToMap(keyValue[0], keyValue[1]);
                        updateCollectionDisplay(selectedType, collectionDisplayArea);
                    } else {
                        collectionDisplayArea.setText("Invalid input format for Map. Use key=value.");
                    }
                }
            } else {
                collectionDisplayArea.setText("Please enter an item.");
            }
        });

        editButton.setOnAction(e -> {
            String item = itemField.getText().trim();
            String selectedType = collectionTypeComboBox.getValue();
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                if (selectedType.equals("List")) {
                    int index = dataManager.getArrayList().indexOf(selectedItem);
                    dataManager.updateList(index, item);
                    updateCollectionDisplay(selectedType, collectionDisplayArea);
                } else if (selectedType.equals("Set")) {
                    dataManager.updateSet(selectedItem, item);
                    updateCollectionDisplay(selectedType, collectionDisplayArea);
                } else if (selectedType.equals("Map")) {
                    String[] keyValue = item.split("=");
                    if (keyValue.length == 2) {
                        dataManager.updateMap(keyValue[0], keyValue[1]);
                        updateCollectionDisplay(selectedType, collectionDisplayArea);
                    } else {
                        collectionDisplayArea.setText("Invalid input format for Map. Use key=value.");
                    }
                }
            } else {
                collectionDisplayArea.setText("No item selected for editing.");
            }
        });

        deleteButton.setOnAction(e -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                String selectedType = collectionTypeComboBox.getValue();
                if (selectedType.equals("List")) {
                    dataManager.deleteFromList(Integer.parseInt(selectedItem));
                } else if (selectedType.equals("Set")) {
                    dataManager.deleteFromSet(selectedItem);
                } else if (selectedType.equals("Map")) {
                    dataManager.deleteFromMap(selectedItem.split("=")[0]);
                }
                updateCollectionDisplay(selectedType, collectionDisplayArea);
            } else {
                collectionDisplayArea.setText("No item selected for deletion.");
            }
        });

        clearButton.setOnAction(e -> {
            String selectedType = collectionTypeComboBox.getValue();
            if (selectedType.equals("List")) {
                dataManager.clearList();
            } else if (selectedType.equals("Set")) {
                dataManager.clearSet();
            } else if (selectedType.equals("Map")) {
                dataManager.clearMap();
            }
            updateCollectionDisplay(selectedType, collectionDisplayArea);
        });

        findItemButton.setOnAction(e -> {
            String item = itemField.getText().trim();
            String selectedType = collectionTypeComboBox.getValue();
            if (selectedType.equals("List")) {
                boolean found = dataManager.findInList(item);
                collectionDisplayArea.setText(found ? "Item found in List." : "Item not found in List.");
            } else if (selectedType.equals("Set")) {
                boolean found = dataManager.findInSet(item);
                collectionDisplayArea.setText(found ? "Item found in Set." : "Item not found in Set.");
            } else if (selectedType.equals("Map")) {
                String[] keyValue = item.split("=");
                if (keyValue.length == 1) {
                    String value = String.valueOf(dataManager.findInMap(keyValue[0]));
                    collectionDisplayArea.setText("Value: " + value);
                } else {
                    collectionDisplayArea.setText("Invalid input format for Map. Use key=value.");
                }
            }
        });

        return box;
    }

    private void updateCollectionDisplay(String collectionType, TextArea collectionDisplayArea) {
        ObservableList<String> items;
        switch (collectionType) {
            case "List":
                items = FXCollections.observableArrayList(dataManager.getArrayList());
                listView.setItems(items);
                collectionDisplayArea.setText("ArrayList: " + dataManager.getArrayList().toString());
                break;
            case "Set":
                items = FXCollections.observableArrayList(dataManager.getHashSet());
                listView.setItems(items);
                collectionDisplayArea.setText("HashSet: " + dataManager.getHashSet().toString());
                break;
            case "Map":
                items = FXCollections.observableArrayList(dataManager.getHashMap().entrySet().stream()
                        .map(entry -> entry.getKey() + "=" + entry.getValue())
                        .toArray(String[]::new));
                listView.setItems(items);
                collectionDisplayArea.setText("HashMap: " + dataManager.getHashMap().toString());
                break;
        }
    }

    private void styleButton(Button button, String color) {
        button.setStyle("-fx-background-color: " + color + "; -fx-text-fill: white;");
    }
}
