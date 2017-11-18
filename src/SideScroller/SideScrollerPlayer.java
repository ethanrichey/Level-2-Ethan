package SideScroller;
import java.awt.Color;
import java.awt.Graphics;

public class SideScrollerPlayer extends SideScrollerObjects {

	private int jumph = -175;
	private double playergrav = .5;
	private boolean collide = false;
	private int yVelocity = 1;

	SideScrollerPlayer(int x, int y, int w, int h) {
		super(x, y, w, h);
		scrolls = false;

	}
	public void setCollide(boolean collide) {
		this.collide = collide;
	}

	public void jump() {
		yVelocity = jumph;

	}

	public void setJumph(int jumph) {
		this.jumph = jumph;

	}

	public void draw(Graphics g) {
		
		y = (int) rect.getY();
		if (y < SideScrollerPanel.HEIGHT - h - 20 && collide == false) {
			//y += playergrav;
			y += yVelocity;
			rect.setBounds(x, (int) (y + yVelocity), w, h);
		}
		else if( collide == true) {
			rect.setBounds(x, (int) y, w, h);
		}
		collide = false;
		//super.draw(g);
		yVelocity += playergrav;
		//y += yVelocity;
		System.out.println(yVelocity);
		//rect.setBounds(x, y, w, h);
		g.setColor(Color.RED);
		g.fillRect(x, (int) y, w, h);
		if(y >= 600) {
			yVelocity = 0;
		}
		
		
	}
}
