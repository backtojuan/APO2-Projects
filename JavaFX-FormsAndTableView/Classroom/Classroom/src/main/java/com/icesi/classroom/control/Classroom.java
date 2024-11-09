package com.icesi.classroom.control;

import com.icesi.classroom.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.time.LocalDate;

public class Classroom {
    private static Classroom instance;
    private ObservableList<StudentAccount> students;
    private Classroom classroom;
    private Classroom() {
        students = FXCollections.observableArrayList();
    }

    public static Classroom getInstance() {
        if (instance == null) {
            instance = new Classroom();
        }
        return instance;
    }

    public void addStudent(String username, String password, Image image, Gender gender, Career career, LocalDate birthDate, Browser browser){
        StudentAccount student = new StudentAccount(username,password,image,gender,career,birthDate,browser);
        students.add(student);
    }

    public ObservableList<StudentAccount> getStudents(){
        return students;
    }

    public void setStudents(ObservableList<StudentAccount> students){
        this.students = students;
    }

    public boolean logIn(String username, String password){
        boolean flag = false;
        for (int i = 0; i < students.size() && !flag; i++) {
            if(students.get(i).getUsername().equals(username)){
                if(students.get(i).getPassword().equals(password)){
                    flag = true;
                }
            }
        }
        return flag;
    }
}
