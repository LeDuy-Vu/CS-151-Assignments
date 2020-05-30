import java.util.* ;

/**
   A class to calculate the sum of consecutive integers.
 */
public class CalculateSum
{
	/**
	   Constructs a CalculateSum object that produce the sum of integers from startNum to endNum.
	   @param num1 the starting integer.
	   @param num2 the ending integer.
	 */
	public CalculateSum(int num1, int num2)
	{
		startNum = num1 ;
		endNum = num2 ;
	}
	
	/**
	   Default constructer set both startNum and endNum equal 0.
	 */
	public CalculateSum()
	{
		this(0,0) ;
	}
	
	/**
	   Modify the value of startNum and endNum.
	 */
	public void prompt() throws InputMismatchException
	{
		boolean keepPrompt = true ;
		
		do
		{
			try
			{
				System.out.print("Enter starting integer: ") ;
				startNum = input.nextInt() ;
				keepPrompt = false ;
				
				if (startNum < 0)
				{
					System.out.println("Input must be positive. Try again.\n") ;
					keepPrompt = true ;
				}
			}
			catch (InputMismatchException ex)
			{
				System.out.println("You must enter an integer. Try again.\n") ;
				input.nextLine() ;
			}
		} while (keepPrompt) ;
		
		keepPrompt = true ;
		do
		{
			try
			{
				System.out.print("Enter ending integer: ") ;
				endNum = input.nextInt() ;
				keepPrompt = false ;
				
				if (endNum < startNum)
				{
					System.out.println("Ending number must be bigger than starting numer. Try again.\n") ;
					keepPrompt = true ;
				}
			}
			catch (InputMismatchException ex)
			{
				System.out.println("You must enter an integer. Try again.\n") ;
				input.nextLine() ;
			}
		} while (keepPrompt) ;
	}
	
	/**
	   Getter of variable startNum.
	   @return the value of startNum.
	 */
	public int getStartNum()
	{
		return startNum;
	}
	
	/**
	   Getter of variable endNum.
	   @return the value of endNum.
	 */
	public int getEndNum()
	{
		return endNum;
	}
	
	/**
	   Calculate the sum from startNum to endNum.
	   @return the sum under int type.
	 */
	public int sum()
	{
		int sum = 0 ;
		for (int i = startNum; i <= endNum; i++)
			sum += i ;
		return sum;
	}
	
	private int startNum ;
	private int endNum ;
	private static Scanner input = new Scanner(System.in) ;
}
