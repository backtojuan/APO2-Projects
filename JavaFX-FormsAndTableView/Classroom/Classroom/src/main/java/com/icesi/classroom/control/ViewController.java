package com.icesi.classroom.control;

import com.icesi.classroom.model.Career;
import com.icesi.classroom.model.Gender;
import com.icesi.classroom.model.StudentAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ViewController {

    @FXML
    private Button logOut;

    @FXML
    private ImageView studentProfilePic;

    @FXML
    private TableView<StudentAccount> studentsTable;

    @FXML
    private TableColumn<StudentAccount, String> usernameColumn;

    @FXML
    private TableColumn<StudentAccount, Gender> genderColumn;

    @FXML
    private TableColumn<StudentAccount, Career> careerColumn;

    @FXML
    private TableColumn<StudentAccount, LocalDate> birthdateColumn;

    private Classroom classroom;

    @FXML
    private void initialize(){
        classroom = Classroom.getInstance();

        studentsTable.setItems(classroom.getStudents());
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
        careerColumn.setCellValueFactory(new PropertyValueFactory<>("career"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
    }

    @FXML
    private void logOut(ActionEvent event) {

    }

    private void closeWindow(){
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.close();
    }
}
