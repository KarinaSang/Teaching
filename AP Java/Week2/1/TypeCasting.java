package week2;

public class TypeCasting {

	public static void main(String[] args) {
		int total = 10;
		int n = 10;
		double average;
		
		average = total/n;
		System.out.println("Integer Average: " + average);
		
		average = (double) total/n;
		System.out.println("Double Average: " + average);
		
		average = total/(double) n;
		System.out.println("Double Average: " + average);
	}

}
