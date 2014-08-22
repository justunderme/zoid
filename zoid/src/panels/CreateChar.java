package panels;

import gameMechanics.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import principal.MainFrame;
import principal.Player;

@SuppressWarnings("serial")
public class CreateChar extends JPanel
{
	
	static Dimension dimension = new Dimension(400, 400);
	public static JTabbedPane gameTabedPanel;
	public static JPanel scorePanel;
	private static JLabel nameLabel;
	private static JLabel areaLabel;
	private static JTextField nameField;
	private static JTextField areaField;
	
	public CreateChar()
	{
		this.setLayout(null);
		this.setPreferredSize(dimension);
		
		nameLabel = new JLabel("Name: ");
		areaLabel = new JLabel("Area Name: ");
		
		nameField = new JTextField();
		areaField = new JTextField();
		
		nameField.setBounds(150, 100, 100, 30);
		areaField.setBounds(100, 160, 200, 30);
		
		nameLabel.setBounds(180, 60, 40, 50);
		areaLabel.setBounds(165, 120, 70, 50);
		
		JButton confirm = new JButton("Confirm");
		confirm.setBounds(60, 330, 100, 50);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(250, 330, 100, 50);
		
		
		cancel.addActionListener(new ActionListener() {
			
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
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				startGame();
			}
		});
		
		this.add(nameField);
		this.add(areaField);
		this.add(nameLabel);
		this.add(areaLabel);
		this.add(confirm);
		this.add(cancel);
	}
	
	public static void startGame()
	{
		if(Player.name == null)
		{
			if(nameField.getText().length() != 0 && areaField.getText().length() != 0)
				Player.setNames(nameField.getText(), areaField.getText());
		}
		
		gameTabedPanel = new Game();
		scorePanel = new Score();
			
		MainFrame.myFrame.getContentPane().removeAll();
		MainFrame.myFrame.getContentPane().invalidate();
		
		MainFrame.myFrame.getContentPane().add(scorePanel , BorderLayout.NORTH);
		MainFrame.myFrame.getContentPane().add(gameTabedPanel , BorderLayout.SOUTH);
			
		MainFrame.myFrame.getContentPane().revalidate();
		MainFrame.myFrame.pack();
		MainFrame.myFrame.setLocationRelativeTo(null);
	}
}
