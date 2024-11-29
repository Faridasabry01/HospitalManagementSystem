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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculateSalaryController {
    public Label lbl_calc;
    public TextField txtf_email;
    public TextField txtf_yoe;
    public TextField txtf_numOfOP;
    public TextField txtf_numOfApp;
    public TextField txtf_initialSal;
    public Button btn_calc;
    public Button btn_update;
    public Button btn_back;
    public ImageView img_salary;


    //To Add pics
    @FXML
    public void initialize() {
        img_salary.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\Bill-Icon-PNG-Transparent-Image.png"));

    }




    //Back button
    public void GoToAdminLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    String sal;
    //To calculate
    public void CalculateSal(){
        sal = (Double.parseDouble(txtf_initialSal.getText()) + 250*Double.parseDouble(txtf_numOfApp.getText()) +
                1500*Double.parseDouble(txtf_numOfOP.getText())+ 8000*Double.parseDouble(txtf_yoe.getText()))+ "$";

        lbl_calc.setText(sal);
    }

    //To Update
    Connection con = null;
    PreparedStatement pst = null;
    public void UpdateDoc(ActionEvent event) throws SQLException {

        String query = "update doctors set Salary=? where email=?";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);
        pst.setString(2,txtf_email.getText());
        pst.setString(1,lbl_calc.getText());
        pst.executeUpdate();

        Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
        successAlert.setHeaderText("Update Confirmed");
        successAlert.setContentText("Salary Updated successfully");
        successAlert.showAndWait();

    }
}
