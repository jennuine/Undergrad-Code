public class TestUnorderList{
  public static void main(String[] args){
    UnorderedListDyn<Integer> myList=new UnorderedListDyn<Integer>(); 
    System.out.println("size: "+myList.size()); 
  
    try{ 
      myList.remove(5); 
    } 
    catch(ListEmptyException ex){ 
      System.out.println("Exception:" + ex.getMessage()); 
    } 
    catch(NotFoundInListException ex){ 
      System.out.println("Exception:" + ex.getMessage()); 
    } 
    
    myList.add(3);
    myList.add(2);
    myList.add(5);
    myList.add(6);
    
    myList.displayForward();
    try{ 
    
      myList.remove(4); 
        System.out.println("test");
    } 
    catch(ListEmptyException ex){ 
      System.out.println("Exception:" + ex.getMessage()); 
    } 
    catch(NotFoundInListException ex){ 
      System.out.println("Exception:" + ex.getMessage()); 
    }
    myList.displayForward();
    try{ 
      myList.remove(5); 
    } 
    catch(ListEmptyException ex){ 
      System.out.println("Exception:" + ex.getMessage()); 
    } 
    catch(NotFoundInListException ex){ 
      System.out.println("Exception:" + ex.getMessage()); 
    }
    myList.displayForward();
    myList.add(7);
    myList.add(9);
    myList.displayForward();
   
  }
  
  
}