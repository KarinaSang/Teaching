package week5;

public class TestShape {

	public static void main(String[] args) {
		Shape s1 = new Square(4, "square1");
		Shape s2 = new Square(2, "square2");
		Shape s3 = new Square(3, "square3");
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		
		String str = "I am a shape";
		System.out.println(s1.compareTo(str));
	}

}
