package gameMechanics;

import javax.swing.ImageIcon;

public class Items 
{
	private String name;
	private int quantity;
	private ImageIcon imageIcon = new ImageIcon();
	
	
	public Items(String name , int quantity , ImageIcon imageIcon)
	{
		this.name = name;
		this.quantity = quantity;
		this.imageIcon = imageIcon;
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
}
