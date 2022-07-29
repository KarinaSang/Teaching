package week2;

import java.util.Scanner;

public class ArithmeticExceptionExample {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int numScores = myScanner.nextInt();
		
		if (numScores == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		else {
			System.out.println(60/numScores);
		}
		

	}

}
