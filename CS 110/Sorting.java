import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sorting {
	
	public static void printArray(String [] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int minPos(String [] array, int start) {
		String min = array[start];
		int pos = start;
		
		
		for (int i = start; i < array.length; i++) {
			if (min.compareTo(array[i]) > 0) {
				min = array[i];
				pos = i;
			}
		}
		return pos;
	}
	
	public static void selectionSort(String [] words) {
		String temp = null;
		int pos = 0;
		
		for (int i = 0; i < words.length; i++) {
			temp = words[i];
			pos = minPos(words, i);
			words[i] = words[pos];
			words[pos] = temp;
		}
	}
	
	public static void insertionSort(String [] words) {
		String temp = null;
		int pos = 0;
		
		for (int i = 1; i < words.length; i++) {
			for (int j = 0; j < (words.length - 1); j++) {
				while ((words[j].compareTo(words[j + 1])) > 0) {
					temp = words[j];
					pos = j + 1;
					words[j] = words[pos];
					words[pos] = temp;
				}
			}
		}
	}
	
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		String filename = null;
		File file = null;
		Scanner inputFile = null;
		Boolean goodFile = false; 
		int elements = 0;
		String [] fileString = null;
		
		System.out.println("Please enter a filename");
		filename = input.next();
		
		file = new File(filename);
		
		while (!goodFile) {
			try {
				inputFile = new Scanner(file);
				goodFile = true;
				
			} catch (FileNotFoundException e) {
				System.out.println("Error, please enter the filename again.");
				filename = input.next();
				file = new File(filename);
			
			}	
		}
		
			elements = Integer.parseInt(inputFile.nextLine());
			fileString = new String[elements];
			
			for (int i = 0; inputFile.hasNextLine(); i++) {
				fileString[i] = inputFile.nextLine();
				}
			
		selectionSort(fileString);
		System.out.print("Sorted by selection: \n\t");
		printArray(fileString);
		
		System.out.println();
		
		insertionSort(fileString);
		System.out.print("Sorted by insertion: \n\t");
		printArray(fileString);
	
	}
}
