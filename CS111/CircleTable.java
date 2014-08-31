import java.util.Scanner;
import java.lang.Math;

public class CircleTable {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		int n = 0;
		int remainder = 0;
		int red = 0;
		int green = 0;
		int blue = 0;
		final int MIN_X = 0;
		final int MAX_X = 8;
		final int MIN_Y = 0;
		final int MAX_Y = 8;
		final int TWO_FIFTY_FIVE = 255;
		final double PT_ZERO_FIVE = 0.05;
		
		
		
		System.out.println("Enter a number");
		n = input.nextInt();
		
		StdDraw.setXscale(MIN_X, MAX_X);
		StdDraw.setYscale(MIN_Y, MAX_Y);
		
		
		for (int i = 1; i <= n; i++) {
			
			red = (int)(Math.random() * TWO_FIFTY_FIVE);
			green = (int)(Math.random() * TWO_FIFTY_FIVE);
			blue = (int)(Math.random() * TWO_FIFTY_FIVE);
			
			for (int j = 1; j <= n; j++) {
				remainder = i % j;
				
				for (int k = 1; k <= n; k++) {
				
				StdDraw.setPenRadius(remainder);
				StdDraw.filledSquare(j, i, remainder * PT_ZERO_FIVE);
				StdDraw.setPenColor(red, green, blue);
				
				
				}		
				}
			}		
		}
	}
