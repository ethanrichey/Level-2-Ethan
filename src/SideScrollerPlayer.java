import java.awt.Graphics;

public class SideScrollerPlayer extends SideScrollerObjects {

	private int jumph = 175;
	private int playergrav = 1;

	SideScrollerPlayer(int x, int y, int w, int h) {
		super(x, y, w, h);
		scrolls = false;

	}

	public void jump() {
		y -= jumph;

	}

	public void setJumph(int jumph) {
		this.jumph = jumph;

	}

	public void draw(Graphics g) {
		if (y < SideScrollerPanel.HEIGHT - h - 20) {
			y += playergrav;
		}
		super.draw(g);

	}
}
