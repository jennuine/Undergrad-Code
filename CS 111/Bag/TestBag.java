//TestBag.java

import java.util.*;

public class TestBag {
    public static void main(String[] args) throws BagIsEmptyException, ItemNotFoundException {
	Scanner input = new Scanner(System.in);
	Bag<Object> bag = new Bag<Object>();

	boolean option = true;

	while (option) {

	    System.out.println("\nWhat would you like to do?:\n" +
			       "\tEnter (1) - To insert element in bag\n" +
			       "\tEnter (2) - To remove one element of item from the bag\n" +
			       "\tEnter (3) - To remove all elements of item from the bag\n" +
			       "\tEnter (4) - To display all the elements in the bag\n" +
			       "\tEnter (5) - To exit\n");

	    int choice = input.nextInt();
        
	    switch (choice) {

	    case 1: 
		System.out.println("\nWhat would you like to put in the bag?");
		Object insert = input.next();
		bag.insert(insert);
		break;

	    case 2:
		bag.display();
		System.out.println("\nWhat would you like to remove from the bag?");
		
		try {
		    Object remove = input.next();
		    bag.removeOne(remove);

		} catch (BagIsEmptyException x) {
		    System.out.println("\n" + x);

		} catch (ItemNotFoundException y) {
		    System.out.println("\n" + y); }

		break;

	    case 3: 
		bag.display();
		System.out.println("\nWhat items would you like to remove from the bag?");

		try {
		    Object removeAll = input.next();
		    bag.removeAll(removeAll);

		} catch (BagIsEmptyException x) {
		    System.out.println("\n" + x);

		} catch (ItemNotFoundException y) {
		    System.out.println("\n" + y); }
		
		break;

	    case 4:
		System.out.println("\nHere is what is in your bag so far: \n");
		bag.display();
		break;

	    case 5:
		System.out.println("Goodbye!\n");
		option = false;
		System.exit(0);

	    default:
		System.out.println("\nThat was an invalid option.  Please try again. " + bag.size());
 
	    }//switch
	}//while
    }//end main
}//end class TestBag
