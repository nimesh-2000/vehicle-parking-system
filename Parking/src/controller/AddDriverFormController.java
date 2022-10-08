package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import java.util.Optional;

public class AddDriverFormController {
    public AnchorPane addDriverFormContext;
    public TextField txtDriverName;
    public TextField txtDrivingLicenseNo;
    public TextField txtNic;
    public TextField txtAddress;
    public TextField txtContactNo;

    public void addDriverOnAction(ActionEvent actionEvent) {
        if (txtDriverName.getText().equals("") || txtNic.getText().equals("") ||txtDrivingLicenseNo.getText().equals("") ||txtAddress.getText().equals("") || txtContactNo.getText().equals("")  ) {



            Alert alert=new Alert(Alert.AlertType.WARNING,"DATA NOT ENTERED",
                    ButtonType.OK);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if(buttonType.get().equals(ButtonType.OK)){


            }

        }
        else {

            if (txtContactNo.getText().matches("[0]{1}[0-9]{9}")&&txtDriverName.getText().matches("[A-Z]{1}[a-z]*[ ][A-Z]{1}[a-z]*")&& txtDrivingLicenseNo.getText().
                    matches("[B]{1}[0-9]{7}")&& txtNic.getText().matches("[0-9]{10}[V]{1}")&&txtAddress.getText().matches("[A-Z]{1}[a-z]*")){
                Driver d2 = new Driver(txtDriverName.getText(), txtNic.getText(), txtDrivingLicenseNo.getText(), txtAddress.getText(), txtContactNo.getText());
                Database.drivers.add(d2);
                new Alert(Alert.AlertType.CONFIRMATION,txtDriverName.getText()+" "+"Add Successfully!..").show();
                Stage stage = (Stage) addDriverFormContext.getScene().getWindow();
                stage.close();
            }else {

                if(txtContactNo.getText().matches("[0]{1}[0-9]{9}")!=true) {
                    Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong Contact Number!..",
                            ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();

                    txtContactNo.setText("");
                }
                if(txtDriverName.getText().matches("[A-Z]{1}[a-z]*[ ][A-Z]{1}[a-z]*")!=true) {
                    Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong Driver Name!..",
                            ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();

                    txtDriverName.setText("");
                }
                if(txtDrivingLicenseNo.getText(). matches("[B]{1}[0-9]{7}")!=true) {
                    Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong Driving License Number!..",
                            ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();

                    txtDrivingLicenseNo.setText("");
                }
                if(txtNic.getText().matches("[0-9]{10}[V]{1}")!=true) {
                    Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong NIC Number!..",
                            ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();

                    txtNic.setText("");
                }
                if(txtAddress.getText().matches("[A-Z]{1}[a-z]*")!=true) {
                    Alert alert=new Alert(Alert.AlertType.ERROR,"Wrong Address !..",
                            ButtonType.OK);
                    Optional<ButtonType> buttonType = alert.showAndWait();

                    txtAddress.setText("");
                }




            }


        }
    }


    }

