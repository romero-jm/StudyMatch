package com.example.studymatch;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface WindowInterface {
    void onExit(ActionEvent event) throws IOException;
    void switchScene(ActionEvent event, String fxmlFile) throws IOException;
}
