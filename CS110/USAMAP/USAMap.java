import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class USAMap {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("states.txt"); //object of File
		Scanner fileInput = new Scanner(file); //object of Scanner
		
		double minX = 0;
		double maxX = 0;
		double minY = 0;
		double maxY = 0;
		int nrStates = 0;
		State state = null; //from object made State
		State [] states = null; //creates an array of States
		final int WIDTH = 1024;
		double width = 0;
		double height = 0;
		
		
		minX = fileInput.nextDouble();
		maxX = fileInput.nextDouble();
		minY = fileInput.nextDouble();
		maxY = fileInput.nextDouble();
		//^^ minX&Y and maxX&Y will set the scale of the map
		
		width = maxX - minX;
		height = maxY - minY;
		StdDraw.setCanvasSize(WIDTH, 
				(int)(height / width * WIDTH));
		
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY, maxY);

		nrStates = fileInput.nextInt();
		fileInput.nextLine(); //reads and skips blank line
		states = new State[nrStates]; //allocates memory for State array
		
		
		for (int j = 0; j < nrStates; j++) {
		states[j] = readState(fileInput);
		}//end for loops (this for loops reads all the lines of the state)
		
		boolean blink = false;
		while(true) {
			StdDraw.clear();
			for (int i = 0; i < states.length; i++) {
				states[i].draw();
				
				if (states[i].getName().equals("west virginia")) {
					if (blink) {
						states[i].setColor(Color.YELLOW);
						blink = false;
					} else {
						states[i].setColor(Color.BLUE);
						blink = true;
					}
				}
			}
			
			StdDraw.show(200);
		}
	}
	//can use this in for loop to create other states but simplier to put it in a method
	
	
	public static State readState(Scanner fileInput) {//will return an object of the class state
		String stateName = null;
		int nrCoordinates = 0;
		double [] x = null;
		double [] y = null;
		int nrStates = 0;
		State state = null; //from object made State
		
		
		stateName = fileInput.nextLine();
		nrCoordinates = fileInput.nextInt();
		System.out.println(nrStates + " " + stateName + " " + nrCoordinates);
		
		x = new double[nrCoordinates];
		y = new double[nrCoordinates];
		//allocating memory for x and y coordinates
		
		for (int i = 0; i < nrCoordinates; i++) {
			x[i] = fileInput.nextDouble();
			y[i] = fileInput.nextDouble();
		}
		fileInput.nextLine();//skips the blank line it is trying to read
		
		state = new State(stateName, x, y);
		return state;
	}
			
}
