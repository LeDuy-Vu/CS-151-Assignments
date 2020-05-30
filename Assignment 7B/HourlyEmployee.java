/**
 * A subclass of Employee class whose objects are paid by hour.
 */
public class HourlyEmployee extends Employee
{
	private static final int HOURS_PER_WEEK = 40 ;
	
	/**
	 * Constructs an HourlyEmployee object.
	 * @param name the name of the employee
	 * @param hourlySalary the hourly salary of the employee
	 */
	public HourlyEmployee(String name, double hourlySalary)
	{
		super(name) ;
		setSalary(hourlySalary) ;
	}
	
	/**
	 * Gets the weekly salary of the employee.
	 * @return the weekly salary
	 */
	public double getWeeklySalary()
	{
		return getSalary() * HOURS_PER_WEEK;
	}
}
