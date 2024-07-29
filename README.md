# JavaFX Text Processing Tool Documentation

## 1. Overview

- **Project Name:** Text Processing Tool
- **Description:** The JavaFX Text Processing Tool is a desktop application designed for various text manipulation tasks. It enables users to perform operations such as pattern matching and text replacement through regular expressions. The application also features data management capabilities, including adding, updating, and deleting items. Users can save and load both text and data files, facilitating easy storage and retrieval of processed information.
- **Authors:** Elvis Mugisha and Gerturde Uzimana
- **Version:** 1.0
- **Date:** 25th July 2024

## 2. Key Features

- **Text Input:** Users can enter text to be processed.
- **Regex Matching:** Enables the matching of regular expressions with the input text.
- **Text Replacement:** Facilitates the replacement of matched text with user-specified replacements.
- **Data Management:** Allows for the addition, modification, removal, and clearing of items in a list.
- **Data Persistence:** Supports saving and loading data from files.
- **Text File Handling:** Provides options for saving processed text to files and loading text data from files.
- **Intuitive Interface:** Features a modern and easy-to-use interface for a better user experience.

## 3. Architecture

### 3.1. Overview

The application employs a Model-View-Controller (MVC) architecture:

- **Model:** Handles data and business logic.
- **View:** Contains FXML files that define the user interface layout.
- **Controller:** Manages user interactions and updates the view based on changes in the model.

### 3.2. Component Breakdown

- **Model Classes:** Manage data operations including regex processing, list management, and file handling.
- **Controller Class:** (TextProcessorController.java) Manages user actions and interactions with the model.
- **View (FXML):** Describes the UI components and their arrangement.

## 4. User Interface Design

### 4.1. Layout

- **Input Area:** Provides a text area for users to input data.
- **Regex Section:** Contains fields for entering regex patterns and replacement text.
- **Action Buttons:** Includes buttons for matching patterns, replacing text, and clearing fields.
- **Data Management:** Features text fields and buttons for managing data entries.
- **File Operations:** Offers buttons for saving and loading both list data and text data.

### 4.2. Styling

The application uses inline CSS for styling to ensure a visually consistent and appealing interface. Custom styles are applied to buttons and text fields to enhance user interaction and feedback.

## 5. Implementation Details

### 5.1. Regex Processing

- **Pattern Matching:** Utilizes Java’s Pattern and Matcher classes for regular expression operations.
- **Text Replacement:** Performs replacements of matched patterns using String.replaceAll().

### 5.2. Data Management

- **Collection Type:** Utilizes ObservableList for maintaining a list of data.
- **CRUD Operations:** Implements functionalities for creating, reading, updating, and deleting items.

### 5.3. File Operations

- **Data Persistence:**
  - **Saving Data:** Serializes the data list to a file using FileWriter and BufferedWriter.
  - **Loading Data:** Reads data from a file using BufferedReader and updates the list.

- **Text File Operations:**
  - **Saving Text Data:** Writes processed text to a file using FileWriter.
  - **Loading Text Data:** Reads text data from a file using BufferedReader.

### 5.4. Error Handling

- Implements basic error handling mechanisms for file operations and regex processing to ensure the application can manage exceptions and provide appropriate user feedback.

## 6. Usage Instructions

### 6.1. Prerequisites

- **Java Development Kit (JDK):** Version 11 or higher is recommended.
- **JavaFX SDK:** Ensure JavaFX is correctly configured in your development environment.

### 6.2. Setup and Execution

1. **Clone the Repository:**

   ```sh
   https://github.com/gertrude654/Text-Processing-and-Data-Management-Tool


2. **Run tests:**

   ```sh
   mvn test

## 7. Conclusion

The JavaFX Text Processing Tool provides a comprehensive solution for performing text manipulation and data management tasks. With its user-friendly design, the application is suitable for both beginners and advanced users looking to efficiently handle text processing tasks.

For a visual overview of the application, watch the Loom video: [Loom Video](https://www.loom.com/)

