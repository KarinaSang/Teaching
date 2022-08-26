package week5;

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
		//System.out.println("Square area is called");
		return side * side; 
	}
}
