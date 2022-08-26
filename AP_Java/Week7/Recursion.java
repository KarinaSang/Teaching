package week7;

public class Recursion {
	
	/** @param n a nonnegative integer
	* @return n with its digits reversed
	*/
	public static void revDigs(int n) { // n = 1   321
		System.out.print(n % 10); //rightmost digit
		
		if (n / 10 != 0) //base case
			revDigs(n / 10);
	}
	

	/** Compute n! recursively.
	* @param n a nonnegative integer
	* @return n!
	*/
	public static int factorial(int n)	{
		if (n == 0) //base case
			return 1;
		else
			return n * factorial(n - 1);
	}
	
	
	public static void drawLine(int n) {
		if (n == 0)
			System.out.println("That’s all, folks!");
		else {
			for (int i = 1; i <= n; i++)
				System.out.print("*");
			System.out.println();
			drawLine(n - 1);
		}
	}
	
	
	public static void catastrophe(int n) {
		System.out.println(n);
		catastrophe(n);
	}
	
	
	public static void main(String[] args) {
//		System.out.println(factorial(5));
//		revDigs(59823);
		int[] arr = {2, 5, 8, 7, 1, -5, 100, 99};
		SelectionSort sort = new SelectionSort(arr);
		sort.selectionSort();
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}

}
