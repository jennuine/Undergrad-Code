import java.util.Scanner;

public class Days {
	public static void main(String [] args) {
	Scanner input = new Scanner(System.in);
	
	int number = 0;
	
	System.out.println("Please enter a number between 1 to 7.");
	number = input.nextInt();
	
	switch (number) {
	case 1: 
		System.out.println(number + " is Sunday"); break;
	case 2:
		System.out.println(number + " is Monday"); break;
	case 3:
		System.out.println(number + " is Tuesday"); break;
	case 4:
		System.out.println(number + " is Wednesday"); break;
	case 5:
		System.out.println(number + " is Thursday"); break;
	case 6:
		System.out.println(number + " is Friday"); break;
	case 7:
		System.out.println(number + " is Saturday"); break;
	default: 
		System.out.println("The number you entered is not between 1 and 7."); break;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
}