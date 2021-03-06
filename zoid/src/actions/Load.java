package actions;

import gameMechanics.Items;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Properties;

import principal.Player;
import principal.Resources;

public class Load 
{
	public static void loadProperties()
	{
		Properties prop = new Properties();
		 
		InputStream inputStream;
		
		try 
		{
			inputStream = new FileInputStream(Save.FILE);
			prop.load(inputStream);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Player.setNames(prop.getProperty("Name"), prop.getProperty("Area.Name"));
		Resources.setFood(Double.parseDouble(prop.getProperty("Food")));
		Resources.setWater(Double.parseDouble(prop.getProperty("Water")));
		Resources.setPopulation(Double.parseDouble(prop.getProperty("Population")));
		Resources.setPopulationKids(Double.parseDouble(prop.getProperty("Kids")));
	}
	
	public static void loadItems()
	{
		Items item = new Items();
		
		try
		{
			FileInputStream fin = new FileInputStream("item.save");
			ObjectInputStream ois = new ObjectInputStream(fin);
			
			item = (Items) ois.readObject();
			
			ois.close();
		}
		catch(Exception ex)
		{
			   ex.printStackTrace();
		}
	}
	
	public static void load()
	{
		loadProperties();
		//loadItems();
	}
}
