package week7;

// Java program for implementation of Insertion Sort
public class InsertionSort {
	/*Function to sort array using insertion sort*/
	public void sort(int arr[]) { // {4, 6, 2, 1}
		int n = arr.length;  // 4
		
		for (int i = 1; i < n; ++i) { // i = 1, 2, 3
			int key = arr[i]; // 6 2 1
			int j = i - 1; // 0 1 2

			/* Move elements of arr[0..j], that are
			greater than key, to one position ahead
			of their current position */
			while (j >= 0 && arr[j] > key) { // j = 2, 1, 0, -1
				arr[j + 1] = arr[j]; // {2, 2, 4, 6}
				j = j - 1;
			}
			
			arr[j + 1] = key; // {1, 2, 4, 6}
		}
	}

	/* A utility function to print array of size n*/
	static void printArray(int arr[]) {
		int n = arr.length;
		
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println();
	}

	
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		ob.sort(arr);

		printArray(arr);
	}
} 
