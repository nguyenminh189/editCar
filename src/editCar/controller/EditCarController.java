package editCar.controller;

import editCar.database.Connecter;
import editCar.entity.EditCar;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.PreparedStatement;
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
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/OurCars.fxml"));

    }
    public void submit(ActionEvent actionEvent){
        try {
            String Name = ipName.getText();
            String Position = ipPosition.getText();
            String Date = String.valueOf(ipDate.getValue());
            String sql = "update ";

            Connecter connecter = Connecter.getInstance();
            PreparedStatement pstm = connecter.getConn().prepareStatement(sql);
            pstm.setString(1, Name);
            pstm.setString(2, Position);
            pstm.setString(3, Date.toString());
            pstm.execute();

            backToList(null);

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