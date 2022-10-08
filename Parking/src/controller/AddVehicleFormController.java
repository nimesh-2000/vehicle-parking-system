package controller;

import db.Database;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Vehicle;

import java.util.Optional;

public class AddVehicleFormController {
    public AnchorPane addVehicleFormContext;
    public TextField txtVehicleNumber;
    public TextField txtNoOfPassengers;
    public TextField txtMaximumWeight;
    public ComboBox cmbVehicleType;
    int next;

    public void initialize() {
        cmbVehicleType.getItems().add("Van");
        cmbVehicleType.getItems().add("Cargo Lorry");
        cmbVehicleType.getItems().add("Bus");
    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
        if (txtVehicleNumber.getText().equals("") || txtMaximumWeight.getText().equals("") || txtNoOfPassengers.getText().equals("") || cmbVehicleType.getValue() == null) {


            Alert alert = new Alert(Alert.AlertType.WARNING, "DATA NOT ENTERED",
                    ButtonType.OK);
            Optional<ButtonType> buttonType = alert.showAndWait();

            if (buttonType.get().equals(ButtonType.OK)) {


            }

        } else {
            switch ((String) cmbVehicleType.getValue()) {
                case "Van":
                    if (txtVehicleNumber.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") && txtMaximumWeight.getText().
                            matches("[0-9]{3}") && txtNoOfPassengers.getText().matches("[1-9]{1}")) {
                        Vehicle v1 = new Vehicle(txtVehicleNumber.getText(), (String) cmbVehicleType.getValue(), txtMaximumWeight.getText(), txtNoOfPassengers.getText());
                        Database.vehicles.add(v1);
                        new Alert(Alert.AlertType.CONFIRMATION, "Van add Successfully!..").show();

                        Stage stage = (Stage) addVehicleFormContext.getScene().getWindow();
                        stage.close();
                    }else{
                        if (txtVehicleNumber.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Vehicle Number!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                        if (txtMaximumWeight.getText().matches("[0-9]{3}") && txtMaximumWeight.getText().matches("[0-9]{4}") &&
                                txtMaximumWeight.getText().matches("[0-9]{5}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Illegal weight!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                        if (txtNoOfPassengers.getText().matches("[1-9]{1}") && txtNoOfPassengers.getText().matches("[1-9]{1,2}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Illegal Passengers!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                    }

                    break;
                case "Bus":
                    if (txtVehicleNumber.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") && txtMaximumWeight.getText().
                            matches("[0-9]{4}") && txtNoOfPassengers.getText().matches("[1-9]{1,2}")) {
                        Vehicle v1 = new Vehicle(txtVehicleNumber.getText(), (String) cmbVehicleType.getValue(), txtMaximumWeight.getText(), txtNoOfPassengers.getText());
                        Database.vehicles.add(v1);
                        new Alert(Alert.AlertType.CONFIRMATION, "Bus add Successfully!..").show();
                        Stage stage = (Stage) addVehicleFormContext.getScene().getWindow();
                        stage.close();
                    } else{
                        if (txtVehicleNumber.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Vehicle Number!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                        if (txtMaximumWeight.getText().matches("[0-9]{3}") && txtMaximumWeight.getText().matches("[0-9]{4}") &&
                                txtMaximumWeight.getText().matches("[0-9]{5}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Illegal weight!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                        if (txtNoOfPassengers.getText().matches("[1-9]{1}") && txtNoOfPassengers.getText().matches("[1-9]{1,2}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Illegal Passengers!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                    }
                    break;
                case "Cargo Lorry":
                    if (txtVehicleNumber.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") && txtMaximumWeight.getText().
                            matches("[0-9]{5}") && txtNoOfPassengers.getText().matches("[1-9]{1}")) {
                        Vehicle v1 = new Vehicle(txtVehicleNumber.getText(), (String) cmbVehicleType.getValue(), txtMaximumWeight.getText(), txtNoOfPassengers.getText());
                        Database.vehicles.add(v1);
                        new Alert(Alert.AlertType.CONFIRMATION, "Cargo Lorry add Successfully!..").show();
                        Stage stage = (Stage) addVehicleFormContext.getScene().getWindow();
                        stage.close();
                    } else {
                        if (txtVehicleNumber.getText().matches("[A-Z 0-9]{2}[-][0-9]{4}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Wrong Vehicle Number!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                        if (txtMaximumWeight.getText().matches("[0-9]{3}") && txtMaximumWeight.getText().matches("[0-9]{4}") &&
                                txtMaximumWeight.getText().matches("[0-9]{5}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Illegal weight!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }
                        if (txtNoOfPassengers.getText().matches("[1-9]{1}") && txtNoOfPassengers.getText().matches("[1-9]{1,2}") != true) {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Illegal Passengers!..",
                                    ButtonType.OK);
                            Optional<ButtonType> buttonType = alert.showAndWait();

                            txtVehicleNumber.setText("");
                        }



                    }
                    break;
            }


        }

    }

 
}


