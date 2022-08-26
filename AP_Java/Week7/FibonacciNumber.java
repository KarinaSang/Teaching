package week7;

public class FibonacciNumber {
	/** @param n a positive integer
	* @return the nth Fibonacci number
	*/
	public static int fib(int n) {
		System.out.println(n);
		if (n == 1 || n == 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}
	
	
	public static void main(String[] args) {
		// System.out.println(fib(5));
		fib(5);
	}

}
