
package farlesmedical;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application; //import the application package which contains the application class
import javafx.event.ActionEvent;
import static javafx.application.Application.launch;
import javafx.event.EventHandler; // To add mouse clicked event to our button
import javafx.scene.input.MouseEvent;
import javafx.geometry.Insets;
import javafx.scene.shape.Line;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FarlesLoginUI extends Application {
    
    private static String UserName;
    private static String PassWord;
    
    
     public String getUserName(){
          return UserName;
      }
     public String getPassWord(){
       return PassWord;
     }

    public void setUserName(String s){
        UserName = s;
    }
    public void setPassword(String s){
        PassWord = s;
    }
    
     @Override
    public void start(Stage primaryStage) { //The primary Stage object created by the platform is passed to the start() method of the Application class
    //Create a label username
    Text text1 = new Text("UserName");
    //Create a password
    Text text2 = new Text("Password");
    //Create forgot password
     Label text3 = new Label();
    //Create a textfield for email
    TextField username_box = new TextField();
    //create a textfield for password
    TextField password_box = new PasswordField();
    // creating buttons
    Button btn1 = new Button("Login");
             //Creating a Grid Pane
		GridPane gridPane = new GridPane();
		//Setting the size of the pane
		gridPane.setMinSize(400,200);
		// Setting padding
		gridPane.setPadding(new Insets(10,10,10,10));
		// setting the vertical and horizontal gaps between the column
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		//set grid alignment
		gridPane.setAlignment(Pos.CENTER);
        //Arranging all the nodes in the grid
		gridPane.add(text1,0,0);
		gridPane.add(username_box,1,0);
		gridPane.add( text2,0,1);
		gridPane.add(password_box,1,1);
		gridPane.add(btn1,0,2);
		gridPane.add(text3,0,4);
                
                
                
           EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
                       @Override
                       public void handle(MouseEvent e){
                             DBconnect   dataAccesor = null;
                             PatientViewUI patientView = new PatientViewUI();
                           try {
                              
                               dataAccesor = new DBconnect("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/farles","ADMIN","jumbotron");
                              } catch (SQLException ex) {
                               Logger.getLogger(FarlesLoginUI.class.getName()).log(Level.SEVERE, null, ex);
                              } catch (ClassNotFoundException ex) {
                               Logger.getLogger(FarlesLoginUI.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                             UserName = String.valueOf(username_box.getText());
                             PassWord = String.valueOf(password_box.getText()); 
                           try {
                               if(dataAccesor.LoginCredentials()){
                                // primaryStage.close();
                                   try {   
                                       patientView.start(primaryStage);
                                   } catch (Exception ex) {
                                       Logger.getLogger(FarlesLoginUI.class.getName()).log(Level.SEVERE, null, ex);
                                   }
                                  }else{
                                   System.out.println("Connection Unsuccefful:");
                                   text3.setText("Sorry try again!");
                                   text3.getStyleClass().add("farles.css");
                                   username_box.clear();
                                   password_box.clear();
                               }
                           } catch (SQLException ex) {
                               Logger.getLogger(FarlesLoginUI.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       
                       
                       }
                      };
                btn1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
                
                
                
          //Setting up the stage
          Scene scene = new Scene(gridPane,500,300);
          String css = FarlesLoginUI.class.getResource("farles.css").toExternalForm(); // to load the external CSS file.
          scene.getStylesheets().add(css); 
          primaryStage.setTitle("FARLES ENT CLINIC MEDICAL LOGIN"); //set the title of the Stage window
	  primaryStage.setScene(scene); //we add the scene to the Stage which provides the application window.
	  primaryStage.show();// display the contents of the stage.
        
}
    
   
    
 public static void main(String[] args) throws Exception {
        launch(args);
     
  }
 }
    

