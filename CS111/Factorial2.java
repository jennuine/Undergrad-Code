import java.util.Scanner;

public class Factorial2 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		double start = 0;
		double end = 0;
		final double STEP = 0.5;
		
		System.out.println("Enter the start and end of the interval");
		start = input.nextDouble();
		end = input.nextDouble();
		
		for (double x = start; x <= end; x += STEP) {
			System.out.printf("%10.2f %10.2f %10.2f %10.2f\n", x, Math.sqrt(x), Math.pow(x, 2), Math.pow(x, 3));
			
			
		}
	}
}
