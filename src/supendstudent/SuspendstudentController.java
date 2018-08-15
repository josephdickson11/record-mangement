/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supendstudent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class SuspendstudentController implements Initializable {

    @FXML
    private JFXButton cancelbtn;
    @FXML
    private AnchorPane selectMatNo;
    @FXML
    private JFXButton suspendBtn;
    @FXML
    private JFXTextField suspendStu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancelButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainproject/schoolhamburger.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);

            stage.setScene(new Scene(root1));
            stage.show();
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                @Override
                public void handle(WindowEvent e) {
                    try {
                        System.out.println("save");
                        Mainproject.save();

                    } catch (IOException ex) {
                        ex.printStackTrace();

                    }

                }

            });
            //closing this window
            cancelbtn.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SuspendstudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void suspendButton(ActionEvent event) {
        String u = suspendStu.getText();

        if (u.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Login");
            alert.setContentText("Empty");
            alert.showAndWait();

        } else if (Mainproject.saveStudent.containsKey(u)) {
            Mainproject.saveStudent.get(u).setSuspendStatus("SUSPENDED");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Login");
            alert.setContentText("No Studen");
            alert.showAndWait();
        }

    }

}
