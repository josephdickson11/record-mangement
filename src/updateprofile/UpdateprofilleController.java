/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updateprofile;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.Journal;
import objects.Student;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class UpdateprofilleController implements Initializable {

    @FXML
    private JFXTextField surname;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField middlename;
    @FXML
    private JFXComboBox gender;
    @FXML
    private JFXButton registerbtn;
    @FXML
    private JFXButton cancelbtn;
    @FXML
    private JFXDatePicker dateofbirth;
    @FXML
    private JFXTextField matricno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           ObservableList<String> selectgender = FXCollections.observableArrayList
                                                    ("Male", "Female");
           gender.setItems(selectgender);
    
        // TODO
    }

    @FXML
    private void registerButton(ActionEvent event) {

        String onename = surname.getText();
        String twoname = firstname.getText();
        String thirdname = middlename.getText();
        String gend = String.valueOf(gender.getValue());
        String birthdate = dateofbirth.getValue().toString();

        if (onename.isEmpty() || twoname.isEmpty() || thirdname.isEmpty() || gend.isEmpty() || birthdate.isEmpty()) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("ALL fields are required");
            alert1.setHeaderText("Message");
            alert1.showAndWait();
        } else {
            Journal j1 = new Journal(Mainproject.loggedIn.getFisrtname() + "Student Update Profile Successfully", Mainproject.loggedIn.getMatno());
            Mainproject.jMemory.put(j1.getId(), j1);
            Student one = mainproject.Mainproject.loggedIn;
            one.setSurname(onename);
            one.setMiddlename(thirdname);
            one.setFisrtname(twoname);
            one.setGender(gend);
            one.setDOB(birthdate);

            mainproject.Mainproject.saveStudent.put(mainproject.Mainproject.loggedIn.getMatno(), one);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("new alert");
            alert.setContentText(onename + " was successfully updated");
            alert.setHeaderText("confirmation");
            alert.showAndWait();

        }

    }

    @FXML
    private void cancelButton(ActionEvent event) {

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
            cancelbtn.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(UpdateprofilleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
