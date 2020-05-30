/**
 * A subclass of BankAccount for checking account.
 */
public class CheckingAccount extends BankAccount
{
	private int transactionCount ;
	private static final int MAX_FREE_TRANSACTION_COUNT = 5 ;
	private static final int TRANSACTION_FEE = 1 ;
	
	/**
	 * Constructs a CheckingAccount object.
	 * @param initialBalance the initial balance of the account
	 */
	public CheckingAccount(double initialBalance)
	{
		super(initialBalance) ;
		transactionCount = 0 ;
	}
	
	/**
	 * Gets the number of transactions this account did.
	 * @return the transaction count
	 */
	public int getTransactionCount()
	{
		return transactionCount;
	}
	
	/**
	 * Deducts transaction fee if appropriate transaction count.
	 */
	private void deductFees()
	{
		if (++transactionCount > MAX_FREE_TRANSACTION_COUNT)
			super.withdraw(TRANSACTION_FEE) ;
	}
	
	/**
	 * Overriden method from BankAccount.
	 */
	public void deposit(double amount)
	{
		super.deposit(amount) ;
		deductFees() ;
	}
	
	/**
	 * Overriden method from BankAccount.
	 * @precondition getTransactionCount() < 5 || getBalance() >= amount + 1
	 */
	public void withdraw(double amount)
	{
		assert(getTransactionCount() < 5 || getBalance() >= amount + 1) : "Insufficient balance" ;
		super.withdraw(amount) ;
		deductFees() ;
	}
}
