package panels;

import java.awt.Dimension;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import actions.Buttons;

@SuppressWarnings("serial")
public class Menu extends JPanel 
{
	static Dimension dimension = new Dimension(400, 400);
	
	public Menu()
	{
		this.setLayout(new MigLayout("center , center , gapy 50 , wrap"));
		//this.setPreferredSize(dimension);
		
		Buttons menuButton = new Buttons();
		
		this.add(menuButton.newGameButton(), "gapleft 55 , gapright 55");
		this.add(menuButton.continueButton() , "gapleft 60 , gapright 60");
		this.add(menuButton.settingsButton(), "gapleft 60 , gapright 60");
		this.add(menuButton.exitButton(), "gapleft 70 , gapright 70");
	}
}
