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

public class RemovePatientController {

    public TextField txtf_email;
    public TextField txtf_id;
    public Button btn_remove;
    public Label lbl_removed;
    public Button btn_back;
    public ImageView img_remove;


    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //To Add pics
    @FXML
    public void initialize() {
        img_remove.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\x-icon-png-0.jpg"));
    }


    public void RemovePatient(ActionEvent event) throws SQLException {

            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
            String query = "delete from patients where email=? and patientId=?";
            pst = con.prepareStatement(query);
            pst.setString(1,txtf_email.getText());
            pst.setString(2,txtf_id.getText());

            pst.executeUpdate();
           // pst.close();
            lbl_removed.setText("Patient "+txtf_email.getText()+" is successfully removed");
    }

    public void GoToAdminLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
