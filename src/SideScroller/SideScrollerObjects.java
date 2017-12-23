package SideScroller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class SideScrollerObjects {

	int x;
	double y;
	int w;
	int h;
	Rectangle rect = new Rectangle();
	boolean scrolls = true;
	Random rand = new Random();
	public int randint = rand.nextInt(750);
	private float scrollspeed = (float) 20;

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
			y = randint;
			y = rand.nextInt(750);
		}
		if (scrolls) {
			x -= scrollspeed;
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
