package week4;

import java.util.Scanner;

public class TestShapePolymorphism {

	public static void main(String[] args) {
		// Shape a = new Shape("shape");
		Shape circ = new Circle(10, "circle");
		Shape sq = new Square(9.4, "square");
		Shape s = null;
		
		System.out.println("Which shape?");
		
		Scanner myScanner = new Scanner(System.in);
		
		String str = myScanner.nextLine(); //read user input
		
		if (str.equals("circle"))
			s = circ;
		else
			s = sq;
		
		System.out.println("Area of " + s.getName() + " is " + s.area());

	}

}
