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

import java.io.IOException;
import java.sql.*;

public class PatientLoginController {


    public TextField txtf_email;
    public TextField txtf_id;
    public Button btn_login;
    public Button btn_back;
    public Label lbl_welcome;
    public Button btn_calc;
    public Label lbl_bill;
    public ImageView img_patient;


    //To add pics
    @FXML
    public void initialize(){
        img_patient.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\BenMedica+Patient+Icon.png"));
    }




    //Login Button
    public void LoginPatient(ActionEvent event) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String Email = txtf_email.getText().toString();
        String patientId = txtf_id.getText().toString();

        String query = "select * from patients where Email=? and patientId=?";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);

        try{
            pst = con.prepareStatement(query);
            pst.setString(1,Email);
            pst.setString(2,patientId);
            rs = pst.executeQuery();

            if(!rs.next()){
                lbl_welcome.setText("Log in is unsuccessfull");
            }

            else
                lbl_welcome.setText("Welcome "+txtf_email.getText()+"!");
        } catch(Exception e){
            e.printStackTrace();
        }

        btn_calc.setText("Show Bill");

    }

    //Logout button
    public void GoToPatient(ActionEvent event)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Patient.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //To show bill
    public void CalcBill(ActionEvent event) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "select Bill from patients where email=? and patientId=?";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);

        pst.setString(1,txtf_email.getText());
        pst.setString(2,txtf_id.getText());
        rs = pst.executeQuery();
        if(rs.next()){
            lbl_bill.setText(rs.getString(1));
        }

    }
}
