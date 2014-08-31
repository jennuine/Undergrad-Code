import java.util.Scanner;

public class jqnguyen6 {
    public static void main(String [] args) {
	Scanner input = new Scanner(System.in);
	Person x = new Person();

	System.out.println();
	x.printPerson();

	boolean result = false;
	
	while (!result) {
	    try {
		System.out.println("\nPlease input the lastname.");
		String newLast = input.next();
		x.setLast(newLast);
		result = true;

	    } catch (InvalidNameException e) {
		System.out.println(e);

	    } catch (Exception e1) {
		System.out.println(e1);
	    }
	}
	System.out.println();
	x.printPerson();
	
	boolean option = false;
	while (!option) {
	    try {
		System.out.println("\nPlease enter your countryID");
		String a = input.next();
		x.setCountryId(Integer.parseInt(a));
		option = true;

	    } catch (Exception e) {
		System.out.println("\nSorry, that is an invalid number.");
	    }
	}
	System.out.println("\n");
	x.printPerson();
    }
}
