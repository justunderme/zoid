package gameMechanics;

import java.util.ArrayList;

import gameTabs.area.Area;
import gameTabs.jobs.Jobs;
import gameTabs.overview.Overview;
import gameTabs.research.Research;
import gameTabs.resources.ResourcesPanel;
import gameTabs.shop.Shop;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import panels.Score;
import principal.Resources;



@SuppressWarnings("serial")
public class Game extends JTabbedPane
{
	
	public static boolean isRunning = false;
	public static ArrayList<Items> arrItems = new ArrayList<Items>();
	
	public Game()
	{
		isRunning = true;
		
		JPanel areaPanel = new Area();
		JPanel jobsPanel = new Jobs();
		JPanel overviewPanel = new Overview();
		JPanel researchPanel = new Research();
		JPanel resourcesPanel = new ResourcesPanel();
		JPanel shopPanel = new Shop();
		
		Resources.setIcons();
		
		Thread monthThread = new Thread(new MonthThread(), "MonthThread");
		monthThread.start();
		
		Thread dayThread = new Thread(new DayThread(), "DayThread");
		dayThread.start();
		
        this.addTab("Overview", overviewPanel);
        this.addTab("Resources", resourcesPanel);
        this.addTab("Area", areaPanel);
        this.addTab("Jobs", jobsPanel);
        this.addTab("Trade Center", shopPanel);
        this.addTab("Research", researchPanel);
	}
}

class MonthThread implements Runnable
{
	public int monthCounter = 1;
	
	public void run()
	{
		while(Game.isRunning)
		{
			Resources.addPopulationKids(Random.getRandomInt(2));
			
			Resources.addPopulation(Resources.getPopulationKids() * 0.25);
			Resources.removePopulationKids(Resources.getPopulationKids() * 0.25);
			
			Resources.removeFood((Resources.getPopulation() * 0.2) + (Resources.getPopulationKids() * 0.1));
			Resources.removeWater((Resources.getPopulation() * 0.4) + (Resources.getPopulationKids() * 0.2));
			
			Resources.resourcesCheck();
			Score.refresh();
			
			monthCounter++;
			
			try {
				Thread.sleep(600000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class DayThread implements Runnable
{
	public int dayCounter = 1;
	
	public void run()
	{
		while(Game.isRunning)
		{
			
			Score.refresh();
			
			dayCounter++;
			
			try {
				Thread.sleep(20000);
			} 
			catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}