
//import external classes to make GUI
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
//import external classes to manage 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

//import external classes to manage the mouse movement
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;

//this class creates a new Asteroid Frame with moving asteroid on a background. Asteroid bounces off the wall. Saucer moves with the mouse movement and collides with it
@SuppressWarnings("serial")
public class AsteroidFramePart3 extends JFrame implements ActionListener, MouseMotionListener {

	// create labels to hold the images
	JLabel background = new JLabel(new ImageIcon("images/space.jpg"));
	JLabel asteroid = new JLabel(new ImageIcon("images/asteroid.gif"));
	JLabel saucer = new JLabel(new ImageIcon("images/saucer.gif"));
	JLabel aliens = new JLabel(new ImageIcon("images/aliens.gif")); int alienWidth, alienHeight;

	// variable to count lives
	private static int lives = 5;
	JLabel livesL = new JLabel("LIVES: " + Integer.toString(lives));

	private static int points = 0;
	JLabel pointsL = new JLabel("POINTS: " + Integer.toString(points));

	// Creates a timer that 'fires' every 50 milliseconds. Referred to as interval
	Timer gameTimer = new Timer(10, this);

	// change in x and y. delta x and y
	int dx = -5;
	int dy = -10;
	
	//Music path
	private static String collideMusic="music/pop3.wav";
	
	//SoundEffect object
	static SoundEffect se= new SoundEffect();
	
	// Constructor: will be called from the main method
	public AsteroidFramePart3() {

		// sets the frame size and title
		setSize(750, 750);
		setTitle("Shreyas' Asteroid Game");

		// sets the layout manager to use coordinates
		background.setLayout(null);

		// place the asteroid on the frame
		asteroid.setBounds(200, 100, 50, 50);
		background.add(asteroid);
		
		// Place the saucer on the frame
		saucer.setBounds(300, 22, 75, 60);
		background.add(saucer);
		
		// Place the alien on the frame
		alienWidth=140; alienHeight=175;
		aliens.setBounds(225, 5, alienWidth, alienHeight);
		background.add(aliens);
		
		// Displays Lives
		livesL.setBounds(420, 0, 100, 50);
		livesL.setForeground(Color.red);
		background.add(livesL);

		// Text
		pointsL.setBounds(320, 0, 70, 50);
		pointsL.setForeground(Color.blue);
		background.add(pointsL);

		// background will be added
		add(background);

		setBlankCursor();
		// Start the game timer
		gameTimer.start();
		
		
		se.setFile(collideMusic);
		
		// add a motion listener to this frame
		addMouseMotionListener(this);

		// Makes the frame visible
		setVisible(true);
	}

	// This method handles the timer events
	@Override
	public void actionPerformed(ActionEvent event) {
		
		// move the asteroid by setting new bounds
		asteroid.setBounds(asteroid.getX() + dx, asteroid.getY() + dy, 50, 50);

		// left wall
		if (asteroid.getX() < 0)
			dx = -dx;

		// right wall
		if (asteroid.getX() > this.getWidth() - asteroid.getWidth())
			dx = -dx;

		// top wall
		if (asteroid.getY() < 0) {
			dy = -dy;
		}
		
		
		// bottom wall
		if (asteroid.getY() > this.getHeight() - asteroid.getHeight()) {
			decrementLives();
			dy = -dy;
		}
		
		if (asteroid.getBounds().intersects(aliens.getBounds())) {
			createNewAlien();
			incrementPoints();}

		// when the asteroid collides with saucer, it bounces upwards
		if (asteroid.getBounds().intersects(saucer.getBounds())) {
			se.play();
			dy = -5;}
		
	}

	private void createNewAlien() {
		int x = (int)(Math.random() * 400);
		int y = (int)(Math.random() * 400);
		
		
		aliens.setBounds(x, y, alienWidth, alienHeight);
		background.add(aliens);
	}

	private void incrementPoints() {
		points += 1;
		pointsL.setText("POINTS: " + Integer.toString(points));
		
		//Increment a life for every ten points
		if(points % 10==0)
			incrementLives();
		
	}

	// Not used but must remain for the interface to work
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	// This method will move the saucer
	@Override
	public void mouseMoved(MouseEvent mouse) {
		// The saucer's position should match the
		saucer.setBounds(mouse.getX(), mouse.getY(), 75, 60);
	}

	public void decrementLives() {
		lives -= 1;
		livesL.setText("LIVES: " + Integer.toString(lives));
	}

	public void incrementLives() {
		lives += 1;
		livesL.setText("LIVES: " + Integer.toString(lives));
	}

	// Helper methods

	public void setBlankCursor() {

		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");

		// Set the blank cursor to the JFrame.
		setCursor(blankCursor);
	}

	
}
