package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.stage.Stage;

import java.io.IOException;

import java.sql.SQLException;

public class PatientController {


    public ToggleGroup tglGender;

    public TextField txtf_loginEmail;
    public TextField txtf_loginId;
    public Button btn_login;
    public Button btn_back;
    public TextField txtf_name;
    public TextField txtf_id;
    public TextField txtf_address;
    public TextField txtf_email;
    public TextField txtf_phoneNum;
    public TextField txtf_age;
    public RadioButton rd_male;
    public RadioButton rd_female;
    public ComboBox cmb_bloodType;
    public Button btn_signup;
    public TextField txtf_room;
    public ImageView img_patient;

    String Gender;

    Connection con = null;
    PreparedStatement pst = null;



    //To add options in comboBox and add pics
    @FXML
    public void initialize() {
        img_patient.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\BenMedica+Patient+Icon.png"));
        cmb_bloodType.getItems().removeAll(cmb_bloodType.getItems());
        cmb_bloodType.getItems().addAll("O+", "O-", "A+","A-","B+","B-","AB+","AB-");
       // cmb_bloodType.getSelectionModel().select("-Select Your Blood Type-");
    }

    //Sign up form sends to database
    public void AddPatient(ActionEvent event) throws SQLException {
        if(rd_female.isSelected()){
            Gender=rd_female.getText();
        }
        else if(rd_male.isSelected()){
            Gender=rd_male.getText();
        }
        String query = "insert into patients values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);
        pst.setString(1,txtf_name.getText());
        pst.setString(2,txtf_id.getText());
        pst.setString(3,txtf_address.getText());
        pst.setString(4,txtf_email.getText());
        pst.setString(5,txtf_phoneNum.getText());
        pst.setString(6,txtf_age.getText());
        pst.setString(7,Gender);
        pst.setString(8,txtf_room.getText());
        pst.setString(9, (String) cmb_bloodType.getValue());
        pst.setString(10,null);
        pst.executeUpdate();

        Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
        successAlert.setHeaderText("Sign Up Confirmed");
        successAlert.setContentText("Welcome!");
        successAlert.showAndWait();
    }

    public void GoToMain(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToPatientLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PatientLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
