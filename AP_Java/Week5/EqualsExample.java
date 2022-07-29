package week5;

public class EqualsExample {

	public static void main(String[] args) {
		Date d1 = new Date("January", 14, 2001);
		Date d2 = d1;
		Date d3 = new Date("January", 14, 2001);
		
		if (d1.equals(d2)) {
			System.out.println("d1 and d2 are equal");
		}
		
		if (d1.equals(d3)) {
			System.out.println("d1 and d3 are equal");
		}

	}

}
