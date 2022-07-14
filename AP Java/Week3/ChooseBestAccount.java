package week3;

public class ChooseBestAccount {
	
	public static void chooseBestAccount1(BankAccount better, 
			BankAccount b1, BankAccount b2) {
		if (b1.getBalance() > b2.getBalance()) {
			better = b1;
		}
		else {
			better = b2;
		}
	}
	
	public static BankAccount chooseBestAccount2(BankAccount b1, 
			BankAccount b2) {
		BankAccount better;
		
		if (b1.getBalance() > b2.getBalance()) {
			better = b1;
		}
		else {
			better = b2;
		}
		
		return better;
	}
	
	public static BankAccount chooseBestAccount3(BankAccount b1, 
			BankAccount b2) {
		BankAccount better;
		
		if (b1.getBalance() > b2.getBalance()) {
			better = new BankAccount(b1.getPassword(), b1.getBalance());
		}
		else {
			better = new BankAccount(b2.getPassword(), b2.getBalance());;
		}
		
		return better;
	}

	public static void main(String[] args) {
		BankAccount briansFund = new BankAccount("BrianL", 10000);
		BankAccount paulsFund = new BankAccount("PaulM", 90000);
		BankAccount betterFund = null;
		
		chooseBestAccount1(betterFund, briansFund, paulsFund);
		System.out.println(betterFund);

	}

}
