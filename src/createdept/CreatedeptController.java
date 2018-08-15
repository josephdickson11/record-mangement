/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createdept;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.effects.JFXDepthManager;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.department;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class CreatedeptController implements Initializable {

    @FXML
    private VBox departmentinfo;
    @FXML
    private VBox departmentphil;
    @FXML
    private JFXComboBox selectfaculty;
    @FXML
    private JFXTextField inputdeptname;
    @FXML
    private JFXTextField createabbrv;
    @FXML
    private JFXTextField HODname;
    @FXML
    private JFXComboBox yearofstudy;
    @FXML
    private JFXTextArea deptphil;
    @FXML
    private JFXButton createdept;
    @FXML
    private JFXButton back;
    @FXML
    private JFXTextField pogram;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> selectFact1 = FXCollections.observableArrayList("SICT", "SEET", "SEMT", "SAAT", "SET");
        ObservableList<Integer> yearofstudy1 = FXCollections.observableArrayList(1, 2, 3, 4, 5);

        selectfaculty.setItems(selectFact1);
        yearofstudy.setItems(yearofstudy1);

        //  JFXDepthManager.setDepth(departmentphil, 2);
        // JFXDepthManager.setDepth(departmentinfo, 2);
    }

    @FXML
    private void createDept(ActionEvent event) {

        String factyy = selectfaculty.getValue().toString();
        String deptty = inputdeptname.getText();
        String abbrev = createabbrv.getText();
        String hoddy = HODname.getText();
        String yearry = yearofstudy.getValue().toString();
        String proggy = pogram.getText();

        if (!factyy.isEmpty() || !deptty.isEmpty() || !abbrev.isEmpty() || !hoddy.isEmpty() || !yearry.isEmpty() || !proggy.isEmpty()) {

            department one = new department(factyy, deptty, abbrev, hoddy, yearry, proggy);
            mainproject.Mainproject.saveDepartment.put(abbrev, one);
            
              Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("new alert");
            alert.setContentText(inputdeptname.getText() + " was successfully Registered");
            alert.setHeaderText("confirmation");

            alert.showAndWait();


        } else {

            Alert error = new Alert(AlertType.ERROR);
            error.setHeaderText("Error");
            error.setContentText("Error loging in , please re-try");
            error.showAndWait();
        }

    }

    @FXML
    private void backbtn(ActionEvent event) {
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
            Logger.getLogger(CreatedeptController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
