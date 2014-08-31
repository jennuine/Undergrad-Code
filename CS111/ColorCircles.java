import java.awt.Color;
import java.util.Scanner;

public class ColorCircles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double minR = 0;
		double maxR = 0;
		double radius = 0;
		int numCircles = 0;
		double x = 0;
		double y = 0;
		int remainder = 0;
		final int BLACK = 0;
		final int BLUE = 1;
		final int YELLOW = 2;
		final int THREE = 3;
		final int MIN_X = 0;
		final int MAX_X = 1;
		final int MIN_Y = 0;
		final int MAX_Y = 1;
		
		
		StdDraw.setXscale(MIN_X, MAX_X);
		StdDraw.setYscale(MIN_Y, MAX_Y);
		
		System.out.println("Please enter the minimum and maximum values of the radius "
				+ "(keep in mind the values should be small values or the circle will be too big).");
		minR = input.nextDouble();
		maxR = input.nextDouble();
		
		System.out.println("How many circles do you want?");
		numCircles = input.nextInt();
		
		
		for (int i = 0; i < numCircles; i++) {
			
			radius = Math.random() * (maxR - minR);
			
			x = Math.random() * (MAX_X - MIN_X);
			y = Math.random() * (MAX_Y - MIN_Y);

			remainder = i % THREE;
				
				
			switch (remainder) {
				
				case BLACK: StdDraw.setPenColor(Color.BLACK); break;
				case BLUE: StdDraw.setPenColor(Color.BLUE); break;
				case YELLOW: StdDraw.setPenColor(Color.YELLOW); break;
				
			}
			
			StdDraw.setPenRadius(Math.random() * radius);
			StdDraw.circle(x, y, radius);
			
			
		}
		
	}

}
