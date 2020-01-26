import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class algo_end extends Viereck {

	private gui_fenster fenster;

	public algo_end(gui_fenster fenster) {
		super(fenster, 0, false, false, false);
//		getarrow().get(3).setVisible(false);
		this.fenster = fenster;
		setSize(new Dimension(30, 30));
		setEditable(false);
		setBackground(Color.WHITE);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Point pointa = new Point(getWidth(), getHeight());
		Point pointb = new Point(0,getHeight());
		Point pointc = new Point(getWidth() / 2,0);
		g2d.fillPolygon(pfeil.dreieck(pointa, pointb, pointc));
	}
	



}
