import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JButton;

public class draw extends JButton {
	int typ;
	public draw(int typ) {
		this.typ = typ;
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d =(Graphics2D)g;
		Point a = new Point(00,5);
		Point b = new Point(getWidth(),5);
		Point c = new Point(getWidth()/2,getHeight());
		if(typ == 1) {
			a = new Point(0,getHeight()-5);
			b = new Point(getWidth(),getHeight()-5);
			c = new Point(getWidth()/2,0);
		}
		if(typ == 2) {
			a = new Point(5,0);
			b = new Point(5,getHeight());
			c = new Point(getWidth(),getHeight()/2);
		}
		if(typ == 3) {
			a = new Point(getWidth()-5,0);
			b = new Point(getWidth()-5,getHeight());
			c = new Point(5,getHeight()/2);
		}
		if(typ == 0||typ == 1||typ == 2||typ == 3)g2d.fillPolygon(pfeil.dreieck(a,b,c));
		
	}
}
