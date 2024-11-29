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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenerateBillController {
    public TextField txtf_numOfDays;
    public TextField txtf_numOfOps;
    public TextField txtf_otherExpenses;
    public ComboBox cmb_roomType;
    public Button btn_generate;
    public Button btn_back;
    public Label lbl_bill;
    public Button btn_update;
    public TextField txtf_email;
    public ImageView img_bill;




    //Back button
    public void GoToAdminLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //To add options in comboBox and add pics
    @FXML
    public void initialize() {
        cmb_roomType.getItems().removeAll(cmb_roomType.getItems());
        cmb_roomType.getItems().addAll("ICU","OR","Regular","VIP","ER");
        img_bill.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\Bill-Icon-PNG-Transparent-Image.png"));
        //cmb_bloodType.getSelectionModel().select("-Select Your Blood Type-");
    }

    String bill;
    //Generate Bill method
    public void GenerateBill(){
         double room=0;

        if(cmb_roomType.getValue()=="ER"){
            room=500;
        }
        else if(cmb_roomType.getValue()=="Regular"){
            room=1000;
        }
        else if(cmb_roomType.getValue()=="OR"){
            room=1500;
        }
        else if(cmb_roomType.getValue()=="ICU"){
            room=2000;
        }

        else if(cmb_roomType.getValue()=="VIP"){
            room=3000;
        }
        bill = (Double.parseDouble(txtf_numOfDays.getText())*room + Double.parseDouble(txtf_otherExpenses.getText()) + 2000*Double.parseDouble(txtf_numOfOps.getText()))+"$";

        lbl_bill.setText(bill);
    }

    Connection con = null;
    PreparedStatement pst = null;

    public void Update(ActionEvent event) throws SQLException {

        String query = "update patients set Bill=? where email=?";
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");
        pst = con.prepareStatement(query);
        pst.setString(2,txtf_email.getText());
        pst.setString(1,lbl_bill.getText());
        pst.executeUpdate();

        Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
        successAlert.setHeaderText("Update Confirmed");
        successAlert.setContentText("Bill Updated successfully");
        successAlert.showAndWait();

    }
}
