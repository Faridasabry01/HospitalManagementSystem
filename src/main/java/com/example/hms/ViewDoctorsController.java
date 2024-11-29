package com.example.hms;

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

public class ViewDoctorsController implements Initializable {
    public TableView <ModelTableDoctors> tbl_doc;
    public TableColumn <ModelTableDoctors, String> col_name;
    public TableColumn <ModelTableDoctors, String> col_id;
    public TableColumn <ModelTableDoctors, String> col_address;
    public TableColumn <ModelTableDoctors, String> col_email;
    public TableColumn <ModelTableDoctors, String> col_phoneNum;
    public TableColumn <ModelTableDoctors, String> col_age;
    public TableColumn <ModelTableDoctors, String> col_specialty;
    public TableColumn <ModelTableDoctors, String> col_hours;
    public TableColumn <ModelTableDoctors, String> col_salary;
    public TableColumn <ModelTableDoctors, String> col_yoe;
    public TableColumn <ModelTableDoctors, String> col_room;
    public Button btn_back;

    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx-trial","root","Root_Password");

    ObservableList<ModelTableDoctors> obList = FXCollections.observableArrayList();

    public ViewDoctorsController() throws SQLException {
    }

    public void GoToAdminLogin(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ResultSet rs = conn.createStatement().executeQuery("select * from doctors");

            while (rs.next()){
                obList.add(new ModelTableDoctors(rs.getString("doctorName"), rs.getString("doctorId"),
                        rs.getString("Address"),rs.getString("Email"),rs.getString("PhoneNumber"),
                        rs.getString("Age"),rs.getString("Specialty"), rs.getString("Hours"),
                        rs.getString("Salary"), rs.getString("YOE"), rs.getString("Room")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_name.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        col_phoneNum.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        col_age.setCellValueFactory((new PropertyValueFactory<>("Age")));
        col_specialty.setCellValueFactory(new PropertyValueFactory<>("Specialty"));
        col_hours.setCellValueFactory(new PropertyValueFactory<>("Hours"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        col_yoe.setCellValueFactory(new PropertyValueFactory<>("YOE"));
        col_room.setCellValueFactory(new PropertyValueFactory<>("Room"));
        tbl_doc.setItems(obList);

    }
}
