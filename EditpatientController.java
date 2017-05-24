/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farlesmedical2;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Don
 */
public class EditpatientController implements Initializable {
       @FXML
    private TextField firstnameedit;
    @FXML
    private TextField lastnameedit;
    @FXML
    private TextField phonenumberedit;
    @FXML
    private TextField residenceedit;
    @FXML
    private TextField sexedit;
    @FXML
    private JFXButton saveButton;
    @FXML
    private JFXButton cancelButton;
   
 
    public TextField getFirstnameedit() {
        return firstnameedit;
    }

    public void setFirstnameedit(TextField firstnameedit) {
        this.firstnameedit = firstnameedit;
    }

    public TextField getLastnameedit() {
        return lastnameedit;
    }

    public void setLastnameedit(TextField lastnameedit) {
        this.lastnameedit = lastnameedit;
    }

    public TextField getPhonenumberedit() {
        return phonenumberedit;
    }

    public void setPhonenumberedit(TextField phonenumberedit) {
        this.phonenumberedit = phonenumberedit;
    }

    public TextField getResidenceedit() {
        return residenceedit;
    }

    public void setResidenceedit(TextField residenceedit) {
        this.residenceedit = residenceedit;
    }

    public TextField getSexedit() {
        return sexedit;
    }

    public void setSexedit(TextField sexedit) {
        this.sexedit = sexedit;
    }
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
