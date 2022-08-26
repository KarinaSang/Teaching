package week6;

public class ArrayInitialization {

	public static void main(String[] args) {
		double[] data = new double[25];  // data[0], data[24]
		data[0] = 1;
		data[1] = 2;
		data[2] = 3;
		double data2[] = new double[25];
		double[] data3;
		data3 = new double[25];
		data3 = new double[40]; // creates a new array and reassigns it to data3
		
		// default value of arrays
		System.out.println(data[0]);
		
		int[] intArr = new int[1];
		System.out.println(intArr[0]);
		
		boolean[] boolArr = new boolean[1];
		System.out.println(boolArr[0]);
		
		BankAccount[] bankArr = new BankAccount[1];
		System.out.println(bankArr[0]);
		
		String[] stringArr = new String[1];
		System.out.println(stringArr[0]);
		
		// multiple declaration
		int[] intArr1, intArr2;
		int[] arr1 = new int[15], arr2 = new int[30];
		
		// initializer list
//		int[] coins = new int[4];
//		coins[0] = 1;
//		coins[1] = 5;
//		coins[2] = 10;
//		coins[3] = 25;
		
		int[] coins = {1, 5, 10, 25, 50}; // implicitly using new

	}

}
