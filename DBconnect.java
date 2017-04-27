
package farlesmedical;
import java.sql.Connection ; //used to connect to our database
import java.sql.Date;
import java.sql.DriverManager ;
import java.sql.PreparedStatement;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ; //To handle data returned from the table.
import javafx.scene.control.TableColumn.CellDataFeatures;

import java.util.List ;
import java.util.ArrayList ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBconnect {
 
    private final Connection con;
    
    
    
    //this Constructor connects to the database.
    public DBconnect(String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName); // we load the jdbc driver here.
        //Create a connection to the DB using the superUser Credentials.
        con = DriverManager.getConnection(dbURL, user, password); // we create an object of the connection class.
    }
    
    //This method closes the connection to the Database if the connection was successful in the first place.
    public void shutdown() throws SQLException {
        if (con != null){
            con.close();
        }
    }
    //To add a person to the database
    public  void  addPatient() throws SQLException{
   
    AddPatient pat = new AddPatient();
     PreparedStatement ps  = con.prepareStatement("INSERT INTO patient(firstName,lastName,phoneNumber,Sex,Residence,Inference)"
                                                           +"VALUES(?,?,?,?,?,?);");
     
     ps.setString(1, pat.getFirstName());
     ps.setString(2, pat.getLastName());
     ps.setString(3, pat.getPhoneNumber());
    ps.setString(4, pat.getSex());
    ps.setString(5, pat.getResidence());
    ps.setString(6,pat.getInference());
  
    
    ps.executeUpdate();
    
    }
    
    
    
    
    //To get a Person from the table
    public ObservableList<Patient> getPersonList() throws SQLException { // this method returns an arrayList
       try (
            Statement stmnt = con.createStatement(); //we create a statement object to execute SQL Queries.
            ResultSet rs = stmnt.executeQuery("select * from patient;"); //the executeQuery() method of the Statement class Issues SQL queries.
              // The result of the query is returned as a ResultSet object. 
               ){
            ObservableList<Patient> personList = FXCollections.observableArrayList(); //declare an ArrayList to hold the objects of type Patient.
            while(rs.next()){ //The next() method of the ResultSet class returns a boolean value to indicate whether there is move data is available.
                //Here we analyze the Query results returned as a ResultSet object.
                   String firstName = rs.getString("firstName"); // we use the column names instead of the index 
                   String lastName = rs.getString("lastName");
                   String PhoneNumber = rs.getString("PhoneNumber");
                   String Inference = rs.getString("Inference");
                   String Sex = rs.getString("Sex");
                   String Residence = rs.getString("Residence");
                   String date = rs.getString("Date");
                   Patient patient = new Patient(firstName, lastName,PhoneNumber,Sex,Inference,Residence,date);
                    personList.add(patient);// add the person object to the arraylist.
            }
           
           return personList;   
       }
        
    }
    
    public boolean LoginCredentials() throws SQLException{
        FarlesLoginUI obj = new FarlesLoginUI();
        boolean let_in = false;
        try(
          Statement stmnt = con.createStatement(); 
          ResultSet rs = stmnt.executeQuery("SELECT * FROM users;"); 
         ){
        while(rs.next()){
            String username = rs.getString("Username");
            String password = rs.getString("Password");
        if( username.equals(obj.getUserName()) && password.equals(obj.getPassWord())){
            let_in = true;
               
        } else {
            
            let_in = false;
        }
          }
        }
     return let_in;
     }
     }
    
  
    

