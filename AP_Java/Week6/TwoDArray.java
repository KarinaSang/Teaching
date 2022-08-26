package week6;

public class TwoDArray {

	public static void main(String[] args) {
		int[][] table; 
		double[][] matrix = new double[3][4]; 
	
		String[][] strs = new String[2][5]; 
		
		int[][] mat = { {3, 4, 5}, //row 0
						{6, 7} }; //row 1
		
		System.out.println(matrix);
		System.out.println(matrix[0]);
		System.out.println(matrix[0][0]);
		System.out.println(strs[1][0]);
		System.out.println(mat[1][2]);

	}

}
