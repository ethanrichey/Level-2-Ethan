package SideScroller;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.peer.MouseInfoPeer;
import javax.swing.event.MouseInputListener;

public class SideScrollerPlayer extends SideScrollerObjects implements MouseInputListener, MouseInfoPeer {

	//private double jumph = -3.5;
	//private double playergrav = .03;
	private boolean collide = false;
	private double yVelocity = 0;
	private int yLimit = 1000;
	
	

	SideScrollerPlayer(int x, int y, int w, int h) {
		super(x, y, w, h);
		scrolls = false;

	}
	public void setCollide(boolean collide) {
		this.collide = collide;
	}

	public void setYLimit(int l) {
		yLimit = l;
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
			//y = y + yVelocity;
			//rect.setBounds(x, (int) (y), w, h);
			y = MouseInfo.getPointerInfo().getLocation().getY();
			System.out.println("mousepos" + y);
			
		}
		//y =  rect.getY();
		collide = false;
		//super.draw(g);
		//yVelocity += playergrav;
		rect.setRect(x, Math.ceil(y + yVelocity), w, h);
		//rect.setBounds(x,y + yVelocity, w, h);
		
		//y += yVelocity;
		System.out.println(yVelocity);
		System.out.println(y + "y");
		System.out.println(x + "x");
		
		
		
	}
	
	public void draw(Graphics g) {
		//rect.setBounds(x, y, w, h);
		g.setColor(Color.RED);
		g.fillRect(x, (int) y, w, h);
		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
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
		// TODO Auto-generated method stub
		return false;
	}
}
