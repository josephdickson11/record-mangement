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

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class DeptdrawerboxController implements Initializable {

    @FXML
    private JFXButton register;
    @FXML
    private JFXButton ViewJournal;
    @FXML
    private JFXButton searchprogramme;
    @FXML
    private JFXButton searchStu;
    @FXML
    private JFXButton treartransfer;
    @FXML
    private JFXButton updatestudent;
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
    private void registerStudent(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/registerstudent/registerstudent.fxml"));
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
            register.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DeptdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    @FXML
    private void viewjournal(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewjournal/viewjournal.fxml"));
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
            register.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DeptdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchProgramme(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/searchprogramme/deptsearchprog.fxml"));
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
            register.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DeptdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchStudent(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/searchstudent/schoolsearch.fxml"));
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
            register.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DeptdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void treatTransfer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/treattransferrequest/departmentTreat.fxml"));
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
            register.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DeptdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateStudent(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/updatestudentrecord/updatestudentrecord.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            
            stage.setResizable(false);
            stage.setTitle("Update");
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
            register.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DeptdrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void exitApp(ActionEvent event) {
        
        System.exit(0);
    }
}