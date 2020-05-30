import java.util.* ;

public class LaptopSortTester
{
	public static void main(String[] args)
	{
		ArrayList<Laptop> laptops = new ArrayList<Laptop>() ;
		laptops.add(new Laptop("Lion"	, 123, 456, 789 , 10, "Gaming laptop")) ;
		laptops.add(new Laptop("Tiger"	, 156, 500, 625 , 12, "Very serious laptop")) ;
		laptops.add(new Laptop("Buffalo", 191, 712, 1000, 20, "Overpriced laptop")) ;
		laptops.add(new Laptop("Unicorn", 142, 699, 600 , 5 , "Featherweight laptop")) ;
		laptops.add(new Laptop("Dragon"	, 200, 212, 2000, 8 , "Overpriced laptop")) ;
		laptops.add(new Laptop("Fox"	, 101, 300, 900 , 4 , "Very serious laptop")) ;
		laptops.add(new Laptop("Phoenix", 176, 580, 1500, 11, "Indestructible laptop")) ;
		
		//Below are invalid objects of laptops to test assertion
		//laptops.add(new Laptop("", 123, 456, 789 , 10, "Gaming laptop")) ;
		//laptops.add(new Laptop("Lion"	, 0, 456, 789 , 10, "Gaming laptop")) ;
		//laptops.add(new Laptop("Lion"	, 123, -23, 789 , 10, "Gaming laptop")) ;
		//laptops.add(new Laptop("Lion"	, 123, 456, -100 , 10, "Gaming laptop")) ;
		//laptops.add(new Laptop("Lion"	, 123, 456, 789 , -1, "Gaming laptop")) ;
		//laptops.add(new Laptop("Lion"	, 123, 456, 789 , 10, "Affordable laptop")) ;
		
		//sort by CPU benchmark
		Collections.sort(laptops, Laptop.comparatorByCPUBenchmark()) ;
		printList("CPU benchmark", laptops) ;
		
		//sort by GPU benchmark
		Collections.sort(laptops, Laptop.comparatorByGPUBenchmark()) ;
		printList("GPU benchmark", laptops) ;
		
		//sort by price
		Collections.sort(laptops, Laptop.comparatorByPrice()) ;
		printList("price", laptops) ;
		
		//sort by battery life
		Collections.sort(laptops, Laptop.comparatorByBatteryLife()) ;
		printList("battery life", laptops) ;
		
		//sort by category
		Collections.sort(laptops, Laptop.comparatorByCategory()) ;
		printList("category", laptops) ;
	}
	
	/**
	 * Prints a list of laptops by format.
	 * @param criterion the specific criterion by which the list is sorted
	 * @param list the list of laptops
	 */
	public static void printList(String criterion, ArrayList<Laptop> list)
	{
		System.out.println("\nSort by " + criterion + ":\n") ;
		System.out.printf("%-10s%-16s%-16s%-8s%-15s%s\n", "Name", "CPU Benchmark", "GPU Benchmark", "Price", "Battery Life", "Category") ;
		for (Laptop l : list)
			System.out.printf("%-10s%-16s%-16s%-8s%-15s%s\n", l.getName(), l.getCPUBenchmark(), l.getGPUBenchmark(), 
					l.getPrice(), l.getBatteryLife(), l.getCategory()) ;
	}
}
