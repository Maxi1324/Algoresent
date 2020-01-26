import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class while1 extends Viereck {

	private gui_fenster fenster;
	private schleifen_ruck_dings input1;

	public while1(gui_fenster fenster) {
		super(fenster, 0, false, false, true);
		acion1();
		this.fenster = fenster;
		input1 = new schleifen_ruck_dings(fenster);
		fenster.canvas.add(input1);		
	}

	@Override
	public void destroy() {
		super.destroy();
		fenster.canvas.remove(input1);
	}
	
	@Override
	public void notwendig() {
		super.notwendig();
		
		pos_arrow_input();
		
	}

	public void pos_arrow_input() {
		if (input1 != null) {
			input1.setLocation(new Point(getPfeilstart()[0].x,getPfeilstart()[0].y-10));
			input1.setSize(new Dimension(20,20));
		}
		else {
			
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int x = 30;
		Point[] points = new Point[6];
		points[0] = new Point(0, getHeight() / 2);
		points[1] = new Point(x, getHeight() - 5);
		points[2] = new Point(getWidth() - x, getHeight() - 5);
		points[3] = new Point(getWidth(), getHeight() / 2);
		points[4] = new Point(getWidth() - x, 5);
		points[5] = new Point(x, 5);

		for (int i = 0; i + 1 < points.length; i++) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new BasicStroke(2));
			g2d.drawLine(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
		}
		g.drawLine(points[0].x, points[0].y, points[5].x, points[5].y);

	}

	@Override
	public void size_anpassung(int theo_size) {
		super.size_anpassung(theo_size);
		setSize(getSize().width + 100, getSize().height);
	}

}
