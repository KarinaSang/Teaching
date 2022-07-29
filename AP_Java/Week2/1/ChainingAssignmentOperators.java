package week2;

public class ChainingAssignmentOperators {

	public static void main(String[] args) {
		int next, prev, sum;
		next = prev = sum = 1;
		next += prev += sum += 2;
		
		System.out.println(next + " " + prev + " " + sum);
	}

}
