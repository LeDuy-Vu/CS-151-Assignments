/**
 * A class for bank account.
 */
public class BankAccount
{
	private double balance ;
	
	/**
	 * Constructs a BankAccount object with non-negative balance.
	 * @param balance the initial balance of the account
	 * @precondition balance >= 0
	 */
	public BankAccount(double balance)
	{
		assert(balance >= 0) : "Invalid balance" ;
		this.balance = balance ;
	}
	
	/**
	 * Gets the balance of the account.
	 * @return the balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Adds money into the account.
	 * @param amount the amount of money added
	 * @precondition amount > 0
	 */
	public void deposit(double amount)
	{
		assert(amount > 0) : "Invalid amount" ;
		balance += amount ;
	}
	
	/**
	 * Takes money from the account.
	 * @param amount the amount of money taken away
	 * @precondition amount > 0
	 * @precondition getBalance() >= amount
	 */
	public void withdraw(double amount)
	{
		assert(amount > 0) : "Invalid amount" ;
		assert(getBalance() >= amount) : "Insufficient balance" ;
		balance -= amount ;
	}
}
