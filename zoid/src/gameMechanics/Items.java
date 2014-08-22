package gameMechanics;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import principal.Resources;

@SuppressWarnings("serial")
public class Items extends JButton implements Serializable
{
	private String name;
	private String comment;
	private int maxquantity;
	private int quantity;
	private ImageIcon imageIcon = new ImageIcon();
	
	public static BufferedReader br;
	
	public Items()
	{
		
	}
	
	public Items(String name , String comment , int maxquantity , ImageIcon imageIcon)
	{
		this.name = name;
		this.comment = comment;
		this.quantity = 1;
		this.maxquantity = maxquantity;
		this.imageIcon = imageIcon;
		
		setText(this.name);
		setToolTipText(this.comment + " | " + quantity + " units");
		setIcon(this.imageIcon);
	}
	
	public static void createItems()
	{
		try 
		{
			br = new BufferedReader(new FileReader("resources/files/items.txt"));
			int numberOfItems = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < numberOfItems; i++)
			{
				Items item = new Items(br.readLine() , br.readLine() , Integer.parseInt(br.readLine()) , Resources.arrIcons[i+5]);
				Game.arrItems.add(item);
			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setButton(ActionListener al)
	{
		this.actionListener = al;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getMaxQuantity()
	{
		return this.maxquantity;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity += quantity;
	}
	
	public String getComment()
	{
		return this.comment;
	}
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
}
