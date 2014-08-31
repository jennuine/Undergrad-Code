import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CountWhiteSpaces {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		String filename = null;
		Scanner inputFile = null;
		File file = null;
		String line = null;
		int numWhiteSpaces = 0;
		
		System.out.println("Enter a filename.");
		filename = input.nextLine();
		
		file = new File(filename);
		inputFile = new Scanner(file);
		
		while (inputFile.hasNextLine()) {
			line = inputFile.nextLine();
			System.out.println(line);
			
			for (int i = 0; i < line.length(); i++)	{
				if (Character.isWhitespace(line.charAt(i))) {
					numWhiteSpaces ++;
				}
			}
			
		}
		
		System.out.println("Number of whitespaces " + numWhiteSpaces);
		
	}
}
