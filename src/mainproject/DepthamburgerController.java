/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Ibeun Joe Dickson
 */
public class DepthamburgerController implements Initializable {

    @FXML
    private JFXHamburger studenthamburger;
    @FXML
    private JFXDrawer studentdrawer;
    @FXML
    private JFXButton home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            VBox box = FXMLLoader.load(getClass().getResource("deptdrawerbox.fxml"));

            studentdrawer.setSidePane(box);

            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(studenthamburger);
            transition.setRate(-1);
            studenthamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                transition.setRate(transition.getRate() * -1);
                transition.play();

                if (studentdrawer.isShown()) {
                    studentdrawer.close();
                } else {
                    studentdrawer.open();
                }
                // TODO
            });

        } catch (IOException ex) {
            Logger.getLogger(DepthamburgerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Homebtn(ActionEvent event) {
        try {

            mainproject.Mainproject.deptLoggedIn = null;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("HOME");
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
            home.getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(DepthamburgerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
