package gameTabs.resources;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import actions.Buttons;

@SuppressWarnings("serial")
public class ResourcesPanelFood extends JPanel 
{
	
	public static Buttons foodButton;
	private static TitledBorder titleBorder;
	
	public ResourcesPanelFood() 
	{
		setPreferredSize(new Dimension(512 , 340));
		setLayout(null);
		
		titleBorder = new TitledBorder(new LineBorder(Color.BLACK), "Food");
		
		foodButton = new Buttons();
		
		this.setBorder(titleBorder);
		this.add(foodButton.foodButton());
	}

	
}