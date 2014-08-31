import java.util.Scanner;

public class Date {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		String date = null;
		String month = null;
		String day = null;
		String year = null;
		int posWhiteSpace1 = 0;
		int posWhiteSpace2 = 0;
		
		System.out.println("Please enter a date following the format month date, year (ie: September 8, 2013).");
		date = input.nextLine();
		
		posWhiteSpace1 = date.indexOf(' ');
		posWhiteSpace2 = date.lastIndexOf(' ');
		
		month = date.substring(0, posWhiteSpace1);
		day = date.substring(posWhiteSpace1 + 1, posWhiteSpace2 - 1);
		year = date.substring(posWhiteSpace2 + 1);
		
		System.out.println(day + " - " + month + " - " + year);
		
		
		
		
	}
}
