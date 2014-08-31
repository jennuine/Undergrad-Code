import javax.swing.JOptionPane;

public class InchesConverter {
	public static void main(String [] args) {
		
		String inches = null;
		double inches2 = 0;
		String operator = null;
		int operator2 = 0;
		double result = 0;
		final int FEET = 1;
		final int METERS = 2;
		final int YARDS = 3;
		final double INCH_IN_FEET = 12;
		final double INCH_IN_METERS = 39.37;
		final double INCH_IN_YARDS = 36;
		
		inches = JOptionPane.showInputDialog("Please enter a value in inches.");
		inches2 = Double.parseDouble(inches);
		
		operator = JOptionPane.showInputDialog("Type the number you would like inches convert to? "
				+ "\n\t1. Feet \n\t2. Meters \n\t3. Yards");
		operator2 = Integer.parseInt(operator);
		
		switch (operator2) {
		case FEET: {
			result = (inches2 / INCH_IN_FEET);
			System.out.printf("\n%.2f inches = %.2f feet", inches2, result);
			
		}
		break;
		case METERS: {
			result = (inches2 / INCH_IN_METERS);
			System.out.printf("\n%.2f inches = %.2f meters", inches2, result);
		}
		break;
		case YARDS: {
			result = (inches2 / INCH_IN_YARDS);
			System.out.printf("\n%.2f inches = %.2f yards", inches2, result);
		}
		break;
		default: {
			System.out.println("Invalid choice. Please try again.");
			
			}
		
		}
		
	}
}
