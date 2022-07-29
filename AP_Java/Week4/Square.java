package week4;

public class Square extends Shape {
	private double side;
	
	
	//constructor
	public Square(double squareSide, String squareName) {
		super(squareName);
		side = squareSide;
	}
	
	
	public double perimeter() { 
		return 4 * side; 
	}
	
	
	public double area() { 
		return side * side; 
	}
}
