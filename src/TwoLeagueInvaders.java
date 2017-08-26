import javax.swing.JFrame;

public class TwoLeagueInvaders {
JFrame frame = new JFrame();
final int WIDTH = 500;
final int HEIGHT = 800;

TwoLeagueInvaders(){
	this.frame = frame;
	
}

void setup() {
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}

public static void main(String[] args) {
	TwoLeagueInvaders tli = new TwoLeagueInvaders();
	tli.setup();
	}
}
