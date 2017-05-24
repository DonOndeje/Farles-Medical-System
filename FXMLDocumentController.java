/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farlesmedical2;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Don
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXTextField userName;
  @FXML
  private Label invalid_credentials;
  
    private static String UserName;
    private static String PassWord;

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setUserName(String s) {
        UserName = s;
    }

    public void setPassword(String s) {
        PassWord = s;
    }

    @FXML
    public void loginCredentials(ActionEvent event) throws IOException {
        DBConnect dataAccesor = null;
   
        try {
            dataAccesor = new DBConnect("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/farles", "ADMIN", "jumbotron"); //connect to the database.
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        UserName = String.valueOf(userName.getText());
        PassWord = String.valueOf(pass.getText());
        try {
            if (dataAccesor.LoginCredentials()) {
               
                      FXMLLoader loader = new FXMLLoader();
                      
                      loader.setLocation(FXMLDocumentController.class.getResource("Farles.fxml"));
                     AnchorPane patientView = (AnchorPane) loader.load();
                     Scene patientViewScene = new Scene(patientView);
                     Stage stg = (Stage) ((Node) event.getSource()) .getScene().getWindow();
                      stg.setScene(patientViewScene);
                     stg.show();
                 
                
                    System.out.println("Connected");
            } else {
               invalid_credentials.setText("Invalid Credentials Try Again");
                    invalid_credentials.setStyle("-fx-text-fill: red");
               userName.clear();
               pass.clear();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
