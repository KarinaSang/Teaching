package week5;

public class StringComparison {

	public static void main(String[] args) {
		String s1 = "cat";
		String s2 = "Cat";
		String s3 = "Cats";
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s3));

	}

}
