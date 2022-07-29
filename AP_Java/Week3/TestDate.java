package week3;

public class TestDate {

	public static void main(String[] args) {
		Date d1 = new Date (17, 7, 2022);
		System.out.println(d1);
		
		Date birthday = d1;
		System.out.println(birthday);
		
		d1.changeDate(17, 8, 2023);
		System.out.println(d1);
		System.out.println(birthday);
		
		Date birthday2 = new Date(d1.getDay(), d1.getMonth(), d1.getYear());
		d1.changeDate(18, 9, 2023);
		System.out.println(birthday2);
		System.out.println(d1);
		System.out.println(birthday);
	}

}
