import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class SideScrollerPanel extends JPanel implements ActionListener{
	
	JFrame frame = new JFrame();
	final int HEIGHT = 800;
	final int WIDTH = 1100;
	Timer time = new Timer(60/1000,this);
	
	void run(){
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	time.start();
	frame.add(this);
	frame.setVisible(true);
	}
	
	
	ArrayList<SideScrollerObjects> platforms = new ArrayList<SideScrollerObjects>();
	
	public void obj() {
		
	platforms.add(100, 200, 400, 400);
	
	
	}
	@Override
	public void paintComponent(Graphics g){
		
		//g.fillRect(100, 200, 400, 400);
	}
	
	
	public static void main(String [] args){
	SideScrollerPanel sidepan = new SideScrollerPanel();
	sidepan.run();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
}
