public class TestSubClass{
  public static void main(String []args){
     
   
    Teacher t1=new Teacher("Carrano","Prichard",new Date(05,04,1954),"ComputerScience");
    System.out.println("Printing t1");
    t1.printPerson();
    
    
    Date d=new Date(05,04,1954);
    Teacher t2=new Teacher("Carrano",d);
    System.out.println("Printing t2");
    t2.printPerson();
    System.out.println("Comparing t1 to t2: "+t1.equals(t2));
    t2.setLast("Prichard");
    t2.setDepartment("ComputerScience");
    System.out.println("Printing t2");
    t2.printPerson();
    
     System.out.println("Now again Comparing t1 and t2: "+t1.equals(t2));
  
    Student s1=new Student();
    System.out.println("Printing s1");
    s1.printPerson();
    Student s2=new Student("Jackson","Michael",new Date(05,04,1954),4,700000001,t1);
    System.out.println("Printing s2");
    s2.printPerson();
    
    System.out.println("Comparing s1 and s2:"+ s1.equals(s2));
    
   
    Student s3=new Student("Jackson","Michael",d,700000001);
    System.out.println("Printing s3");
    s3.printPerson();
    System.out.println("Comparing s2 and s3:"+ s2.equals(s3));
 
    s3.setGPA(4);
    s3.setAdvisor(t1);   
    System.out.println("Printing s3");
    s3.printPerson();
    System.out.println("Now again Comparing s2 and s3: "+s2.equals(s3));
       
    
  }
}