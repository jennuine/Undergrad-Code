import java.util.Scanner;
import java.lang.Math;

public class ConvertingColors {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		double w = 0;
		double cyan = 0;
		double magenta = 0;
		double yellow = 0;
		double black = 0;
		int red = 0;
		int green = 0;
		int blue = 0;
		final double MAX_SCALE = 255;
		
		System.out.println("Please enter components for red, green, and blue.");
		
		red = input.nextInt();
		green = input.nextInt();
		blue = input.nextInt();
		
		w = Math.max(red / MAX_SCALE, Math.max(green / MAX_SCALE, blue / MAX_SCALE));
		cyan = (w - (red / MAX_SCALE)) / w ;
		magenta = (w - (green / MAX_SCALE)) / w ;
		yellow = (w - (blue / MAX_SCALE)) / w ;
		black = 1 - w ;
		
		System.out.println("Cyan: " + cyan);
		System.out.println("Magenta: " + magenta);
		System.out.println("Yellow: " + yellow);
		System.out.println("Black: " + black);
		
		
		
		
		
	}
	

}
