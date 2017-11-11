import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SideScrollerObjects {

	int x;
	int y;
	int w;
	int h;
	Rectangle rect = new Rectangle();
	boolean scrolls = true;

	SideScrollerObjects(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		rect.setBounds(x, y, w, h);

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, w, h);
		if (x <= 0) {
			x = SideScrollerPanel.WIDTH;
		}
		/*
		 * if (x == 900) {
		 * 
		 * }
		 */
		if (scrolls) {
			x--;
		}

		rect.setBounds(x, y, w, h);
		g.setColor(Color.RED);
		g.drawRect(x, y, w, h);
	}
}
