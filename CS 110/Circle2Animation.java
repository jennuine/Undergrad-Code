import java.awt.Color;


public class Circle2Animation {
	public static void main(String [] args) {
		final double MIN_X = -1;
		final double MAX_X = 1;
		final double MIN_Y = -1;
		final double MAX_Y = 1;
		double delta = -0.01;
		
		StdDraw.setXscale(MIN_X, MAX_X);
		StdDraw.setYscale(MIN_Y, MAX_Y);
		
		Circle2 circle1 = new Circle2(0, 0, 1);
		
		Circle2 circle2 = new Circle2(0.5, 0.5, 0.2);
		
		Circle2 circle3 = new Circle2(0, 0, 1.5);
		
		Circle2 circle4 = new Circle2(0.5, 0.5, 0.2);
		
		Circle2 circle5 = new Circle2(0.7, 0.7, 0.25);
		
		Circle2 circle6 = new Circle2(0.5, 0.5, 0.2);
		
		Circle2 circle7 = new Circle2(0.5, 0.5, 0.2);
		
		circle1.setColor(Color.GREEN);
		while(true) {
		
			StdDraw.clear();
			
			circle1.draw();
			circle2.draw();
			circle3.drawUnfilled();
			circle4.draw();
			circle5.draw();
			circle6.draw();
			circle7.drawUnfilled();
			
			circle2.updateX(0.05, MIN_X, MAX_X);
			circle2.updateY(0.01, MIN_Y, MAX_Y);
			
			circle3.updateX(0.05 * 0.05, MIN_X, MAX_X);
			circle3.updateY(0.01 * 0.01, MIN_Y, MAX_Y);
			
			circle4.updateX(0.01, MIN_X, MAX_X);
			circle4.updateY(0.05, MIN_Y, MAX_Y);
			
			circle5.updateX(0.1, MIN_X, MAX_X);
			circle5.updateXDown(0.01, MIN_X,MAX_X);
			
			circle6.updateX(-0.05, MIN_X, MAX_X);
			circle6.updateY(-0.01, MIN_Y, MAX_Y);
			
			circle7.updateX(-0.01, MIN_X, MAX_X);
			circle7.updateY(-0.05, MIN_Y, MAX_Y);
			
			circle2.setColor(Color.CYAN);
			circle4.setColor(Color.MAGENTA);
			circle6.setColor(Color.GRAY);
			circle7.setColor(Color.ORANGE);
				
			if (circle1.getRadius() <= 0.00001) {
				delta = 0.05;
				
				circle1.setColor(Color.PINK);
		
			} else if (circle1.getRadius() > 1) {
				delta = -0.01;
				
				circle1.setColor(Color.RED);			
		
			}
			
			circle1.updateRadius(delta);
			circle2.updateRadius(delta);
			circle3.updateRadius(delta);
			circle4.updateRadius(delta);
			circle6.updateRadius(delta);
			circle7.updateRadius(delta);
			
			StdDraw.show(20);
		}	
	}
}
