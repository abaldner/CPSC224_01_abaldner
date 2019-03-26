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
	private int leavesY = 70;
	private int leavesWidth;
	private int leavesHeight;
        
        private int arcX = 5;
        private int arcY = 100;
        private int arcWidth;
        private int arcHeight;
        private int startAngle;
        private int arcAngle;
        
        private int arcX2 = 50;
        private int arcY2 = 350;
        private int arcWidth2;
        private int arcHeight2;
        private int startAngle2;
        private int arcAngle2;
	
	

	
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
		
                //paint all the graphics
		skyWidth = 1000;
		skyHeight = 1000;
		g.setColor(Color.cyan);
		g.fillRect(skyX, skyY, skyWidth, skyHeight);
		
                g.setColor(Color.black);
                arcWidth = 400;
                arcHeight = 500;
                startAngle = 30;
                arcAngle = 130;
                g.drawArc(arcX, arcY, arcWidth, arcHeight, startAngle, arcAngle);
                
                g.setColor(Color.GREEN);
                arcWidth2 = 200;
                arcHeight2 = 300;
                startAngle2 = 30;
                arcAngle2 = 130;
                g.drawArc(arcX2, arcY2, arcWidth2, arcHeight2, startAngle2, arcAngle2);
                
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
		
		
		g.setColor(Color.GREEN);
		leavesWidth = 50;
		leavesHeight = 80;
		g.fillRect(leavesX, leavesY, leavesWidth, leavesHeight);
		
                
		
		
		
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
                    //new values made depending on where the mouse is
			int mouseX = e.getX();
			int mouseY = e.getY();
			
			skyX = mouseX - 300;
			skyY = mouseY - 300;
                        
                        arcX = 40 + ((mouseX-300) /15);
                        arcY = 50 + (mouseY /6);
                        
                        arcX2 = 50 + (mouseX -500) /15;
                        arcY2 = 170 + (mouseY /15);
			
			oceanX = (mouseX + 5);
			oceanY = (mouseY + 5);
			
                       
			sunX = 190 + (mouseX - 75) / 12;
			sunY = 10 + (mouseY - 75) / 12;
			
			grassX = (mouseX - 300) / 12;
			grassY = 200 + (mouseY) / 12;
			
			stumpX = 30 + (mouseX - 300) / 12;
			stumpY = 170 + (mouseY) / 12;
                        
                        leavesX = 25 + (mouseX - 300)/12;
                        leavesY = 95 + (mouseY) /12;
		}
		

	}

}