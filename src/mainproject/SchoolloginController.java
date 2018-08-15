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

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class SchoolloginController implements Initializable {

    @FXML
    private JFXPasswordField schoolpword;
    @FXML
    private JFXButton admin2login;
    @FXML
    private JFXButton backbtn;

    @FXML
    private JFXTextField schooluser;

    public JFXTextField getSchooluser() {
        return schooluser;
    }

    public JFXPasswordField getSchoolpword() {
        return schoolpword;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void admin2login(ActionEvent event) {

       
        try {

            if( schooluser.getText().isEmpty() || schoolpword.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Login");
            alert.setContentText("please input your details");
            alert.showAndWait();
            }
            else if ("musbau".equals(schooluser.getText()) &&  "buckky".equals(schoolpword.getText())) {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("schoolhamburger.fxml"));
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
                backbtn.getScene().getWindow().hide();
            }
           
            else {
                    Alert num = new Alert(Alert.AlertType.ERROR);
            num.setHeaderText("Invalid Login");
            num.setContentText("invalid username or password");
            num.showAndWait();
                    }
            
            
        } catch (IOException ex) {
            Logger.getLogger(SchoolloginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void backbtn(ActionEvent event) {
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
            backbtn.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
