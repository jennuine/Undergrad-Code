import javax.swing.JOptionPane;

public class EmailEditor {
	public static void main(String [] args) {
		
		String email = null;
		String userName = null;
		String domainName = null;
		int atSign = 0;
		
		email = JOptionPane.showInputDialog("Please enter your email");
		
		atSign = email.indexOf('@');
		
		userName = email.substring(0, atSign);
		domainName = email.substring(atSign + 1);
		
		JOptionPane.showMessageDialog(null, "Username: " + userName + "\nDomain: " + domainName);
		
		
		
	}
}
