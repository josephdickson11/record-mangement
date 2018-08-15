/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closedept;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.department;


public class ClosedeptController implements Initializable {

    @FXML
    private JFXButton close;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXTextField deptName;
    @FXML
    private AnchorPane closeDept;
    @FXML
    private Label mssgLbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closebtn(ActionEvent event) {
        String nameDept = deptName.getText();
        if (nameDept.isEmpty()) {
            mssgLbl.setText("please enter a department name");
        } else if (Mainproject.saveDepartment.containsKey(nameDept)) {

            Mainproject.saveDepartment.remove(nameDept);
        } else {
            mssgLbl.setText("Department does not exist");
        }
    }

    @FXML
    private void cancelbtn(ActionEvent event) {
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
            close.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(ClosedeptController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
