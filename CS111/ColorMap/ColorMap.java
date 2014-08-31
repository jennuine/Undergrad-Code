import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ColorMap {

	private static int[][] adj = null;
	private static int[] colors = null;
	private static int numRegions = 0;
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the number of regions in the map");
		numRegions = input.nextInt();

		adj = new int[numRegions][numRegions];
		colors = new int[numRegions];

		System.out.println("\nPlease enter the filename of the adjacency matrix.");
		String filename = input.next();

		File file = null;
		Scanner inputFile = null;
		Boolean goodFile = false;

		//will keep looping until correct file input
		while (!goodFile) {
			try {
				file = new File(filename);
				inputFile = new Scanner(file);
				goodFile = true;

			} catch (FileNotFoundException e) {
				System.out.println("\nSorry, the filename you have entered does not exist "
						+ "or was entered incorrectly.  \nPlease try entering the filename again.");
				filename = input.next();
			}
		}
		
		//records file into adj matrix
		for (int row = 0; row < numRegions; row++) {
			for (int col = 0; col < numRegions; col++) {
				adj[row][col] = inputFile.nextInt();
			}
		}
		
		printMatrix();
		printColorMap();
	}

	/**Function that checks if assignment of color is acceptable
	 * Pre-condition: must be valid region & colors. Both are integers
	 * Post-condition: color assignment is ok iff adjacent region does not have same color
	 * Responses to abnormal behavior: Error Terminate
	 * @param the integer region
	 * @param the integer color
	 * @return true iff adjacent region does not have same color otherwise false 
	 */
	public static boolean okColor(int region, int color) {
		for (int i = 0; i < numRegions; i++) {
			if (adj[region][i] == 1 && colors[i] == color) return false;
		}
		return true;
	}

	/**Function that will check assignment of region colors, assign colors to a region, then backtrack and correct any colors that
	 * are adjacent to one another
	 * Pre-conditions: region is a valid integer
	 * Post-condition: colors are assigned to each region with no two of the same colors touching
	 * Responses to abnormal behavior: Error terminate
	 * @param the integer region
	 * @return true iff all regions assigned colors with no colors adjacent to each other
	 */
	public static boolean colorCoder(int region) {
		if (region == numRegions) return true;

		for (int i = 1; i <= 4; i++) {
			if (okColor(region, i)) {
				colors[region] = i;

				if(colorCoder(region + 1)) return true;
				
				colors[region] = 0;
			}
		}
		return false;
	}

	/**Function that prints out the matrix adjacency map stored in the array
	 * Pre-conditions: must be valid data stored in the array
	 * Post-Conditions: will print out array in correct columns and rows
	 * Responses to abnormal behavior: Error Terminate
	 */
	public static void printMatrix() { 
		System.out.println();
		for (int row = 0; row < numRegions; row++) {
			for (int col = 0; col < numRegions; col++) {
				System.out.print(adj[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**Function that prints out the region and the color assigned to that region
	 * Pre-conditions: method colorCoder must execute accurately
	 * Post-conditions: will neatly print out the region and what the color of the region is
	 * Responses to abnormal behavior: Error Terminate
	 */
	public static void printColorMap() {
		System.out.printf("%7s %7s", "REGION", "COLOR");
		colorCoder(0);
		System.out.println();
		System.out.printf("%7s %7s", "------", "-----");
		System.out.println();
		
		for (int i = 0; i < colors.length; i++) {
			int option = colors[i];
			
			switch (option) {
			case 1: System.out.printf("%4d %10s", i + 1, "Red\n"); break;
			case 2: System.out.printf("%4d %11s", i + 1, "Blue\n"); break;
			case 3: System.out.printf("%4d %12s", i + 1, "Green\n"); break;
			case 4: System.out.printf("%4d %13s", i + 1, "Yellow\n"); break;
			}
		}
		System.out.println();
	}
}