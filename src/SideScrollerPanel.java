import javax.swing.JFrame;


public class SideScrollerPanel {
	
	JFrame frame = new JFrame();
	final int HEIGHT = 800;
	final int WIDTH = 1100;
	
	SideScrollerPanel(){
	SideScrollerPlayer sideplay = new SideScrollerPlayer();
	setup();
		
	}
	
	void setup(){
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
		
	}
	
	
	public static void main(String [] args){
	SideScrollerPanel sidepan = new SideScrollerPanel();
	sidepan.setup();
	}
}
