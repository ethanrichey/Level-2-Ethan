import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{ 
	
	Timer time = new Timer(1000/60, this);

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}


