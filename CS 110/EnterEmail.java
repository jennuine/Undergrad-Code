import java.util.Scanner;

public class EnterEmail {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		String email = null;
		final char AT_SIGN = '@';
		final char WHITE_SPACE = ' ';
		
		System.out.println("Please enter your email address");
		email = input.nextLine();
		
	
		if (email.indexOf(AT_SIGN) < 0 && email.indexOf(WHITE_SPACE) > 0) {
			System.out.println("Your email can not cantain any white spaces and must have an \"@\" symbol.");
			
		} else if (email.isEmpty()) {
			System.out.println("You did not enter anything.");	
		
		} else if (email.indexOf(WHITE_SPACE) > 0) {
			System.out.println("Your email can not contain white spaces.");
			
		} else if (email.indexOf(AT_SIGN) < 0) {
			System.out.println("You must have an \"@\" sign in your email.");
			
		} else {
			System.out.println("This is a valid email.");
		
		} 
			
			
		
		
	}
}
