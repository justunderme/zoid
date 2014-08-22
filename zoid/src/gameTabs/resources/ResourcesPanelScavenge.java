package gameTabs.resources;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import actions.Buttons;

@SuppressWarnings("serial")
public class ResourcesPanelScavenge extends JPanel 
{
	
	public static Buttons scavengeButton;
	private static TitledBorder titleBorder;
	
	public ResourcesPanelScavenge() 
	{
		setPreferredSize(new Dimension(1024 , 340));
		setLayout(new MigLayout());
		
		titleBorder = new TitledBorder(new LineBorder(Color.BLACK), "Scavenge");
		
		this.setBorder(titleBorder);
		this.add(Buttons.scavengeButton());
		
	}

	
}
