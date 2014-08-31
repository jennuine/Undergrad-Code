import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReader {
	public static void main(String [] args) throws FileNotFoundException {
		
		String filename = null;
		Scanner inputFile = null;
		Scanner input = new Scanner(System.in);
		File file = null;
		String line = null;
		int nrLines = 0;
		int nrWords = 0;
		int nrCharacters = 0;
		int nrDigits = 0;
		int nrWhiteSpace = 0;
		int nrOther = 0;
		char characters = ' ';
		
		System.out.println("Please enter the name of the data file you would like to use.");
		filename = input.nextLine();
		
		file = new File(filename);
		inputFile = new Scanner(file);
		
		while (inputFile.hasNextLine()) {
			line = inputFile.nextLine();
			nrLines ++;
			
			for (int i = 0; i < line.length(); i++) {
				characters = line.charAt(i);
				
				if (Character.isWhitespace(characters)) {
					nrWords ++;
					nrWhiteSpace = nrWords;
					
				} else if (Character.isLetter(characters)) {
					nrCharacters ++;
					
				} else if (Character.isDigit(characters)) {
					nrDigits ++;
					
				} else {
					nrOther ++;
					
				}
					
			}
			
		}
		
		System.out.println("Number of line(s) is " + nrLines);
		System.out.println("Number of word(s) is " + nrWords);
		System.out.println("Number of character(s) is " + nrCharacters);
		System.out.println("Number of digit(s) is " + nrDigits);
		System.out.println("Number of blank space(s) is " + nrWhiteSpace);
		System.out.println("Number of other character(s) is " + nrOther);
	}

	
	}
