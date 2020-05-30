import java.time.LocalDate ;
import java.time.temporal.ChronoUnit ;

/**
 * Represents a calendar day in the Gregorian calendar.
 */
public class Day
{
	private final int year ;
	private final int month ;
	private final int date ;
	
	/**
	 * Constructs a day with a given year, month, and day of the Julian/Gregorian calendar.
	 * The Julian calendar is used for all days before October 15, 1582.
	 * @param year a year
	 * @param month a month
	 * @param date a day
	 * @precondition checkDay()
	 * @postcondition create a new Day object with valid year, month, and date
	 */
	public Day(int year, int month, int date)
	{
		assert(checkDay(year, month, date)) : "Input is invalid!" ;
		
		this.year = year ;
		this.month = month ;
		this.date = date;
	}
	
	/**
	 * Returns the year of this day.
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Returns the month of this day.
	 * @return the month
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * Returns the date of this day.
	 * @return the date
	 */
	public int getDate()
	{
		return date;
	}
	
	/**
	 * Checks if the input day is valid.
	 * @param year the input year
	 * @param month the input month
	 * @param date the input date
	 * @return true if the day is valid
	 */
	public static boolean checkDay(int year, int month, int date)
	{
		if (checkYear(year) && checkMonth(month) && checkDate(year, month, date))
			return true;
		return false;
	}
	
	/**
	 * Checks if the input year is valid.
	 * @param year the input year
	 * @return true if year is valid
	 */
	private static boolean checkYear(int year)
	{
		return year == 0 ? false : true;
	}
	
	/**
	 * Checks if the input month is valid.
	 * @param month the input month
	 * @return true if month is valid
	 */
	private static boolean checkMonth(int month)
	{
		return (month < 1 || month > 12) ? false : true;
	}
	
	/**
	 * Checks if the input date is valid.
	 * @param year the input year
	 * @param month the input month
	 * @param date the input date
	 * @return true if date is valid
	 */
	private static boolean checkDate(int year, int month, int date)
	{
		if (date < 1 || date > 31)
			return false;
		
		if (year == 1582 && month == 10 && date > 4 & date < 15)
			return false;
		
		if (month == 2)
		{
			if (year % 4 != 0 || (year > 1582 && year % 100 == 0 && year % 400 != 0))	//check if not leap year
			{
				if (date > 28)
					return false;
			}
			else
			{
				if (date > 29)
					return false;
			}
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11)
		{
			if (date == 31)
				return false;
		}
		
		return true;
	}
	
	/**
	 * Returns a day that is a certain number of days away from this day.
	 * @param n the number of days, can be negative
	 * @return a day that is n days away from this one
	 */
	public Day addDays(int n)
	{
		LocalDate thisDay = LocalDate.of(year, month, date) ;
		LocalDate newDay = LocalDate.of(year, month, date).plusDays(n) ;
		
		//skip year 0
		if (newDay.getYear() == 0 || (year ^ newDay.getYear()) < 0)
			if (n > 0)
				newDay = newDay.plusDays(366) ;
			else
				newDay = newDay.plusDays(-366) ;
		
		//skip 10 days in October 1582
		//278th day of 1582 is October 5th, 287th day is October 14th
		if (year < 1582 || (year == 1582 && thisDay.getDayOfYear() < 278))
		{
			if (newDay.getYear() > 1582 || (newDay.getYear() == 1582 && newDay.getDayOfYear() >= 278))
				newDay = newDay.plusDays(10) ;
		}
		else
			if (newDay.getYear() < 1582 || (newDay.getYear() == 1582 && newDay.getDayOfYear() <= 287))
				newDay = newDay.plusDays(-10) ;
		
		return new Day(newDay.getYear(), newDay.getMonthValue(), newDay.getDayOfMonth());
	}
	
	/**
	 * Returns the number of days between this day and another day.
	 * @param other the other day
	 * @return the number of days that this day is away from the other (>0 if this day comes later)
	 */
	public int daysFrom(Day other)
	{
		LocalDate thisDay = LocalDate.of(year, month, date) ;
		LocalDate otherDay = LocalDate.of(other.getYear(), other.getMonth(), other.getDate()) ;
		int diff = (int) ChronoUnit.DAYS.between(otherDay, thisDay);
		
		//skip year 0
		if ((year ^ other.getYear()) < 0)
			 if (diff > 0)
				 diff -= 366 ;
			 else
				 diff += 366 ;
		
		//skip 10 days in October 1582
		//278th day of 1582 is October 5th, 287th day is October 14th
		if (year < 1582 || (year == 1582 && thisDay.getDayOfYear() < 278))
		{
			if (other.getYear() > 1582 || (other.getYear() == 1582 && otherDay.getDayOfYear() > 287))
				diff += 10 ;
		}
		else
		{
			if (other.getYear() < 1582 || (other.getYear() == 1582 && otherDay.getDayOfYear() < 278))
				diff -= 10 ;
		}
		
		return diff;
	}
}
