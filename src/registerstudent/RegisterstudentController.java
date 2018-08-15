/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerstudent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
public class RegisterstudentController implements Initializable {

    @FXML
    private JFXTextField surname;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField middlename;
    @FXML
    private JFXComboBox selectfaculty;
    @FXML
    private JFXComboBox gender;
    @FXML
    private JFXButton registerbtn;
    @FXML
    private JFXButton cancelbtn;
    @FXML
    private JFXComboBox selectdepartment;
    @FXML
    private JFXDatePicker dateofbirth;
    @FXML
    private JFXTextField matricno;
    @FXML
    private Label mssgLbl;

    // String factone = selectfaculty.getValue();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<String> selectFact = FXCollections.observableArrayList("SICT", "SEET", "SEMT", "SAAT", "SET");

        ObservableList<String> selectgender = FXCollections.observableArrayList("Male", "Female");

        ObservableList<String> selectdept = FXCollections.observableArrayList("IMT", "CPT", "CSS", "SAAT", "SET");
        selectfaculty.setItems(selectFact);
        gender.setItems(selectgender);
        selectdepartment.setItems(selectdept);

    }

    @FXML
    private void registerButton(ActionEvent event) {

        String onename = surname.getText();
        String twoname = firstname.getText();
        String thirdname = middlename.getText();
        String facult = String.valueOf(selectfaculty.getValue());
        String gend = String.valueOf(gender.getValue());
        String dept = String.valueOf(selectdepartment.getValue());
        String birthdate = dateofbirth.getValue().toString();
        String matricon = matricno.getText();

        if (onename.isEmpty() || twoname.isEmpty() || thirdname.isEmpty() || facult.isEmpty() || gend.isEmpty() || dept.isEmpty() || birthdate.isEmpty() || matricon.isEmpty()) {

            mssgLbl.setText("All fields are required");

        } else {
            
            //update the journal
            Journal j1 = new Journal("Student Registered Succesfully", Mainproject.deptLoggedIn.getDepartmentname());
            Mainproject.jMemory.put(j1.getId(), j1);
            
            
           //register the student
            Student one = new Student(onename, twoname, thirdname, matricon, facult, gend, dept, birthdate, "OK");
            mainproject.Mainproject.saveStudent.put(one.getMatno(), one);
            

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("new alert");
            alert.setContentText(onename + " was successfully Registered");
            alert.setHeaderText("confirmation");

            alert.showAndWait();

            surname.clear();
            firstname.clear();
            middlename.clear();
            matricno.clear();
        }
  
        
    }

    

    @FXML
    private void cancelButton(ActionEvent event) {

        Alert cancel = new Alert(AlertType.CONFIRMATION);
        cancel.setHeaderText("new alert");
        cancel.setContentText(" are you sure you want to go back");
        cancel.setHeaderText("confirmation");
        
        ButtonType ok = new ButtonType("Yes");
        ButtonType no = new ButtonType("NO");
        
        cancel.getButtonTypes().setAll(ok, no);
        
        Optional <ButtonType> result = cancel.showAndWait();
        
        if( result.get().equals(ok)){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainproject/depthamburger.fxml"));
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
                matricno.getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(RegisterstudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        

    }

}
