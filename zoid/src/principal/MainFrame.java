package principal;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import actions.Save;
import net.miginfocom.swing.MigLayout;
import panels.Menu;

public class MainFrame
{
	public static JFrame myFrame;
	
	public static void main(String[] args) 
	{
		myFrame = new JFrame("Super Duper");
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(new MigLayout());
		myFrame.addWindowListener(new WindowListener() 
		{
			
			public void windowClosing(WindowEvent e) 
			{
				if(Player.name != null)
					Save.saveProperties();
				
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		/*Music music = new Music();
		
		music.readyMusic();
		Music.start();*/
		
		
		JPanel mainMenu = new Menu();
		
		myFrame.add(mainMenu);
		
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}
}