import java.util.Scanner;

public class Address {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		Scanner console = new Scanner(System.in);
		
		String firstName;
		String lastName;
		int streetNumber = 0;
		String streetName;
		String aptNumber;
		String city;
		String state;
		int zipCode = 0;
		

		
		System.out.println("Please enter your first name.");
		firstName = input.next();
		
		System.out.println("Now, enter your last name.");
		lastName = input.next();
		
		System.out.println("Ok, now enter your street number.");
		streetNumber = input.nextInt();
		
		System.out.println("What is the name of your street?");
		streetName = console.nextLine();
		
		System.out.println("What's your apartment number? (If you don't live in an apartment just hit enter to skip it)");
		aptNumber = console.nextLine();
		
		System.out.println("What city do you live in?");
		city = console.next();
		
		System.out.println("Enter the abbreviations for the state you live in.");
		state = input.next();
		
		System.out.println("Finally, what's your zip code?");
		zipCode = input.nextInt();
		
		System.out.println("\n" + "Your Information:");
		System.out.println("\t" + firstName + " " + lastName);
		System.out.println("\t" + streetNumber + " " + streetName + "," + " " + aptNumber );
		System.out.println("\t" + city + "," + " " + state + " " + zipCode);
		
		
		
		}
		
		
		
	}
	

