import javax.swing.JOptionPane;

public class SecondConverter {
	public static void main(String [] args) {
		
		String timeInSeconds = null;
		int timeInSeconds2 = 0;
		int hours = 0;
		int hoursRem = 0;
		int minutes = 0;
		int minutesRem = 0;
		int seconds = 0;
		
		timeInSeconds = JOptionPane.showInputDialog("Enter the time in seconds");
		timeInSeconds2 = Integer.parseInt(timeInSeconds);
		
		hours = (timeInSeconds2 / 3600);
		hoursRem = (timeInSeconds2 % 3600);
		minutes = (hoursRem / 60);
		minutesRem = (hoursRem % 60);
		seconds = (minutesRem);
		
		System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
	}
}
