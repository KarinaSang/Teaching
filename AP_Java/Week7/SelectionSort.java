package week7;

/* A class that sorts an array of ints from
* largest to smallest using selection sort. */
public class SelectionSort {
	private int[] a;
	
	
	public SelectionSort(int[] arr) { 
		a = arr; 
	}
	

	/** Swap a[i] and a[j] in array a.
	 * @param i an index for array a
	 * @param j an index for array a
	 */
	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	/** Sort array a from largest to smallest using selection sort.
	* Precondition: a is an array of ints.
	*/
	public void selectionSort() { // {5, 3, 7, 1}
		int minPos, min;
		
		for (int i = 0; i < a.length - 1; i++)	{ // i = 0, 1, 2      < 3
			//find max element in a[i+1] to a[a.length-1]
			min = a[i];  // 5
			minPos = i;  // 0
			
			for (int j = i + 1; j < a.length; j++)  // j = 1, 2, 3, 4    < 4
				if (min > a[j])	{
					min = a[j];   // 3  1
					minPos = j;   // 1	3
				}
			
			swap(i, minPos); //swap a[i] and a[maxPos]  {1, 3, 7, 5}
		}
	}
}
