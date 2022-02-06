//import external classes to make GUI
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

//import external classes to manage 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


//This class creates a new Asteroid frame with a moving asteroid. The asteroid balances off the walls
@SuppressWarnings("serial")
public class AsteroidFramePart2 extends JFrame implements ActionListener{	//extends means "IS A"
	
	//create labels to hold the images
	JLabel background = new JLabel(new ImageIcon("images/space.jpg"));
	JLabel asteroid = new JLabel(new ImageIcon("images/asteroid.gif"));
	JLabel weeknd = new JLabel(new ImageIcon("images/weeknd.png"));
	
	//Creates a timer that 'fires' every 50 milliseconds. Referred to as interval
	Timer gameTimer=new Timer(50,this);
	
	//change in x and y. delta x and y
	int dx=-5;
	int dy=-10;
	
	//Constructor: will be called from the main method
	public AsteroidFramePart2() {
		
		//sets the frame size and title
		setSize(500,500);	
		setTitle("Shreyas' Asteroid Game");
		
		//sets the layout manager to use coordinates
		background.setLayout(null);
		
		//place the asteroid on the frame
		asteroid.setBounds(200,100,50,50);
		background.add(asteroid);
		
		weeknd.setBounds(400,100,50,50);
		background.add(weeknd);
		
		//background will be added
		add(background);
		
		//Start the game timer
		gameTimer.start();
		
		//Makes the frame visible
		setVisible(true);
	}
	
	//This method handles the timer events
	@Override
	public void actionPerformed(ActionEvent event) {

		//move the asteroid by setting new bounds
		asteroid.setBounds(asteroid.getX()+ dx, asteroid.getY() + dy, 50, 50);
		weeknd.setBounds(weeknd.getX()+ dx, weeknd.getY() + dy, 50, 50);
		
		//left wall
		if(asteroid.getX() <0)
			dx=-dx;
		
		//right wall
		if(asteroid.getX() > 430)
			dx=-dx;
		
		//top wall
		if(asteroid.getY() <0)
			dy=-dy;
		
		//bottom wall
		if(asteroid.getY() > 415)
			dy=-dy;
	}
}
