module org.example.textprocessingdatamanagementtool {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.textprocessingdatamanagementtool to javafx.fxml;
    exports org.example.textprocessingdatamanagementtool;
}