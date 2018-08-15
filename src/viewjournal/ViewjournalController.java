/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewjournal;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainproject.Mainproject;
import objects.Journal;
import objects.Studenttransfer;
import viewprofile.ViewprofileController;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class ViewjournalController implements Initializable {

   
    @FXML
    private JFXButton backBtn;
    @FXML
    private TableView<Journal> viewJournal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ArrayList<Journal> j = new ArrayList<>();
        for (String key : mainproject.Mainproject.jMemory.keySet()) {
            j.add(mainproject.Mainproject.jMemory.get(key));
        }
        viewJournal.setItems(FXCollections.observableArrayList(j));

    }


    @FXML
    private void backBtn(ActionEvent event) {
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
            backBtn.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(ViewprofileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
