public class TestArrayList{
  public static void main(String[] args){
    MyArrayList<Integer> list=new MyArrayList<Integer>();
    
    list.display();
    System.out.println("IsEmpty: "+list.empty());
    list.add(5);
    list.add(54);
    list.add(31);
    System.out.println("Front: "+ list.front());
    list.add(12);
    list.add(62);
    list.add(44);
    list.display();
    System.out.println("removed:"+list.remove(5));
    System.out.println("Front: "+ list.front());
    System.out.println("IsEmpty: "+list.empty());
    list.display();
  } 
}