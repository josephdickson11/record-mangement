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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import objects.Student;

/**
 *
 * @author Ibeun Joe Dickson
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label mssgLbl;
    @FXML
    private JFXTextField usernametext;
    @FXML
    private JFXPasswordField pword;

    @FXML
    private JFXButton loginbtn;
    @FXML
    private JFXButton departmentallogin;
    @FXML
    private JFXButton schoollogin;
    @FXML
    private JFXButton aboutUS;

    public JFXTextField getUsernametext() {
        return usernametext;
    }

    public JFXPasswordField getPword() {
        return pword;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginbutton(ActionEvent event) {

        String username = usernametext.getText();
        String password = pword.getText();

        Student newi = mainproject.Mainproject.saveStudent.get(username);
        if (username.isEmpty() || password.isEmpty()) {
            mssgLbl.setText("invalid details");

            System.out.print(username);
        } else if (newi != null && password.equals(newi.getFisrtname())) {
            try {
                if (!newi.getSuspendStatus().equals("OK")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Invalid Login");
                    alert.setContentText("You are suspended");
                    alert.showAndWait();
                    return;
                }
                Mainproject.loggedIn = newi;

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("studenthamburger.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();

                stage.setResizable(false);
                stage.setTitle("Welcome " + usernametext.getText());
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
                loginbtn.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Login");
            alert.setContentText("invalid username or password");
            alert.showAndWait();
        }
    }

    @FXML
    private void departmentallogin(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Departmentallogin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Departmentallogin");
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
            departmentallogin.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void schoollogin(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("schoollogin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("schoollogin");
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
            //closing current window
            schoollogin.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void aboutUs(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AboutUs.fxml"));
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
           aboutUS.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    }

