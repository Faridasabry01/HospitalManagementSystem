package com.example.hms;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewPatientsController implements Initializable {
    public TableView <ModelTablePatients> table_patients;
    public TableColumn <ModelTablePatients, String> col_name;
    public TableColumn <ModelTablePatients, String> col_id;
    public TableColumn <ModelTablePatients, String> col_address;
    public TableColumn <ModelTablePatients, String> col_email;
    public TableColumn<ModelTablePatients, String> col_phoneNum;
    public TableColumn <ModelTablePatients, String> col_age;
    public TableColumn <ModelTablePatients, String>col_gender;
    public TableColumn <ModelTablePatients, String>col_room;
    public TableColumn <ModelTablePatients, String>col_bloodType;
    public Button btn_back;
    public TableColumn col_bill;

    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");


    ObservableList<ModelTablePatients> obList = FXCollections.observableArrayList();

    public ViewPatientsController() throws SQLException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from patients");

            while (rs.next()){
                obList.add(new ModelTablePatients(rs.getString("patientName"),rs.getString("patientId"),rs.getString("Address"),
                        rs.getString("Email"),rs.getString("PhoneNumber"),rs.getString("Age"),
                        rs.getString("Gender"),rs.getString("Room"),rs.getString("BloodType"),rs.getString("Bill")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_name.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        col_age.setCellValueFactory((new PropertyValueFactory<>("Age")));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
        col_room.setCellValueFactory(new PropertyValueFactory<>("Room"));
        col_bloodType.setCellValueFactory(new PropertyValueFactory<>("BloodType"));
        col_bill.setCellValueFactory(new PropertyValueFactory<>("Bill"));

        table_patients.setItems(obList);
    }

    public void GoToAdminLoggedIn(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
