module com.example.studymatch {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.studymatch to javafx.fxml;
    exports com.example.studymatch;
}