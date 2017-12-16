package SideScroller;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SideScrollerPanel extends JPanel implements ActionListener, KeyListener {

	JFrame frame = new JFrame();
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 2000;
	Timer time = new Timer(60 / 1000, this);
	SideScrollerPlayer player = new SideScrollerPlayer(150, 600, 150, 200);
	private BufferedImage img = null;

	void run() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		time.start();
		frame.add(this);
		frame.setVisible(true);
		frame.addKeyListener(this);
		obj();
		image();
		
	}

	public boolean collision(SideScrollerPlayer player) {
		for (SideScrollerObjects sso : platforms) {
			if (sso.rect.intersects(player.rect)) {
				return true;
			}
			else {
				player.setYLimit(950);
			}
		}

		return false;

	}

	ArrayList<SideScrollerObjects> platforms = new ArrayList<SideScrollerObjects>();

	public void obj() {
		platforms.add(new SideScrollerObjects(100, 550, 330, 2));
		platforms.add(new SideScrollerObjects(150, 700, 330, 2));
		platforms.add(new SideScrollerObjects(350, 425, 330, 2));
		platforms.add(new SideScrollerObjects(600, 300, 330, 2));
		platforms.add(new SideScrollerObjects(850, 175, 330, 2));
	}

	@Override
	public void paintComponent(Graphics g) {
		for (SideScrollerObjects s : platforms) {
			s.draw(g);
		}
		player.draw(g);
		g.drawImage( img, player.x, (int) player.y, player.w, player.h, this );

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
	public void image () {
		try {
			
		    img = ImageIO.read((this.getClass().getResourceAsStream("AjitPai.jpeg")));
		}
		catch ( IOException exc ) {
		
		    //TODO: Handle exception.
			}
	}

	
}
