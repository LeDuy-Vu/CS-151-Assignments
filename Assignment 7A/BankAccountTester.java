public class BankAccountTester
{
	public static void main(String[] args)
	{
		BankAccount chau = new BankAccount(1) ;
		System.out.println(chau.getBalance()) ;
		//chau.deposit(0) ;
		//chau.deposit(-1) ;
		chau.deposit(1) ;
		System.out.println(chau.getBalance()) ;
		//chau.withdraw(0) ;
		chau.withdraw(1) ;
		System.out.println(chau.getBalance()) ;
		chau.withdraw(2) ;
		System.out.println(chau.getBalance() + "\n") ;
		
		CheckingAccount duy = new CheckingAccount(5) ;
		System.out.println(duy.getBalance()) ;
		//duy.deposit(-1) ;
		for (int i = 1; i <= 6; i++)
		{
			duy.deposit(1) ;
			System.out.println(duy.getBalance()) ;
		}
		duy.withdraw(10) ;
		System.out.println(duy.getBalance()) ;
		//duy.withdraw(-1) ;
	}
}
