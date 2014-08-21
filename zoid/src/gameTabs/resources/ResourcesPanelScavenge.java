package gameTabs.resources;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import actions.Buttons;

@SuppressWarnings("serial")
public class ResourcesPanelScavenge extends JPanel 
{
	
	public static Buttons scavengeButton;
	private static TitledBorder titleBorder;
	
	public ResourcesPanelScavenge() 
	{
		setPreferredSize(new Dimension(1024 , 340));
		setLayout(null);
		
		titleBorder = new TitledBorder(new LineBorder(Color.BLACK), "Scavenge");
		
		scavengeButton = new Buttons();
		
		this.setBorder(titleBorder);
		this.add(scavengeButton.scavengeButton());
		
	}

	
}