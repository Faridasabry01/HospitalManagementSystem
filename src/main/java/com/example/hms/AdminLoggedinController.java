package com.example.hms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoggedinController {
    public Button btn_exit;
    public Button btn_addpatient;
    public Button btn_viewPatients;
    public Button btn_remove;
    public Button btn_addDoc;
    public Button btn_viewDocs;
    public Button btn_removeDoc;
    public Button btn_patientBill;
    public Button btn_calSal;
    public ImageView img_control;


    //To Add pics
    @FXML
    public void initialize() {
        img_control.setImage(new Image("D:\\Nour\\Term 6\\Object Oriented Programming\\HMS\\src\\main\\java\\com\\example\\hms\\pics\\settings-icon-13.png"));
    }


    public void GoToMainPage2(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToCalSal(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CalculateSalary.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void GoToAddPatient(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddPatient.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToViewPatients(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewPatients.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToRemovePatient(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemovePatient.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToAddDoctor(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddDoctor.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToViewDoctors(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ViewDoctors.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToRemoveDoctor(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RemoveDoctor.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToGenerateBill(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GenerateBill.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
