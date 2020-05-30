/**
 * A subclass of Employee class whose objects are paid by year.
 */
public class SalariedEmployee extends Employee
{
	private static final int WEEKS_PER_YEAR = 52 ;
	
	/**
	 * Constructs a SalariedEmployee object.
	 * @param name the name of the employee
	 * @param annualSalary the annual salary of the employee
	 */
	public SalariedEmployee(String name, double annualSalary)
	{
		super(name) ;
		setSalary(annualSalary) ;
	}
	
	/**
	 * Gets the weekly salary of the employee.
	 * @return the weekly salary
	 */
	public double getWeeklySalary()
	{
		return getSalary() / WEEKS_PER_YEAR;
	}
}
