package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.IOException;

public class AdminController {
    public Button btn_logout;
    public TextField txtf_password;
    public TextField txtf_username;
    public Button btn_login;
    public Label lbl_suscceslogin;
    public ImageView img_admin;

    public void GoToMainPage(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void AdminLogin(ActionEvent event) throws IOException {
        String username = txtf_username.getText();
        String password = txtf_password.getText();


        if(username.equals("hospitalAdmin") && password.equals("Admin123")){
            Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Please enter the correct credentials.");
            errorAlert.showAndWait();
        }
    }

    @FXML
    public void initialize(){
        img_admin.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\download (2).png"));
    }

}
