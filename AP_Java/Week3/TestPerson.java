package week3;

public class TestPerson {

	public static void main(String[] args) {
		Person p1 = new Person("Bob", 25);
		p1.printPerson();
		
		Person p2 = new Person();
		p2.printPerson();

		p2.setName("Bob2");
		p2.printPerson();
		System.out.println(p2.getName());
	}

}
