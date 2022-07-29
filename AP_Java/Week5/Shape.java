package week5;

public abstract class Shape implements Comparable<Object>{
	private String name;
	
	//constructor
	public Shape(String shapeName) { 
		name = shapeName; 
	}
	
	
	public String getName() { 
		return name; 
	}
	
	public abstract double area();
	
	public abstract double perimeter();
	
	public double semiPerimeter() { 
		return perimeter() / 2; 
	}
	

	public int compareTo(Object obj) {
		Shape rhs = (Shape) obj;
		double diff = this.area() - rhs.area();
		
		if (Math.abs(diff) == 0)
			return 0; //area of this shape equals area of obj
		else if (diff < 0)
			return -1; //area of this shape less than area of obj
		else
			return 1; //area of this shape greater than area of obj
	}
}
