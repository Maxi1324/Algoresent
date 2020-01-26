import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class pfeil extends JButton {

	private Dimension size;
	private Container ob1;
	private Container ob2;
	public gui_fenster fenster;
	private int pos;
	private boolean typ;

	public pfeil(Container ob1, Container ob2, gui_fenster fenster, int pos, boolean typ) {
		this.ob1 = ob1;
		this.ob2 = ob2;
		this.pos = pos;
		this.fenster = fenster;
		fenster.add(this);
		this.typ = typ;

	}

	public void zeichnen(Graphics2D g2d) {

		Point start = new Point(ob1.getLocation().x + 10, ob1.getLocation().y);
		Point end = new Point(ob2.getLocation().x + 10, ob2.getLocation().y);
		Point vorecke = new Point(start);
		Point ecke_eins = new Point(start.x, start.y + 20);
		Point ecke_zwei = new Point(end.x, ecke_eins.y);
		Point rectangel_down = new Point(end.x, end.y + 20);
		Point rectangel_up_left = new Point(rectangel_down.x - 10, rectangel_down.y - 20);
		Point rectangel_up_right = new Point(rectangel_down.x + 10, rectangel_down.y - 20);
		if (typ == true) {
			rectangel_down = add_point(rectangel_down, 0, 0);
			rectangel_up_left = add_point(rectangel_up_left, 10, 0);
			rectangel_up_right = add_point(rectangel_up_right, 0, 10);
		}
		int[] rectanx = { rectangel_down.x, rectangel_up_left.x, rectangel_up_right.x };
		int[] rectany = { rectangel_down.y, rectangel_up_left.y, rectangel_up_right.y };

		if (typ == true) {

		}

		if (pos == 0) {
			vorecke = (start);
			start = add_pointx(start, 20);
			ecke_eins = vorecke;
			ecke_zwei = new Point(end.x, vorecke.y);

		}
		if (pos == 1) {
			vorecke = (start);
			start = add_pointx(start, -20);
			ecke_eins = vorecke;
			ecke_zwei = new Point(end.x, vorecke.y);

		}

		g2d.drawLine(end.x, end.y, end.x, (int) (end.y + 20));
		g2d.drawLine(start.x, start.y, vorecke.x, vorecke.y);
		g2d.drawLine(vorecke.x, vorecke.y, ecke_eins.x, ecke_eins.y);
		g2d.drawLine(ecke_eins.x, ecke_eins.y, ecke_zwei.x, ecke_zwei.y);
		g2d.drawLine(end.x, end.y, ecke_zwei.x, ecke_zwei.y);

		g2d.fillPolygon(rectanx, rectany, 3);
	}

	/*
	 * boolean da = false; ArrayList<Point> pos = new ArrayList<Point>();
	 * pos.add(ob1.getLocation()); ArrayList<Container> obs = new
	 * ArrayList<Container>(); for (int i = 0; i < fenster.vier.size(); i++) {
	 * obs.add(fenster.vier.get(i));
	 * 
	 * }
	 * 
	 * pos.add(ob1.getLocation()); int i = 0; int a = 1; // positiv oder negativ
	 * links rechts; links = poitiv rechts negativ while (da == false) { boolean
	 * drinnen = false; Point lastpos = pos.get(pos.size()-1 ); Point theo_pos =
	 * add_point(pos.get(pos.size() - 1), -20 * a, 0); for (int x = 0; x <
	 * obs.size() && drinnen == false; x++) { if (point_drin(theo_pos,
	 * obs.get(x).getLocation(), obs.get(x).getSize())) { Point start = lastpos;
	 * //int runtergehen =-100; int runtergehen = (obs.get(x).getSize().height -
	 * (obs.get(x).getLocation().y - lastpos.y)) + 20; Point eins =
	 * add_point(lastpos, 0, runtergehen); int rechtsgehen =
	 * -(obs.get(x).getSize().width + 40) * a; Point zwei = add_point(eins, x, 0);
	 * pos.add(eins); pos.add(add_point(eins, rechtsgehen, 0));
	 * pos.add(add_point(start, rechtsgehen, 0)); drinnen = true; } else { drinnen =
	 * false; } } if (drinnen == false) { pos.add(theo_pos); } if
	 * (lastpos.getLocation().x < ob2.getLocation().x) { da = true; } i++; }
	 * 
	 * for (int i1 = 0; i1 < pos.size() - 1; i1++) { g2d.drawLine(pos.get(i1).x,
	 * pos.get(i1).y, pos.get(i1 + 1).x, pos.get(i1 + 1).y);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * public Container lastArrayList(ArrayList<Container> list) { return
	 * list.get(list.size() - 1); }
	 * 
	 * public boolean point_drin(Point b, Point a, Dimension a_dim) { Point c =
	 * add_point(b, a_dim.width, a_dim.height);
	 * 
	 * 
	 * if (a.x < b.x && b.x < c.x && a.y < b.y && b.y < c.y) {
	 * 
	 * return true; }
	 * 
	 * return false; }
	 */
	public boolean pixe_white(Point pos) {
		if (pixel_at(pos).equals(new Color(250, 250, 250))) {
			return true;
		} else {
			return false;
		}
	}

	public Color pixel_at(int x, int y) {
		Color col = null;
		try {
			col = new Robot().getPixelColor(x, y);
		} catch (AWTException e) {

		}
		return col;
	}

	public Color pixel_at(Point pos) {
		return pixel_at(pos.x, pos.y);
	}

	static public Point add_point(Point point, int x, int y) {
		return new Point(point.x + x, point.y + y);
	}

	static public Point add_pointy(Point point, int y) {
		return add_point(point, 0, y);
	}

	static public Point add_pointx(Point point, int x) {
		return add_point(point, x, 0);
	}

	static public Polygon dreieck(Point a) {
		Point rectangel_down = new Point(a.x, a.y);
		Point rectangel_up_left = new Point(rectangel_down.x - 10, rectangel_down.y - 20);
		Point rectangel_up_right = new Point(rectangel_down.x + 10, rectangel_down.y - 20);
		int[] rectanx = { rectangel_down.x, rectangel_up_left.x, rectangel_up_right.x };
		int[] rectany = { rectangel_down.y, rectangel_up_left.y, rectangel_up_right.y };
		return new Polygon(rectanx, rectany, 3);
	}

	static public Polygon dreieck(Point a, Point b, Point c) {
		Point rectangel_down = a;
		Point rectangel_up_left = b;
		Point rectangel_up_right = c;
		int[] rectanx = { rectangel_down.x, rectangel_up_left.x, rectangel_up_right.x };
		int[] rectany = { rectangel_down.y, rectangel_up_left.y, rectangel_up_right.y };
		return new Polygon(rectanx, rectany, 3);
	}

	static public Polygon dreieck(Point a,float mult) {
		Point rectangel_down = new Point(a.x, a.y);
		Point rectangel_up_left = new Point((int)(rectangel_down.x - 10 *mult), (int)(rectangel_down.y - 20*mult));
		Point rectangel_up_right = new Point((int)(rectangel_down.x + 10 *mult), (int)(rectangel_down.y - 20*mult));
		int[] rectanx = { rectangel_down.x, rectangel_up_left.x, rectangel_up_right.x };
		int[] rectany = { rectangel_down.y, rectangel_up_left.y, rectangel_up_right.y };
		return new Polygon(rectanx, rectany, 3);
	}
	
	public void set_pos(int x, int y) {
		setBounds(x, y, getWidth(), getHeight());
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Container getOb1() {
		return ob1;
	}

	public void setOb1(Container ob1) {
		this.ob1 = ob1;
	}

	public Container getOb2() {
		return ob2;
	}

	public void setOb2(Container ob2) {
		this.ob2 = ob2;
	}

	public gui_fenster getFenster() {
		return fenster;
	}

	public void setFenster(gui_fenster fenster) {
		this.fenster = fenster;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

}
