import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class algo_start extends Viereck {

	private gui_fenster fenster;

	public algo_start(gui_fenster fenster) {
		super(fenster, 0, false, false, true);

		this.fenster = fenster;
		setSize(new Dimension(30, 30));
		setEditable(false);
		setBackground(Color.WHITE);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Point pointa = new Point(0, 0);
		Point pointb = new Point(getWidth(), 0);
		Point pointc = new Point(getWidth() / 2, getHeight());
		g2d.fillPolygon(pfeil.dreieck(pointa, pointb, pointc));
	}
	
	@Override
	public void onplaced() {
		super.onplaced();
		fenster.canvas.remove(getarrow().get(3));
	}
}