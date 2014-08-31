import java.awt.Color;


public class Circle2 {
	private double radius;
	private double x;
	private double y;
	private Color color;
	private int directionX;
	private int directionY;
	private double penRadius;
	
	public Circle2(double newX, double newY, double newRadius) {
		x = newX;
		y = newY;
		radius = newRadius;
		color = color.BLACK;
		directionX = 1;
		directionY = 1;
		penRadius = 0.1;	
		
	}
	
	public void draw() {
		
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x,  y, radius);
		
	}
	
	public void drawUnfilled() {
		StdDraw.setPenColor(color);
		StdDraw.circle(x, y, radius);
		StdDraw.setPenRadius(penRadius);
	}
	
	public void updateRadius(double delta) {
		radius += delta;
		if (radius < 0) radius = 0;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double newRadius) {
		radius = newRadius;
		if (radius < 0) radius = 0;
	}
	
	public void setColor(Color newColor) {
		color = newColor;
		
	}
	
	public void updateX(double delta, double minX, double maxX) {
		x += directionX * delta;
		
		if (x + radius > maxX) {
			x = maxX - radius;
			directionX = -1;
			
		}
		
		if (x - radius < minX) {
			x = minX + radius;
			directionX = 1;
			
		}
	}
	
	public void updateXDown(double delta, double minX, double maxX) {
		y += directionY * delta;
		
		if (y + radius > maxX) {
			y = maxX - radius;
			directionY = -1;
			
		}
		
		if (y - radius < minX) {
			y = minX + radius;
			directionY = 1;
			
		}
		
	}
	
	public void updateY(double delta, double minY, double maxY) {
		y += directionY * delta;
		
		if (y + radius > maxY) {
			y = maxY - radius;
			directionY = -1;
			
		}
		
		if (y - radius < minY) {
			y = minY + radius;
			directionY = 1;
			
		}
	}	
}
