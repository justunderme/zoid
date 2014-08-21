package panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import principal.MainFrame;
import principal.Music;
import actions.Buttons;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class Settings extends JPanel 
{
	public static JLabel volumeLabel;
	public Settings()
	{
		setLayout(new MigLayout("center , center , wrap"));
		setPreferredSize(new Dimension(400 , 400));
		
		Buttons musicButton = new Buttons();
		volumeLabel = new JLabel("Volume: 100");
		
		JButton confirm = new JButton("Confirm");
		JButton cancel = new JButton("Cancel");
		
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Music.volume(0);
				
				JPanel mainMenu = new Menu();
				
				MainFrame.myFrame.getContentPane().removeAll();
				MainFrame.myFrame.getContentPane().invalidate();
				
				MainFrame.myFrame.getContentPane().add(mainMenu);
				
				MainFrame.myFrame.getContentPane().revalidate();
				MainFrame.myFrame.pack();
				
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				JPanel mainMenu = new Menu();
			
				MainFrame.myFrame.getContentPane().removeAll();
				MainFrame.myFrame.getContentPane().invalidate();
			
				MainFrame.myFrame.getContentPane().add(mainMenu);
				
				MainFrame.myFrame.getContentPane().revalidate();
				MainFrame.myFrame.pack();
			}
		});
		
		add(musicButton.musicOnOffButton());
		add(musicButton.soundVolume());
		add(volumeLabel);
		add(confirm);
		add(cancel);
	}
	
}
