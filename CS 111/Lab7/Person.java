import java.util.Calendar;
public class Person implements Cloneable,Comparable{
  
  private String firstName;
  private String lastName;
  private Date dob;
  
  //null contructor
  public Person(){
    this.firstName="AAAA";
    this.lastName="BBBB";
    this.dob=new Date();
  }
  
  //contructor which takes firstname,lastname and age
  public Person(String first,String last,Date dob){
    this.firstName=first;
    this.lastName=last;
    this.dob=dob;
    
  }
  
  //prints details about a person
  public void printPerson(){
    System.out.println("Person with "+this.toString());
  }
  
  //getter for DateOfBirth
  public Date getDOB(){
    return this.dob;
  }
  
  //Getter for first name
  public String getFirst(){
    return this.firstName;
  }
  
  //Getter for last name
  public String getLast(){
    return this.lastName;
  }
  
  
  //Setter for Last Name
  public void setLast(String last){ 
    this.lastName=last;
  }
  
  //calculate the age of the Person
  private int getAge(){
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    return currentYear-this.dob.getYear();
  }
  
  
  //checks if two persons are equal
  public boolean equals(Object o){
    return (o instanceof Person  &&  ((Person)o).dob.equals(this.dob)  &&  ((Person)o).firstName.equals(this.firstName)   &&    ((Person)o).lastName.equals(this.lastName) );    
  }
  
  //creates a copy of the object being called upon
  public Object clone(){
    return new Person(this.firstName,this.lastName,new Date(this.dob.getDay(),this.dob.getMonth(),this.dob.getYear()));
    //doubt in this for whether to use just this.dob , or create a new Date object??
  }
  
  //compares two objects based on the age
  public int compareTo(Object o){
    return this.getAge()-((Person)o).getAge();
  }  
  
  public String toString(){
    return ("FirstName:"+this.firstName+" LastName:"+this.lastName+" DateOfBirth: "+this.dob);
  }
  
}