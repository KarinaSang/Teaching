package week5;

public class ConcatenationOperator {

	public static void main(String[] args) {
		int five = 5;
		String state = "Hawaii-";
		String tvShow = state + five + "-0";
		
		System.out.println(tvShow);
		
		int x = 3, y = 4;
		String sum = x + y;
		
		Date d1 = new Date("August", 2, 1947);
		Date d2 = new Date("Feburary", 17, 1948);
		String s = "My birthday is " + d2; 
		
		String s2 = d1 + d2; //error: + not defined for objects
		
		String s3 = d1.toString() + d2.toString(); 

	}

}
