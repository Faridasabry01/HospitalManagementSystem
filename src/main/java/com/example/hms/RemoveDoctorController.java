package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class RemoveDoctorController {
    public Button btn_remove;
    public Button btn_back;
    public TextField txtf_email;
    public TextField txtf_id;
    public Label lbl_removed;


    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void RemovePatient(ActionEvent event) throws SQLException {

        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        String query = "delete from doctors where Email=? and doctorId=?";
        pst = con.prepareStatement(query);
        pst.setString(1,txtf_email.getText());
        pst.setString(2,txtf_id.getText());

        pst.executeUpdate();
        // pst.close();
           lbl_removed.setText("Doctor "+txtf_email.getText()+" is successfully removed");
    }




    public void GoToAdminLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
