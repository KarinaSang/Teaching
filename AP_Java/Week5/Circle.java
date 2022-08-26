package week5;

public class Circle extends Shape{
	private double radius;
	
	
	//constructor
	public Circle(double circleRadius, String circleName) {
		super(circleName);
		radius = circleRadius;
	}
	
	
	public double perimeter() { 
		return 2 * Math.PI * radius; 
	}
	
	
	public double area() { 
		//System.out.println("Circle area is called");
		return Math.PI * radius * radius; 
	}
	
	public int area(int radius) {
		return 0;
	}
}
