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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Don
 */
public class AddPatientController implements Initializable {
 @FXML
    public TextField firstnamefield;

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

    public TextField getFirstnamefield() {
        return firstnamefield;
    }

    public void setFirstnamefield(TextField firstnamefield) {
        this.firstnamefield = firstnamefield;
    }

    public TextField getLastnamefield() {
        return lastnamefield;
    }

    public void setLastnamefield(TextField lastnamefield) {
        this.lastnamefield = lastnamefield;
    }

    public TextField getPhonenumberfield() {
        return phonenumberfield;
    }

    public void setPhonenumberfield(TextField phonenumberfield) {
        this.phonenumberfield = phonenumberfield;
    }

    public TextField getResidencefield() {
        return residencefield;
    }

    public void setResidencefield(TextField residencefield) {
        this.residencefield = residencefield;
    }

    public TextField getSexfield() {
        return sexfield;
    }

    public void setSexfield(TextField sexfield) {
        this.sexfield = sexfield;
    }
    
    
    
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    
}
}
