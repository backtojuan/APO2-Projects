package com.icesi.classroom.control;

import com.icesi.classroom.ClassroomApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController {

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField userNameField;

    @FXML
    private Alert alert;

    @FXML
    private void initialize(){
        alert = new Alert(Alert.AlertType.NONE);
    }

    @FXML
    public void logIn(ActionEvent event) {
        String username = userNameField.getText();
        String password = passwordField.getText();

        if(Classroom.getInstance().logIn(username,password)) {
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Login Successful");
            alert.show();
            ClassroomApplication.openWindow("/view.fxml");
        }
        else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Login Unsuccessful");
            alert.show();
        }
    }

    @FXML
    public void signUp(ActionEvent event) {

        ClassroomApplication.openWindow("/register.fxml");
    }

}
