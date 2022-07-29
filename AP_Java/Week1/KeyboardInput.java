import java.util.Scanner;

public class KeyboardInput {

	public static void main(String[] args) {
		// Create a new Scanner object for Keyboard input
		Scanner keyboard = new Scanner(System.in);
		
		// Input the information from the keyboard
		// we also declare each new variable as needed
		System.out.println("Keyboard Input");
		System.out.print("Please enter your name: ");
		
		String name = keyboard.nextLine();
		
		System.out.print(name + ", please enter an integer number: ");
		
		int myInteger = keyboard.nextInt();
		
		System.out.println(name + ", please enter a real number: ");
		
		double myDouble = keyboard.nextDouble();
		
		keyboard.close();
		
		// Output the input information
		System.out.println("Here are your inputs:");
		System.out.println("User Name: " + name);
		System.out.println("The integer number entered was " + myInteger);
		System.out.println("The double number entered was " + myDouble);
		System.out.println("End of Program");
		
	} // main method

} // KeyboardInput class
