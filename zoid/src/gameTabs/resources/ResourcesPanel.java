package gameTabs.resources;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ResourcesPanel extends JPanel 
{
	public static JPanel scavengePanel;
	public static JPanel FoodPanel;
	public static JPanel WaterPanel;
	
	public ResourcesPanel() 
	{
		
		setLayout(new MigLayout());
		
		FoodPanel = new ResourcesPanelFood();
		WaterPanel = new ResourcesPanelWater();
		scavengePanel = new ResourcesPanelScavenge();
		
		this.add(FoodPanel);
		this.add(WaterPanel , "wrap");
		this.add(scavengePanel , "span");
	}
}
