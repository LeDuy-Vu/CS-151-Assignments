public class EmployeeTester
{
	public static void main(String[] args)
	{
		Employee a = new Employee("Chau") ;
		a.setSalary(500) ;	
		System.out.println(a.getSalary()) ;
		
		HourlyEmployee b = new HourlyEmployee("Duy", 20) ;
		System.out.println(b.getWeeklySalary()) ;
		
		SalariedEmployee c = new SalariedEmployee("Nay", 52000) ;
		System.out.println(c.getWeeklySalary()) ;
	}
}
