package com.example.studymatch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class HelloController {
    Users users = new Users();

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
    @FXML
    public Label Message;

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
        LoginView.setData(getCourseCode());
        switchScene(event, "login-view.fxml");
    }

    @FXML
    public void openPrompt(String displayText) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("display-prompt.fxml"));
        Parent root = loader.load();

        // Get the controller associated with the loaded FXML
        DisplayPrompt displayPrompt = loader.getController();
        displayPrompt.setDisplay(displayText);

        Stage window = new Stage();
        window.setTitle(displayText);
        window.setScene(new Scene(root));
        window.show();
    }

    @FXML
    public void openEnlistedView() throws IOException {
        openPrompt("Successfully Enlisted");
    }

    @FXML
    public void openEmptyEnlistedFieldView(ActionEvent event) throws IOException {
        openPrompt("Some Text Fields are Empty");
    }

    private String getIdNum() {
        return IDNumberField.getText().trim();
    }

    private String getCourseCode() {
        return CourseCodeField.getText().trim();
    }

    private String getStudentName() {
        return studentNameField.getText();
    }

    private String getLesson() {
        return LessonField.getText().trim();
    }

    private String getContactField() {
        return ContactField.getText().trim();
    }

    private String getModeField() {
        return ModeField.getText().trim();
    }

    @FXML
    private void enlist(ActionEvent event) throws IOException {
        if (studentNameField.getText().isEmpty() ||
                CourseCodeField.getText().isEmpty() ||
                IDNumberField.getText().isEmpty() ||
                LessonField.getText().isEmpty() ||
                ModeField.getText().isEmpty() ||
                ContactField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DLSU SystemMatch");
            alert.setHeaderText("Incomplete Information");
            alert.setContentText("Make sure all fields are filled.");
            alert.show();
        }
        else {
            Message.setText(getStudentName()+" enlisted");
            User user = new User(getIdNum(), getStudentName(), getCourseCode(), getLesson(), getModeField(), getContactField());
            users.addUser(user);
            users.printId();

        }
    }
}
