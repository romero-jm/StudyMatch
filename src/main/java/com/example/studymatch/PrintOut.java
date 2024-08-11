package com.example.studymatch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class PrintOut implements Initializable,WindowInterface {

    @FXML
    private TableColumn<User, String> newID;
    @FXML
    private TableColumn<User, String> newName;
    @FXML
    private TableColumn<User, String> newCourse;
    @FXML
    private TableColumn<User, String> newLessons;
    @FXML
    private TableColumn<User, String> newPlatforms;
    @FXML
    private TableColumn<User, String> newContacts;
    @FXML
    private TableView<User> SecondTable;

    private Stage stage;
    private Scene scene;

    static ObservableList<User> finalList = FXCollections.observableArrayList();

    public void onExit(ActionEvent event) throws IOException {
        SecondTable.getItems().clear();
        SecondTable.refresh();
        switchScene(event,"login-view.fxml");
    }

    public void onExport(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fileChooser.setTitle("Save User List");
        fileChooser.setInitialFileName("out.txt");
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (User user : finalList) {
                    writer.write("ID: " + user.getIDNum() + "\n");
                    writer.write("Name: " + user.getName() + "\n");
                    writer.write("Course: " + user.getCourseID() + "\n");
                    writer.write("Lessons: " + user.getLesson() + "\n");
                    writer.write("Platforms: " + user.getMode() + "\n");
                    writer.write("Contacts: " + user.getContact() + "\n");
                    writer.write("\n"); // Add a blank line between users
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/studymatch/"+fxmlFile)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void setData(ArrayList<User> data) {
        finalList.addAll(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newID.setCellValueFactory(new PropertyValueFactory<User, String>("IDNum"));
        newName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        newCourse.setCellValueFactory(new PropertyValueFactory<User, String>("courseID"));
        newLessons.setCellValueFactory(new PropertyValueFactory<User, String>("lesson"));
        newPlatforms.setCellValueFactory(new PropertyValueFactory<User, String>("mode"));
        newContacts.setCellValueFactory(new PropertyValueFactory<User, String>("contact"));

        SecondTable.setItems(finalList);
        System.out.println(finalList);
    }
}
