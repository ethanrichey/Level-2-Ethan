import java.awt.Graphics;

public class SideScrollerPlayer extends SideScrollerObjects {

	private int jumph = 175;
	private int playergrav = 1;
	private int xVelocity = 5;
	private boolean collide = false;

	SideScrollerPlayer(int x, int y, int w, int h) {
		super(x, y, w, h);
		scrolls = false;

	}
	public void setCollide(boolean collide) {
		this.collide = collide;
	}

	public void jump() {
		y -= jumph;

	}

	public void setJumph(int jumph) {
		this.jumph = jumph;

	}

	public void draw(Graphics g) {
		
		y = (int) rect.getY();
		if (y < SideScrollerPanel.HEIGHT - h - 20 && collide == false) {
			//y += playergrav;
			rect.setBounds(x, y + playergrav, w, h);
		}
		else if( collide == true) {
			rect.setBounds(x, y, w, h);
		}
		collide = false;
		super.draw(g);
		
	}
}
