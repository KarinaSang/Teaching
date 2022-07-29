package week4;

public class TestStudent {
	
	public static void main (String[] args) {
		Student eula = new GradStudent("Eula", new int [] {90, 94, 99}, "none", 1111);		
		Student klee = new UnderGrad("Klee", new int [] {65, 65, 65}, "none");
		GradStudent diona = new GradStudent("Diona", new int [] {70, 70, 70}, "none", 1234);
		
		eula.setGrade("Pass");
		klee.setGrade("Pass");
		diona.setGrade("Pass");
		
		
		// won't work
		// int studentNum = ((GradStudent) eula).getID();
		// int underGradNum = ((GradStudent) klee).getID();
		int gradNum = diona.getID();
		
		System.out.println(gradNum);
		
		
		// will work
		eula.computeGrade();
		klee.computeGrade();
		diona.computeGrade();
		
		System.out.println(eula.getGrade());
		System.out.println(klee.getGrade());
		System.out.println(diona.getGrade());
	}

}
