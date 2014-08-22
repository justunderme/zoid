package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import actions.Buttons;
import net.miginfocom.swing.MigLayout;
import principal.Resources;

@SuppressWarnings("serial")
public class Score extends JPanel 
{
	public static JLabel foodLabel = new JLabel("Food: " + Resources.getFood());
	public static JLabel waterLabel = new JLabel("Water: " + Resources.getWater());
	public static JLabel populationLabel = new JLabel("Population: " + Resources.getPopulation());
	
	public Score()
	{
		setLayout(new MigLayout("center"));
		
		this.add(Buttons.backSpeedButton());
		this.add(Buttons.forwardSpeedButton());
		this.add(foodLabel);
		this.add(waterLabel);
		this.add(populationLabel);
	}
	public synchronized static void refresh()
	{
		foodLabel.setText("Food: " + (int) Resources.getFood());
		waterLabel.setText("Water: " + (int) Resources.getWater());
		populationLabel.setText("Population: " + (int) Resources.getPopulation());
	}
}
