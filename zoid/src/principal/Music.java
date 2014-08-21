package principal;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music 
{
	private static Clip clip;
	private static AudioInputStream audioIn;
	
	public void readyMusic() 
	{
		try 
		{
			audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(getClass().getResourceAsStream("/music/Improv for Evil.wav")));
			
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		} 
		catch (UnsupportedAudioFileException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error: " + e.getMessage());
		} 
	}
	
	public static void start()
	{
		if(!clip.isRunning())
		{
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public static void stop()
	{
		if(clip.isRunning())
		{
			clip.stop();
		}
	}
	
	public static void volume(int gainAmount)
	{
		if(gainAmount < -70)
			stop();
		else if(gainAmount > -70 && !clip.isRunning())
			start();
		
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(gainAmount);
	}
	
	public static boolean isPlaying()
	{
		if(clip.isRunning())
			return true;
		return false;
	}
}
