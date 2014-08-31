import java.awt.Color;

public class SquareAnimation {
	public static void main(String [] args) {
		final double MIN_X = -2;
		final double MAX_X = 2;
		final double MIN_Y = -2;
		final double MAX_Y = 2;
		double delta = 0.01;
		
		StdDraw.setXscale(MIN_X, MAX_X);
		StdDraw.setYscale(MIN_Y, MAX_Y);
		
		Square square1 = new Square(0, 1, 3);
		
		while (true) {
			StdDraw.clear();
			
			square1.draw();
			
			square1.updateX(0.05, MIN_X, MAX_X);
			square1.updateY(0.002, MIN_Y, MAX_Y);
			
			if (square1.getX() <= 0.0001) {
				delta = 0.5;
				
				square1.setColor(Color.RED);	
			} else if (square1.getX() > 0.0001) {
				delta = -0.05;
				
				square1.setColor(Color.BLUE);
			}
			
			square1.updateHalfSide(delta);
			square1.scale(Math.random() * 1.5);
			StdDraw.show(20);
		}
		
		
	}
}
