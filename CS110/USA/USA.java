import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class USA {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		String filename = null;
		Scanner inputFile = null;
		Scanner input = new Scanner(System.in);
		File file = null;
		
		double x = 0;
		double y = 0;
		final double MIN_X = 669905.0;
		final double MAX_X = 1244962.0;
		final double MIN_Y = 247205.0;
		final double MAX_Y = 700000.0;
		
		System.out.println("Please enter the filename.");
		filename = input.nextLine();
		
		file = new File(filename);
		inputFile = new Scanner(file);
		
		StdDraw.setXscale(MIN_X, MAX_X);
		StdDraw.setYscale(MIN_Y, MAX_Y);
		
		
		while (inputFile.hasNextLine()) {
			
			x = inputFile.nextDouble();
			y = inputFile.nextDouble();
			StdDraw.point(x, y);
			
		}
	}
}