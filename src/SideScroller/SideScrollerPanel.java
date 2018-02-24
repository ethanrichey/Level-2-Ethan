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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SideScrollerPanel extends JPanel implements ActionListener, KeyListener {

	JFrame frame = new JFrame();
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 2000;
	public Timer time = new Timer(60 / 1000, this);
	Timer roundtimer = new Timer(30000/1000, this);
	public int roundcounter = 1;
	SideScrollerPlayer player = new SideScrollerPlayer(150, 600, 50, 50);
	private BufferedImage img = null;
	private BufferedImage img2 = null;
	private BufferedImage img3 = null;
	private BufferedImage img4 = null;
	private BufferedImage img5 = null;
	private BufferedImage img6 = null;
	private int yLimit = 1000;
	Random rando = new Random(10);
	int networth = 10000000;

	void run() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
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
				player.setYLimit(900);
			}
		}

		return false;

	}

	ArrayList<SideScrollerObjects> platforms = new ArrayList<SideScrollerObjects>();

	public void obj() {
		platforms.add(new SideScrollerObjects(2100, 550, 330, 10));
		platforms.add(new SideScrollerObjects(2150, 700, 330, 10));
		platforms.add(new SideScrollerObjects(2350, 425, 330, 10));
		platforms.add(new SideScrollerObjects(2600, 300, 330, 10));
		platforms.add(new SideScrollerObjects(2850, 175, 330, 10));
	}

	
	
	public void paintComponent(Graphics g) {
		
		
		g.drawImage(img3, 0, 0, 2000, 1000, this);
	
		g.drawImage(img2, 0, 800, 2000, 400, this);
		
		
		
		
		
		for (SideScrollerObjects s : platforms) {
			s.draw(g);
		}
		player.draw(g);
		g.drawImage(img, player.x, (int) player.y, player.w, player.h, this);
		
		if(player.y >= 1000) {
			time.stop();
			g.drawImage(img4, 0, 0, 2000, 1000, this);
			JOptionPane.showMessageDialog(null, "GAME OVER! Brendan Fraser has just signed on for the sequel to Furry Vengeance!");
			
		}
		
		g.drawImage(img5, 1600, 0, 300, 400, this);
		
		if (collision(player)) {
			System.out.println("crash");
			player.setCollide(true);
			g.drawImage(img6, 0, 0, 2000, 1000, this);
			time.stop();
			JOptionPane.showMessageDialog(null, "GAME OVER! Brendan's own crowd funded version of The Mummy has failed miserably, and he is now being prosecuted for the fraudulent use of his only backer's money during production");
			
		
			
			
		}

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
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			time.start();
			
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public void image () {
		try {
			
		    img = ImageIO.read((this.getClass().getResourceAsStream("brendan.jpg")));
		    img2 = ImageIO.read((this.getClass().getResourceAsStream("poop.jpg")));
		    img3 = ImageIO.read((this.getClass().getResourceAsStream("boop.jpg")));
		    img4 = ImageIO.read((this.getClass().getResourceAsStream("encinoman.jpg")));
		    img5 = ImageIO.read((this.getClass().getResourceAsStream("dollars.png")));
		    img6 = ImageIO.read((this.getClass().getResourceAsStream("ripbrendan.jpg")));
		}
		catch ( IOException exc ) {
		
		    //TODO: Handle exception.
			}
	}

	
}
