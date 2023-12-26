package editCar.controller;

import editCar.entity.EditCar;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class EditCarController implements Initializable {
    public TextField ipName;
    public Button ipSubmit;
    public DatePicker ipDate;
    public TextArea ipPosition;
    public static EditCar editCardetails;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        ipName.setText(editCardetails.getName());
        ipDate.setValue(editCardetails.getDate());
        ipPosition.setText(editCardetails.getPosition());
    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../entity/CarDetail.fxml"));

    }
    public void submit(ActionEvent actionEvent){
        try {
            String Name = ipName.getText();
            String Position = ipPosition.getText();
            String Date = String.valueOf(ipDate.getValue());


        }catch (Exception e){
            showAlert(e.getMessage());
        }
    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.show();

    }


}