package principal;

import javax.swing.ImageIcon;

public class Resources 
{
	private static double food;
	private static double water;
	private static double population;
	private static double populationKids;
	private static ImageIcon[] arrIcons = new ImageIcon[5];
	
	
	public synchronized static void resourcesCheck()
	{
		if(food < 0)
		{
			food = 0;
		}
		if(water < 0)
		{
			water = 0;
		}
		if(population < 0)
		{
			population = 0;
		}
	}
	
	public synchronized static void setFood(double food)
	{
		Resources.food = food;
	}
	
	public synchronized static void setIcons()
	{
		arrIcons[0] = new ImageIcon("resources/images/bluePotion.png");
		arrIcons[1] = new ImageIcon("resources/images/bow.jpg");
		arrIcons[2] = new ImageIcon("resources/images/greenPotion.png");
		arrIcons[3] = new ImageIcon("resources/images/redPotion.png");
		arrIcons[4] = new ImageIcon("resources/images/shield.png");
	}
	
	public synchronized static ImageIcon getIcon(int i)
	{
		return arrIcons[i];
	}
	
	public synchronized static void setWater(double water)
	{
		Resources.water = water;
	}
	
	public synchronized static double getFood()
	{
		return Resources.food;
	}
	
	public synchronized static double getWater()
	{
		return Resources.water;
	}

	public synchronized static void addFood(double nextInt) 
	{
		Resources.food += nextInt;
		
	}

	public synchronized static void addWater(double nextInt) 
	{
		Resources.water += nextInt;
		
	}
	
	public synchronized static void removeFood(double nextInt) 
	{
		Resources.food -= nextInt;
		
	}

	public synchronized static void removeWater(double nextInt) 
	{
		Resources.water -= nextInt;
		
	}
	
	public synchronized static void removePopulation(double nextInt) 
	{
		Resources.population -= nextInt;
		
	}
	
	public synchronized static void setPopulation(double pop)
	{
		Resources.population = pop;
	}
	
	public synchronized static double getPopulation()
	{
		return Resources.population;
	}
	
	public synchronized static void addPopulation(double nextInt) 
	{
		Resources.population += nextInt;
		
	}
	
	public synchronized static void removePopulationKids(double nextInt) 
	{
		Resources.populationKids -= nextInt;
		
	}
	
	public synchronized static void setPopulationKids(double pop)
	{
		Resources.populationKids = pop;
	}
	
	public synchronized static double getPopulationKids()
	{
		return Resources.populationKids;
	}
	
	public synchronized static void addPopulationKids(double nextInt) 
	{
		Resources.populationKids += nextInt;
		
	}
}
