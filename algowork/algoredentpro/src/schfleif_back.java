import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;

public class schfleif_back extends Viereck{

	private gui_fenster fenster;
	
	private pfeil_kreis_zuruck back;
	public schfleif_back(gui_fenster fenster) {
		super(fenster,0,false,false,true);
		setSize(new Dimension(20,20));
		setEditable(false);
		setBackground(Color.WHITE);
		back = new pfeil_kreis_zuruck(fenster, this);
		fenster.canvas.add(back);
		this.fenster = fenster;
	}
	
	@Override
	public void destroy() {
		super.destroy();
		
	}
	
	@Override
	public void notwendig() {
		super.notwendig();
		pos_arrow_input(); 
	}
	
	public void pos_arrow_input() {
		if (back != null) {
			back.setLocation(new Point(getPfeilstart()[0].x,getPfeilstart()[0].y));
			back.setSize(new Dimension(20,20));
		}
		else {
			
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(3));
		
		g2d.fillOval(0, 0, getWidth(), getHeight());
	}
	
}
