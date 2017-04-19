
package farlesmedical;

import javafx.application.Application;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class PatientViewUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
      TableView<Patient> personTable = new TableView<>(); 
      Button button = new Button("Add Patient");
      Button button1 = new Button("Close");
       GridPane root = new  GridPane();
       
       
       EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
           AddPatient pat = new AddPatient();   
           @Override
             public void handle(MouseEvent e){
             pat.start(primaryStage);
            }
         
       };
       
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
       root.add(button,0,0);
        Scene scene = new Scene(root,800,600);
         String css = PatientViewUI.class.getResource("farles.css").toExternalForm(); // to load the external CSS file.
          scene.getStylesheets().add(css); 
        primaryStage.setTitle("PATIENTS DIAGNOSED");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    }
