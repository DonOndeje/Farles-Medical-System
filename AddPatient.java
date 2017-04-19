
package farlesmedical;

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
    
    @Override
    public void start(Stage primaryStage) {
        // Properties to be added to the table.
            Text firstName = new Text("FIRSTNAME");
            Text lastName = new Text("LASTNAME");
            Text phoneNumber = new Text("PHONENUMBER");
            Text Sex = new Text("SEX(M or F)");
            Text Residence = new Text("RESIDENCE");
            Text Inference = new Text("INFERENCE");
            Button btn2 = new Button("Add Patient");
            Button btn3 = new Button("Discard");
            
      TextField firstNameField = new TextField();
      TextField lastNameField = new TextField();
      TextField phoneField = new TextField();
      TextField SexField = new TextField();
      TextField ResidenceField = new TextField();
      TextArea InferenceField = new TextArea();
       GridPane gridpane = new GridPane();
       gridpane.add(firstName,0,0);
       gridpane.add(firstNameField,1,0);
       gridpane.add(lastName,0,1);
       gridpane.add(lastNameField,1,1);
       gridpane.add(phoneNumber,0,2);
       gridpane.add(phoneField,1,2);
       gridpane.add(Sex,0,3);
       gridpane.add(SexField,1,3);
       gridpane.add(Residence,0,4);
       gridpane.add(ResidenceField,1,4);
       gridpane.add(Inference,0,5);
       gridpane.add(InferenceField,1,5);
       gridpane.add(btn2,1,6);
       gridpane.add(btn3,1,7);
       gridpane.setAlignment(Pos.CENTER);
                gridpane.setVgap(5);
		gridpane.setHgap(10);
                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent e){
                    
                
                }
                
                
                };
       Scene scene = new Scene(gridpane,800,600);
          String css = PatientViewUI.class.getResource("farles.css").toExternalForm(); // to load the external CSS file.
          scene.getStylesheets().add(css); 
        primaryStage.setTitle("ADD PATIENT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
  
}
