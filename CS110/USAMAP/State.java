import java.awt.Color;
import java.awt.Font;

public class State {
	private String name;
	private double [] x;
	private double [] y;
	private Color color;
	private double centerX;
	private double centerY;
	
	public State(String newName, double [] newX, double [] newY) { //constructor
		name = newName;
		x = newX;
		y = newY;
		color = Color.BLUE;
		
		centerX = calculateCenter(x);
		centerY = calculateCenter(y);
	}
	
	public void draw() {
		
		
		StdDraw.setPenColor(color);
		StdDraw.filledPolygon(x, y);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(centerX, centerY, name);
		
	}
	
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public String getName() {
		return name;
	}
	
	private double calculateCenter(double [] array) {
		double min = array[0];
		double max = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
			if (max < array[i]) {
				max = array[i];
			}
		}
		return (max + min) / 2;
	}
	
	

}
