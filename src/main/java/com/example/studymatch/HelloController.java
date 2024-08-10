package com.example.studymatch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HelloController {
    @FXML
    public TextField studentName;
    @FXML
    public TextField courseCode;
    @FXML
    public TextField idNum;
    @FXML
    public TextField lesson;


    private Scene scene;
    private Stage stage;

    @FXML
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/studymatch/" + fxmlFile)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToLoginView(ActionEvent event) throws IOException {
        switchScene(event, "login-view.fxml");
    }

    private String getIdNum() {
        return idNum.getText().trim();
    }

    private String getCourseCode() {
        return courseCode.getText().trim();
    }

    private String getStudentName() {
        return studentName.getText().trim();
    }

    private String getLesson() {
        return lesson.getText().trim();
    }




}