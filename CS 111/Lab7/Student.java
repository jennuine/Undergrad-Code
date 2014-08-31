public class Student extends Person {
    
    private double gpa;
    private int studentID;
    private Teacher advisor;

    //default constructor
    public Student() {
	super();
	this.gpa = 0.00;
	this.studentID = 0000;
	this.advisor = new Teacher();
    }

    //constructor1
    public Student(String firstName2, String lastName2, Date dob2, double gpa2, int studentID2, Teacher advisor2) {
	super(firstName2, lastName2, dob2);
	this.gpa = gpa2;
	this.studentID = studentID2;
	this.advisor = advisor2;
    }
    
    //constructor2
    public Student(String firstName2, String lastName2, Date dob2, int studentID2) {
	super(firstName2, lastName2, dob2);
	this.studentID = studentID2;
	this.gpa = 0.00;
	this.advisor = new Teacher();
    }

    public int getStudentID() {
	return this.studentID;
    }

    public void setGPA(double gpa2) {
	this.gpa = gpa2;
    }

    public double getGPA() {
	return this.gpa;
    }

    public void setAdvisor(Teacher a) {
	this.advisor = a;
    }

    public Teacher getAdvisor() {
	return this.advisor;
    }

    public boolean equals(Object s) {
	return (s instanceof Student && super.equals(s) && ((Student)s).gpa == (this.gpa)
		&& ((Student)s).studentID == (this.studentID)
		&& ((Student)s).advisor.equals(this.advisor));
    }

    public String toString() {
	return (super.toString() + "\nGPA:  " + gpa + "\nStudentID:  " + studentID + "\nAdvisor:  " + advisor);
    }


}