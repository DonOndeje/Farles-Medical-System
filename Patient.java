
package farlesmedical;

import java.sql.Date;
import javafx.beans.property.StringProperty; //defines read-only properties and writable properties, plus a number of implementations.
import javafx.beans.property.SimpleStringProperty;



public class Patient {
    // Declare VAriables to hold the field vales from our patient table.
     private final  StringProperty PatientNo = new SimpleStringProperty(this,"PatientNo");
     private final StringProperty Date = new SimpleStringProperty(this,"Date");
     private final StringProperty firstName = new SimpleStringProperty(this,"firstName");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName");
    private final StringProperty Sex = new SimpleStringProperty(this, "Sex");
    private final StringProperty Inference = new SimpleStringProperty(this,"Inference");
    private final StringProperty Residence = new SimpleStringProperty(this, "Residence");
    private final StringProperty PhoneNumber = new SimpleStringProperty(this, "PhoneNumber");
   
   
    
    
      public StringProperty SexProperty(){
      return Sex;
  }
      public String getsexProperty(){
      return SexProperty().get();
  }
     public final void setSex(String Sex){
        SexProperty().set(Sex);
    }
    
     public StringProperty DateProperty(){
      return Date;
  }
    public StringProperty getDateProperty(){
        return DateProperty();
    }
          public final void setDate(String date){
         getDateProperty().set(date);
    }
    
  public StringProperty PatientNoProperty(){
      return PatientNo;
  }
  public final String getPatientNo(){
      return PatientNoProperty().get();
  }
    
      public final void setPatientNo(String PatientNo){
        ResidenceProperty().set(PatientNo);
    }
    public StringProperty ResidenceProperty(){
        return Residence;
    }
    public final String getResidence(){
        return ResidenceProperty().get();
    }
    public final void setResidence(String Residence){
        ResidenceProperty().set(Residence);
    }
    
    
     //Getter to retun the firstName
    public StringProperty firstNameProperty(){
        return firstName;
    }
    public final String getFirstName() {
        return firstNameProperty().get();
    }
    public final void setFirstName(String firstName) {
        firstNameProperty().set(firstName);
    }
    
   
    public StringProperty lastNameProperty() {
        return lastName;
    }
    public final String getLastName() {
        return lastNameProperty().get();
    }
    public final void setLastName(String lastName) {
        lastNameProperty().set(lastName);
    }
    
    public StringProperty PhoneNumberProperty() {
        return PhoneNumber;
    }
    public final String getPhoneNumber() {
        return PhoneNumberProperty().get();
    }
    public final void setPhoneNumber(String PhoneNumber) {
        PhoneNumberProperty().set(PhoneNumber);
    }


public StringProperty InferenceProperty(){
    return Inference;
}
  public final String getInference(){
      return InferenceProperty().get();
  }
  public final void setInference(String Inference){
     InferenceProperty().set(Inference);
  }

    public Patient(String firstName, String lastName, String PhoneNumber,String Sex,String Inference,String Residence,String date) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(PhoneNumber);
        setSex(Sex);
        setInference(Inference);
        setResidence(Residence);
        setDate(date);
    }
    
 
public Patient(){} // Constructor with no parameters
    
    
    

    
}
