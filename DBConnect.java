/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farlesmedical2;

import java.sql.Connection ; //used to connect to our database
import java.sql.Date;
import java.sql.DriverManager ;
import java.sql.PreparedStatement;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ; //To handle data returned from the table.
import java.util.List ;
import java.util.ArrayList ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DBConnect {
      private final   Connection con;
     //this Constructor connects to the database.
    public DBConnect (String driverClassName, String dbURL, String user, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driverClassName); // we load the jdbc driver here.
        //Create a connection to the DB using the superUser Credentials.
        this.con = DriverManager.getConnection(dbURL, user, password); // we create an object of the connection class.
    }
    
        //To add  patient particularsto the database
    public  void  addPatient() throws SQLException{
   
    AddPatientController pat = new AddPatientController();
     PreparedStatement ps  = this.con.prepareStatement("insert into patient(firstName,lastName,phoneNumber,Sex,Residence) values (?,?,?,?,?);");
     
     ps.setString(1,pat.getFirstName().toUpperCase());
     ps.setString(2, pat.getLastName().toUpperCase());
     ps.setString(3, pat.getPhoneNumber().toUpperCase());
    ps.setString(4, pat.getSex().toUpperCase());
    ps.setString(5, pat.getResidence().toUpperCase());
  
    ps.execute();
    
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
                    String patientNo = rs.getString("PatientNo");
                   String firstName = rs.getString("firstName"); // we use the column names instead of the index 
                   String lastName = rs.getString("lastName");
                   String PhoneNumber = rs.getString("phoneNumber");
                   String Sex = rs.getString("Sex");
                   String Residence = rs.getString("Residence");
                   String date = rs.getString("Date");
                   Patient patient = new Patient(patientNo,firstName, lastName,PhoneNumber,Sex,Residence,date);
                    personList.add(patient);// add the person object to the arraylist.
            }
           
           return personList;   
       }
        }
        
    
      public boolean LoginCredentials() throws SQLException{
        FXMLDocumentController obj = new  FXMLDocumentController ();
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
