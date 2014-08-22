package actions;

import gameMechanics.Game;
import gameMechanics.Items;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

import principal.Player;
import principal.Resources;

public class Save 
{
	private static FileOutputStream fos;
	public static final String FILE = "resources/save/save.properties";
	
	public static void saveProperties()
	{
		try 
		{
			fos = new FileOutputStream(FILE);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
		
		Properties prop = new Properties();
		
		prop.put("Name", Player.name);
		prop.put("Area.Name", Player.areaName);
		prop.put("Food", Double.toString(Resources.getFood()));
		prop.put("Water", Double.toString(Resources.getWater()));
		prop.put("Population", Double.toString(Resources.getPopulation()));
		prop.put("Kids" , Double.toString(Resources.getPopulationKids()));

		try 
		{
			prop.store(fos, "Player Info");
			
			fos.flush();
			fos.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void saveItems()
	{
		try
		{  
			FileOutputStream fout = new FileOutputStream("item.save");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			
			oos.write(Game.arrItems.size());
			
			for(Items item : Game.arrItems)
			{ 
				oos.writeObject(item);
			}
			oos.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void save()
	{
		saveProperties();
		saveItems();
	}
}
