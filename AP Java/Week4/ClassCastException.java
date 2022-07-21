package week4;

public class ClassCastException {

	public static void main(String[] args) {
		Student u = new UnderGrad();
		// System.out.println((String) u); //ClassCastException
		//u is not an instance of String
		
		int x = ((GradStudent) u).getID(); //ClassCastException
		//u is not an instance of GradStudent
	}

}
