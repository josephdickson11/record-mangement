/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import objects.Student;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class DepartmentalloginController implements Initializable {

    @FXML
    private JFXTextField admin1user;
    @FXML
    private JFXPasswordField admin1pword;
    @FXML
    private JFXButton admin1login;
    @FXML
    private JFXButton admin1back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void adminlogin(ActionEvent event) {
        try {
            String username = admin1user.getText();
            String password = admin1pword.getText();

            if (mainproject.Mainproject.saveDepartment.get(username) != null && password.equals("1234")) {

                mainproject.Mainproject.deptLoggedIn = mainproject.Mainproject.saveDepartment.get(username);

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("depthamburger.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();

                stage.setResizable(false);
                stage.setTitle("Register");
                stage.setScene(new Scene(root1));
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
                stage.show();
                //closing this window
                admin1login.getScene().getWindow().hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Invalid Login");
                alert.setContentText("invalid username or password");
                alert.showAndWait();
            }
        } catch (IOException ex) {
            Logger.getLogger(DepartmentalloginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void admin1back(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("FXMLDocument");
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
            admin1back.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
