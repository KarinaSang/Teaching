package week5;

public class StringMethods {

	public static void main(String[] args) {
//		"unhappy".substring(2);
//		"cold".substring(4);
//		"cold".substring(5);
//		"strawberry".substring(5,7);
//		"crayfish".substring(4,8);
//		"crayfish".substring(4,9);
//		"crayfish".substring(5,4);
		
		
		String s = "funnyfarm";
		int x = s.indexOf("farm");
		System.out.println(x);
		x = s.indexOf("farmer");
		System.out.println(x);
		int y = s.length();
		System.out.println(y);

	}

}
