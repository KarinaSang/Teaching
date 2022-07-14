package week3;

public class BankAccount {
	private String password;
	private double balance;
	private Date date;
	public static final double OVERDRAWN_PENALTY = 20.00;

	//constructors
	/** Default constructor.
	 * Constructs bank account with default values. */
	public BankAccount()
	{ 
		
	}


	/** Constructs bank account with specified password and balance. */
	public BankAccount(String acctPassword, double acctBalance)
	{ 
		password = acctPassword;
		balance = acctBalance;
	}


	// accessor
	/** @return balance of this account */
	public double getBalance()
	{ 
		return balance;
	}
	
	public String getPassword() {
		return password;
	}


	// mutators
	/** Deposits amount in bank account with given password.
	 * @param acctPassword the password of this bank account
	 * @param amount the amount to be deposited
	 */
	public void deposit(String acctPassword, double amount)
	{ 
		if (password.equals(acctPassword)) {
			balance += amount;
		}
			
	}


	/** Withdraws amount from bank account with given password.
	 * Assesses penalty if balance is less than amount.
	 * @param acctPassword the password of this bank account
	 * @param amount the amount to be withdrawn
	 */
	public void withdraw(String acctPassword, double amount)
	{ 
		if (password.equals(acctPassword)) {
			balance -= amount;
		}
	}

}

