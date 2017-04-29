import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame = new JFrame();
	public static final int HEIGHT = 800;
	public static final int WIDTH = 500;
	GamePanel gp = new GamePanel();
	
	
	LeagueInvaders(){
		frame = new JFrame();
		setup();
		gp = new GamePanel();
		}
	
	
	void setup(){
		frame.add(gp);
		frame.addKeyListener(gp);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		gp.startGame();
	
	
	
	
	
	}
	public static void main(String[] args) {
	LeagueInvaders LI = new LeagueInvaders();
	LI.setup();
}
}
