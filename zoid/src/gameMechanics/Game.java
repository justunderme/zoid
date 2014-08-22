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
import principal.MainFrame;
import principal.Resources;



@SuppressWarnings("serial")
public class Game extends JTabbedPane
{
	public static boolean isRunning = false;
	public static ArrayList<Items> arrItems = new ArrayList<Items>();
	public static int days = 0;
	public static int months = 0;
	
	private static long speedDay = 20000; //20000
	
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
		
		Thread gameThread = new Thread(new GameThread(), "GameThread");
		gameThread.start();
		
        this.addTab("Overview", overviewPanel);
        this.addTab("Resources", resourcesPanel);
        this.addTab("Area", areaPanel);
        this.addTab("Jobs", jobsPanel);
        this.addTab("Trade Center", shopPanel);
        this.addTab("Research", researchPanel);
	}
	
	public static void setSpeed(long speed)
	{
		if((Game.speedDay + speed) > 0)
			Game.speedDay += speed;
	}
	
	public static long getSpeed()
	{
		return Game.speedDay;
	}
}

class GameThread implements Runnable
{
	private static int dayCounter = 0;
	
	public void run()
	{
		long lastTime = System.currentTimeMillis();

		while(Game.isRunning)
		{
			MainFrame.myFrame.setTitle(MainFrame.TITLE + "  |  " + "Month: " + Game.months + " - Day: " + Game.days + "  |  " + "SecondsPerDay: " + Game.getSpeed() / 1000);
			
			Resources.resourcesCheck();
			Score.refresh();
			
			long now = System.currentTimeMillis();
			long delta = now - lastTime;
			
			Game.days = dayCounter;
			
			if(dayCounter == 31) //MONTH CYCLE
			{
				Resources.addPopulationKids(Random.getRandomInt(2));
			
				Resources.addPopulation(Resources.getPopulationKids() * 0.25);
				Resources.removePopulationKids(Resources.getPopulationKids() * 0.25);
			
				Resources.removeFood((Resources.getPopulation() * 0.2) + (Resources.getPopulationKids() * 0.1));
				Resources.removeWater((Resources.getPopulation() * 0.4) + (Resources.getPopulationKids() * 0.2));
				
				Game.months++;
				dayCounter = 0;
			}
			
			if(delta > Game.getSpeed()) //DAY CYCLE
			{
				dayCounter++;
				lastTime = now;
			}
			
			try 
			{
				Thread.sleep(10);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}