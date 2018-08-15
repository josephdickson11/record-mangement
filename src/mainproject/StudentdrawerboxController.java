/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import com.jfoenix.controls.JFXButton;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import objects.Journal;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class StudentdrawerboxController implements Initializable {

    @FXML
    private JFXButton viewprofile;
    @FXML
    private JFXButton updateprofie;
    @FXML
    private JFXButton requesttransfer;
    @FXML
    private JFXButton exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewProfile(ActionEvent event) {try {
        Journal j1 = new Journal(Mainproject.loggedIn.getFisrtname() + " Student Viewed Profile", Mainproject.loggedIn.getMatno());
            Mainproject.jMemory.put(j1.getId(), j1);
            
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewprofile/viewprofile.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        
        stage.setResizable(false);
        stage.setTitle("view profile");
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
        viewprofile.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(StudentdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateProfile(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/updateprofile/updateprofille.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            
            stage.setResizable(false);
            stage.setTitle("update profile");
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
            updateprofie.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(StudentdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void requestTransfer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/requesttransfer/requesttransfer.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            
            stage.setResizable(false);
            stage.setTitle("Request transfer");
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
            viewprofile.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(StudentdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        
        System.exit(0);
    }
    
}
