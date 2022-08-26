package week5;

public class StringMethods {

	public static void main(String[] args) {
//		Date d1 = new Date ("Jan", 12, 2020);
//		System.out.println(d1);
//		System.out.println("unhappy".substring(2));
//		System.out.println("cold".substring(4));
//		System.out.println("cold".substring(5));
//		System.out.println("strawberry".substring(5,7));
//		System.out.println("crayfish".substring(4,8));
//		System.out.println("crayfish".substring(4,9));
//		System.out.println("crayfish".substring(5,4));
		
		
		String s = "funnyfarm";
		int x = s.indexOf("farm");
		System.out.println(x);
		x = s.indexOf("farmer");
		System.out.println(x);
		int y = s.length();
		System.out.println(y);

	}

}
