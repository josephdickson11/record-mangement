/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treattransferrequest;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.Studenttransfer;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class TreattransferrequestController implements Initializable {

    @FXML
    private JFXButton accept;
    @FXML
    private JFXButton back;
    @FXML
    private TableView transferTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<Studenttransfer> reqTransfer = new ArrayList<>();
        for (String key : mainproject.Mainproject.makeTransfer.keySet()) {
            if(mainproject.Mainproject.makeTransfer.get(key).getDeptStatusOfReq().equals("Waiting for Approval") || mainproject.Mainproject.makeTransfer.get(key).getDeptStatusOfReq().equals("Rejected") ){
            continue;
            }
            reqTransfer.add(mainproject.Mainproject.makeTransfer.get(key));
        }
        transferTable.setItems(FXCollections.observableArrayList(reqTransfer));

    }

    @FXML
    private void acceptbtn(ActionEvent event) {
        
        

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("CONFIRM APPROVAL OF TRANSFER");
        alert.setContentText("APPROVE TRANSFER?");
        ButtonType approve = new ButtonType("Approve");
        ButtonType disApprove = new ButtonType("Reject");

        alert.getButtonTypes().setAll(approve, disApprove);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get().equals(approve)) {

                    ObservableList<Studenttransfer> obby1 = transferTable.getSelectionModel().getSelectedItems();
            for (Studenttransfer studTransfer : obby1) {
                studTransfer.setSchlStatusOfReq("Approved");
            }
        }
        else{
                    ObservableList<Studenttransfer> obby = transferTable.getSelectionModel().getSelectedItems();
            for (Studenttransfer studTransfer : obby) {
                studTransfer.setSchlStatusOfReq("Rejected");
                
            }
        }
        initialize(null, null);

    }

    @FXML
    private void expelButton(ActionEvent event) {
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
            back.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(TreattransferrequestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
