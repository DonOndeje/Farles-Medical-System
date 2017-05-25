/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farlesmedical2;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Don
 */
public class AddPatientController implements Initializable {
 @FXML
    private TextField firstnamefield;

    @FXML
    private TextField lastnamefield;

    @FXML
    private TextField phonenumberfield;

    @FXML
    private TextField residencefield;

    @FXML
    private TextField sexfield;

    @FXML
    private JFXButton addbutton;

    @FXML
    private JFXButton cancelbutton;

private  static String firstName;
private   static String lastName;
private   static String phoneNumber;
private  static String Sex ;
private  static String Residence;

    public  String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        AddPatientController.firstName = firstName;
    }

    public  String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        AddPatientController.lastName = lastName;
    }

    public  String getPhoneNumber() {
        return phoneNumber;
    }

    public  void setPhoneNumber(String phoneNumber) {
        AddPatientController.phoneNumber = phoneNumber;
    }

    public  String getSex() {
        return Sex;
    }

    public  void setSex(String Sex) {
        AddPatientController.Sex = Sex;
    }

    public  String getResidence() {
        return Residence;
    }

    public  void setResidence(String Residence) {
        AddPatientController.Residence = Residence;
    }


    
    
    /*
    @FXML
    public void addpatient(ActionEvent event){
          try {
         DBConnect conn = new DBConnect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/farles", "ADMIN", "jumbotron");
         conn.addPatient();
     } catch (SQLException | ClassNotFoundException ex) {
         Logger.getLogger(AddPatientController.class.getName()).log(Level.SEVERE, null, ex);
     }
          
    }
   

    @FXML
   public void cancelwindow(ActionEvent event) {

    }
*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventHandler<MouseEvent> eventHandler;
    
       eventHandler =  new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                firstName = firstnamefield.getText().trim();
                lastName = lastnamefield.getText().trim();
                phoneNumber = phonenumberfield.getText().trim();
                Sex = sexfield.getText().trim();
                Residence = residencefield.getText().trim();
                if(firstnamefield.getText().trim().isEmpty() || lastnamefield.getText().trim().isEmpty() || phonenumberfield.getText().trim().isEmpty() || sexfield.getText().trim().isEmpty() || residencefield.getText().trim().isEmpty())
                      {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                String content = "Please fill all requested fields";
                alert.setContentText(content);
                alert.showAndWait();
            }     else {
                  try {
         DBConnect conn = new DBConnect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/farles", "ADMIN", "jumbotron");
         conn.addPatient();
     } catch (SQLException | ClassNotFoundException ex) {
         Logger.getLogger(AddPatientController.class.getName()).log(Level.SEVERE, null, ex);
     }
            }
            }
        };   
      
       addbutton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
}
}
