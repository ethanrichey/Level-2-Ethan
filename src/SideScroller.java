import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SideScroller implements KeyListener {
final int FRAMEHEIGHT = 800;
final int FRAMEWIDTH = 1000;

	
JFrame frame = new JFrame();
JPanel panel = new JPanel();
 void run(){
	 frame.add(panel);
     frame.pack();
     frame.setVisible(true);
     frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
     
	 
 }
	
	
	
	public static void main(String[] args) {
	SideScroller sd = new SideScroller();
	sd.run();
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
