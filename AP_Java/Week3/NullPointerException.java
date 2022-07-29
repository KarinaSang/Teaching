package week3;

public class NullPointerException {

	public static void main(String[] args) {
		BankAccount b = null;
		
		if (b == null) {
			System.out.println("account is null");
		}
		
		// b.deposit("password", 50);
		
		b = new BankAccount("password", 500);
		
		b.deposit("password", 50);	
	}

}
