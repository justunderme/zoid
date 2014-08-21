package gameTabs.overview;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import actions.Buttons;
import principal.Player;

@SuppressWarnings("serial")
public class Overview extends JPanel 
{
	
	public static JButton[] arrBagItems = new JButton[33];
	
	public Overview() 
	{
		setLayout(null);
		
		JLabel nameLabel = new JLabel("<html><font size=\"20\">" +  Player.name + "<br>" + Player.areaName + "</font></html>");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(0, 0, 1000, 150);
		this.add(nameLabel );
		
		
			for(int i = 0; i < 11; i++)
			{
				arrBagItems[i] = new Buttons(new Dimension(50, 50));
				arrBagItems[i].setBounds(100 + i*75,400 , 50, 50);
				add(arrBagItems[i]);
			}
			for(int j = 11; j < 22; j++)
			{
				arrBagItems[j] = new Buttons(new Dimension(50, 50));
				arrBagItems[j].setBounds(100 + (j-11)*75,500 , 50, 50);
				add(arrBagItems[j]);
			}
			for(int k = 22; k < 33; k++)
			{
				arrBagItems[k] = new Buttons(new Dimension(50, 50));
				arrBagItems[k].setBounds(100 + (k-22)*75,600 , 50, 50);
				add(arrBagItems[k]);
			}
	}
	
	public static void giveItem(ImageIcon icon)
	{
		int slot = 0;
		
		do
		{	
				if(arrBagItems[slot].getIcon() ==  null && slot < arrBagItems.length)
				{
					arrBagItems[slot].setIcon(icon);
					return;
				}	
				else
				{
					slot += 1;
				}
		}
		while(slot<arrBagItems.length);
		
		System.out.println("Estás sem espaço no bag, " + Player.name + "!");
	}
}
