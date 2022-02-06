import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

//Code from https://www.youtube.com/watch?v=TErboGLHZGA&ab_channel=MaxO%27Didily

public class SoundEffect {
	Clip clip;

	public void setFile(String filepath) {
		try {

			File musicPath = new File(filepath);

			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
			}

			else
				System.out.println("Does not exist");

		} 
		catch (Exception e) {

		}

	}

	public void play() {

		clip.setFramePosition(0);
		clip.start();
		JOptionPane jop = new JOptionPane(null);
		
	}
	
	public SoundEffect() {
		
	}
}
