package SideScroller;

// Randomize rectangle positions, add a timer, configure object collision logic (bottom of object versus top of object).
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SideScrollerPanel extends JPanel implements ActionListener, KeyListener {

	JFrame frame = new JFrame();
	public static final int HEIGHT = 800;
	public static final int WIDTH = 1100;
	Timer time = new Timer(60 / 1000, this);
	SideScrollerPlayer player = new SideScrollerPlayer(150, 600, 50, 50);

	void run() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		time.start();
		frame.add(this);
		frame.setVisible(true);
		frame.addKeyListener(this);
		obj();
	}

	public boolean collision(SideScrollerPlayer player) {
		for (SideScrollerObjects sso : platforms) {
			if (sso.rect.intersects(player.rect)) {
				return true;
			}
		}

		return false;

	}

	ArrayList<SideScrollerObjects> platforms = new ArrayList<SideScrollerObjects>();

	public void obj() {
		platforms.add(new SideScrollerObjects(100, 550, 240, 50));
		platforms.add(new SideScrollerObjects(350, 425, 240, 50));
		platforms.add(new SideScrollerObjects(600, 300, 240, 50));
		platforms.add(new SideScrollerObjects(850, 175, 240, 50));
	}

	@Override
	public void paintComponent(Graphics g) {
		for (SideScrollerObjects s : platforms) {
			s.draw(g);
		}
		player.draw(g);

	}

	public static void main(String[] args) {
		SideScrollerPanel sidepan = new SideScrollerPanel();
		sidepan.run();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (collision(player)) {
			System.out.println("crash");
			player.setCollide(true);
		}
		player.update();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			player.jump();
			
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
 
	}
}
