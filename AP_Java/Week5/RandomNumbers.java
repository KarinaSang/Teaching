package week5;

public class RandomNumbers {

	public static void main(String[] args) {
		// double random numbers
//		double x;
//		
//		for (int i = 0; i < 10; i++) {
//			// x = 6 * Math.random();
//			// x = Math.random() + 2;
//			x = 2 * Math.random() + 4;
//			System.out.println(x);
//		}
//		
		// int random numbers
		int num;
		
		for (int i = 0; i < 10; i++) {
			// num = (int) (Math.random() * 1000);
			// num = (int) (Math.random() * 1000) + 1;
			num = (int) (Math.random() * 20) + 5;
			System.out.println(num);
		}
	}

}
