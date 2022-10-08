package controller;

import com.jfoenix.controls.JFXButton;
import db.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.InParking;
import model.OnDilivery;
import view.TM.InParkingTM;
import view.TM.OnDiliveryTM;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class InParkingFormController {
    public AnchorPane inParkingFormContext;
    public ComboBox cmbInParking;
    public TableView tblInParking;
    public TableColumn colVehicleType;
    public JFXButton btnLogOut;
    public TableColumn colVehicleNo;
    public TableColumn colSlotNo;
    public TableColumn colParkedTime;


    public void initialize(){
       cmbInParking.getItems().add("In Parking");
        cmbInParking.getItems().add("On Dilivery");

        loadInParkingTable();
    }
    private void loadInParkingTable() {
        ObservableList<InParkingTM> parking = FXCollections.observableArrayList();
        for (InParking i : Database.inParking) {
            InParkingTM p = new InParkingTM(i.getVehicleNo(), i.getVehicleType(), i.getParkingSlot(), i.getParkedTime());
            parking.add(p);
        }
        colVehicleNo.setCellValueFactory(new PropertyValueFactory("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colSlotNo.setCellValueFactory(new PropertyValueFactory("parkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("parkedTime"));
        tblInParking.setItems(parking);
    }


    private void loadOnDiliveryTable(){
        ObservableList<OnDiliveryTM> dilivery = FXCollections.observableArrayList();
        for (OnDilivery i: Database.onDilivery){
            OnDiliveryTM d=new OnDiliveryTM(i.getVehicleNo(),i.getVehicleType(),i.getDriverName(),i.getLeftTime());
            dilivery.add(d);


        }
        colVehicleNo.setCellValueFactory(new PropertyValueFactory("vehicleNo"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory("vehicleType"));
        colSlotNo.setCellValueFactory(new PropertyValueFactory("DriverName"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory("leftTime"));
        tblInParking.setItems(dilivery);
    }

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        inParkingFormContext.getChildren().clear();
        Parent parent= FXMLLoader.load(getClass().getResource("../view/ParkingSystemForm.fxml"));
        inParkingFormContext.getChildren().add(parent);


    }




    public void InParkingOnAction(ActionEvent actionEvent) {
        if (cmbInParking.getValue().equals("On Dilivery")){
            colSlotNo.setText("Driver Name");
            colParkedTime.setText("Left Time");
            btnLogOut.setVisible(false);
            loadOnDiliveryTable();
        }
        if (cmbInParking.getValue().equals("In Parking")){
            btnLogOut.setVisible(true);
            colSlotNo.setText("Parking Slot");
            colParkedTime.setText("Parked Time");

            loadInParkingTable();
        }
    }
}
