package week6;

import java.util.Scanner;

public class TwoDArrayProcessing {
	
	/** Precondition: Number of rows and columns known.
	* @return matrix containing rows × cols integers
	* read from the keyboard
	*/
	public static int[][] getMatrix() {
		Scanner myScanner = new Scanner(System.in);
		
		int rows = myScanner.nextInt();
		int cols = myScanner.nextInt();
		
		int[][] mat = new int[rows][cols]; //initialize slots
		
		System.out.println("Enter matrix, one row per line:");
		System.out.println();
		
		//read user input and fill slots
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++)
				mat[r][c] = myScanner.nextInt(); //read user input
		
		myScanner.close();
		
		return mat;
	}
	
	
	/** Add 10 to each int in arr */
	public static void addTen(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] += 10;
	}
	

	public static int sumAll1(int[][] mat) {
		int sum = 0;
		
		for (int r = 0; r < mat.length; r++)
			for (int c = 0; c < mat[r].length; c++)
				sum += mat[r][c];
		
		return sum;
	}
	
	
	public static int sumAll2(int[][] mat) {
		int sum = 0;
		
		for (int[] row : mat) //for each row array in mat
			for (int element : row) //for each element in this row
				sum += element;
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[][] mat = { {3, 4, 5}, //row 0
						{6, 7, 8}, // row 1
						{1, 2}}; //row 2
		
		mat = getMatrix();
		
		// Add 10 to each element in row 2 of matrix mat.
//		for (int c = 0; c < mat[2].length; c++)
//			mat[2][c] += 10;
				
//		
//		addTen(mat[1]);
//		addTen(mat[2]);
		
		
//		for (int row = 0; row < mat.length; row++)
//			addTen(mat[row]);
		
//		System.out.println(sumAll2(mat));
		
		
		for (int[] arr : mat) {
			for (int num: arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

}
