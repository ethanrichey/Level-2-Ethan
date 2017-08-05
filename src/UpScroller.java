import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class UpScroller implements ActionListener, KeyListener {

	final int HEIGHT = 600;
	final int WIDTH = 900;
	
	//Player p = new Player()
	
	UpScroller(){
		
	}
	
	void run(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		
		
	}
	public void paintComponent(Graphics g){
		
	}
	
	public static void main(String [] args){
		UpScroller up = new UpScroller();
		up.run();
	}


	
	
	
	
	
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
