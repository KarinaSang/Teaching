package week2;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) {
		// Example 1
		int i = 1, mult3 = 3;
		while (mult3 < 20) {
			System.out.println(mult3 + " ");
			i++;
			mult3 *= i;
		}
		
		Scanner myScanner = new Scanner (System.in);
		
		// Example 2
		// A sentinel value is a special value in the context of an algorithm 
		// which uses its presence as a condition of termination
		final int SENTINEL = -999;
		System.out.println("Enter list of positive integers, " + 
		"end list with " + SENTINEL);
		int value = myScanner.nextInt(); // read user input
		
		while (value != SENTINEL) {
			value = myScanner.nextInt(); //read another value
		}
		
		myScanner.close();
		
	}

}
