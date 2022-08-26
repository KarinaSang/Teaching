package week8;

import java.util.*;
public class QuickSort { 
    //selects last element as pivot, pi using which array is partitioned. 
	public int partition(int intArray[], int low, int high) { 
        int pi = intArray[low];  
        int up = low; 
        int down = high;
        
        while (up != down) {
        	 while (intArray[down] > pi && up != down) {
             	down--;
             }
             
             while (intArray[up] <= pi && up != down) {
             	up++;
             }
             
             int temp = intArray[up]; 
             intArray[up] = intArray[down]; 
             intArray[down] = temp; 
        }
        
        intArray[low] = intArray[up];
        intArray[up] = pi;
       
        return up; 
    } 
   
   
  //routine to sort the array partitions recursively
    public void quick_sort(int intArray[], int low, int high) { 
        if (low < high) { 
            //partition the array around pi=>partitioning index and return pi
            int pi = partition(intArray, low, high); 
   
            // sort each partition recursively 
            quick_sort(intArray, low, pi-1); 
            quick_sort(intArray, pi+1, high); 
        } 
    } 
    
    
    public static void main(String args[]) {
        //initialize a numeric array, intArray
        int intArray[] = {4,-1,6,8,0,5,-3}; 
        int n = intArray.length; 
        //print the original array
        System.out.println("Original Array: " + Arrays.toString(intArray));
        //call quick_sort routine using QuickSort object
        QuickSort obj = new QuickSort(); 
        obj.quick_sort(intArray, 0, n-1); 
        //print the sorted array
        System.out.println("\nSorted Array: " + Arrays.toString(intArray)); 
    } 
}
 