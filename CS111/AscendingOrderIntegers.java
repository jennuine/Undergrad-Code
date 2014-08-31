import java.util.Scanner;
import java.lang.Math;

public class AscendingOrderIntegers {
	public static void main(String [] args) {
	Scanner input = new Scanner(System.in);
	
	int number1 = 0;
	int number2 = 0;
	int number3 = 0;
	int smallest = 0;
	int middle = 0;
	int largest = 0;
	
	System.out.println("Please enter 3 numeric values.");
	
	number1 = input.nextInt();
	number2 = input.nextInt();
	number3 = input.nextInt();
	
	smallest = Math.min(number3, Math.min(number1, number2));
	largest = Math.max(number3, Math.max(number1, number2));
	middle = number1 + number2 + number3 - largest - smallest;
	
	System.out.println("Smallest: " + smallest);
	System.out.println("Middle: " + middle);
	System.out.println("Largest: " + largest);
	
	
	
	
	}
}
