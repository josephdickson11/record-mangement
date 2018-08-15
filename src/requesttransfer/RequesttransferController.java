/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requesttransfer;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.Journal;
import objects.Student;
import objects.Studenttransfer;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class RequesttransferController implements Initializable {

    @FXML
    private JFXTextField matricnumber;
    @FXML
    private JFXTextField choicedestination;

    @FXML
    private JFXTextField reasonFortransfer;
    @FXML
    private JFXButton cancelrequest1;

    @FXML
    private Label messgLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancelTransferRequest(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainproject/studenthamburger.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Register");
            stage.setScene(new Scene(root));
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
            cancelrequest1.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(RequesttransferController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void processTransferRequest(ActionEvent event) {

        String matty = matricnumber.getText();
        String desty = choicedestination.getText();
        String resty = reasonFortransfer.getText();
        
        if(matty.equals(Mainproject.loggedIn.matno)){
            Journal j1 = new Journal(Mainproject.loggedIn.getFisrtname() + " Student Put in Request For Transfer", Mainproject.loggedIn.getMatno());
            Mainproject.jMemory.put(j1.getId(), j1);
            
        Student stud = mainproject.Mainproject.loggedIn;
        Studenttransfer trans = new Studenttransfer(matty, desty, resty, stud.getFaculty(), stud.getDepartment(), "Waiting for Approval", "Waiting for Approval");
        mainproject.Mainproject.makeTransfer.put(matty, trans);
        
        messgLbl.setText("Transfer Request Sent");
        matricnumber.clear();
        choicedestination.clear();
        reasonFortransfer.clear();
        }else {
        messgLbl.setText("Invalid Matric No_");
        }
    }

    @FXML
    private void viewRequestStatus(ActionEvent event) {
        Student stud = mainproject.Mainproject.loggedIn;
        Studenttransfer studT = mainproject.Mainproject.makeTransfer.get(stud.getMatno());
        
       

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("VIEW APPROVAL OF TRANSFER REQUEST");
        alert.setContentText(studT.getSchlStatusOfReq());
        alert.showAndWait();
    }

}
