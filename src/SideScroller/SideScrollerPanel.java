package SideScroller;
import java.awt.Color;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.peer.MouseInfoPeer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;






public class SideScrollerPanel extends JPanel implements ActionListener, KeyListener, MouseMotionListener, MouseInfoPeer {

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
	private BufferedImage img7 = null;
	private BufferedImage img8 = null;
	private BufferedImage img9 = null;
	private BufferedImage img10 = null;
	private BufferedImage img11 = null;
	private BufferedImage img12 = null;
	
	private int yLimit = 1000;
	Random rando = new Random(10);
	int networth = 1000000;
	//public int mouseX;
	//public int mouseY;
	public final int GAMESTATE = 1;
	public final int MENUSTATE = 0;
	public final int ENDSTATE = 2;
	int currentstate;
	String enter = "PRESS ENTER TO BEGIN";
	String money = "$" + networth;
	String rip = "R.I.P. Brendan J. Fraser";
	String therapist = "You are Brendan Fraser's new therapsit, and it is your job to help him dodge his own depressing, doubt filled existential thoughts.";
	Font font = new Font("Arial", Font.BOLD, 40);
	Font font1 = new Font("Arial", Font.BOLD, 30);
	

	void run() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.addMouseMotionListener(this);
		obj();
		image();
		currentstate = 0;
		time.start();
		
		
		
		
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
		platforms.add(new SideScrollerObjects(2950, 310, 330, 10));
	}

	
	
	public void paintComponent(Graphics g) {
		 
		if(currentstate == 1) {
			drawGameState(g);
		}
		else if(currentstate == 0) {
			drawMenuState(g);
		}
		else if(currentstate == 2) {
			drawEndState(g);
		}
	}

	
	public void drawMenuState(Graphics g) {
		g.drawImage(img9, 0, 0, 2000, 1000, this);
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString(enter, 650, 550);
		g.setFont(font1);
		g.drawString(therapist, 10, 650);
		
		
	}
	
	public void drawGameState(Graphics g) {
		
		
		g.drawImage(img3, 0, 0, 2000, 1000, this);
		
		g.drawImage(img2, 0, 800, 2000, 400, this);
		
		
		
			
			
		if(networth <= 600000 ) {
			g.drawImage(img10, 0, 0, 2000, 1000, this);
		}
		
		 if(networth <= 300000) {
			g.drawImage(img11,0, 0, 2000, 1000, this);
		}
		
		for (SideScrollerObjects s : platforms) {
			s.draw(g);
		}
		player.draw(g);
		g.drawImage(img, player.x, (int) player.y, player.w, player.h, this);
		money ="$" + networth;
		g.setFont(font);
		g.setColor(Color.GREEN);
		g.drawString(money, 1700, 50);
		networth -= 50;
		if(player.y >= 1000) {
			
			
		}
		
		
		
		if (collision(player)) {
			System.out.println("crash");
			player.setCollide(true);
			
			g.drawImage(img7, 0, 0, 2000, 1000, this);
			currentstate = 2;
			g.drawImage(img8, 0, 0, 2000, 1000, this);
	
			
		
			g.drawImage(img5, 1600, 0, 300, 400, this);
			
		}

	}
	
	/*public void gameRestart() {
		networth = 1000000;
		time.restart();
		platforms.
		
	}
	*/
	
		public void drawEndState(Graphics g) {
			g.drawImage(img12, 0, 0, 2000, 1000, this);
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString(rip, 500, 200);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("Press Escape to close", 1000, 500);
			g.setFont(font);
			g.setColor(Color.RED);
			g.drawString("Press Backspace to restart", 1000, 600);
			
			
			
			
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
			currentstate = 1; 
			
			}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			frame.dispose();
			time.stop();
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
		   //img5 = ImageIO.read((this.getClass().getResourceAsStream("dollars.png")));
		   //img6 = ImageIO.read((this.getClass().getResourceAsStream("ripbrendan.jpg")));
		   //img7 = ImageIO.read((this.getClass().getResourceAsStream("brendanontrial.jpg")));
		   //img8 = ImageIO.read((this.getClass().getResourceAsStream("myman.jpg")));
		     img9 = ImageIO.read((this.getClass().getResourceAsStream("brendanboy.jpg")));
		     img10 = ImageIO.read((this.getClass().getResourceAsStream("sadbrendan1.jpg")));
		     img11 = ImageIO.read((this.getClass().getResourceAsStream("sadbrendan2.jpg")));
		     img12 = ImageIO.read((this.getClass().getResourceAsStream("Ting2.png")));
		}
		catch ( IOException exc ) {
		
		    //TODO: Handle exception.
			}
	}

	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public int fillPointWithCoords(Point point) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isWindowUnderMouse(Window w) {
		return false;
	}

	
}
