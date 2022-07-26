package week5;

public class MathMethods {

	public static void main(String[] args) {
		System.out.println("Math.abs: ");
		System.out.println(Math.abs(-8));
		System.out.println(Math.abs(-8.900));
		
		System.out.println("Math.pow: ");
		System.out.println(Math.pow(1, 0));
		System.out.println(Math.pow(2.5, 2));
		System.out.println(Math.pow(-2, 3));
		
		System.out.println("Math.sqrt: ");
		System.out.println(Math.sqrt(-2));
		System.out.println(Math.sqrt(4));
		System.out.println(Math.sqrt(4.9));
		

		System.out.println("Math.random: ");
		for (int i = 0; i < 10; i++) {
			System.out.println(Math.random());
		}
		
	}

}
