public class CalculateSumTester
{
	public static void main(String[] args)
	{
		CalculateSum one = new CalculateSum() ;
		CalculateSum oneHundred = new CalculateSum() ;
		
		one.prompt() ;
		System.out.println("The sum of integers from " + one.getStartNum() + " to " + one.getEndNum() + " is " + one.sum() + "\n") ;
		
		oneHundred.prompt() ;
		System.out.println("The sum of integers from " + oneHundred.getStartNum() + " to " + oneHundred.getEndNum() + " is " + oneHundred.sum()) ;
	}
}
