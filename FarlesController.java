/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farlesmedical2;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Don
 */
public class FarlesController implements Initializable {

    
    
    
    
    @FXML
    private TableView<Patient> tableView;
    @FXML
    private TableColumn<Patient, String> firstNameCol;
    @FXML
    private TableColumn<Patient, String> lastNameCol;
    @FXML
    private JFXButton editButton;
    @FXML
    private JFXButton newPatButton;
    @FXML
    private JFXButton deleteButton;
      @FXML
    private Label patientnumber;

    @FXML
    private Label firstname;

    @FXML
    private Label lastname;

    @FXML
    private Label Phonenumber;

    @FXML
    private Label Sex;

    @FXML
    private Label Residence;

    @FXML
    private Label Date;
    private void showPersonDetails(Patient person) {
    if (person != null) {
        // Fill the labels with info from the person object.
        patientnumber.setText(person.getPatientNo());
         firstname.setText(person.getFirstName());
        lastname.setText(person.getLastName());
        Phonenumber.setText(person.getPhoneNumber());
        Sex.setText(person.getsexProperty());
        Residence.setText(person.getResidence());
        Date.setText(person.getDateProperty());

        // TODO: We need a way to convert the birthday into a String! 
        // birthdayLabel.setText(...);
    } else {
        // Person is null, remove all the text.
        firstname.setText("");
        lastname.setText("");
        Phonenumber.setText("");
        Sex.setText("");
        Residence.setText("");
        Date.setText("");
    }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         EventHandler<MouseEvent> eventHandler;
         EventHandler<MouseEvent> editEvent; 
         EventHandler<MouseEvent> deleteEvent;
        DBConnect conn = null;
        Patient pat = new Patient();
        try {
            conn = new DBConnect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/farles", "ADMIN", "jumbotron");
        } catch (SQLException ex) {
            Logger.getLogger(FarlesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FarlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tableView.setItems( conn.getPersonList()); // we cast the arrayList returned by getPerson() to ObsrvableList type.
           
        } catch (SQLException ex) {
            Logger.getLogger(FarlesController.class.getName()).log(Level.SEVERE, null, ex);
        }
         firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.getColumns().addAll();
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
       eventHandler = new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 
                 
                 try {
                     FXMLLoader loader = new FXMLLoader();
                     loader.setLocation(FarlesController.class.getResource("AddPatient.fxml"));
                     Scene scene;
                     Stage stg = new Stage();
                     scene = new Scene((AnchorPane) loader.load());
                     stg.setScene(scene);
                     stg.show();
                 
                   
                 } catch (IOException ex) {
                     Logger.getLogger(FarlesController.class.getName()).log(Level.SEVERE, null, ex);
                 } }
         }; 
      editEvent = new EventHandler<MouseEvent>(){
             @Override
             public void handle(MouseEvent event) {
                 try {
                     Patient selectedPerson = tableView.getSelectionModel().getSelectedItem();
                     if(selectedPerson == null){
                          Alert alert = new Alert(AlertType.WARNING,"Please select a record to edit".toUpperCase());
                          alert.showAndWait();
                          
                     } else{
                     FXMLLoader loader = new FXMLLoader();
                     loader.setLocation(FarlesController.class.getResource("editpatient.fxml"));
                     Scene scene;
                     Stage stg = new Stage();
                     scene = new Scene((AnchorPane) loader.load());
                     stg.setScene(scene);
                     stg.show();
                     EditpatientController controller = loader.getController();
                     controller.getFirstnameedit().setText(selectedPerson.getFirstName());
                      controller.getLastnameedit().setText(selectedPerson.getLastName());
                      controller.getSexedit().setText(selectedPerson.getsexProperty());
                      controller.getPhonenumberedit().setText(selectedPerson.getPhoneNumber());
                       controller.getResidenceedit().setText(selectedPerson.getResidence());
                     }
                     
                 } catch (IOException ex) {
                     Logger.getLogger(FarlesController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }; 
      deleteEvent = new EventHandler<MouseEvent>(){
             @Override
             public void handle(MouseEvent event) {
                  int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                     Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete the selected record?".toUpperCase());
                     alert.setTitle("Delete this record parmanently");
                     alert.showAndWait().ifPresent(response -> {
                               if (response == ButtonType.OK) {
                                         tableView.getItems().remove(selectedIndex);    
                                 }
                               });
             } else {
        // Nothing selected.
     //   Stage window  = new Stage();
     
        Alert alert = new Alert(AlertType.WARNING,"Please select a record to delete".toUpperCase());
     alert.setTitle("Select a record");
      alert.showAndWait();

                }     
             }
         };
      
     newPatButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
     editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, editEvent);
          deleteButton.addEventHandler(MouseEvent.MOUSE_CLICKED, deleteEvent);
    
    } 
}
