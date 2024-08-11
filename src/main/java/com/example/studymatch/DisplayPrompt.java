package com.example.studymatch;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class DisplayPrompt {

    @FXML
    private Label displayLabel;

    @FXML
    private Button continueButton;

    @FXML
    public void handleContinueButton(ActionEvent event) {
        // Get the stage from the event source
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close(); // Close the stage
    }

    public void setDisplay(String displayText) {
        displayLabel.setText(displayText);
    }
}
