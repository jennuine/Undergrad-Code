import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
	public static void main(String [] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		File usersFile = null;
		Scanner inputFile = null;
		String filename = null;
		String word = null;
		String line = null;
		int nrMatches = 0;
		
		System.out.println("Enter a filename.");
		filename = input.nextLine();
		
		System.out.println("Enter a word.");
		word = input.nextLine();
		
		usersFile = new File(filename);
		inputFile = new Scanner(usersFile);
		
		while (inputFile.hasNextLine()) {
			line = inputFile.nextLine();
			
			for (int i = 0; i < line.length(); i++) {
				if (line.startsWith(word, i)) {
					nrMatches ++;
				
				}
			}
		}
		System.out.println("The word is found " + nrMatches + " time(s)");
		
	}
}
