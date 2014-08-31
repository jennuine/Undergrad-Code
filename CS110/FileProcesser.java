import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileProcesser {
	
	public static boolean isWord(String token) {
		for (int i = 0; i < token.length(); i++) {
			if (!Character.isLetter(token.charAt(i))) {
				return false;
			} 	
		}
		return true;
	}
	
	public static boolean isInteger(String token) {
		if (token.startsWith("+") || token.startsWith("-")) {
			for (int i = 1; i < token.length(); i++) {
			if (!Character.isDigit(token.charAt(i))) {
				return false;
				}
			}
		return true;
		
		} else {
			for (int i = 0; i < token.length(); i++) {
				if (!Character.isDigit(token.charAt(i))) {
					return false;
					}
				}
		}	
		return true;
	}	
	
	public static boolean isFloat(String token) {
		
		if (!(token.contains("."))) {
			return false;
		} 
		
		if (token.startsWith("+") || token.startsWith("-")) {
			for (int i = 1; i < token.length(); i++) {
			if (!Character.isDigit(token.charAt(i)) && !(token.charAt(i) == '.')) {
				return false;
				}
			}
		return true;
		
		} else {
			for (int i = 0; i < token.length(); i++) {
				if (!Character.isDigit(token.charAt(i)) && !(token.charAt(i) == '.')) {
					return false;
					}
				}
			return true;
		}
		
			
	}
		
		public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		Boolean goodFile = false;
		String filename = null;
		Scanner inputFile = null;
		File file = null;
		String token = null;
		int nrWords = 0;
		int nrIntegers = 0;
		int nrFloats = 0;
		int nrUnknown = 0;
		
		System.out.println("Please enter the filename.");
		filename = input.next();
		
		file = new File(filename);
		
		while (!goodFile) {
			try {
				inputFile = new Scanner(file);
				goodFile = true;
				
			} catch (FileNotFoundException e) {
				
				System.out.println("Error. Please enter the file name again.");
				filename = input.next();
				file = new File(filename);
				
			}
			
		}
		
		while (inputFile.hasNextLine()) {
			token = inputFile.next();
			
			if (isWord(token)) {
				nrWords++;
				
			} else if (isInteger(token)) {
				nrIntegers++;
				
			} else if (isFloat(token)) {
				nrFloats++;
				
			} else {
				nrUnknown++;
				
				System.out.println("Unknown: " + token);
				
			}
			
			
		}
		
		
		System.out.println();
		System.out.println("Number of words: " + nrWords);
		System.out.println("Number of integers: " + nrIntegers);
		System.out.println("Number of floats: " + nrFloats);
		System.out.println("Number of unknown: " + nrUnknown);
		
		
	}

}
