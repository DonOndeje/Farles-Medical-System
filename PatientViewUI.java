
package farlesmedical;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;


public class PatientViewUI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
      TableView<Patient> personTable = new TableView<Patient>(); 
      // create columns for our tableview control element.
      TableColumn<Patient ,String> PatientNoCol = new TableColumn<>("PatientNo");
      TableColumn<Patient ,String> firstNameCol  = new TableColumn<>("firstName");
       TableColumn <Patient ,String> lastNameCol  = new TableColumn<>("lastName");
        TableColumn <Patient ,String> phoneNumCol  = new TableColumn<>("phoneNumber");
        TableColumn <Patient ,String> sexCol  = new TableColumn<>("Sex");
        TableColumn <Patient ,String> ResidenceCol  = new TableColumn<>("Residence");;
        TableColumn <Patient ,String> InferenceCol  = new TableColumn<>("Inference");;
        
        
            Button button = new Button("Add Patient");
           Button button1 = new Button("Close");
           GridPane root = new  GridPane();
           DBconnect   obj = new DBconnect("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/farles","ADMIN","jumbotron");
               
     
            // Defines how to fill data for each cell.
      // Get value from property of  Patient.
      
      PatientNoCol.setCellValueFactory(new PropertyValueFactory<>("PatientNo"));
      firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
      lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
      phoneNumCol.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
      sexCol.setCellValueFactory(new PropertyValueFactory<>("Sex"));
     ResidenceCol.setCellValueFactory(new PropertyValueFactory<>("Residence"));
    InferenceCol.setCellValueFactory(new PropertyValueFactory<>("Inference"));
       
    
     personTable.setItems( obj.getPersonList()); // we cast the arrayList returned by getPerson() to ObsrvableList type.
      personTable.getColumns().addAll(PatientNoCol, firstNameCol,  lastNameCol,   phoneNumCol,sexCol,  ResidenceCol, InferenceCol);
       EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
           AddPatient pat = new AddPatient();   
        
           @Override
             public void handle(MouseEvent e){
             
             pat.start(primaryStage);
            }
         
       };
       
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        root.setAlignment(Pos.CENTER);
       root.add(button,0,0);
       root.add(personTable,0,1);
        Scene scene = new Scene(root,800,600);
         String css = PatientViewUI.class.getResource("farles.css").toExternalForm(); // to load the external CSS file.
          scene.getStylesheets().add(css); 
        primaryStage.setTitle("PATIENTS DIAGNOSED");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    }
