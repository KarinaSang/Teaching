package week3;

public class ChargeFee {

	public static void chargeFee(BankAccount b, String password, double fee) {
		final double MIN_BALANCE = 10.00;
		if(b.getBalance() < MIN_BALANCE) {
			b.withdraw(password, fee);
		}
	}
	public static void main(String[] args) {
		final double FEE = 5.00;
		BankAccount andysAccount = new BankAccount("AndyS", 7.00);
		System.out.println(andysAccount.getBalance());
		
		chargeFee(andysAccount, "AndyS", FEE);
		System.out.println(andysAccount.getBalance());
	}

}
