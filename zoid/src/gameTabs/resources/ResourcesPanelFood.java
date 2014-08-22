package gameTabs.resources;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import actions.Buttons;

@SuppressWarnings("serial")
public class ResourcesPanelFood extends JPanel 
{
	
	public static Buttons foodButton;
	private static TitledBorder titleBorder;
	
	public ResourcesPanelFood() 
	{
		setPreferredSize(new Dimension(512 , 340));
		setLayout(new MigLayout());
		
		titleBorder = new TitledBorder(new LineBorder(Color.BLACK), "Food");
		
		this.setBorder(titleBorder);
		this.add(Buttons.foodButton());
	}

	
}
