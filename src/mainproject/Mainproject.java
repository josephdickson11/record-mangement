/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import objects.Journal;
import objects.SchoolJournal;
import objects.Student;
import objects.Studenttransfer;
import objects.department;

/**
 *
 * @author Ibeun Joe Dickson
 */
public class Mainproject extends Application {

    public static HashMap<String, Student> saveStudent;
    public static HashMap<String, department> saveDepartment;
    public static HashMap<String, Studenttransfer> makeTransfer;
    public static HashMap<String, Journal> jMemory;
    public static HashMap<String, SchoolJournal> schlJMemory;

    public static Student loggedIn;
    public static department deptLoggedIn;

    private static File Directory, student, dept, journalmemory, studentTrans, schlJournalMemory;

    public void load() throws IOException {
        if (Directory.exists()) {
            
            ObjectInputStream r1 = new ObjectInputStream(new FileInputStream(student));

            try {
                saveStudent = (HashMap<String, Student>) r1.readObject();
                r1.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            ObjectInputStream d = new ObjectInputStream(new FileInputStream(dept));
            try {

                saveDepartment = (HashMap<String, department>) d.readObject();
                d.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            ObjectInputStream ST = new ObjectInputStream(new FileInputStream(studentTrans));
            try {
                
                    makeTransfer = (HashMap<String, Studenttransfer>) ST.readObject();
                
                ST.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
            
            ObjectInputStream J = new ObjectInputStream(new FileInputStream(journalmemory));
            try {
               
                    jMemory = (HashMap<String, Journal>) J.readObject();
                
                J.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
            
            ObjectInputStream SJ = new ObjectInputStream(new FileInputStream(schlJournalMemory));
            try {
               
                    schlJMemory = (HashMap<String, SchoolJournal>) SJ.readObject();
                
                SJ.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
        }
    }

    public static void save() throws IOException {

        if (!Directory.exists()) {
            Directory.mkdir();
        }

        ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream(student));
        w.writeObject(saveStudent);
        
        w.flush();
        w.close();
        
        w = new ObjectOutputStream(new FileOutputStream(dept));
         w.writeObject(saveDepartment);
        w.flush();
        w.close();
        
        w = new ObjectOutputStream(new FileOutputStream(studentTrans));
         w.writeObject(makeTransfer);
        w.flush();
        w.close();
        
        w = new ObjectOutputStream(new FileOutputStream(journalmemory));
         w.writeObject(jMemory);
        w.flush();
        w.close();
        
        w = new ObjectOutputStream(new FileOutputStream(schlJournalMemory));
         w.writeObject(schlJMemory);
        w.flush();
        w.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("load");
        load();
        

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent e) -> {
            try {
                System.out.println("save");
                save();
                
            } catch (IOException ex) {
                ex.printStackTrace();
                
            }
        });
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Directory = new File(System.getenv("APPDATA") + "/DIRECTORY");
        student = new File(Directory + "/STUDENT FILE");
        dept = new File(Directory + "/DEPARTMENT FILE");
        studentTrans = new File(Directory + "/STUDENT TRANSFER FILE");
        journalmemory = new File(Directory + "/JOURNAL FILE");
        schlJournalMemory = new File(Directory + "/SCHOOL JOURNAL FILE");
         saveStudent = new HashMap<>();
         saveDepartment = new HashMap<>();
         makeTransfer = new HashMap<>();
         jMemory = new HashMap<>();
         schlJMemory = new HashMap<>();
        launch(args);
    }

}
