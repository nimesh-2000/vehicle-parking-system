package controller;

import db.Database;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Driver;
import model.InParking;
import model.OnDilivery;
import model.Vehicle;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class ParkingSystemFormController extends ParkingSlotType{
    public AnchorPane parkingSystemContext;
    public ComboBox cmbSelectVehicle;
    public ComboBox cmbDriver;
    public Label lblDate;
    public Label lblTime;
    public Label lblSlot;
    public Label lblType;
    int next;
    String addVehicleNo[]=new String[14];


    public void initialize() {
        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            park((String) newValue);

            if (isExistsSlot()) {
                lblSlot.setText("This vehicle already park");
            }else {
                lblSlot.setText(vehicleSlot);
            }
        });
        dateAndTime();


        ObservableList<String> vehicleList = FXCollections.observableArrayList();
        for (Vehicle v1: Database.vehicles){
            vehicleList.add(v1.getVehicleNo());
        }
        cmbSelectVehicle.setItems(vehicleList);

        ObservableList<String> driverList = FXCollections.observableArrayList();
        for (Driver d1: Database.drivers){
            driverList.add(d1.getName());
        }
        cmbDriver.setItems(driverList);

    }


    private void dateAndTime() {

        Calendar clndr = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat(" aa");



        Timeline clock = new Timeline(new KeyFrame(Duration.INDEFINITE.ZERO, e -> {
            LocalTime currenttime = LocalTime.now();
            LocalDate currentdate = LocalDate.now();
            lblTime.setText(currenttime.getHour() + ":" + currenttime.getMinute() + ":" + currenttime.getSecond()+"  "+format1.format(clndr.getTime()));
            lblDate.setText(currentdate.getDayOfMonth() + "-" + currentdate.getMonthValue() + "-" + currentdate.getYear());

        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }



    public void parkVehicleOnAction(ActionEvent actionEvent) {
        if (isExistsSlot()) {
            new Alert(Alert.AlertType.WARNING, "Already Parked!!").show();
        }else {
            InParking inParking = new InParking((String) cmbSelectVehicle.getValue(), lblType.getText(), lblSlot.getText(), lblTime.getText());
            Database.inParking.add(inParking);
            addVehicleNo[next++] = (String) cmbSelectVehicle.getValue();
        }



    }

    public void onDiliveryOnAction(ActionEvent actionEvent) {

        if (Database.inParking.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "NOT PARKED VEHICLE!..");
            alert.show();

        } else {
            for (int i = 0; i < Database.inParking.size(); i++) {
                if (cmbSelectVehicle.getValue().equals(Database.inParking.get(i).getVehicleNo())) {
                    Database.inParking.remove(i);
                    OnDilivery onDilivery = new OnDilivery((String) cmbSelectVehicle.getValue(), lblType.getText(), (String) cmbDriver.getValue(), lblTime.getText());
                    Database.onDilivery.add(onDilivery);
                    new Alert(Alert.AlertType.CONFIRMATION, "DILIVERED!..").show();
                    break;

                }
            }


        }
    }


    public void managementLogInOnAction(ActionEvent actionEvent) throws IOException {
        Database.a= parkingSystemContext;
        URL resource = getClass().getResource("../view/ManagementLoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void selectVehicleOnAction(ActionEvent actionEvent) {
        for (int i=0; i<Database.vehicles.size();i++){
            if (cmbSelectVehicle.getValue().equals(Database.vehicles.get(i).getVehicleNo())){

                lblType.setText(Database.vehicles.get(i).getVehicleType());
            }
        }

    }
    public boolean isExistsSlot(){
        for (int i = 0; i<next; i++){
            if (addVehicleNo[i].equals(cmbSelectVehicle.getValue())){
                return true;
            }
        }return false;
    }

}


