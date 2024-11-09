package com.icesi.classroom.control;

import com.icesi.classroom.model.Browser;
import com.icesi.classroom.model.Career;
import com.icesi.classroom.model.Gender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;

public class RegisterController {

    @FXML
    private BorderPane pane;

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private Button browseProfilePictureButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private ChoiceBox<Browser> favBrowserMenu;

    @FXML
    private CheckBox femaleCheckBox;

    @FXML
    private CheckBox maleCheckbox;

    @FXML
    private CheckBox otherGenderCheckBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox systemsCareerCheckBox;

    @FXML
    private CheckBox telematicsCareerCheckBox;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField pathField;

    @FXML
    private Stage stage;

    @FXML
    private Alert alert;

    @FXML
    private void browseProfilePicture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            pathField.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void initialize(){
        stage = new Stage();
        ObservableList<Browser> options = FXCollections.observableArrayList(Browser.values());
        favBrowserMenu.setItems(options);
        
        alert = new Alert(Alert.AlertType.NONE);
    }

    @FXML
    private void createStudentAccount(ActionEvent event) {
        String username = userNameField.getText();
        String password = passwordField.getText();
        Image image = new Image(pathField.getText());
        Gender gender = null;
        if (maleCheckbox.isSelected()) {
            gender = Gender.Male;
        } else if (femaleCheckBox.isSelected()) {
            gender = Gender.Female;
        } else {
            gender = Gender.Other;
        }
        Career career = null;
        if (systemsCareerCheckBox.isSelected()) {
            career = Career.SystemsEngineering;
        } else {
            career = Career.TelematicsEngineering;
        }
        LocalDate birthdate = birthDatePicker.getValue();
        Browser browser = favBrowserMenu.getValue();

        Classroom.getInstance().addStudent(username, password, image, gender, career, birthdate, browser);
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Student Account Created");
        alert.show();
        closeWindow();
    }

    @FXML
    private void returnToLogInView(ActionEvent event) {
        closeWindow();
    }

    private void closeWindow(){
        Stage stage = (Stage) browseProfilePictureButton.getScene().getWindow();
        stage.close();
    }
}