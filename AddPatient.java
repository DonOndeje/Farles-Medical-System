
package farlesmedical;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Don
 */
public class AddPatient extends Application {
             private  static String firstName;
             private   static String lastName;
             private   static String phoneNumber;
             private  static String Sex ;
             private  static String Residence;
             private  static String Inference;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return Sex;
    }

    public String getResidence() {
        return Residence;
    }

    public String getInference() {
        return Inference;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setResidence(String Residence) {
        this.Residence = Residence;
    }

    public void setInference(String Inference) {
        this.Inference = Inference;
    }
     
         
         
         
    
    @Override
    public void start(Stage primaryStage) {
        // Properties to be added to the table.
            Text fname = new Text("FIRSTNAME");
            Text lname = new Text("LASTNAME");
            Text phonenumber = new Text("PHONENUMBER");
            Text sex = new Text("SEX(M or F)");
            Text residence = new Text("RESIDENCE");
            Text inference = new Text("INFERENCE");
            Button btn2 = new Button("Add Patient");
            Button btn3 = new Button("Discard");
            
      TextField firstNameField = new TextField();
      TextField lastNameField = new TextField();
      TextField phoneField = new TextField();
      TextField SexField = new TextField();
      TextField ResidenceField = new TextField();
      TextArea InferenceField = new TextArea();
       GridPane gridpane = new GridPane();
       gridpane.add( fname ,0,0);
       gridpane.add(firstNameField,1,0);
       gridpane.add(lname,0,1);
       gridpane.add(lastNameField,1,1);
       gridpane.add(phonenumber,0,2);
       gridpane.add(phoneField,1,2);
       gridpane.add(sex,0,3);
       gridpane.add(SexField,1,3);
       gridpane.add(residence,0,4);
       gridpane.add(ResidenceField,1,4);
       gridpane.add(inference,0,5);
       gridpane.add(InferenceField,1,5);
       gridpane.add(btn2,1,6);
       gridpane.add(btn3,1,7);
       gridpane.setAlignment(Pos.CENTER);
                gridpane.setVgap(5);
		gridpane.setHgap(10);
                EventHandler<MouseEvent> eventHandler;
             eventHandler = new EventHandler<MouseEvent>(){
                 DBconnect   obj = null;
                 @Override
                 public void handle(MouseEvent e){
                     try {
                         obj = new DBconnect("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/farles","ADMIN","jumbotron");
                     } catch (SQLException ex) {
                         Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex); 
                     }
                       firstName = String.valueOf(firstNameField.getText());
                       lastName = String.valueOf(lastNameField.getText());
                       phoneNumber = String.valueOf(phoneField.getText());
                       Sex = String.valueOf(SexField.getText());
                        Residence   =   String.valueOf(ResidenceField.getText());
                        Inference =  String.valueOf(InferenceField.getText());
                     try {
                         obj.addPatient();
                     } catch (SQLException ex) {
                         Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                      
                 
             };
              btn2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
       Scene scene = new Scene(gridpane,800,600);
          String css = PatientViewUI.class.getResource("farles.css").toExternalForm(); // to load the external CSS file.
          scene.getStylesheets().add(css); 
        primaryStage.setTitle("ADD PATIENT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
  
}
