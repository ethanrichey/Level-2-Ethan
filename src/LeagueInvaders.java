import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame = new JFrame();
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	
	
	
	LeagueInvaders(){
		frame = new JFrame();
		setup();
		
		}
	
	
	void setup(){
		
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	
	
	
	
	
	}
	public static void main(String[] args) {
	LeagueInvaders LI = new LeagueInvaders();
	LI.setup();
}
}
