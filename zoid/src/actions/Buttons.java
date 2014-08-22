package actions;

import panels.CreateChar;
import panels.Score;
import panels.Settings;
import principal.Music;
import principal.Resources;
import gameMechanics.Random;
import gameTabs.overview.Overview;

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

	public Buttons() {
		// TODO Auto-generated constructor stub
	}

	public JButton newGameButton(Dimension dimension)
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
	
	public JButton settingsButton(Dimension dimension)
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
	
	public JButton exitButton(Dimension dimension)
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
	
	public JButton scavengeButton()
	{
		JButton scavengeButton = new JButton("Scavenge");
		
		scavengeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
				if(Random.getRandomDouble(0 , 9) < 5)
					Overview.giveItem(Resources.getIcon(Random.getRandomInt(4)));
			}
		});
		
		
		return scavengeButton;
	}
	
	public JButton foodButton()
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
	
	public JButton waterButton()
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
	
	public JButton musicOnOffButton()
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
	
	public JScrollBar soundVolume()
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
}
