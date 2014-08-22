package principal;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
		/*Music music = new Music();
		
		music.readyMusic();
		Music.start();*/
		
		int i = 9;
		
		JPanel mainMenu = new Menu();
		
		myFrame.add(mainMenu);
		
		myFrame.pack();
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}
}