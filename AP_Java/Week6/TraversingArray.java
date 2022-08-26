package week6;

public class TraversingArray {

	/** @return the number of even integers in array arr of integers */
	public static int countEven(int[] arr) {
		int count = 0;
		
		for (int num : arr)
			if ( num % 2 == 0) //num is even
				count++;
		
		return count;
	}
	
	/** Change each even-indexed element in array arr to 0.
	* Precondition: arr contains integers.
	* Postcondition: arr[0], arr[2], arr[4], ... have value 0.
	*/
	public static void changeEven(int[] arr) {
		for (int i = 0; i < arr.length; i += 2)
			arr[i] = 0; 
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		// {0, 2, 0, 4, 0, 6}
		
		System.out.println(countEven(arr));
		changeEven(arr);
		System.out.println(countEven(arr));

	}

}
