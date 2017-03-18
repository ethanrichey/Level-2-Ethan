import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener{

Timer clock;
GameObject go = new GameObject();
GamePanel(){
	clock = new Timer(1000/60, this);
	go = new GameObject();
}

void startGame(){
	clock.start();
	
	
}


public void paintComponent(Graphics g){
	go.draw(g);
	
}

@Override
public void actionPerformed(ActionEvent e) {
System.out.println("lel");
repaint();
go.update();
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("J");
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("G");
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("H");
}

}
