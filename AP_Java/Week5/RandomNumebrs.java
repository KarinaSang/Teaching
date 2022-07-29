package week5;

public class RandomNumebrs {

	public static void main(String[] args) {
		// double random numbers
		double x = 6 * Math.random();
		x = Math.random() + 2;
		x = 2 * Math.random() + 4;
		
		for (int i = 0; i < 10; i++) {
			System.out.println(x);
		}
		
		// int random numbers
		int num = (int) (Math.random() * 1000);
		num = (int) (Math.random() * 1000) + 1;
		num = (int) (Math.random() * 20) + 5;
		
		for (int i = 0; i < 10; i++) {
			System.out.println(num);
		}
	}

}
