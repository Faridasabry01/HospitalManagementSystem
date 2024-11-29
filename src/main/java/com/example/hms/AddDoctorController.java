package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDoctorController {
    public TextField txtf_name;
    public TextField txtf_id;
    public TextField txtf_address;
    public TextField txtf_email;
    public TextField txtf_phonenNum;
    public TextField txtf_age;
    public ComboBox cmb_specialty;
    public TextField txtf_hours;
    public TextField txtf_salary;
    public TextField txtf_yoe;
    public TextField txtf_room;
    public Button btn_add;
    public Button btn_back;
    public ImageView img_st;

    //Back Button
    public void GoToAdminLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //To add options in comboBox
    public void initialize() {
        cmb_specialty.getItems().removeAll(cmb_specialty.getItems());
        cmb_specialty.getItems().addAll("Neuro", "Ortho", "Cardio","Peds");
        img_st.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\stethoscope-icon-21.png"));
        //cmb_specialty.getSelectionModel().select("-Select Your Blood Type-");
    }

    //To connect with database
    Connection con = null;
    PreparedStatement pst = null;
    public void AddDoctor(ActionEvent event) throws SQLException {

        String query = "insert into doctors values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);
        pst.setString(1,txtf_name.getText());
        pst.setString(2,txtf_id.getText());
        pst.setString(3,txtf_address.getText());
        pst.setString(4,txtf_email.getText());
        pst.setString(5,txtf_phonenNum.getText());
        pst.setString(6,txtf_age.getText());
        pst.setString(7,(String)cmb_specialty.getValue());
        pst.setString(8, txtf_hours.getText());
        pst.setString(9, txtf_salary.getText());
        pst.setString(10, txtf_yoe.getText());
        pst.setString(11,txtf_room.getText());
        pst.executeUpdate();

        Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
        successAlert.setHeaderText("Registration Confirmed");
        successAlert.setContentText("Doctor added successfully!");
        successAlert.showAndWait();

    }
}
