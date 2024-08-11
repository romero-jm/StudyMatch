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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class PrintOut implements Initializable {

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

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/studymatch/login-view.fxml")));
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
