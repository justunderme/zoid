package gameTabs.resources;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import actions.Buttons;

@SuppressWarnings("serial")
public class ResourcesPanelWater extends JPanel 
{
	
	public static Buttons waterButton;
	private static TitledBorder titleBorder;
	
	public ResourcesPanelWater() 
	{
		setPreferredSize(new Dimension(512 , 340));
		setLayout(null);
		
		titleBorder = new TitledBorder(new LineBorder(Color.BLACK), "Water");
		
		waterButton = new Buttons();
		
		this.setBorder(titleBorder);
		this.add(waterButton.waterButton());
	}
}
