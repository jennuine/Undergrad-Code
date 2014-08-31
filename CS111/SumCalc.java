import java.util.Scanner;

public class SumCalc {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		int n = 0;
		double sum1 = 0;
		double sum2 = 0;
		double sum3 = 0;
		final double ONE = 1;
		final int THREE = 3;
		
		System.out.println("Please enter a number greater than zero.");
		n = input.nextInt();
		
		for (int i = 1; i <= n; i++) {
			sum1 = THREE * i;
			sum2 = ONE / sum1;
			sum3 = sum2 + sum3;
		}
		
		System.out.printf("The sum is: %.4f", sum3);
		
	}
}
