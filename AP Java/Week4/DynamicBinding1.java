package week4;

import java.util.Scanner;

public class DynamicBinding1 {

	public static void main(String[] args) {
		Student s = null;
		Student u = new UnderGrad("Klee", new int [] {65, 65, 65}, "none");
		Student g = new GradStudent("Diona", new int [] {70, 70, 70}, "none", 1234);
		
		System.out.println("Enter student status: ");
		System.out.println("Grad (G), Undergrad (U), Neither (N)");
		
		Scanner myScanner = new Scanner (System.in);
		
		String str = myScanner.nextLine(); //read user input
		if (str.equals("G"))
			s = g;
		else if (str.equals("U"))
			s = u;
		else
			s = new Student();
		
		s.computeGrade();
		System.out.println(s.getGrade());
	}

}
