/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchdept;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.Student;
import objects.department;
import searchstudent.SearchstudentController;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class SearchdeptController implements Initializable {

    @FXML
    private Button searchdept;
    @FXML
    private Button cancelbtn;
    @FXML
    private JFXTextField inputAbb;
    @FXML
    private Label dePartName;
    @FXML
    private Label Abbreviationnn;
    @FXML
    private Label programmename;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void searchDepartment(ActionEvent event) {
        
        String searchProg = inputAbb.getText();
         department viewS = mainproject.Mainproject.saveDepartment.get(searchProg);
        if (viewS != null ) {
            Mainproject.deptLoggedIn = viewS;
            
             ArrayList<department> listDetails = new ArrayList<>();
        for (String key : mainproject.Mainproject.saveDepartment.keySet()) {
        dePartName.setText(Mainproject.deptLoggedIn.getDepartmentname());
        Abbreviationnn.setText(Mainproject.deptLoggedIn.getDeptabbrv());
        programmename.setText(Mainproject.deptLoggedIn.getProgramme());
        
        inputAbb.clear();
        }
            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Search");
            alert.setContentText("Invalid dept name");
            alert.showAndWait();
        }
    }

    @FXML
    private void cancelButton(ActionEvent event) {
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
            cancelbtn.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(SearchdeptController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
