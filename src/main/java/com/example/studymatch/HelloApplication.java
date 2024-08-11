package com.example.studymatch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Users user = new Users();
        user.loadFile("src/main/resources/database.txt");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 370);
        stage.setTitle("DLSU StudyMatch");
        stage.setScene(scene);
        stage.show();//test commented
    }

    public static void main(String[] args) {
        launch();
    }
}