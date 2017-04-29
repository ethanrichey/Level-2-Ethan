import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener{

Timer clock;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
GamePanel(){
	clock = new Timer(1000/60, this);
	
}

void startGame(){
	clock.start();
	
	
}

void drawGameState(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT );
	
}

void drawEndState(Graphics g){
	

}

void drawMenuState(Graphics g){
	

}

void updateMenuState(){
	
	
}

void updateEndState(){
	
	
}

void updateGameState(){
	
	
}

public void paintComponent(Graphics g){
	if(currentState == MENU_STATE){
		drawMenuState(g);
	}else if(currentState == GAME_STATE){
		drawGameState(g);
	}else if(currentState == END_STATE){
		drawEndState(g);
	}

	
}

@Override
public void actionPerformed(ActionEvent e) {
System.out.println("lel");
if(currentState == MENU_STATE){
	updateMenuState();
}else if(currentState == GAME_STATE){
	updateGameState();
}else if(currentState == END_STATE){
	updateEndState();
}

repaint();

	
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
