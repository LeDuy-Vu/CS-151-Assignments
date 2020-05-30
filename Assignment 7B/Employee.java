/**
 * A class for an employee with name and salary.
 */
public class Employee
{
	private final String name ;
	private double salary ;
	
	/**
	 * Constructs an Employee object.
	 * @param name the name of the employee
	 * @precondition name.length() > 0
	 */
	public Employee(String name)
	{
		assert(name.length() > 0) : "Invalid name" ;
		this.name = name ;
	}
	
	/**
	 * Sets the salary of the employee
	 * @param salary the salary
	 * @precondition salary > 0
	 */
	public void setSalary(double salary)
	{
		assert(salary > 0) : "Invalid salary" ;
		this.salary = salary ;
	}
	
	/**
	 * Gets the name of the employee
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the salary of the employee
	 * @return the salary
	 */
	public double getSalary()
	{
		return salary;
	}
}
