package actions;

import panels.CreateChar;
import panels.Score;
import panels.Settings;
import principal.Music;
import principal.Resources;
import gameMechanics.Game;
import gameMechanics.Random;
import gameTabs.resources.ResourcesPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import principal.MainFrame;

@SuppressWarnings("serial")
public class Buttons extends JButton
{
	public Buttons(Dimension dimension) 
	{
		setSize(dimension);
	}

	public static JButton newGameButton()
	{
		JButton newGameButton = new JButton("New Game");
		
		newGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) 
			{
				JPanel createChar = new CreateChar();
				
				MainFrame.myFrame.getContentPane().removeAll();
				MainFrame.myFrame.getContentPane().invalidate();
				
				MainFrame.myFrame.getContentPane().add(createChar);
				
				MainFrame.myFrame.getContentPane().revalidate();
				MainFrame.myFrame.pack();
			}
		});
		return newGameButton;
		
	}
	
	public static JButton continueButton ()
	{
		JButton continueButton = new JButton("Continue");
		
		continueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Load.load();
				CreateChar.startGame();
				
			}
		});
		return continueButton;
	}
	
	public static JButton settingsButton()
	{
		JButton settingsButton = new JButton("Settings");
		
		settingsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) 
			{
				JPanel settings = new Settings();
				
				MainFrame.myFrame.getContentPane().removeAll();
				MainFrame.myFrame.getContentPane().invalidate();
				
				MainFrame.myFrame.getContentPane().add(settings);
				
				MainFrame.myFrame.getContentPane().revalidate();
				MainFrame.myFrame.pack();
				
			}
		});
		return settingsButton;
		
	}
	
	public static JButton exitButton()
	{
		JButton exitButton = new JButton("Exit");
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) 
			{
				System.exit(0);
				
			}
		});
		return exitButton;
		
	}
	
	public static JButton scavengeButton()
	{
		JButton scavengeButton = new JButton("Scavenge");
		
		scavengeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				int r = Random.getRandomInt(4);
				
				if(Random.getRandomDouble(0 , 9) < 5)
				{
					if(Game.arrItems.get(r).getParent() == null)
					{
						ResourcesPanel.scavengePanel.add(Game.arrItems.get(r) , "h 50! , w 50!");
					}
					else
					{
						Game.arrItems.get(r).setQuantity(1);
						Game.arrItems.get(r).setToolTipText(Game.arrItems.get(r).getComment() + " | " + Game.arrItems.get(r).getQuantity() + " units");
					}
				}
			}
		});
		
		
		return scavengeButton;
	}
	
	public static JButton foodButton()
	{
		JButton foodButton = new JButton("Food");
		
		foodButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Resources.addFood(Random.getRandomDouble(0 , 0.5));
				
				Score.refresh();
				
			}
		});
		
		return foodButton;
	}
	
	public static JButton waterButton()
	{
		JButton waterButton = new JButton("Water");
		
		waterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Resources.addWater(Random.getRandomDouble(0 , 1));
				
				Score.refresh();
			}
		});
		
		return waterButton;
	}
	
	public static JButton musicOnOffButton()
	{
		final JButton musicOnOff = new JButton("Music Off");
		
		musicOnOff.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(Music.isPlaying())
				{
					Music.stop();
					musicOnOff.setText("Music ON");
				}
				else
				{
					Music.start();
					musicOnOff.setText("Music Off");
				}
				
			}
		});
		return musicOnOff;
	}
	
	public static JScrollBar soundVolume()
	{
		JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
		scrollBar.setMinimum(-80);
		scrollBar.setMaximum(0);
		scrollBar.setPreferredSize(new Dimension(150, 20));
		
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent vol) 
			{
				Settings.volumeLabel.setText("Volume: " + (vol.getValue()+110));
				Music.volume(vol.getValue());
				
			}
		});
		
		return scrollBar;
	}
	
	public static JButton backSpeedButton()
	{
		JButton back = new JButton("-");
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) 
			{
				Game.setSpeed(-1000L);
			}
		});
		
		return back;
	}
	
	public static JButton forwardSpeedButton()
	{
		JButton forward = new JButton("+");
		
		forward.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) 
			{
				Game.setSpeed(1000L);
			}
		});
		
		return forward;
	}
}
