package SideScroller;
import java.awt.Color;
import java.awt.Graphics;

public class SideScrollerPlayer extends SideScrollerObjects {

	private double jumph = -2;
	private double playergrav = .01;
	private boolean collide = false;
	private double yVelocity = 0;

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
	
	public void update() {
		
		 if(collide == true) {
			rect.setBounds(x, (int) y, w, h);
			if(yVelocity >= 0) {
				yVelocity = 0;
			}
			System.out.println("yes");
		}
		 else if ( collide == false) {
			//y += playergrav;
			y = y + yVelocity;
			//rect.setBounds(x, (int) (y), w, h);
			
		}
		y =  rect.getY();
		collide = false;
		//super.draw(g);
		yVelocity += playergrav;
		rect.setRect(x, Math.ceil(y + yVelocity), w, h);
		//rect.setBounds(x,y + yVelocity, w, h);
		
		//y += yVelocity;
		System.out.println(yVelocity);
		System.out.println(y + "y");
	}
	
	public void draw(Graphics g) {
		//rect.setBounds(x, y, w, h);
		g.setColor(Color.RED);
		g.fillRect(x, (int) y, w, h);
		
		
		
	}
}
