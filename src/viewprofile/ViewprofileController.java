/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewprofile;

import com.jfoenix.controls.JFXButton;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.Student;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class ViewprofileController implements Initializable {

    @FXML
    private Label faculty;
    @FXML
    private Label dept;
    @FXML
    private Label gender;
    @FXML
    private JFXButton backbtn;
    @FXML
    private JFXButton updateprofile;
    @FXML
    private Label surname;
    @FXML
    private Label middlename;
    @FXML
    private Label firstname;
    @FXML
    private Label dateOfBirth;
    @FXML
    private Label matricNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<Student> listDetails = new ArrayList<>();
        for (String key : mainproject.Mainproject.saveStudent.keySet()) {
            firstname.setText(mainproject.Mainproject.loggedIn.getFisrtname());
            surname.setText(mainproject.Mainproject.loggedIn.getSurname());
            middlename.setText(mainproject.Mainproject.loggedIn.getMiddlename());
            matricNo.setText(mainproject.Mainproject.loggedIn.getMatno());
            dateOfBirth.setText(mainproject.Mainproject.loggedIn.getDOB());
            faculty.setText(mainproject.Mainproject.loggedIn.getFaculty());
            dept.setText(mainproject.Mainproject.loggedIn.getDepartment());
            gender.setText(mainproject.Mainproject.loggedIn.getGender());

        }
        // TODO
    }

    @FXML
    private void backbtn(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainproject/studenthamburger.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Update Profile");
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
            backbtn.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(ViewprofileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateProfile(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/updateprofile/updateprofille.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Update Profile");
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
            backbtn.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(ViewprofileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
