import java.awt.Graphics;

public class SideScrollerObjects {

int x;
int y;
int w; 
int h;
	
	
	SideScrollerObjects(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
	}
	
	SideScrollerObjects sso = new SideScrollerObjects(x, y, w, h);
	
	public void paintComponent(Graphics g){
		g.fillRect(x, y, w, h);
	}
}
