
public class Teacher extends Person {

    private String department;

    //default constructor
    public Teacher() {
	super();
	this.department = "DDDD";
    }
   
    //constructor1
    public Teacher(String firstName2, String lastName2, Date dob2, String department2) {
	super(firstName2,lastName2,dob2);
	this.department = department2;
    }

    //constructor2
    public Teacher(String firstName2, Date dob2) {
	super(firstName2,"BBBB", dob2);
	this.department = "DEPARTMENT";

    }

    public void setDepartment(String department2) {
	this.department = department2;
    }

    public String getDepartment() {
	return this.department;
    }

    public boolean equals(Object t) {
	return (t instanceof Teacher && super.equals(t) && ((Teacher)t).department.equals(this.department));
    }
 
    public String toString() {
	return (super.toString() + "\nDepartment: " + department);
    }
}
