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


import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class HelloController {
    @FXML
    public TextField studentNameField;
    @FXML
    public TextField CourseCodeField;
    @FXML
    public TextField IDNumberField;
    @FXML
    public TextField LessonField;
    @FXML
    public TextField ModeField;
    @FXML
    public TextField ContactField;

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

    public String getIdNum() {
        return IDNumberField.getText().trim();
    }

    public String getCourseCode() {
        return CourseCodeField.getText().trim();
    }

    public String getStudentName() {
        return studentNameField.getText();
    }

    public String getLesson() {
        return LessonField.getText().trim();
    }

    public String getContactField() {
        return ContactField.getText().trim();
    }

    public String getModeField() {
        return ModeField.getText().trim();
    }

    @FXML
    private void enlist(ActionEvent event) throws IOException {
        String filePath = "out.txt"; // Path to your file
        String content = getIdNum()+","+getStudentName()+","+getCourseCode()+","+getLesson()+","+getModeField()+","+getContactField();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
