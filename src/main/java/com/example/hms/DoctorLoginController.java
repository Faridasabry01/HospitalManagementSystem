package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DoctorLoginController {
    public Button btn_login;
    public TextField txtf_email;
    public TextField txtf_id;
    public Label lbl_welcome;
    public Button btn_logout;
    public Button btn_calc;
    public Label lbl_salary;
    public ImageView img_doc;

    //Back button
    public void GoToMain(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //To add pics
    @FXML
    public void initialize(){
        img_doc.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\48-489387_blue-veterinarian-icon-doctor-clipart-black-and-white.png"));
    }



    public void LoginDoctor(ActionEvent event) throws SQLException, IOException {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String Email = txtf_email.getText().toString();
        String doctorId = txtf_id.getText().toString();

        String query = "select * from doctors where Email=? and doctorId=?";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);

        try{
            pst = con.prepareStatement(query);
            pst.setString(1,Email);
            pst.setString(2,doctorId);
            rs = pst.executeQuery();

            if(!rs.next()){
                lbl_welcome.setText("Log in is unsuccessfull");
            }

            else{
                lbl_welcome.setText("Welcome "+txtf_email.getText()+"!");
                btn_calc.setText("Show Salary");
            }

        } catch(Exception e){
            e.printStackTrace();
        }



    }


    //To show salary
    public void CalcSalary(ActionEvent event) throws SQLException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String query = "select Salary from doctors where email=? and doctorId=?";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);

        pst.setString(1,txtf_email.getText());
        pst.setString(2,txtf_id.getText());
        rs = pst.executeQuery();
        if(rs.next()){
            lbl_salary.setText(rs.getString(1));
        }

    }
}
