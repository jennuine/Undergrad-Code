import java.awt.Color;

public class Square {
	private double x;
	private double y;
	private double halfSide;
	private Color color;
	private int directionX;
	private int directionY;
	
	public Square(double newX, double newY,  double newHalfSide) {
		x = newX;
		y = newY;
		halfSide = newHalfSide;
		color = Color.BLACK;
		directionX = 2;
		directionY = 2;
		
	}
	
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledSquare(x, y, halfSide);
	}
	
	public void move(double newX, double newY) {
		x = newX;
		y = newY;
	}
	
	public void scale(double percentage) {
		halfSide = halfSide * percentage;	
	}
	
	public double getX() {
		return x;
	}
	
	
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public void updateX(double delta, double minX, double maxX) {
		x += directionX * delta;
		
		if (x + halfSide > maxX) {
			x = maxX - halfSide;
			directionX = -2;
			
		}
		
		if (x - halfSide < minX) {
			x = minX + halfSide;
			directionX = 2;
			
		}
	}
	
	public void updateY(double delta, double minY, double maxY) {
		y += directionY * delta;
		
		if (y + halfSide > maxY) {
			y = maxY - halfSide;
			directionY = -2;
		
		}
		
		if (y - halfSide < minY) {
			y = minY + halfSide;
			directionY = 2;
			
		}
	}
	
	public void updateHalfSide(double delta) {
		halfSide += delta;
		if (halfSide < 0) halfSide = 0;
	}
}
