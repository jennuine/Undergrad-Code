import javax.swing.JOptionPane;

public class ByteConverter {
	public static void main(String [] args) {
		
		String posInt = null;
		int posInt2 = 0;
		int kilo = 0;
		int mega = 0;
		long giga = 0;
		long tera = 0;
		
		posInt = JOptionPane.showInputDialog("Please enter a positive integer.");
		posInt2 = Integer.parseInt(posInt);
		
		kilo = (posInt2 * 1000);
		mega = (posInt2 * (int)Math.pow(1000, 2));
		giga = (posInt2 * (long)Math.pow(1000, 3));
		tera = (posInt2 * (long)Math.pow(1000, 4));
		
		System.out.printf("The number you entered: %d \n\tThen converted to...", posInt2);
		System.out.printf("\n\t\tKilobytes = %d \n\t\tMegabytes = %d \n\t\tGigabytes = %d \n\t\tTerabytes = %d", 
				kilo, mega, giga, tera);
		
		
		
	}
	
}
