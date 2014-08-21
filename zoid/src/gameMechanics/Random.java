package gameMechanics;

@SuppressWarnings("serial")
public class Random extends java.util.Random 
{
	
	private static Random rand = new Random();
	
	public synchronized static double getRandomDouble(double min , double max)
	{
		double randomDouble;
		
		randomDouble = min + (max - min) * rand.nextDouble();
		
		return randomDouble;
	}

	public static int getRandomInt(int value) 
	{
		
		return rand.nextInt(value);
	}
}
