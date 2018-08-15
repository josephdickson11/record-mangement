/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchstudent;

import com.jfoenix.controls.JFXButton;
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
import mainproject.Mainproject;
import objects.Journal;
import objects.Student;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class SearchstudentController implements Initializable {

    @FXML
    private JFXButton back;
    @FXML
    private JFXTextField inputMatno;
    @FXML
    private JFXButton search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            Logger.getLogger(SearchstudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void searchBtn(ActionEvent event) {
        String searchS = inputMatno.getText();
        Student viewS = mainproject.Mainproject.saveStudent.get(searchS);
        if (viewS != null ) {
            Journal j1 = new Journal("Student Search Query Found For" + searchS, Mainproject.deptLoggedIn.getDepartmentname());
            Mainproject.jMemory.put(j1.getId(), j1);
            Mainproject.loggedIn = viewS;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewprofile/schoolsearch.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();

                stage.setResizable(false);
                

                stage.setScene(new Scene(root1));
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                    @Override
                    public void handle(WindowEvent e) {
                        try {
                            Mainproject.save();

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                //closing this window
                back.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(SearchstudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Journal j2 = new Journal("Student Search Query Not Found For" + searchS, Mainproject.deptLoggedIn.getDepartmentname());
            Mainproject.jMemory.put(j2.getId(), j2);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Search");
            alert.setContentText("invalid matric No");
            alert.showAndWait();
        }
    }

}
