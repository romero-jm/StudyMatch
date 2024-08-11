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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginView implements Initializable {

    private static ArrayList<User> listUsers = Users.getUsers();
    static ObservableList<User> selected = FXCollections.observableArrayList();

    @FXML
    private TableColumn<User, String> profile;
    @FXML
    private TableColumn<User, String> idNo;
    @FXML
    private TableColumn<User, String> fullname;
    @FXML
    private TableColumn<User, String> coursecode;
    @FXML
    private TableColumn<User, String> lessons;
    @FXML
    private TableColumn<User, String> platforms;
    @FXML
    private TableColumn<User, String> chosenContact;
    @FXML
    private TableView<User> MainTable;

    private Scene scene;
    private Stage stage;

    public static void setData(String course) {
        for(User user : listUsers) {
            if(course.contains(user.getCourseID())){
                selected.add(user);
                System.out.println("Added "+ user.getName());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idNo.setCellValueFactory(new PropertyValueFactory<User, String>("IDNum"));
        fullname.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        coursecode.setCellValueFactory(new PropertyValueFactory<User, String>("courseID"));
        lessons.setCellValueFactory(new PropertyValueFactory<User, String>("lesson"));
        platforms.setCellValueFactory(new PropertyValueFactory<User, String>("mode"));
        chosenContact.setCellValueFactory(new PropertyValueFactory<User, String>("contact"));

        MainTable.setItems(selected);
        System.out.println(selected);
    }

    public void extBtn(ActionEvent event) throws IOException {
        MainTable.getItems().clear();
        MainTable.refresh();
        System.out.println(MainTable.getItems());
        System.out.println(selected);
        switchScene(event,"hello-view.fxml");
    }

    @FXML
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/studymatch/" + fxmlFile)));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
