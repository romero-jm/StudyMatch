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
    public ArrayList<User> users = new ArrayList<>();

    public final int IDNUM = 1, NAME = 0, CODE = 2, LESSON = 3;
    public void loadFile(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            Scanner text = new Scanner(fileReader);

            while (text.hasNext()) {
                String line = text.nextLine();
                String[] details = line.split(",");
                String iDNum = details[IDNUM];
                String name = details[NAME];
                String code = details[CODE];
                String lesson = details[LESSON];

                User user = new User(iDNum, name, code, lesson);
                users.add(user);
            }
            text.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not Exist");
        }
    }

//branch test23



    @Override
    public void start(Stage stage) throws IOException {

        loadFile("src/main/resources/assets/data");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getCourseID());
        }


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}