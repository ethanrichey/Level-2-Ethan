package SideScroller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JOptionPane;

public class SideScrollerObjects {

	int x;
	double y;
	int w;
	int h;
	Rectangle rect = new Rectangle();
	boolean scrolls = true;
	Random rand = new Random();
	public int randint = rand.nextInt(750);
	public float scrollspeed = (float) 2.2;
	public  int counter = 0;
	

	
	 SideScrollerObjects(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		rect.setBounds(x, y, w, h);

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, (int) y, w, h);
		if (x <= -250) {
			x = SideScrollerPanel.WIDTH;
			x = randint + 2000;
			y = randint;
			y = rand.nextInt(1250);
			scrollspeed += .3;
					
			System.out.println(counter);
			
		}
		if(scrollspeed == 6) {
			counter += 1;
		}
		if (scrolls) {
			x -= scrollspeed;
			counter += 1;
		}
		rect.setBounds(x, (int) y, w, h);
		g.setColor(Color.RED);
		g.drawRect(x, (int) y, w, h);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return (int) y;
		
		
	}
	
}
