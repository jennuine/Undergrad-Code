import java.util.Scanner;
import javax.swing.JOptionPane;

public class UsernameAndPassword {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		String username = null;
		String password = null;
		final String USERNAME = "NikolaJanevski";
		final String PASSWORD = "CS110_Fall2013";
		
		System.out.println("Please enter your username.");
		username = input.nextLine();
		
		System.out.println("Now please enter your password. (Remember, your password is case sensitive)");
		password = input.nextLine();
		
		if (username.equalsIgnoreCase(USERNAME) && password.equals(PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Welcome! \u2665", "Access Granted", JOptionPane.PLAIN_MESSAGE);
		
		} else if (!(username.equalsIgnoreCase(USERNAME)) && password.equals(PASSWORD)) {
			JOptionPane.showMessageDialog(null, "Your username is wrong.", "ERROR", JOptionPane.ERROR_MESSAGE);
		
		} else if (username.equalsIgnoreCase(USERNAME) && !(password.equals(PASSWORD))) {
			JOptionPane.showMessageDialog(null, "Your password is incorrect.", "ERROR", JOptionPane.ERROR_MESSAGE);
		
		} else if (!(username.equalsIgnoreCase(USERNAME) && password.equals(PASSWORD))) {
			JOptionPane.showMessageDialog(null, "Your username and password is not valid.", "ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

}
