//import external classes to make GUI
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

//This class creates a new Asteroid frame with stationary asteroid in the background
@SuppressWarnings("serial")
public class AsteroidFramePart1 extends JFrame {	//extends means "IS A"
	
	//create labels to hold the images
	JLabel background = new JLabel(new ImageIcon("images/space.jpg"));
	JLabel asteroid = new JLabel(new ImageIcon("images/asteroid.gif"));
	
	//Constructor: will be called from the main method
	public AsteroidFramePart1() {
		
		//sets the frame size and title
		setSize(500,500);	//width, height
		setTitle("Shreyas' Asteroid Game");
		
		//sets the layout manager to use coordinates
		background.setLayout(null);
		
		//place the asteroid on the frame
		asteroid.setBounds(300,100,50,50);
		background.add(asteroid);
		
		//background will be added
		add(background);
		
		//Makes the frame visible
		setVisible(true);
	}
}
