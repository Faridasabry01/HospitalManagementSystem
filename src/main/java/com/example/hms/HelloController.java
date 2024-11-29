package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloController {

    public ImageView img_adminPic;
    public ImageView img_patient;
    public Button btn_patient;
    public ImageView img_doc;
    public Button btn_doc;
    //public ImageView img_bg;

    //To add pics
    @FXML
    public void initialize(){
        img_adminPic.setImage(new Image("src\\main\\java\\com\\example\\hms\\pics\\download (2).png"));
        img_patient.setImage(new Image("src\\main\\java\\com\\example\\hms\\pics\\BenMedica+Patient+Icon.png"));
        img_doc.setImage(new Image("src\\main\\java\\com\\example\\hms\\pics\\48-489387_blue-veterinarian-icon-doctor-clipart-black-and-white.png"));
    }
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    @FXML
    private Button btn_admin;

    public void GoToAdmin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToPatient(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Patient.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToDoctorLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DoctorLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

