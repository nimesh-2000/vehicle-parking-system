package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginFormController{
    public AnchorPane managementLoginContext;
    public TextField txtUserName;
    public PasswordField pwdPassword;
    int attempts=0;

    public void cancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) managementLoginContext.getScene().getWindow();
        stage.close();
    }

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        attempts++;
        if (attempts<=3) {
            String tempUserName = txtUserName.getText();
            String tempPassword = pwdPassword.getText();
            if (tempUserName.equals("admin") && tempPassword.equals("1234")) {
                Stage stage = (Stage) managementLoginContext.getScene().getWindow();
                stage.close();
                Database.a.getChildren().clear();
                Parent parent = FXMLLoader.load(getClass().getResource("../view/InParkingForm.fxml"));
                Database.a.getChildren().add(parent);

            } else {
                new Alert(Alert.AlertType.WARNING, "Try again").show();
            }
        }else {
            txtUserName.setEditable(false);
            pwdPassword.setEditable(false);
        }

        }



    }




