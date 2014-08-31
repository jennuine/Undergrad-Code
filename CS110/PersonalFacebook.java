import java.util.Scanner;

public class PersonalFacebook {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		String facebookURL = null;
		int backSlash = 0;
		String personalURL = null;
		
		System.out.println("Please enter your Facebook page's URL.");
		facebookURL = input.nextLine();
		
		backSlash = facebookURL.lastIndexOf('/');
		
		personalURL = facebookURL.substring(backSlash + 1);
		
		System.out.println("\nPersonalized URL: \n\t" + personalURL);
		
		
	}
}
