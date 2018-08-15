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
public class SchooldrawerboxController implements Initializable {

    @FXML
    private JFXButton createdept;
    @FXML
    private JFXButton closedept;
    
    @FXML
    private JFXButton searchdept;
    @FXML
    private JFXButton suspendstu;
    @FXML
    private JFXButton expelstu;
    @FXML
    private JFXButton viewjournal;
    @FXML
    private JFXButton searchprog;
    @FXML
    private JFXButton searchstu;
    @FXML
    private JFXButton treattransfer;
    @FXML
    private JFXButton exitapp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void createdeptmet(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/createdept/createdept.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("createdepartmentui");
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
            createdept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void closeDept(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/closedept/closedept.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("close department");
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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

    @FXML
    private void searchDepartment(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/searchdept/searchdept.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Search department");
            stage.setScene(new Scene(root1));
            stage.show();stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void suspendstu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supendstudent/suspendstudent.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Search department");
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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void expelStu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/expelstudent/expelstudent.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Search department");
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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void viewJournal(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewjournal/schoolViewJournal.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Search department");
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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchProg(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/searchprogramme/searchprogramme.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Search department");
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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchSTu(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/searchstudent/searchstudent.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Search student");
            stage.setScene(new Scene(root2));
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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void treatTRansf(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/treattransferrequest/treattransferrequest.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Treat Transfer Request");
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
            closedept.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SchooldrawerboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ExitApp(ActionEvent event) {

        System.exit(1);
    }

}
