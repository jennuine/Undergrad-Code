import java.util.Scanner;

public class NameAndEmail {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		String fullName = null;
		String email = null;
		
		System.out.println("Please enter your first and  last name.");
		fullName = input.nextLine();
		
		System.out.println("What is your email address?");
		email = input.nextLine();
		
		System.out.print("\"" + fullName + "\"");
		System.out.print(" <" + email + ">");
		
	}
}
