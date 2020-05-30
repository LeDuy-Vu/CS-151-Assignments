import java.util.Comparator ;

/**
 * A laptop with its CPU and GPU benchmark results, price, battery life, and category.
 */
public class Laptop
{
	private final String name ;
	private final int CPUBenchmark ;
	private final int GPUBenchmark ;
	private final int price ;
	private final int batteryLife ;
	private final String category ;
	
	/**
	 * Constructs a laptop with given name, specs, and category.
	 * @param name name of the laptop
	 * @param CPUBenchmark CPU benchmark result of the laptop
	 * @param GPUBenchmark GPU benchmark result of the laptop
	 * @param price price of the laptop
	 * @param batteryLife battery life of the laptop
	 * @param category category of the laptop
	 * @precondition checkInputs()
	 * @postcondition create a new laptop object with valid name, specs, and category.
	 */
	public Laptop(String name, int CPUBenchmark, int GPUBenchmark, int price, int batteryLife, String category)
	{
		assert(checkInputs(name, CPUBenchmark, GPUBenchmark, price, batteryLife, category)) : "Input is invalid!" ;
		
		this.name = name ;
		this.CPUBenchmark = CPUBenchmark ;
		this.GPUBenchmark = GPUBenchmark ;
		this.price = price ;
		this.batteryLife = batteryLife ;
		this.category = category ;
	}
	
	/**
	 * Gets the name of the laptop.
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the CPU benchmark result of the laptop.
	 * @return the CPU benchmark result
	 */
	public int getCPUBenchmark()
	{
		return CPUBenchmark;
	}
	
	/**
	 * Gets the GPU benchmark result of the laptop.
	 * @return the GPU benchmark result
	 */
	public int getGPUBenchmark()
	{
		return GPUBenchmark;
	}
	
	/**
	 * Gets the price of the laptop.
	 * @return the price
	 */
	public int getPrice()
	{
		return price;
	}
	
	/**
	 * Gets the battery life of the laptop.
	 * @return the battery life
	 */
	public int getBatteryLife()
	{
		return batteryLife;
	}
	
	/**
	 * Gets the category of the laptop.
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}
	
	/**
	 * Checks if the inputs for the constructor are valid.
	 * @param name name of the laptop
	 * @param CPUBenchmark CPU benchmark result of the laptop
	 * @param GPUBenchmark GPU benchmark result of the laptop
	 * @param price price of the laptop
	 * @param batteryLife battery life of the laptop
	 * @param category category of the laptop
	 * @return true if the inputs are valid
	 */
	public static boolean checkInputs(String name, int CPUBenchmark, int GPUBenchmark, int price, int batteryLife, String category)
	{
		if (checkName(name) && checkSpecs(CPUBenchmark) && checkSpecs(GPUBenchmark) && checkSpecs(price) 
				&& checkSpecs(batteryLife) && checkCategory(category))
			return true;
		return false;
	}
	
	/**
	 * Checks if the input name is valid.
	 * @param name the input name
	 * @return true if name is valid
	 */
	private static boolean checkName(String name)
	{
		return name.length() == 0 ? false : true;
	}
	
	/**
	 * Checks if the input spec is valid.
	 * @param spec any input spec of the laptop
	 * @return true if the spec is valid
	 */
	private static boolean checkSpecs(int spec)
	{
		return spec > 0 ? true : false;
	}
	
	/**
	 * Checks if the input category is valid.
	 * @param category the input category
	 * @return true if category is valid
	 */
	private static boolean checkCategory(String category)
	{
		if (category == "Gaming laptop" || category == "Very serious laptop" || category == "Overpriced laptop" 
				|| category == "Featherweight laptop" || category == "Indestructible laptop")
			return true;
		return false;
	}
	
	/**
	 * Creates a Comparator object that compares 2 laptops by CPU benchmark result.
	 * @return a Comparator object
	 */
	public static Comparator<Laptop> comparatorByCPUBenchmark()
	{
		return new 
			Comparator<Laptop>()
			{
				public int compare(Laptop first, Laptop second)
				{
					if (first.getCPUBenchmark() < second.getCPUBenchmark())
						return -1;
					if (first.getCPUBenchmark() > second.getCPUBenchmark())
						return 1;
					return 0;
				}
			};
	}
	
	/**
	 * Creates a Comparator object that compares 2 laptops by GPU benchmark result.
	 * @return a Comparator object
	 */
	public static Comparator<Laptop> comparatorByGPUBenchmark()
	{
		return new
			Comparator<Laptop>()
			{
				public int compare(Laptop first, Laptop second)
				{
					if (first.getGPUBenchmark() < second.getGPUBenchmark())
						return -1;
					if (first.getGPUBenchmark() > second.getGPUBenchmark())
						return 1;
					return 0;
				}
			};
	}
	
	/**
	 * Creates a Comparator object that compares 2 laptops by price.
	 * @return a Comparator object
	 */
	public static Comparator<Laptop> comparatorByPrice()
	{
		return new 
			Comparator<Laptop>()
			{
				public int compare(Laptop first, Laptop second)
				{
					if (first.getPrice() < second.getPrice())
						return -1;
					if (first.getPrice() > second.getPrice())
						return 1;
					return 0;
				}
			};
	}
	
	/**
	 * Creates a Comparator object that compares 2 laptops by battery life.
	 * @return a Comparator object
	 */
	public static Comparator<Laptop> comparatorByBatteryLife()
	{
		return new 
			Comparator<Laptop>()
			{
				public int compare(Laptop first, Laptop second)
				{
					if (first.getBatteryLife() < second.getBatteryLife())
						return -1;
					if (first.getBatteryLife() > second.getBatteryLife())
						return 1;
					return 0;
				}
			};
	}
	
	/**
	 * Creates a Comparator object that compares 2 laptops by category.
	 * @return a Comparator object
	 */
	public static Comparator<Laptop> comparatorByCategory()
	{
		return new 
			Comparator<Laptop>()
			{
				public int compare(Laptop first, Laptop second)
				{
					return first.getCategory().compareTo(second.getCategory());
				}
			};
	}
}
