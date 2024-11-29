package com.example.hms;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AddPatientController {
    //public Label btn_successadd;
    public Button btn_add;
    public TextField txtf_id;
    public TextField txtf_name;
    public Label lbl_successadd;
    public TextField txtf_address;
    public TextField txtf_email;
    public TextField txtf_phonenum;
    public TextField txtf_age;
    public TextField txtf_room;
    public RadioButton rd_male;
    public RadioButton rd_female;
    public ComboBox cmb_bloodType;
    public Button btn_back;
    public ToggleGroup tglGender;
    public TextField txtf_bill;
    public ImageView img_patient;
    String Gender;



    Connection con = null;
    PreparedStatement pst = null;

    public void GoToAdminLoggedIn(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //To add options in comboBox
    public void initialize() {
        cmb_bloodType.getItems().removeAll(cmb_bloodType.getItems());
        cmb_bloodType.getItems().addAll("O+", "O-", "A+","A-","B+","B-","AB+","AB-");
        cmb_bloodType.getSelectionModel().select("-Select Your Blood Type-");
        img_patient.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\patient-icon-png-21.png"));
    }
    public void AddPatient(ActionEvent event) throws SQLException {
        if(rd_female.isSelected()){
            Gender=rd_female.getText();
        }
        else if(rd_male.isSelected()){
            Gender=rd_male.getText();
        }
        try {
            String query = "insert into patients values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial", "root", "Root_Password");
            pst = con.prepareStatement(query);
            pst.setString(1, txtf_name.getText());
            pst.setString(2, txtf_id.getText());
            pst.setString(3, txtf_address.getText());
            pst.setString(4, txtf_email.getText());
            pst.setString(5, txtf_phonenum.getText());
            pst.setString(6, txtf_age.getText());
            pst.setString(7, Gender);
            pst.setString(8, txtf_room.getText());
            pst.setString(9, (String) cmb_bloodType.getValue());
            pst.setString(10, txtf_bill.getText());
            pst.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
            successAlert.setHeaderText("Registration Confirmed");
            successAlert.setContentText("Patient added successfully");
            successAlert.showAndWait();
        }
        catch (Exception e)
        {

        }

    }
}
