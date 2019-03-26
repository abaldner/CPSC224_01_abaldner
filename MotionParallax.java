package motionParallax;

import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MotionParallax {
	// execute application
	public static void main(String args[]) {

		JFrame frame = new JFrame("Motion Parallax");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MotionPanel bp = new MotionPanel();
		frame.add(bp);
		frame.setSize(300, 300); // set frame size
		frame.setVisible(true); // display frame
	} // end main
}

// class BallPanel

class MotionPanel extends JPanel implements ActionListener {
	private int delay = 10;
	protected Timer timer;
	private int x = 0; // x position
	private int y = 0; // y position
	private int radius = 15; // ball radius
	private int dx = 2; // increment amount (x coord)
	private int dy = 2; // increment amount (y coord)

	private int skyX = 2000;
	private int skyY = 2000;
	private int skyWidth;
	private int skyHeight;
	
	private int oceanX = 0;
	private int oceanY = 200;
	private int oceanWidth;
	private int oceanHeight;
	
	private int sunX = 110;
	private int sunY = 250;
	private int sunWidth;
	private int sunHeight;
	
	private int grassX = 0;
	private int grassY = 200;
	private int grassWidth;
	private int grassHeight; 
	
	private int birdX = 0;
	private int birdY = 0;
	private int birdWidth;
	private int birdHeight;
	
	private int stumpX = 0;
	private int stumpY = 75;
	private int stumpWidth;
	private int stumpHeight;
	
	private int leavesX = 200;
	private int leavesY = 500;
	private int leavesWidth;
	private int leavesHeight;
	
	/*
	private int[] Mountain1X = {20};
	private int[] Mountain1Y = {25};
	private int Mountain1Width;
	private int Mountain1Height; 
	
	private int Mountain2X = 0;
	private int Mountain2Y = 100;
	private int Mountain2Width;
	private int Mountain2Height; 
*/
	
	public MotionPanel() {
		timer = new Timer(delay, this);
		timer.start(); // start the timer
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
	}

	public void actionPerformed(ActionEvent e)
	// will run when the timer fires
	{
		repaint();
	}

	// draw rectangles and arcs
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // call superclass's paintComponent
		
		skyWidth = 1000;
		skyHeight = 1000;
		g.setColor(Color.cyan);
		g.fillRect(skyX, skyY, skyWidth, skyHeight);
		
		oceanWidth = 30;
		oceanHeight = 40;
		g.setColor(Color.blue);
		g.fillRect(oceanX, oceanY, oceanWidth, oceanHeight);
		
		// paintSun(g);
		// super.paintComponent(g);
		g.setColor(Color.YELLOW);
		sunWidth = 55;
		sunHeight = 55;
		g.fillOval(sunX, sunY, sunWidth, sunHeight);
		
		g.setColor(Color.GREEN);
		grassWidth = 1000;
		grassHeight = 150;
		g.fillRect(grassX,  grassY,  grassWidth, grassHeight);
		
		g.setColor(Color.black);
		birdWidth = 35;
		birdHeight = 10;
		g.fillOval(birdX, birdY, birdWidth, birdHeight);
		
		g.setColor(Color.DARK_GRAY);
		stumpWidth = 15;
		stumpHeight = 30;
		g.fillRect(stumpX, stumpY, stumpWidth, stumpHeight);
		
		//g.setColor(Color.green);
		g.setColor(Color.GREEN);
		leavesWidth = 5;
		leavesHeight = 70;
		g.fillRect(leavesX, leavesY, leavesWidth, leavesHeight);
		
		
		
		/*	g.setColor(Color.GRAY);
		Mountain1Width = 100;
		Mountain1Height = 150;
		g.fillPolygon(Mountain1X, Mountain1Y, 200);
*/
		//g.fillPolygon(Mountain1X,  Mountain1Y,  Mountain1Width);
		/*
		g.setColor(Color.GRAY);
		Mountain2Width = 100;
		Mountain2Height = 200;
		g.fillRect(Mountain2X,  Mountain2Y,  Mountain2Width, Mountain2Height);*/
	
	}

	public void paintSun(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		sunWidth = 100;
		sunHeight = 100;
		g.fillOval(sunX, sunY, sunWidth, sunHeight);
	}

	private class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getX());
			System.out.println(e.getY());
			
			
			int mouseX = e.getX();
			int mouseY = e.getY();
		
			
			birdX = mouseX;
			birdY = mouseY;
		

		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}

	private class MyMouseMotionListener implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
		}

		public void mouseMoved(MouseEvent e) {
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			skyX = mouseX - 300;
			skyY = mouseY - 300;
			
			oceanX = (mouseX + 5);
			oceanY = (mouseY + 5);
			// System.out.println(oceanX);
			// mouseX += oceanX;
			sunX = 190 + (mouseX - 75) / 12;
			sunY = 10 + (mouseY - 75) / 12;
			
			grassX = (mouseX - 300) / 12;
			grassY = 200 + (mouseY) / 12;
			
			stumpX = 30 + (mouseX - 300) / 12;
			stumpY = 190 + (mouseY) / 12;
                        
                        leavesX = 30 + (mouseX - 300)/12;
                        leavesY = 190 + (mouseY) /12;
		}
		

	}

}