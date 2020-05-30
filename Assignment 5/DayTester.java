public class DayTester
{
	public static void main(String[] args) throws IllegalArgumentException
	{
		Day day1 = new Day(1582, 10, 15) ;
		Day day2 = day1.addDays(-3) ;
		System.out.println("Should print 1582-10-2: " + day2.getYear() + "-" + day2.getMonth() + "-" + day2.getDate()) ;
		System.out.println("Should print 3: " + day1.daysFrom(day2)) ;
		System.out.println("Should print 0: " + day1.daysFrom(day1) + "\n") ;
		
		Day day3 = day2.addDays(81) ;
		System.out.println("Should print 1583-1-1: " + day3.getYear() + "-" + day3.getMonth() + "-" + day3.getDate()) ;
		System.out.println("Should print -81: " + day2.daysFrom(day3) + "\n") ;
		
		Day day4 = new Day(1 ,1, 1) ;
		Day day5 = new Day(-1, 12, 30) ;
		System.out.println("Should print 2: " + day4.daysFrom(day5)) ;
		day5 = day4.addDays(-1) ;
		System.out.println("Should print -1-12-31: " + day5.getYear() + "-" + day5.getMonth() + "-" + day5.getDate() + "\n") ;
		
		Day today = new Day(2019, 10, 14) ;
		Day myBirthday = new Day(1998, 12, 21) ;
		System.out.println("I have lived " + today.daysFrom(myBirthday) + " days.") ;
		System.out.println("My 21st birthday is " + -today.daysFrom(new Day(2019, 12, 21)) + " days away!\n") ;
		
		Day dayError ;
		
		//Because of invalid days, each line of code below will throw exceptions when assertion is enabled
		dayError = new Day (0, 21, 12) ;
		
		dayError = new Day (2019, 13, 1) ;
		
		dayError = new Day (2019, 10, 33) ;
		
		dayError = new Day (1582, 10, 7) ;
		
		dayError = new Day (2019, 2, 29) ;
		
		dayError = new Day (1500, 2, 30) ;
		
		dayError = new Day (2019, 11, 31) ;
	}
}
